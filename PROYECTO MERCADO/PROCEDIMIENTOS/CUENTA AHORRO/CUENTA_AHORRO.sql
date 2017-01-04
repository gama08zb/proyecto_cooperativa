create or replace PROCEDURE SP_CREAR_CUENTA_AHORRO(
      P_ID_CLIENTE VARCHAR2,
      P_ID_TIPO_CUENTA INTEGER,
      P_NOMBRE_BENEFICIARIO VARCHAR2,
      P_MENSAJE OUT VARCHAR2
    )AS
     V_NUMERO_SECUENCIA INTEGER;
     V_ID_CUENTA_AHORRO VARCHAR2(12);
     V_CANTIDAD_CUENTA INTEGER;
     V_ESTADO_CLIENTE INTEGER;
     V_CANTIDAD_CLIENTE INTEGER;
  BEGIN
   SELECT ESTADO_CLIENTE INTO V_ESTADO_CLIENTE FROM TBL_CLIENTES WHERE ID_CLIENTE=P_ID_CLIENTE;
    SELECT COUNT(*) INTO V_CANTIDAD_CLIENTE FROM TBL_CLIENTES WHERE ID_CLIENTE=P_ID_CLIENTE;
    IF (V_CANTIDAD_CLIENTE =1) THEN
        IF (V_ESTADO_CLIENTE =1) THEN
            SELECT COUNT(*) INTO V_CANTIDAD_CUENTA FROM TBL_CLIENTES_X_CUENTAS_AHORRO B 
            INNER JOIN TBL_CUENTAS_AHORRO A
                ON (A.ID_CUENTA_AHORRO=B.ID_CUENTA_AHORRO)
            WHERE (A.ID_TIPO_CUENTA= P_ID_TIPO_CUENTA) AND (B.ID_CLIENTE=P_ID_CLIENTE)AND (A.ID_ESTADO_CUENTA=1);
        
            IF (V_CANTIDAD_CUENTA=0) THEN 
                   V_NUMERO_SECUENCIA:=SEQ_CUENTA_AHORRO.NEXTVAL;
                   IF (V_NUMERO_SECUENCIA<10) THEN 
                      V_ID_CUENTA_AHORRO:= '000'||V_NUMERO_SECUENCIA;
                  ELSIF ((V_NUMERO_SECUENCIA>=10 )AND (V_NUMERO_SECUENCIA < 100)) THEN
                     V_ID_CUENTA_AHORRO:= '00'||V_NUMERO_SECUENCIA;
                  ELSIF ((V_NUMERO_SECUENCIA>=100) AND (V_NUMERO_SECUENCIA < 1000)) THEN 
                     V_ID_CUENTA_AHORRO:= '0'||V_NUMERO_SECUENCIA;
                  END IF;
                  IF (P_ID_TIPO_CUENTA<10) THEN 
                      V_ID_CUENTA_AHORRO:= '0'||P_ID_TIPO_CUENTA||V_ID_CUENTA_AHORRO;
                  ELSIF ((V_NUMERO_SECUENCIA>=10 )AND (V_NUMERO_SECUENCIA < 100)) THEN
                      V_ID_CUENTA_AHORRO:= P_ID_TIPO_CUENTA||V_ID_CUENTA_AHORRO;
                  END IF;
                   V_ID_CUENTA_AHORRO:='01'||TO_CHAR(SYSDATE,'YYYY')|| V_ID_CUENTA_AHORRO;
                  INSERT
                      INTO TBL_CUENTAS_AHORRO
                        (
                          ID_CUENTA_AHORRO,
                          ID_TIPO_CUENTA,
                          FECHA_CREACION,
                          FECHA_FINALIZACION,
                          ID_ESTADO_CUENTA,
                          NOMBRE_BENEFICIARIO
                        )
                        VALUES
                        (
                          V_ID_CUENTA_AHORRO,
                          P_ID_TIPO_CUENTA,
                          SYSDATE,
                          NULL,
                          1,
                          P_NOMBRE_BENEFICIARIO
                          
                        );
                    INSERT
                      INTO TBL_CLIENTES_X_CUENTAS_AHORRO
                        (
                          ID_CLIENTE,
                          ID_CUENTA_AHORRO
                        )
                        VALUES
                        (
                          P_ID_CLIENTE,
                          V_ID_CUENTA_AHORRO
                          
                        );
                       COMMIT;   
                   P_MENSAJE:= V_ID_CUENTA_AHORRO;
            ELSE
              P_MENSAJE:= 'YA EXITE ESTE TIPO DE CUENTA';
            END IF;
      ELSE 
          P_MENSAJE:= 'ERROR: EL CLIENTE NO EXISTE';
      END IF;
     ELSE 
          P_MENSAJE:= 'ERROR: EL CLIENTE NO EXISTE';
    END IF;
    EXCEPTION 
      WHEN OTHERS THEN 
       P_MENSAJE:='ERROR: '||SQLCODE||SQLERRM;
        ROLLBACK;
    END;