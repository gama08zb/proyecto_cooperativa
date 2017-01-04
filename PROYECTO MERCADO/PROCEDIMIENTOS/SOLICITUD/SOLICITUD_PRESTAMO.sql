create or replace PROCEDURE SP_SOLICITUD_PRESTAMO(
    P_ID_CLIENTE VARCHAR2,
    P_NOMBRE_PROYECTO VARCHAR2,
    P_DESCRIPCION_PROYECTO VARCHAR2,
    P_ID_FORMA_PAGO INTEGER,
    P_MONTO_SOLICITADO NUMBER,
    P_TASA_INTERES NUMBER,
    P_PLAZO_MESES INTEGER,
    P_CUOTA NUMBER,
    P_ID_TIPO_GARANTIA INTEGER,
    P_DESCRIPCION_GARANTIA VARCHAR2,
    P_NOMBRE_COMPLETO_AVAL1 VARCHAR2,
    P_NUMERO_IDENTIDAD_AVAL1 VARCHAR2,
    P_TELEFONO_AVAL1 VARCHAR2,
    P_CELULAR_AVAL1 VARCHAR2,
    P_DIRECCION_AVAL1 VARCHAR2,
    P_NOMBRE_COMPLETO_AVAL2 VARCHAR2,
    P_NUMERO_IDENTIDAD_AVAL2 VARCHAR2,
    P_TELEFONO_AVAL2 VARCHAR2,
    P_CELULAR_AVAL2 VARCHAR2,
    P_DIRECCION_AVAL2 VARCHAR2,
    P_CANTIDAD_LETRAS VARCHAR2,
    P_MENSAJE OUT VARCHAR2,
    P_NUMERO_SOLICITUD OUT VARCHAR2)
AS
    V_NUMERO_PROYECTO INTEGER;
    V_NUMERO_GARANTIA INTEGER;
    V_DECISION_JUNTA INTEGER;
    V_NUMERO_SOLICITUD VARCHAR2(12);
    V_CANTIDAD_CLIENTE INTEGER;
    V_ID_SOLICITUD INTEGER;
BEGIN
    SELECT COUNT(*) INTO V_CANTIDAD_CLIENTE FROM TBL_CLIENTES_X_SOLICITUDES A
    INNER JOIN TBL_SOLICITUDES B
      ON (A.ID_SOLICITUD=B.ID_SOLICITUD)
    INNER JOIN TBL_DECISIONES_JUNTA C
      ON (B.ID_DECISION_JUNTA=C.ID_DECISION_JUNTA)
    INNER JOIN TBL_PRESTAMOS D
      ON(D.ID_PRESTAMO=B.ID_PRESTAMO)
    WHERE C.ID_FORMA_PAGO=P_ID_FORMA_PAGO AND A.ID_CLIENTE=P_ID_CLIENTE AND D.ID_ESTADO_PRESTAMO=1;
  
    IF (V_CANTIDAD_CLIENTE=0) THEN
        V_NUMERO_PROYECTO:= SEQ_INFORMACION_PROYECTO.NEXTVAL;
        INSERT
          INTO TBL_INFORMACION_PROYECTOS
            (
              ID_INFORMACION_PROYECTO,
              NOMBRE_PROYECTO,
              DESCRIPCION
            )
            VALUES
            (
              V_NUMERO_PROYECTO,
              P_NOMBRE_PROYECTO,
              P_DESCRIPCION_PROYECTO
            );
        V_NUMERO_GARANTIA:=SEQ_INFORMACION_GARANTIA.NEXTVAL;
        INSERT
              INTO TBL_INFORMACION_GARANTIAS
                (
                  ID_INFORMACION_GARANTIA,
                  ID_TIPO_GARANTIA,
                  NOMBRE_COMPLETO_AVAL1,
                  NUMERO_IDENTIDAD_AVAL1,
                  TELEFONO_AVAL1,
                  CELULAR_AVAL1,
                  DIRECCION_AVAL1,
                  NOMBRE_COMPLETO_AVAL2,
                  NUMERO_IDENTIDAD_AVAL2,
                  TELEFONO_AVAL2,
                  CELULAR_AVAL2,
                  DIRECCION_AVAL2,
                  DESCRIPCION_GARANTIA
                )
                VALUES
                (
                  V_NUMERO_GARANTIA,
                  P_ID_TIPO_GARANTIA,
                  P_NOMBRE_COMPLETO_AVAL1,
                  P_NUMERO_IDENTIDAD_AVAL1,
                  P_TELEFONO_AVAL1,
                  P_CELULAR_AVAL1,
                  P_DIRECCION_AVAL1,
                  P_NOMBRE_COMPLETO_AVAL2,
                  P_NUMERO_IDENTIDAD_AVAL2,
                  P_TELEFONO_AVAL2,
                  P_CELULAR_AVAL2,
                  P_DIRECCION_AVAL2,
                  P_DESCRIPCION_GARANTIA
                );
       V_DECISION_JUNTA:=SEQ_DECISION_JUNTA.NEXTVAL;
       INSERT
        INTO TBL_DECISIONES_JUNTA
          (
            ID_DECISION_JUNTA,
            ID_FORMA_PAGO,
            ID_ESTADO_DECISION,
            MONTO_APROBADO,
            TASA_INTERES,
            PLAZO_MESES,
            CUOTA,
            REVISADO_POR_NOMBRE,
            VISTO_BUENO_NOMBRE,
            NOMBRE_PRESIDENTE
          )
          VALUES
          (
            V_DECISION_JUNTA,
            P_ID_FORMA_PAGO,
            1,
            P_MONTO_SOLICITADO,
            P_TASA_INTERES,
            P_PLAZO_MESES,
            P_CUOTA,
            NULL,
            NULL,
            NULL
          );
          
          V_ID_SOLICITUD:=SEQ_NUMERO_SOLICITUD.NEXTVAL;
          IF (V_ID_SOLICITUD<10) THEN 
            V_NUMERO_SOLICITUD:= '000'||V_ID_SOLICITUD;
          ELSIF ((V_ID_SOLICITUD>=10 )AND (V_ID_SOLICITUD < 100)) THEN
           V_NUMERO_SOLICITUD:= '00'||V_ID_SOLICITUD;
          ELSIF ((V_ID_SOLICITUD>=100) AND (V_ID_SOLICITUD < 1000)) THEN 
           V_NUMERO_SOLICITUD:= '0'||V_ID_SOLICITUD;
          END IF;
         IF (TO_CHAR(SYSDATE,'MM')<10) THEN
          V_NUMERO_SOLICITUD:= '02'||TO_CHAR(SYSDATE,'YYYY')||TO_CHAR(SYSDATE,'MM')||V_NUMERO_SOLICITUD;
         ELSE
          V_NUMERO_SOLICITUD:= '02'||TO_CHAR(SYSDATE,'YYYY')||TO_CHAR(SYSDATE,'MM')||V_NUMERO_SOLICITUD;
         END IF;
           INSERT
              INTO TBL_SOLICITUDES
                (
                  ID_SOLICITUD,
                  ID_INFORMACION_PROYECTO,
                  ID_INFORMACION_GARANTIA,
                  ID_DECISION_JUNTA,
                  ID_PRESTAMO,
                  FECHA_SOLICITUD,
                  FECHA_DE_PAGO,
                  CANTIDAD_LETRAS
                )
                VALUES
                (
                  V_NUMERO_SOLICITUD,
                  V_NUMERO_PROYECTO,
                  V_NUMERO_GARANTIA,
                  V_DECISION_JUNTA,
                  null,
                  SYSDATE,
                  null,
                  P_CANTIDAD_LETRAS
                );
                INSERT
                  INTO TBL_CLIENTES_X_SOLICITUDES
                    (
                      ID_CLIENTE,
                      ID_SOLICITUD
                    )
                    VALUES
                    (
                     P_ID_CLIENTE,
                     V_NUMERO_SOLICITUD
                    );
                
                COMMIT;
                P_NUMERO_SOLICITUD:=V_NUMERO_SOLICITUD;
                P_MENSAJE:='AGREGADO EXITOSAMENTE';
           
      ELSE
          P_MENSAJE:='ERROR: YA TIENE PRESTAMO ESTE CLIENTE';
      END IF;
EXCEPTION 
    WHEN OTHERS THEN 
      P_MENSAJE:='ERROR: '||SQLCODE||SQLERRM;
      ROLLBACK;
END;