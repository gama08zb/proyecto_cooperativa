create or replace PROCEDURE SP_DEPOSITO(
      P_CUENTA_AHORRO VARCHAR2,
      P_CANTIDAD_DEPOSITO NUMBER,
      P_TIPO_CUENTA INTEGER,
      P_NOMBRE_DEPOSITANTE VARCHAR2,
      P_MENSAJE OUT VARCHAR2,
      P_SALDO_ANTERIOR OUT NUMBER,
      P_FECHA_ACTUAL OUT DATE,
      P_SALDO_ACTUAL OUT NUMBER
    )AS
      V_CANTIDAD_CLIENTE INTEGER;
      V_SALDO_ACTUAL NUMBER;
      V_FECHA_ACTUAL DATE;
      V_FECHA_FINALIZACION DATE;
  BEGIN
  
    SELECT COUNT(*) INTO V_CANTIDAD_CLIENTE FROM TBL_CUENTAS_AHORRO A
    WHERE A.ID_CUENTA_AHORRO=P_CUENTA_AHORRO AND A.ID_TIPO_CUENTA = P_TIPO_CUENTA AND A.ID_ESTADO_CUENTA=1;
    
    IF (V_CANTIDAD_CLIENTE = 1)  THEN -- SI EXISTE  CLIENTE
      
      IF (P_TIPO_CUENTA!=2)THEN --TIPO CUENTA DISTINTO 2
          SELECT MAX(FECHA_ACTUAL) INTO V_FECHA_ACTUAL FROM TBL_DETALLES_CUENTA_AHORRO
          WHERE ID_CUENTA_AHORRO=P_CUENTA_AHORRO;
          IF (V_FECHA_ACTUAL IS NOT NULL ) THEN 
          
                SELECT A.SALDO INTO P_SALDO_ANTERIOR FROM TBL_DETALLES_CUENTA_AHORRO A 
                WHERE A.FECHA_ACTUAL=( SELECT MAX(FECHA_ACTUAL)  FROM TBL_DETALLES_CUENTA_AHORRO WHERE ID_CUENTA_AHORRO=P_CUENTA_AHORRO) 
                AND  ID_CUENTA_AHORRO=P_CUENTA_AHORRO; 
                V_SALDO_ACTUAL :=P_SALDO_ANTERIOR + P_CANTIDAD_DEPOSITO ;
                P_SALDO_ACTUAL:=V_SALDO_ACTUAL;
                INSERT
                  INTO TBL_DETALLES_CUENTA_AHORRO
                    (
                      ID_DETALLE_CUENTA_AHORRO,
                      ID_CUENTA_AHORRO,
                      ID_TIPO_TRANSACCION,
                      ID_EMPLEADO,
                      FECHA_ACTUAL,
                      RETIRO,
                      DEPOSITO,
                      INTERES,
                      SALDO,
                      NOMBRE_DEPOSITANTE
                    )
                    VALUES
                    (
                      SEQ_DETALLE_CUENTA_AHORRO.NEXTVAL,
                      P_CUENTA_AHORRO,
                      1,
                      NULL,
                      SYSDATE,
                      0,
                      P_CANTIDAD_DEPOSITO,
                      0,
                      V_SALDO_ACTUAL,
                      UPPER(P_NOMBRE_DEPOSITANTE)
                    );
                    COMMIT;
                    P_MENSAJE:='DEPOSITO EXITOS.';
             
          ELSE-- ELSE PRIMER DEPOSITO
              V_SALDO_ACTUAL := P_CANTIDAD_DEPOSITO ;
              P_SALDO_ANTERIOR:=NULL;
              P_SALDO_ACTUAL:=V_SALDO_ACTUAL;
              INSERT
                  INTO TBL_DETALLES_CUENTA_AHORRO
                    (
                      ID_DETALLE_CUENTA_AHORRO,
                      ID_CUENTA_AHORRO,
                      ID_TIPO_TRANSACCION,
                      ID_EMPLEADO,
                      FECHA_ACTUAL,
                      RETIRO,
                      DEPOSITO,
                      INTERES,
                      SALDO,
                      NOMBRE_DEPOSITANTE
                    )
                    VALUES
                    (
                      SEQ_DETALLE_CUENTA_AHORRO.NEXTVAL,
                      P_CUENTA_AHORRO,
                      1,
                      NULL,
                      SYSDATE,
                      0,
                      P_CANTIDAD_DEPOSITO,
                      0,
                      V_SALDO_ACTUAL,
                      UPPER(P_NOMBRE_DEPOSITANTE)
                    );
                    COMMIT;
                    P_MENSAJE:='DEPOSITO EXITOS.';
             
            END IF; -- END IF PRIMER DEPOSITO
            
      ELSE --ELSE TIPO CLIENTE DISTINTO 2
          SELECT FECHA_FINALIZACION INTO V_FECHA_FINALIZACION 
          FROM TBL_CUENTAS_AHORRO 
          WHERE ID_CUENTA_AHORRO=P_CUENTA_AHORRO;
          IF (V_FECHA_FINALIZACION>SYSDATE)THEN 
              SELECT MAX(FECHA_ACTUAL) INTO V_FECHA_ACTUAL FROM TBL_DETALLES_CUENTA_AHORRO
              WHERE ID_CUENTA_AHORRO=P_CUENTA_AHORRO;
              IF (V_FECHA_ACTUAL IS NOT NULL ) THEN 
             
                    SELECT A.SALDO INTO P_SALDO_ANTERIOR FROM TBL_DETALLES_CUENTA_AHORRO A 
                    WHERE A.FECHA_ACTUAL=( SELECT MAX(FECHA_ACTUAL)  FROM TBL_DETALLES_CUENTA_AHORRO WHERE ID_CUENTA_AHORRO=P_CUENTA_AHORRO) 
                    AND  ID_CUENTA_AHORRO=P_CUENTA_AHORRO; 
                    V_SALDO_ACTUAL :=P_SALDO_ANTERIOR + P_CANTIDAD_DEPOSITO ;
                    P_SALDO_ACTUAL:=V_SALDO_ACTUAL;
                    INSERT
                      INTO TBL_DETALLES_CUENTA_AHORRO
                        (
                          ID_DETALLE_CUENTA_AHORRO,
                          ID_CUENTA_AHORRO,
                          ID_TIPO_TRANSACCION,
                          ID_EMPLEADO,
                          FECHA_ACTUAL,
                          RETIRO,
                          DEPOSITO,
                          INTERES,
                          SALDO,
                          NOMBRE_DEPOSITANTE
                        )
                        VALUES
                        (
                          SEQ_DETALLE_CUENTA_AHORRO.NEXTVAL,
                          P_CUENTA_AHORRO,
                          1,
                          NULL,
                          SYSDATE,
                          0,
                          P_CANTIDAD_DEPOSITO,
                          0,
                          V_SALDO_ACTUAL,
                          UPPER(P_NOMBRE_DEPOSITANTE)
                        );
                        COMMIT;
                        P_MENSAJE:='DEPOSITO EXITOS.';
                 
              ELSE-- ELSE PRIMER DEPOSITO
                  V_SALDO_ACTUAL := P_CANTIDAD_DEPOSITO ;
                  P_SALDO_ANTERIOR:=NULL;
                  P_SALDO_ACTUAL:=V_SALDO_ACTUAL;
                  INSERT
                      INTO TBL_DETALLES_CUENTA_AHORRO
                        (
                          ID_DETALLE_CUENTA_AHORRO,
                          ID_CUENTA_AHORRO,
                          ID_TIPO_TRANSACCION,
                          ID_EMPLEADO,
                          FECHA_ACTUAL,
                          RETIRO,
                          DEPOSITO,
                          INTERES,
                          SALDO,
                          NOMBRE_DEPOSITANTE
                        )
                        VALUES
                        (
                          SEQ_DETALLE_CUENTA_AHORRO.NEXTVAL,
                          P_CUENTA_AHORRO,
                          1,
                          NULL,
                          SYSDATE,
                          0,
                          P_CANTIDAD_DEPOSITO,
                          0,
                          V_SALDO_ACTUAL,
                          UPPER(P_NOMBRE_DEPOSITANTE)
                        );
                        COMMIT;
                        P_MENSAJE:='DEPOSITO EXITOS.';
                 
                END IF; -- END IF PRIMER DEPOSITO
            
            ELSE
              P_MENSAJE:='ERROR: NO SE PUEDE DEPOSITAR LA FECHA DE FINALIZACION VENCIDA';
            END IF;
      END IF;
    ELSE -- ELSE IF EXISTE CLIENTE
      P_MENSAJE:= 'ERROR: EL CLIENTE NO EXISTE';
    END IF;-- FIN IF CANTIDAD CLIENTE
    
    SELECT SYSDATE INTO P_FECHA_ACTUAL FROM DUAL;
    EXCEPTION 
      WHEN OTHERS THEN 
       P_MENSAJE:='ERROR: '||SQLCODE||SQLERRM;
        ROLLBACK;
    END;