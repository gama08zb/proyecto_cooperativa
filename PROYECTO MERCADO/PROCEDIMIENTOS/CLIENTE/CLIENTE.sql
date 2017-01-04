create or replace PROCEDURE SP_CLIENTE(
      P_ID_ESTADO_CIVIL INTEGER,
      P_ID_PROFESION INTEGER,
      P_ID_DIRECCION INTEGER,
      P_ID_EMPRESA INTEGER,
      P_ID_CARGO INTEGER,
      P_NUMERO_IDENTIDAD VARCHAR2,
      P_NOMBRES VARCHAR2,
      P_APELLIDOS VARCHAR2,
      P_TELEFONO VARCHAR2,
      P_CELULAR VARCHAR2,
      P_SALARIO NUMBER,
      P_CORREO_ELECTRONICO VARCHAR2,
      P_GENERO CHAR,
      P_FECHA_NACIMIENTO DATE,
      P_MENSAJE OUT VARCHAR2
  )AS
      V_NUMERO_MUNICIPIO INTEGER;
      V_NUMERO_CLIENTE INTEGER;
      V_ID_CLIENTE VARCHAR2(12);
      V_EDAD INTEGER;
  BEGIN
  
    SELECT trunc((trunc(SYSDATE) - trunc(to_date(P_FECHA_NACIMIENTO,'DD/MM/YYYY')))/365) INTO V_EDAD from dual;

   IF V_EDAD>=0 THEN BEGIN 
       V_NUMERO_CLIENTE:= SEQ_CLIENTE.NEXTVAL;
        IF (V_NUMERO_CLIENTE<10) THEN 
            V_ID_CLIENTE:= '000'||V_NUMERO_CLIENTE;
        ELSIF ((V_NUMERO_CLIENTE>=10 )AND (V_NUMERO_CLIENTE < 100)) THEN
           V_ID_CLIENTE:= '00'||V_NUMERO_CLIENTE;
        ELSIF ((V_NUMERO_CLIENTE>=100) AND (V_NUMERO_CLIENTE < 1000)) THEN 
           V_ID_CLIENTE:= '0'||V_NUMERO_CLIENTE;
      END IF;
        SELECT C.ID_MUNICIPIO INTO V_NUMERO_MUNICIPIO FROM TBL_DIRECCIONES A
          INNER JOIN TBL_COLONIAS B
            ON (A.ID_COLONIA=B.ID_COLONIA)
          INNER JOIN TBL_MUNICIPIOS C
            ON (B.ID_MUNICIPIO=C.ID_MUNICIPIO)
          WHERE ID_DIRECCION=P_ID_DIRECCION;
        IF V_NUMERO_MUNICIPIO>=10 THEN
          V_ID_CLIENTE:= '00'||TO_CHAR(SYSDATE,'YYYY') ||V_NUMERO_MUNICIPIO ||V_ID_CLIENTE;
        ELSE
          V_ID_CLIENTE:= '00'||TO_CHAR(SYSDATE,'YYYY') ||'0'||V_NUMERO_MUNICIPIO ||V_ID_CLIENTE;
        END IF;
          INSERT INTO TBL_CLIENTES
                (
                  ID_CLIENTE,
                  ID_ESTADO_CIVIL,
                  ID_PROFESION,
                  ID_DIRECCION,
                  ID_EMPRESA,
                  ID_CARGO,
                  NUMERO_IDENTIDAD,
                  NOMBRES,
                  APELLIDOS,
                  TELEFONO,
                  CELULAR,
                  SALARIO,
                  CORREO_ELECTRONICO,
                  GENERO,
                  FECHA_NACIMIENTO,
                  FECHA_INGRESO,
                  ESTADO_CLIENTE
                )
                VALUES
                (
                  V_ID_CLIENTE,
                  P_ID_ESTADO_CIVIL,
                  P_ID_PROFESION,
                  P_ID_DIRECCION,
                  P_ID_EMPRESA,
                  P_ID_CARGO,
                  P_NUMERO_IDENTIDAD,
                  UPPER(P_NOMBRES),
                  UPPER(P_APELLIDOS),
                  P_TELEFONO,
                  P_CELULAR,
                  P_SALARIO,
                  P_CORREO_ELECTRONICO,
                  P_GENERO,
                  P_FECHA_NACIMIENTO,
                  SYSDATE,
                  1
                );
          COMMIT; 
         P_MENSAJE:= V_ID_CLIENTE;
      END;
      ELSE
        P_MENSAJE:= 'ERROR ES MENOR DE EDAD';
      END IF;
        EXCEPTION 
          WHEN OTHERS THEN 
           P_MENSAJE:='ERROR: '||SQLCODE||SQLERRM;
            ROLLBACK;
        END;