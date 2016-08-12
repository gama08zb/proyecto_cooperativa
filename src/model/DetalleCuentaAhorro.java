package model;

import java.util.Date;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class DetalleCuentaAhorro {
	private IntegerProperty codigoDetalleCuentaAhorro;
	private StringProperty codigoCuentaAhorro;
	private IntegerProperty codigoTipoTransaccion;
	private IntegerProperty codigoTipoCuenta;
	private IntegerProperty codigoEmpleado;
	private Date fechaActual;
	private DoubleProperty retiro;
	private DoubleProperty deposito;
	private DoubleProperty interes;
	private DoubleProperty saldo;
	private StringProperty nombreDepositante;
	private StringProperty mensaje;
	private DoubleProperty saldoAnterior;
	private StringProperty numeroIdentidad;
	
	public DetalleCuentaAhorro( int codigoDetalleCuentaAhorro,String codigoCuentaAhorro,
								int codigoTipoTransaccion,int codigoEmpleado,
							Date fechaActual,  double retiro, double deposito, 
							double interes,double saldo, String nombreDepositante){
		this.codigoDetalleCuentaAhorro= new SimpleIntegerProperty(codigoDetalleCuentaAhorro);
		this.codigoCuentaAhorro= new SimpleStringProperty(codigoCuentaAhorro);
		this.codigoTipoTransaccion= new SimpleIntegerProperty(codigoTipoTransaccion);
		this.codigoEmpleado= new SimpleIntegerProperty(codigoEmpleado);
		this.fechaActual = fechaActual;
		this.retiro= new SimpleDoubleProperty(retiro);
		this.deposito= new SimpleDoubleProperty(deposito);
		this.interes= new SimpleDoubleProperty(interes);
		this.saldo= new SimpleDoubleProperty(saldo);
		this.nombreDepositante= new SimpleStringProperty(nombreDepositante);
	}
	
	public DetalleCuentaAhorro( String codigoCuentaAhorro,double deposito, String nombreDepositante, int codigotipoCuenta){
			
			this.codigoCuentaAhorro= new SimpleStringProperty(codigoCuentaAhorro);
			this.deposito= new SimpleDoubleProperty(deposito);
			this.nombreDepositante= new SimpleStringProperty(nombreDepositante);
			this.codigoTipoCuenta= new SimpleIntegerProperty(codigotipoCuenta);
	}
	
	public DetalleCuentaAhorro( String codigoCuentaAhorro, String numeroIdentidad,double retiro ,int codigotipoCuenta){
		this.codigoCuentaAhorro= new SimpleStringProperty(codigoCuentaAhorro);
		this.numeroIdentidad= new SimpleStringProperty(numeroIdentidad);
		this.retiro= new SimpleDoubleProperty(retiro);
		this.codigoTipoCuenta= new SimpleIntegerProperty(codigotipoCuenta);
	}
	
	public IntegerProperty codigoDetalleCuentaAhorroProperty() {
		return codigoDetalleCuentaAhorro;
	}

	public int getCodigoDetalleCuentaAhorro() {
		return codigoDetalleCuentaAhorro.get();
	}
	
	public void setCodigoDetalleCuentaAhorro(int codigoDetalleCuentaAhorro) {
		this.codigoDetalleCuentaAhorro= new SimpleIntegerProperty(codigoDetalleCuentaAhorro);
	}
	
	public StringProperty numeroIdentidadProperty() {
		return numeroIdentidad;
	}

	public String getNumeroIdentidad() {
		return numeroIdentidad.get();
	}
	
	public void setNumeroIdentidad(String numeroIdentidad) {
		this.numeroIdentidad= new SimpleStringProperty(numeroIdentidad);
	}

	
	public IntegerProperty codigoTipoCuentaProperty() {
		return codigoTipoCuenta;
	}

	public int getCodigoTipoCuenta() {
		return codigoTipoCuenta.get();
	}
	
	public void setCodigoTipoCuenta(int codigoTipoCuenta) {
		this.codigoTipoCuenta= new SimpleIntegerProperty(codigoTipoCuenta);
	}
	public StringProperty codigoCuentaAhorroProperty() {
		return codigoCuentaAhorro;
	}

	public String getCodigoCuentaAhorro() {
		return codigoCuentaAhorro.get();
	}
	
	public void setCodigoCuentaAhorro(String codigoCuentaAhorro) {
		this.codigoCuentaAhorro= new SimpleStringProperty(codigoCuentaAhorro);
	}
	
	public IntegerProperty codigoTipoTransaccionProperty() {
		return codigoTipoTransaccion;
	}

	public int getCodigoTipoTransaccion() {
		return codigoTipoTransaccion.get();
	}
	
	public void setCodigoTipoTransaccion(int codigoTipoTransaccion) {
		this.codigoTipoTransaccion= new SimpleIntegerProperty(codigoTipoTransaccion);
	}

	public IntegerProperty codigoEmpleadoProperty() {
		return codigoEmpleado;
	}

	public int getCodigoEmpleado() {
		return codigoEmpleado.get();
	}
	
	public void setCodigoEmpleado(int codigoEmpleado) {
		this.codigoEmpleado= new SimpleIntegerProperty(codigoEmpleado);
	}
	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}

	
	public DoubleProperty retiroProperty() {
		return retiro;
	}
	
	public double getRetiro() {
		return retiro.get();
	}
	
	public void setRetiro(double retiro) {
		this.retiro= new SimpleDoubleProperty(retiro);
	}
	
	public DoubleProperty depositoProperty() {
		return deposito;
	}
	
	public double getDeposito() {
		return deposito.get();
	}
	
	public void setDeposito(double deposito) {
		this.deposito= new SimpleDoubleProperty(deposito);
	}
	
	public DoubleProperty interesProperty() {
		return interes;
	}
	
	public double getInteres() {
		return interes.get();
	}
	
	public void setInteres(double interes) {
		this.interes= new SimpleDoubleProperty(interes);
	}
	
	public DoubleProperty saldoProperty() {
		return saldo;
	}
	
	public double getSaldo() {
		return saldo.get();
	}
	
	public void setSaldo(double saldo) {
		this.saldo= new SimpleDoubleProperty(saldo);
	}
	
	public StringProperty mensajeProperty() {
		return mensaje;
	}
	
	public String getMensaje() {
		return mensaje.get();
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje= new SimpleStringProperty(mensaje);
	}
	
	public DoubleProperty saldoAnteriorProperty() {
		return saldoAnterior;
	}
	
	public double getSaldoAnterior() {
		return saldoAnterior.get();
	}
	
	public void setSaldoAnterior(double saldoAnterior) {
		this.saldoAnterior= new SimpleDoubleProperty(saldoAnterior);
	}
	
	public StringProperty nombreDepositanteProperty() {
		return nombreDepositante;
	}
	
	public String getNombreDepositante() {
		return nombreDepositante.get();
	}
	
	public void setNombreDepositante(String nombreDepositante) {
		this.nombreDepositante= new SimpleStringProperty(nombreDepositante);
	}
	@Override
	public String toString() {
		return interes.get() + "\t\t"
				;
	}	
}
