package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javafx.collections.ObservableList;

public class Conexion {
	private String url;
	private Connection conexion;
	private final static String USUARIO = "prueba";
	private final static String CONTRASENA = "oracle";
	private String SID = "xe";
	private final static String host = "localhost";
	private String puerto="1521";
	
	public Conexion(){
		establecerConexion();
	}
	
	public Connection getConnection(){
		return conexion;
	}
	
	public void establecerConexion(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url ="jdbc:oracle:thin:@"+host+":"+puerto+":"+SID;
			conexion =DriverManager.getConnection(url,USUARIO,CONTRASENA); 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConexion(){
		return this.conexion;
	}
	
	public void llenarInformacionEstadoCivil(ObservableList<EstadoCivil> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT ID_ESTADO_CIVIL, "
					+ "DESCRIPCION_ESTADO_CIVIL "
					+ "FROM TBL_ESTADOS_CIVIL");
			while(resultado.next()){
				lista.add(
					new EstadoCivil(
						resultado.getInt("ID_ESTADO_CIVIL"),
						resultado.getString("DESCRIPCION_ESTADO_CIVIL")
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String buscarClienteCuentaRetirable(String numeroCuenta, String codigoTipoCuenta){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT B.NOMBRES||' '||B.APELLIDOS AS NOMBRE_COMPLETO FROM TBL_CLIENTES_X_CUENTAS_AHORRO  A "
					+ "INNER  JOIN TBL_CLIENTES B "
					+ "ON (A.ID_CLIENTE= B.ID_CLIENTE) "
					+ "INNER  JOIN TBL_CUENTAS_AHORRO C "
					+ "ON (A.ID_CUENTA_AHORRO= C.ID_CUENTA_AHORRO) "
					+ "WHERE C.ID_CUENTA_AHORRO= "+numeroCuenta+" AND C.ID_TIPO_CUENTA="+codigoTipoCuenta 
					+ " AND B.ESTADO_CLIENTE = 1 ");
					resultado.next();
					return resultado.getString("NOMBRE_COMPLETO");
			
		} catch (SQLException e) {
			 return "";
		}
		
	}
	
	public String buscarCliente(String numeroCuenta){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT NOMBRES||' '||APELLIDOS AS NOMBRE_COMPLETO FROM TBL_CLIENTES "
					+ " WHERE ID_CLIENTE= "+numeroCuenta);
					resultado.next();
					return resultado.getString("NOMBRE_COMPLETO");
			
		} catch (SQLException e) {
			 return "";
		}
		
	}
	
	public DecisionJunta buscarSolicitudPrestamo(String numeroSolicitud){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT C.NOMBRES||' '||C.APELLIDOS AS NOMBRE_COMPLETO, C.ID_CLIENTE , B.MONTO_APROBADO, B.TASA_INTERES, B.PLAZO_MESES, B.CUOTA, E.FORMA_PAGO "+
					"FROM TBL_CLIENTES_X_SOLICITUDES A "+
				    " INNER JOIN TBL_CLIENTES C "+
					" ON (A.ID_CLIENTE=C.ID_CLIENTE) "+
					" INNER JOIN TBL_SOLICITUDES D "+
					" ON (A.ID_SOLICITUD=D.ID_SOLICITUD) "+
					" INNER JOIN TBL_DECISIONES_JUNTA B "+
					" ON (D.ID_DECISION_JUNTA=B.ID_DECISION_JUNTA) "+
					" INNER JOIN TBL_FORMAS_PAGO E "+
					" ON (B.ID_FORMA_PAGO=E.ID_FORMA_PAGO) "
					+ " WHERE A.ID_SOLICITUD= "+numeroSolicitud);
					resultado.next();
					
					DecisionJunta decisionJunta =new DecisionJunta(
							resultado.getString("ID_CLIENTE"),
							resultado.getString("NOMBRE_COMPLETO"),
							resultado.getString("FORMA_PAGO"),
							resultado.getDouble("MONTO_APROBADO"), 
							resultado.getDouble("TASA_INTERES"), 
							resultado.getInt("PLAZO_MESES"),
							resultado.getDouble("CUOTA"));
					return decisionJunta;
			
		} catch (SQLException e) {
			 return null;
		}
		
	}
	
	
	public void llenarInformacionTipoCuenta(ObservableList<TipoCuenta> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT ID_TIPO_CUENTA, "
					+ "TIPO_CUENTA "
					+ "FROM TBL_TIPOS_CUENTAS ");
			while(resultado.next()){
				lista.add(
					new TipoCuenta(
						resultado.getInt("ID_TIPO_CUENTA"),
						resultado.getString("TIPO_CUENTA")
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void llenarInformacionFormaPago(ObservableList<FormaPago> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT ID_FORMA_PAGO, "
					+ "FORMA_PAGO "
					+ "FROM TBL_FORMAS_PAGO ORDER BY ID_FORMA_PAGO ASC ");
			while(resultado.next()){
				lista.add(
					new FormaPago(
						resultado.getInt("ID_FORMA_PAGO"),
						resultado.getString("FORMA_PAGO")
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void llenarInformacionTipoGarantia(ObservableList<TipoGarantia> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT ID_TIPO_GARANTIA, "
					+ "TIPO_GARANTIA "
					+ "FROM TBL_TIPOS_GARANTIAS ");
			while(resultado.next()){
				lista.add(
					new TipoGarantia(
						resultado.getInt("ID_TIPO_GARANTIA"),
						resultado.getString("TIPO_GARANTIA")
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void llenarInformacionPais(ObservableList<Pais> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT ID_PAIS, "
					+ "NOMBRE_PAIS "
					+ "FROM TBL_PAISES");
			while(resultado.next()){
				lista.add(
					new Pais(
						resultado.getInt("ID_PAIS"),
						resultado.getString("NOMBRE_PAIS")
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void llenarInformacionEmpresa(ObservableList<Empresa> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT ID_EMPRESA, "
					+ "NOMBRE_EMPRESA, "
					+ "ID_DIRECCION, "
					+ "TELEFONO "
					+ "FROM TBL_EMPRESAS");
			while(resultado.next()){
				lista.add(
					new Empresa(
						resultado.getInt("ID_EMPRESA"),
						resultado.getInt("ID_DIRECCION"),
						resultado.getString("NOMBRE_EMPRESA"),
						resultado.getString("TELEFONO")
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void llenarInformacionCargo(ObservableList<Cargo> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT ID_CARGO, "
					+ "NOMBRE_CARGO "
					+ "FROM TBL_CARGOS");
			while(resultado.next()){
				lista.add(
					new Cargo(
						resultado.getInt("ID_CARGO"),
						resultado.getString("NOMBRE_CARGO")
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void llenarInformacionProfesion(ObservableList<Profesion> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT ID_PROFESION, "
					+ "DESCRIPCION_PROFESION "
					+ "FROM TBL_PROFESIONES");
			while(resultado.next()){
				lista.add(
					new Profesion(
						resultado.getInt("ID_PROFESION"),
						resultado.getString("DESCRIPCION_PROFESION")
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void llenarInformacionEstado(ObservableList<Estado> lista){
		try {
			Statement instruccionEstado = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet resultadoEstado = instruccionEstado.executeQuery(
					"SELECT ID_ESTADO, "
					+ "NOMBRE_ESTADO "
					+ "FROM TBL_ESTADOS "
					+"WHERE ID_PAIS = 1");
			while(resultadoEstado.next()){
				lista.add(
					new Estado(
							resultadoEstado.getInt("ID_ESTADO"),
							resultadoEstado.getString("NOMBRE_ESTADO")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
	}
	public void llenarInformacionTipoTrabajo(ObservableList<TipoTrabajo> lista){
		try {
			Statement instruccion = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet resultado = instruccion.executeQuery(
					"SELECT ID_TIPO_TRABAJO, "
					+ "TIPO_TRABAJO "
					+ "FROM TBL_TIPOS_TRABAJOS ");
			while(resultado.next()){
				lista.add(
					new TipoTrabajo(
							resultado.getInt("ID_TIPO_TRABAJO"),
							resultado.getString("TIPO_TRABAJO")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
	}
	
	public void llenarInformacionMunicipio(Estado estado, ObservableList<Municipio> lista){
		try {
			Statement instruccion = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet resultado = instruccion.executeQuery(
					"SELECT ID_MUNICIPIO, "
					+ "NOMBRE_MUNICIPIO "
					+ "FROM TBL_MUNICIPIOS "
					+"WHERE ID_ESTADO = "+ estado.getCodigoEstado());
			while(resultado.next()){
				lista.add(
					new Municipio(
							resultado.getInt("ID_MUNICIPIO"),
							resultado.getString("NOMBRE_MUNICIPIO")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			
			}
	 }
	
	public void llenarInformacionColonia(Municipio municipio, ObservableList<Colonia> lista){
		try {
			Statement instruccion = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet resultado = instruccion.executeQuery(
					"SELECT ID_COLONIA, "
					+ "NOMBRE_COLONIA "
					+ "FROM TBL_COLONIAS "
					+"WHERE ID_MUNICIPIO = "+ municipio.getCodigoMunicipio());
			while(resultado.next()){
				lista.add(
					new Colonia(
							resultado.getInt("ID_COLONIA"),
							resultado.getString("NOMBRE_COLONIA")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			
			}
	 }
	
	public void llenarInformacionCargo(TipoTrabajo tipoTrabajo, ObservableList<Cargo> lista){
		try {
			Statement instruccion = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet resultado = instruccion.executeQuery(
					"SELECT ID_CARGO, "
					+ "NOMBRE_CARGO "
					+ "FROM TBL_CARGOS "
					+"WHERE ID_TIPO_TRABAJO = "+ tipoTrabajo.getCodigoTipoTrabajo());
			while(resultado.next()){
				lista.add(
					new Cargo(
							resultado.getInt("ID_CARGO"),
							resultado.getString("NOMBRE_CARGO")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			
			}
	 }
	
	public String insertarDireccion(Direccion direccion){
	       String resultado=null;
	       try {            
	            CallableStatement proc = conexion.prepareCall(" CALL SP_DIRECCION(?,?,?) ");
	            proc.setInt("P_ID_COLONIA", direccion.getCodigoColonia());
	            proc.setString("P_DESCRIPCION_DIRECCION", direccion.getDescripcionDireccion());
	            proc.registerOutParameter("P_MENSAJE", Types.VARCHAR);
	            proc.execute();            
	            resultado = proc.getString("P_MENSAJE");
	        } 
	       catch (Exception e) {                  
	            System.out.println(resultado);
	       }
	       return resultado;
	}
	
	public String insertarEmpresa(Empresa empresa){
	       String resultado=null;
	       try {            
	            CallableStatement proc = conexion.prepareCall(" CALL SP_EMPRESA(?,?,?,?) ");
	            proc.setInt("P_ID_DIRECCION", empresa.getCodigoDireccion());
	            proc.setString("P_NOMBRE_EMPRESA", empresa.getNombreEmpresa());
	            proc.setString("P_TELEFONO", empresa.getTelefono());
	            proc.registerOutParameter("P_MENSAJE", Types.VARCHAR);
	            proc.execute();            
	            resultado = proc.getString("P_MENSAJE");
	        } 
	       catch (Exception e) {                  
	            System.out.println(resultado);
	       }
	       return resultado;
	}
	
	public String insertarCliente(Cliente cliente){
	       String resultado=null;
	       try {            
	            CallableStatement proc = conexion.prepareCall(" CALL SP_CLIENTE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
	            proc.setInt("P_ID_ESTADO_CIVIL", cliente.getEstadoCivil());
	            proc.setInt("P_ID_PROFESION", cliente.getCodigoProfesion());
	            proc.setInt("P_ID_DIRECCION", cliente.getCodigoDireccion());
	            proc.setInt("P_ID_EMPRESA", cliente.getCodigoEmpresa());
	            proc.setInt("P_ID_CARGO", cliente.getCodigoCargo());
	            proc.setString("P_NUMERO_IDENTIDAD", cliente.getNumeroIdentidad());
	            proc.setString("P_NOMBRES", cliente.getNombres());
	            proc.setString("P_APELLIDOS", cliente.getApellidos());
	            proc.setString("P_TELEFONO", cliente.getTelefono());
	            proc.setString("P_CELULAR", cliente.getCelular());
	            proc.setDouble("P_SALARIO", cliente.getSalario());
	            proc.setString("P_CORREO_ELECTRONICO", cliente.getCorreoElectronico());
	            proc.setString("P_GENERO", cliente.getGenero());
	            proc.setDate("P_FECHA_NACIMIENTO", (Date) cliente.getFechaNacimiento());
	            proc.registerOutParameter("P_MENSAJE", Types.VARCHAR);
	            proc.execute();            
	            resultado = proc.getString("P_MENSAJE");
	        } 
	       catch (Exception e) {                  
	            System.out.println(resultado);
	       }
	       return resultado;
	}
	
	public String insertarCuentaAhorro(String codigoCliente, int codigoCuentaAhorro, String nombreBeneficiario){
	       String resultado=null;
	       try {            
	            CallableStatement proc = conexion.prepareCall(" CALL SP_CREAR_CUENTA_AHORRO(?,?,?,?) ");
	            proc.setString("P_ID_CLIENTE", codigoCliente);
	            proc.setInt("P_ID_TIPO_CUENTA", codigoCuentaAhorro);
	            proc.setString("P_NOMBRE_BENEFICIARIO", nombreBeneficiario);
	            proc.registerOutParameter("P_MENSAJE", Types.VARCHAR);
	            proc.execute();            
	            resultado = proc.getString("P_MENSAJE");
	        } 
	       catch (Exception e) {                  
	            System.out.println(resultado);
	       }
	       return resultado;
	}
	
	public String insertarCuentaAhorroPlazo(String codigoCliente, int codigoCuentaAhorro, Date fechaFinalizacion , String nombreBeneficiario){
	       String resultado=null;
	       try {            
	            CallableStatement proc = conexion.prepareCall(" CALL SP_CREAR_CUENTA_AHORRO_PLAZO(?,?,?,?,?) ");
	            proc.setString("P_ID_CLIENTE", codigoCliente);
	            proc.setInt("P_ID_TIPO_CUENTA", codigoCuentaAhorro);
	            proc.setString("P_NOMBRE_BENEFICIARIO", nombreBeneficiario);
	            proc.setDate("P_FECHA_FINALIZACION", fechaFinalizacion);
	            proc.registerOutParameter("P_MENSAJE", Types.VARCHAR);
	            proc.execute();            
	            resultado = proc.getString("P_MENSAJE");
	            return resultado;
	        }  catch (Exception e) {                  
	            return resultado;
	       }
	      
	}
	public DetalleCuentaAhorro insertarDeposito(DetalleCuentaAhorro detalleCuentaAhorro){
	       
	       try {            
	            CallableStatement proc = conexion.prepareCall(" CALL SP_DEPOSITO(?,?,?,?,?,?,?,?) ");
	            proc.setString("P_CUENTA_AHORRO",detalleCuentaAhorro.getCodigoCuentaAhorro());
	            proc.setDouble("P_CANTIDAD_DEPOSITO", detalleCuentaAhorro.getDeposito());
	            proc.setInt("P_TIPO_CUENTA", detalleCuentaAhorro.getCodigoTipoCuenta());
	            proc.setString("P_NOMBRE_DEPOSITANTE",detalleCuentaAhorro.getNombreDepositante());
	            proc.registerOutParameter("P_MENSAJE", Types.VARCHAR);
	            proc.registerOutParameter("P_SALDO_ANTERIOR", Types.NUMERIC);
	            proc.registerOutParameter("P_FECHA_ACTUAL", Types.DATE);
	            proc.registerOutParameter("P_SALDO_ACTUAL", Types.NUMERIC);
	            proc.execute();            
	            detalleCuentaAhorro.setMensaje(proc.getString("P_MENSAJE"));
	            detalleCuentaAhorro.setFechaActual(proc.getDate("P_FECHA_ACTUAL"));
	            detalleCuentaAhorro.setSaldo(proc.getDouble("P_SALDO_ACTUAL"));
	            detalleCuentaAhorro.setSaldoAnterior(proc.getDouble("P_SALDO_ANTERIOR"));
	            return detalleCuentaAhorro;
	        } 
	       catch (Exception e) {                  
	            return null;
	       }
	}
	
	public DetalleCuentaAhorro insertarRetiro(DetalleCuentaAhorro detalleCuentaAhorro){
	       
	       try {            
	            CallableStatement proc = conexion.prepareCall(" CALL SP_RETIRAR(?,?,?,?,?,?,?,?) ");
	            proc.setString("P_CUENTA_AHORRO",detalleCuentaAhorro.getCodigoCuentaAhorro());
	            proc.setInt("P_TIPO_CUENTA", detalleCuentaAhorro.getCodigoTipoCuenta());
	            proc.setDouble("P_CANTIDAD_RETIRO", detalleCuentaAhorro.getRetiro());
	            proc.setString("P_NUMERO_IDENTIDAD",detalleCuentaAhorro.getNumeroIdentidad());
	            proc.registerOutParameter("P_MENSAJE", Types.VARCHAR);
	            proc.registerOutParameter("P_SALDO_ANTERIOR", Types.NUMERIC);
	            proc.registerOutParameter("P_FECHA_ACTUAL", Types.DATE);
	            proc.registerOutParameter("P_SALDO_ACTUAL", Types.NUMERIC);
	            proc.execute();            
	            detalleCuentaAhorro.setMensaje(proc.getString("P_MENSAJE"));
	            detalleCuentaAhorro.setFechaActual(proc.getDate("P_FECHA_ACTUAL"));
	            detalleCuentaAhorro.setSaldo(proc.getDouble("P_SALDO_ACTUAL"));
	            detalleCuentaAhorro.setSaldoAnterior(proc.getDouble("P_SALDO_ANTERIOR"));
	            return detalleCuentaAhorro;
	        } 
	       catch (Exception e) {                  
	            return null;
	       }
	       
	}
	
	public InformacionSolicitud llenarInformacionSolicitud(InformacionSolicitud informacionSolicitud){
	       try {            
	            CallableStatement proc = conexion.prepareCall(" CALL SP_BUSCAR_CLIENTE_SOLICITUD(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
	            proc.setString("P_ID_CLIENTE",informacionSolicitud.getCodigoPersona());
	            proc.registerOutParameter("P_NOMBRE_PROYECTO", Types.VARCHAR);
	            proc.registerOutParameter("P_DESCRIPCION", Types.VARCHAR);
	            proc.registerOutParameter("P_ID_TIPO_GARANTIA", Types.INTEGER);
	            proc.registerOutParameter("P_NOMBRE_COMPLETO_AVAL1", Types.VARCHAR);
	            proc.registerOutParameter("P_NUMERO_IDENTIDAD_AVAL1", Types.VARCHAR);
	            proc.registerOutParameter("P_TELEFONO_AVAL1", Types.VARCHAR);
	            proc.registerOutParameter("P_CELULAR_AVAL1", Types.VARCHAR);
	            proc.registerOutParameter("P_DIRECCION_AVAL1", Types.VARCHAR);
	            proc.registerOutParameter("P_NOMBRE_COMPLETO_AVAL2", Types.VARCHAR);
	            proc.registerOutParameter("P_NUMERO_IDENTIDAD_AVAL2", Types.VARCHAR);
	            proc.registerOutParameter("P_TELEFONO_AVAL2", Types.VARCHAR);
	            proc.registerOutParameter("P_CELULAR_AVAL2", Types.VARCHAR);
	            proc.registerOutParameter("P_DIRECCION_AVAL2", Types.VARCHAR);
	            proc.registerOutParameter("P_DESCRIPCION_GARANTIA", Types.VARCHAR);
	            proc.registerOutParameter("P_MENSAJE", Types.VARCHAR);
	            proc.execute();            
	            informacionSolicitud.setNombreProyecto(proc.getString("P_NOMBRE_PROYECTO"));
	            informacionSolicitud.setDescripcion(proc.getString("P_DESCRIPCION"));
	            informacionSolicitud.setCodigoTipoGarantia(proc.getInt("P_ID_TIPO_GARANTIA"));
	            informacionSolicitud.setNombreCompletoAval1(proc.getString("P_NOMBRE_COMPLETO_AVAL1"));
	            informacionSolicitud.setNumeroIdentidadAval1(proc.getString("P_NUMERO_IDENTIDAD_AVAL1"));
	            informacionSolicitud.setTelefonoAval1(proc.getString("P_TELEFONO_AVAL1"));
	            informacionSolicitud.setCelularAval1(proc.getString("P_CELULAR_AVAL1"));
	            informacionSolicitud.setDireccionAval1(proc.getString("P_DIRECCION_AVAL1"));
	            informacionSolicitud.setNombreCompletoAval2(proc.getString("P_NOMBRE_COMPLETO_AVAL2"));
	            informacionSolicitud.setNumeroIdentidadAval2(proc.getString("P_NUMERO_IDENTIDAD_AVAL2"));
	            informacionSolicitud.setTelefonoAval2(proc.getString("P_TELEFONO_AVAL2"));
	            informacionSolicitud.setCelularAval2(proc.getString("P_CELULAR_AVAL2"));
	            informacionSolicitud.setDireccionAval2(proc.getString("P_DIRECCION_AVAL2"));
	            informacionSolicitud.setDescripcionGarantia(proc.getString("P_DESCRIPCION_GARANTIA"));
	            informacionSolicitud.setMensaje(proc.getString("P_MENSAJE"));
	            return informacionSolicitud;
	        } 
	       catch (Exception e) {                  
	            return null;
	       }  
	}
	
	public InformacionSolicitud llenarSolicitud(InformacionSolicitud informacionSolicitud){
	       try {            
	            CallableStatement proc = conexion.prepareCall(" CALL SP_SOLICITUD_PRESTAMO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
	            proc.setString("P_ID_CLIENTE",informacionSolicitud.getCodigoPersona());
	            proc.setString("P_NOMBRE_PROYECTO",informacionSolicitud.getNombreProyecto());
	            proc.setString("P_DESCRIPCION_PROYECTO",informacionSolicitud.getDescripcion());
	            proc.setInt("P_ID_FORMA_PAGO",informacionSolicitud.getCodigoFormaPago());
	            proc.setDouble("P_MONTO_SOLICITADO",informacionSolicitud.getMontoSolicitado());
	            proc.setDouble("P_TASA_INTERES",informacionSolicitud.getTasaInteres());
	            proc.setInt("P_PLAZO_MESES",informacionSolicitud.getPlazoMeses());
	            proc.setDouble("P_CUOTA",informacionSolicitud.getCuota());
	            proc.setInt("P_ID_TIPO_GARANTIA",informacionSolicitud.getCodigoTipoGarantia());
	            proc.setString("P_DESCRIPCION_GARANTIA",informacionSolicitud.getDescripcionGarantia());
	            proc.setString("P_NOMBRE_COMPLETO_AVAL1",informacionSolicitud.getNombreCompletoAval1());
	            proc.setString("P_NUMERO_IDENTIDAD_AVAL1",informacionSolicitud.getNumeroIdentidadAval1());
	            proc.setString("P_TELEFONO_AVAL1",informacionSolicitud.getTelefonoAval1());
	            proc.setString("P_CELULAR_AVAL1",informacionSolicitud.getCelularAval1());
	            proc.setString("P_DIRECCION_AVAL1",informacionSolicitud.getDireccionAval1());
	            proc.setString("P_NOMBRE_COMPLETO_AVAL2",informacionSolicitud.getNombreCompletoAval2());
	            proc.setString("P_NUMERO_IDENTIDAD_AVAL2",informacionSolicitud.getNumeroIdentidadAval2());
	            proc.setString("P_TELEFONO_AVAL2",informacionSolicitud.getTelefonoAval2());
	            proc.setString("P_CELULAR_AVAL2",informacionSolicitud.getCelularAval2());
	            proc.setString("P_DIRECCION_AVAL2",informacionSolicitud.getDireccionAval2());
	            proc.setString("P_CANTIDAD_LETRAS",informacionSolicitud.getCantidadLetras());
	            proc.registerOutParameter("P_MENSAJE", Types.VARCHAR);
	            proc.registerOutParameter("P_NUMERO_SOLICITUD", Types.VARCHAR);
	            proc.execute();            
	            informacionSolicitud.setCodigoSolicitud(proc.getString("P_NUMERO_SOLICITUD"));
	            informacionSolicitud.setMensaje(proc.getString("P_MENSAJE"));
	            return informacionSolicitud;
	        } 
	       catch (Exception e) {                  
	            return null;
	       }  
	}
	
	public String aprobarPrestamo(String numeroSolicitud, String numeroCliente){
	       try {            
	            CallableStatement proc = conexion.prepareCall(" CALL SP_APROBAR_PRESTAMO(?,?,?,?) ");
	            proc.setString(" P_ID_SOLICITUD",numeroSolicitud);
	            proc.setString("P_ID_CLIENTE",numeroCliente);
	            proc.registerOutParameter("P_NUMERO_PRESTAMO", Types.VARCHAR);
	            proc.registerOutParameter("P_MENSAJE", Types.VARCHAR);
	            proc.execute();            
	            return proc.getString("P_MENSAJE")+ " " +proc.getString("P_NUMERO_PRESTAMO");
	        } 
	       catch (Exception e) {                  
	            return null;
	       }  
	}
	
	public PagoPrestamo buscarPrestamo(String numeroPrestamo){
		try {
			Statement instruccion = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet resultado = instruccion.executeQuery(
					"SELECT B.NOMBRES||' '||B.APELLIDOS AS NOMBRE_COMPLETO, D.CUOTA , D.ID_FORMA_PAGO "
					+ "FROM TBL_CLIENTES_X_SOLICITUDES A "
					+ "INNER JOIN TBL_CLIENTES B "
					+ "ON (A.ID_CLIENTE=B.ID_CLIENTE) "
					+ "INNER JOIN TBL_SOLICITUDES C "
					+ "ON(C.ID_SOLICITUD=A.ID_SOLICITUD) "
					+ "INNER JOIN TBL_PRESTAMOS D "
					+ "ON(D.ID_PRESTAMO=C.ID_PRESTAMO) "
					+"WHERE C.ID_PRESTAMO =  "+ numeroPrestamo);
					
			resultado.next();
			PagoPrestamo pagoPrestamo= new PagoPrestamo(resultado.getString("NOMBRE_COMPLETO"), resultado.getDouble("CUOTA"), resultado.getInt("ID_FORMA_PAGO"));
			return pagoPrestamo ;
			
		} catch (SQLException e) {
			 return null;
		}
	
	 }
	
	public void llenarListaPrestamos (String numeroPrestamo , ObservableList<DetallePrestamo> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT FECHA_PAGO, PAGO, SALDO_ACTUAL "
					+ "FROM TBL_DESCRIPCION_PRESTAMOS "
					+"WHERE ID_PRESTAMO =  "+ numeroPrestamo
					+"ORDER BY FECHA_PAGO ASC");
			while(resultado.next()){
				lista.add(
					new DetallePrestamo(
						resultado.getDate("FECHA_PAGO"),
						resultado.getDouble("PAGO")+ resultado.getDouble("SALDO_ACTUAL"),
						resultado.getDouble("PAGO"),
						resultado.getDouble("SALDO_ACTUAL")
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String pagarPrestamo(String numeroPrestamo){
	       try {
	    		Statement instruccion = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet resultadoTipoPrestamo = instruccion.executeQuery(
						"SELECT ID_FORMA_PAGO "
						+ " FROM TBL_PRESTAMOS "
						+" WHERE ID_PRESTAMO =  "+ numeroPrestamo);
				resultadoTipoPrestamo.next();
				if (resultadoTipoPrestamo.getInt("ID_FORMA_PAGO")==1){
		            CallableStatement proc = conexion.prepareCall(" CALL SP_PAGAR_PRESTAMO_DIARIO(?,?) ");
		            proc.setString("P_ID_PRESTAMO",numeroPrestamo);
		            proc.registerOutParameter("P_MENSAJE", Types.VARCHAR);
		            proc.execute();            
		            return proc.getString("P_MENSAJE");
				}else if (resultadoTipoPrestamo.getInt("ID_FORMA_PAGO")==2){
					 CallableStatement proc = conexion.prepareCall(" CALL SP_PAGAR_PRESTAMO_MENSUAL_C_N(?,?) ");
			         proc.setString("P_ID_PRESTAMO",numeroPrestamo);
			         proc.registerOutParameter("P_MENSAJE", Types.VARCHAR);
			         proc.execute();            
			         return proc.getString("P_MENSAJE");
				}else if (resultadoTipoPrestamo.getInt("ID_FORMA_PAGO")==3){
					 CallableStatement proc = conexion.prepareCall(" CALL SP_PAGAR_PRESTAMO_MENSUAL_S_S(?,?) ");
			            proc.setString("P_ID_PRESTAMO",numeroPrestamo);
			            proc.registerOutParameter("P_MENSAJE", Types.VARCHAR);
			            proc.execute();            
			            return proc.getString("P_MENSAJE");
				}else{
					return null;
				}
	        } 
	       catch (Exception e) {
	    	   System.out.println(e.getMessage());
	            return null;
	       }  
	}
	
	public String pagarPrestamoAtrasado(String numeroPrestamo){
	       try {            
	            CallableStatement proc = conexion.prepareCall(" CALL SP_PAGAR_PRESTAMO_ATRASADO(?,?) ");
	            proc.setString("P_ID_PRESTAMO",numeroPrestamo);
	            proc.registerOutParameter("P_MENSAJE", Types.VARCHAR);
	            proc.execute();            
	            return proc.getString("P_MENSAJE");
	        } 
	       catch (Exception e) {                  
	            return null;
	       }  
	}
	
	public int buscarClienteByIdentidad(String numeroIdentidad){
		try {
			Statement instruccion = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet resultado = instruccion.executeQuery(
					"SELECT COUNT(*) AS CANTIDAD "
					+ "FROM TBL_CLIENTES "
					+"WHERE NUMERO_IDENTIDAD = " +numeroIdentidad);
			resultado.next();
			return resultado.getInt("CANTIDAD");
			
		} catch (SQLException e) {
			 return -1;
		}
	
	 }
	
	public Cliente buscarEditarCliente(String numeroCliente){
		try {
			
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT ID_ESTADO_CIVIL, ID_PROFESION, ID_DIRECCION, ID_EMPRESA, ID_CARGO, NUMERO_IDENTIDAD, "+
					"NOMBRES, APELLIDOS, TELEFONO, CELULAR, SALARIO, CORREO_ELECTRONICO,"+
					"GENERO, FECHA_NACIMIENTO, ESTADO_CLIENTE FROM TBL_CLIENTES  "+
					"WHERE ID_CLIENTE= " + numeroCliente);
			resultado.next();
			if (resultado.getInt("ESTADO_CLIENTE")==1){
				Cliente cliente	=new Cliente(
					resultado.getInt("ID_ESTADO_CIVIL"), 
					resultado.getInt("ID_DIRECCION"),
					resultado.getString("NUMERO_IDENTIDAD"), 
					resultado.getString("NOMBRES"),
					resultado.getString("APELLIDOS"), 
					resultado.getString("TELEFONO"), 
					resultado.getString("CELULAR"), 
					resultado.getString("CORREO_ELECTRONICO"), 
					resultado.getString("GENERO"), 
					resultado.getDate("FECHA_NACIMIENTO"), 
					resultado.getInt("ID_PROFESION"), 
					resultado.getInt("ID_EMPRESA"), 
					resultado.getInt("ID_CARGO"), 
					resultado.getDouble("SALARIO"));	
				return cliente;
			}else{
				return null;
			}
		} catch (SQLException e) {
			 return null;
		}
		
	}
	
	public Direccion buscarDireccion(int codigoDireccion){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT ID_COLONIA, DESCRIPCION_DIRECCION FROM TBL_DIRECCIONES  "+
					"WHERE ID_DIRECCION= " + codigoDireccion);
			resultado.next();
			Direccion direccion= new Direccion(resultado.getInt("ID_COLONIA"), resultado.getString("DESCRIPCION_DIRECCION"));	
			return direccion;
		} catch (SQLException e) {
			 return null;
		}
		
	}
	
	public int buscarMunicipio(int codigoColonia){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT ID_MUNICIPIO FROM TBL_COLONIAS  "+
					"WHERE ID_COLONIA= " + codigoColonia);
			resultado.next();
			return resultado.getInt("ID_MUNICIPIO");
		} catch (SQLException e) {
			 return -1;
		}
		
	}
	
	public int buscarDepartamento(int codigoMunicipio){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT ID_ESTADO FROM TBL_MUNICIPIOS  "+
					"WHERE ID_MUNICIPIO= " + codigoMunicipio);
			resultado.next();
			return resultado.getInt("ID_ESTADO");
		} catch (SQLException e) {
			 return -1;
		}
		
	}
	
	public Empresa buscarEmpresa(int codigoEmpresa){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT ID_DIRECCION, NOMBRE_EMPRESA, TELEFONO FROM TBL_EMPRESAS  "+
					"WHERE ID_EMPRESA= " + codigoEmpresa);
			resultado.next();
			return new Empresa(resultado.getInt("ID_DIRECCION"),resultado.getString("NOMBRE_EMPRESA"),resultado.getString("TELEFONO"));
		} catch (SQLException e) {
			 return null;
		}
		
	}
	
	public int buscarTipoTrabajo(int codigoCargo){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT ID_TIPO_TRABAJO FROM TBL_CARGOS "+
					"WHERE ID_CARGO= " + codigoCargo);
			resultado.next();
			return resultado.getInt("ID_TIPO_TRABAJO");
		} catch (SQLException e) {
			 return -1;
		}
		
	}
	
	public String actualizarCliente(Cliente cliente){
	       String resultado=null;
	       try {            
	            CallableStatement proc = conexion.prepareCall(" CALL SP_ACTUALIZAR_CLIENTE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
	            proc.setString("P_ID_CLIENTE", cliente.getCodigoPersona());
	            proc.setInt("P_ID_ESTADO_CIVIL", cliente.getEstadoCivil());
	            proc.setInt("P_ID_PROFESION", cliente.getCodigoProfesion());
	            proc.setInt("P_ID_DIRECCION", cliente.getCodigoDireccion());
	            proc.setInt("P_ID_EMPRESA", cliente.getCodigoEmpresa());
	            proc.setInt("P_ID_CARGO", cliente.getCodigoCargo());
	            proc.setString("P_NUMERO_IDENTIDAD", cliente.getNumeroIdentidad());
	            proc.setString("P_NOMBRES", cliente.getNombres());
	            proc.setString("P_APELLIDOS", cliente.getApellidos());
	            proc.setString("P_TELEFONO", cliente.getTelefono());
	            proc.setString("P_CELULAR", cliente.getCelular());
	            proc.setDouble("P_SALARIO", cliente.getSalario());
	            proc.setString("P_CORREO_ELECTRONICO", cliente.getCorreoElectronico());
	            proc.setString("P_GENERO", cliente.getGenero());
	            proc.setDate("P_FECHA_NACIMIENTO", (Date) cliente.getFechaNacimiento());
	            proc.registerOutParameter("P_MENSAJE", Types.VARCHAR);
	            proc.execute();            
	            resultado = proc.getString("P_MENSAJE");
	        } 
	       catch (Exception e) {                  
	            System.out.println(e.getMessage());
	       }
	       return resultado;
	}
	
	public String eliminarCliente(String numeroCliente){
	       try {            
	            PreparedStatement proc = conexion.prepareStatement("UPDATE TBL_CLIENTES "+
	            		"SET ESTADO_CLIENTE= 0 "+
	            		"WHERE ID_CLIENTE = " + numeroCliente);
	            
	            proc.execute();            
	            return "cliente eliminado correctamente";
	        } 
	       catch (Exception e) {                  
	            return "ERROR: el cliente no se ha podido eliminar";
	       }
	       
	}
}
