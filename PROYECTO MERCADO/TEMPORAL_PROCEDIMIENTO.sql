create or replace PROCEDURE SP_PAGAR_PRESTAMO(
    P_ID_PRESTAMO VARCHAR2,
    P_MENSAJE OUT VARCHAR2)
AS
    V_CUOTA DECIMAL;
    V_ID_FORMA_PAGO INTEGER;
    V_PLAZO_MESES INTEGER;
    V_CANTIDAD_CUOTAS INTEGER;
    V_FECHA_FINAL DATE;
    V_FECHA_PAGAR DATE;
    V_CANTIDAD_DIAS INTEGER;
    V_SALDO_ACTUAL DECIMAL;
    V_TASA_INTERES DECIMAL;
    V_CONTADOR_CUOTAS INTEGER;
    V_ESTADO_PRESTAMO INTEGER;
BEGIN
  SELECT ID_ESTADO_PRESTAMO INTO V_ESTADO_PRESTAMO 
  FROM TBL_PRESTAMOS WHERE ID_PRESTAMO=P_ID_PRESTAMO;
  SELECT B.CUOTA, B.ID_FORMA_PAGO, B.PLAZO_MESES, B.TASA_INTERES
        INTO V_CUOTA, V_ID_FORMA_PAGO, V_PLAZO_MESES, V_TASA_INTERES
  FROM TBL_SOLICITUDES A
  INNER JOIN  TBL_DECISIONES_JUNTA B
    ON(A.ID_DECISION_JUNTA = B.ID_DECISION_JUNTA)
  WHERE (A.ID_PRESTAMO=P_ID_PRESTAMO);
  
  IF (V_ID_FORMA_PAGO=1) THEN
    IF (V_ESTADO_PRESTAMO=1) THEN
      SELECT FECHA_FINAL INTO V_FECHA_FINAL
      FROM TBL_PRESTAMOS
      WHERE (ID_PRESTAMO=P_ID_PRESTAMO);
      V_CANTIDAD_DIAS:= V_FECHA_FINAL-SYSDATE;
      IF (V_CANTIDAD_DIAS>=0) THEN
        SELECT A.SALDO_ACTUAL INTO V_SALDO_ACTUAL 
        FROM TBL_DESCRIPCION_PRESTAMOS A 
        WHERE A.FECHA_PAGO= ( SELECT MAX(FECHA_PAGO)  FROM TBL_DESCRIPCION_PRESTAMOS WHERE ID_PRESTAMO=P_ID_PRESTAMO) 
              AND  ID_PRESTAMO=P_ID_PRESTAMO; 
        V_SALDO_ACTUAL:= V_SALDO_ACTUAL-V_CUOTA;
        INSERT
          INTO TBL_DESCRIPCION_PRESTAMOS
            (
              ID_DESCRIPCION_PRESTAMO,
              ID_PRESTAMO,
              FECHA_PAGO,
              PAGO,
              SALDO_ACTUAL,
              FECHA_A_PAGAR,
              ID_EMPLEADO
            )
          VALUES
            (
              SEQ_DESCRIPCION_PRESTAMO.NEXTVAL,
              P_ID_PRESTAMO,
              SYSDATE,
              V_CUOTA,
              V_SALDO_ACTUAL,
              NULL,
              NULL
            );
            COMMIT;
        ELSE
          P_MENSAJE:= 'ERROR: EL CLIENTE ESTA ATRASADO EN SU PAGO CON: '||(V_CUOTA*V_CANTIDAD_DIAS*-1*(V_TASA_INTERES+1));
        END IF;
      ELSE
        P_MENSAJE:='ERROR: EL CLIENTE YA PAGO SU DEUDA';
      END IF;
      SELECT COUNT(*) INTO V_CANTIDAD_CUOTAS
      FROM TBL_DESCRIPCION_PRESTAMOS
      WHERE (ID_PRESTAMO=P_ID_PRESTAMO);
      IF (V_CANTIDAD_CUOTAS>=23)THEN
        UPDATE TBL_PRESTAMOS
        SET ID_ESTADO_PRESTAMO = 2
        WHERE ID_PRESTAMO = P_ID_PRESTAMO;
      END IF;
    ELSIF (V_ID_FORMA_PAGO=2) THEN
      IF (V_ESTADO_PRESTAMO=1) THEN
        V_CONTADOR_CUOTAS:=1;
        WHILE (V_CONTADOR_CUOTAS!=V_CANTIDAD_CUOTAS) LOOP
          V_FECHA_PAGAR:=ADD_MONTHS(V_FECHA_PAGAR, V_CONTADOR_CUOTAS);
          V_CONTADOR_CUOTAS:=V_CONTADOR_CUOTAS+1;
        END LOOP;
        V_FECHA_PAGAR:=ADD_MONTHS(V_FECHA_PAGAR, V_CONTADOR_CUOTAS+1);
        IF (MONTHS_BETWEEN(SYSDATE,V_FECHA_PAGAR)>=0) THEN
          SELECT A.SALDO_ACTUAL INTO V_SALDO_ACTUAL 
          FROM TBL_DESCRIPCION_PRESTAMOS A 
          WHERE A.FECHA_PAGO= ( SELECT MAX(FECHA_PAGO)  FROM TBL_DESCRIPCION_PRESTAMOS WHERE ID_PRESTAMO=P_ID_PRESTAMO) 
              AND  ID_PRESTAMO=P_ID_PRESTAMO; 
          V_SALDO_ACTUAL:= V_SALDO_ACTUAL-V_CUOTA;
          INSERT
          INTO TBL_DESCRIPCION_PRESTAMOS
            (
              ID_DESCRIPCION_PRESTAMO,
              ID_PRESTAMO,
              FECHA_PAGO,
              PAGO,
              SALDO_ACTUAL,
              FECHA_A_PAGAR,
              ID_EMPLEADO
            )
          VALUES
            (
              SEQ_DESCRIPCION_PRESTAMO.NEXTVAL,
              P_ID_PRESTAMO,
              SYSDATE,
              V_CUOTA,
              V_SALDO_ACTUAL,
              NULL,
              NULL
            );
            COMMIT;
        ELSE
           P_MENSAJE:= 'ERROR: EL CLIENTE ESTA ATRASADO EN SU PAGO CON: '||(V_CUOTA*MONTHS_BETWEEN(SYSDATE,V_FECHA_PAGAR)*-1*(V_TASA_INTERES+1));
        END IF;
      ELSE
        P_MENSAJE:='ERROR: EL CLIENTE YA PAGO SU DEUDA';
      END IF;
      SELECT COUNT(*) INTO V_CANTIDAD_CUOTAS
      FROM TBL_DESCRIPCION_PRESTAMOS
      WHERE (ID_PRESTAMO=P_ID_PRESTAMO);
      IF (V_CANTIDAD_CUOTAS>=V_PLAZO_MESES)THEN
        UPDATE TBL_PRESTAMOS
        SET ID_ESTADO_PRESTAMO = 2
        WHERE ID_PRESTAMO = P_ID_PRESTAMO;
      END IF;
    END IF;
      
    
EXCEPTION 
    WHEN OTHERS THEN 
      P_MENSAJE:='ERROR: '||SQLCODE||SQLERRM;
      ROLLBACK;
END;

create or replace PROCEDURE SP_PAGAR_PRESTAMO_ATRASADO(
    P_ID_PRESTAMO VARCHAR2,
    P_MENSAJE OUT VARCHAR2)
AS
   V_CUOTA DECIMAL;
    V_ID_FORMA_PAGO INTEGER;
    V_PLAZO_MESES INTEGER;
    V_CANTIDAD_CUOTAS INTEGER;
    V_FECHA_FINAL DATE;
    V_FECHA_PAGAR DATE;
    V_CANTIDAD_DIAS INTEGER;
    V_SALDO_ACTUAL DECIMAL;
    V_TASA_INTERES DECIMAL;
    V_CONTADOR_CUOTAS INTEGER;
BEGIN
  SELECT B.CUOTA, B.ID_FORMA_PAGO, B.PLAZO_MESES, B.TASA_INTERES
        INTO V_CUOTA, V_ID_FORMA_PAGO, V_PLAZO_MESES, V_TASA_INTERES
  FROM TBL_SOLICITUDES A
  INNER JOIN  TBL_DECISIONES_JUNTA B
    ON(A.ID_DECISION_JUNTA = B.ID_DECISION_JUNTA)
  WHERE (A.ID_PRESTAMO=P_ID_PRESTAMO);
  
  SELECT COUNT(*) INTO V_CANTIDAD_CUOTAS
    FROM TBL_DESCRIPCION_PRESTAMOS
    WHERE (ID_PRESTAMO=P_ID_PRESTAMO);
  IF (V_ID_FORMA_PAGO=1) THEN
    SELECT A.SALDO_ACTUAL INTO V_SALDO_ACTUAL 
    FROM TBL_DESCRIPCION_PRESTAMOS A 
    WHERE A.FECHA_PAGO= ( SELECT MAX(FECHA_PAGO)  FROM TBL_DESCRIPCION_PRESTAMOS WHERE ID_PRESTAMO=P_ID_PRESTAMO) 
      AND  ID_PRESTAMO=P_ID_PRESTAMO; 
    V_CANTIDAD_DIAS:= V_FECHA_FINAL-SYSDATE;
    V_CUOTA:=(V_CUOTA*V_CANTIDAD_DIAS*-1*(V_TASA_INTERES+1));
    INSERT
    INTO TBL_DESCRIPCION_PRESTAMOS
      (
        ID_DESCRIPCION_PRESTAMO,
        ID_PRESTAMO,
        FECHA_PAGO,
        PAGO,
        SALDO_ACTUAL,
        FECHA_A_PAGAR,
        ID_EMPLEADO
      )
      VALUES
      (
        SEQ_DESCRIPCION_PRESTAMO.NEXTVAL,
        P_ID_PRESTAMO,
        SYSDATE,
        V_CUOTA,
        V_SALDO_ACTUAL,
        NULL,
        NULL
      );
      COMMIT;
      SELECT COUNT(*) INTO V_CANTIDAD_CUOTAS
      FROM TBL_DESCRIPCION_PRESTAMOS
      WHERE (ID_PRESTAMO=P_ID_PRESTAMO);
      IF (V_CANTIDAD_CUOTAS>=23)THEN
        UPDATE TBL_PRESTAMOS
        SET ID_ESTADO_PRESTAMO = 2
        WHERE ID_PRESTAMO = P_ID_PRESTAMO;
      END IF;
  ELSE
    SELECT A.SALDO_ACTUAL INTO V_SALDO_ACTUAL 
    FROM TBL_DESCRIPCION_PRESTAMOS A 
    WHERE A.FECHA_PAGO= ( SELECT MAX(FECHA_PAGO)  FROM TBL_DESCRIPCION_PRESTAMOS WHERE ID_PRESTAMO=P_ID_PRESTAMO) 
      AND  ID_PRESTAMO=P_ID_PRESTAMO; 
    WHILE (V_CONTADOR_CUOTAS!=V_CANTIDAD_CUOTAS) LOOP
          V_FECHA_PAGAR:=ADD_MONTHS(V_FECHA_PAGAR, V_CONTADOR_CUOTAS);
          V_CONTADOR_CUOTAS:=V_CONTADOR_CUOTAS+1;
    END LOOP;
    V_CUOTA:=(V_CUOTA*MONTHS_BETWEEN(SYSDATE,V_FECHA_PAGAR)*-1*(V_TASA_INTERES+1));
    INSERT
    INTO TBL_DESCRIPCION_PRESTAMOS
      (
        ID_DESCRIPCION_PRESTAMO,
        ID_PRESTAMO,
        FECHA_PAGO,
        PAGO,
        SALDO_ACTUAL,
        FECHA_A_PAGAR,
        ID_EMPLEADO
      )
      VALUES
      (
        SEQ_DESCRIPCION_PRESTAMO.NEXTVAL,
        P_ID_PRESTAMO,
        SYSDATE,
        V_CUOTA,
        V_SALDO_ACTUAL,
        NULL,
        NULL
      );
      COMMIT;
      SELECT COUNT(*) INTO V_CANTIDAD_CUOTAS
      FROM TBL_DESCRIPCION_PRESTAMOS
      WHERE (ID_PRESTAMO=P_ID_PRESTAMO);
      IF (V_CANTIDAD_CUOTAS>=V_PLAZO_MESES)THEN
        UPDATE TBL_PRESTAMOS
        SET ID_ESTADO_PRESTAMO = 2
        WHERE ID_PRESTAMO = P_ID_PRESTAMO;
      END IF;
  END IF;
EXCEPTION 
    WHEN OTHERS THEN 
      P_MENSAJE:='ERROR: '||SQLCODE||SQLERRM;
      ROLLBACK;
END;
