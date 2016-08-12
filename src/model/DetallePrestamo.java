package model;

import java.util.Date;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class DetallePrestamo {
	private IntegerProperty codigoDetallePrestamo;
	private IntegerProperty codigoPrestamo;
	private IntegerProperty codigoEmpleado;
	private Date fechaPago;
	private Date fechaAPagar;
	private DoubleProperty saldoAnterior;
	private DoubleProperty pagoActual;
	private DoubleProperty saldoActual;
	private StringProperty fecha;
	private DoubleProperty interes;
	private DoubleProperty amortizacion;
	public DetallePrestamo( int codigoDetallePrestamo,int codigoPrestamo,int codigoEmpleado,
							Date fechaPago,  double saldoAnterior, double pagoActual, 
							double saldoActual, Date fechaAPagar){
		this.codigoDetallePrestamo= new SimpleIntegerProperty(codigoDetallePrestamo);
		this.codigoPrestamo= new SimpleIntegerProperty(codigoPrestamo);
		this.codigoEmpleado= new SimpleIntegerProperty(codigoEmpleado);
		this.fechaPago = fechaPago;
		this.saldoAnterior= new SimpleDoubleProperty(saldoAnterior);
		this.pagoActual= new SimpleDoubleProperty(pagoActual);
		this.saldoActual= new SimpleDoubleProperty(saldoActual);
		this.fechaAPagar= fechaAPagar;
	}

	public DetallePrestamo( Date fechaPago, double saldoAnterior, double pagoActual, double saldoActual){
		this.fechaPago = fechaPago;
		this.saldoAnterior= new SimpleDoubleProperty(saldoAnterior);
		this.pagoActual= new SimpleDoubleProperty(pagoActual);
		this.saldoActual= new SimpleDoubleProperty(saldoActual);
	}
	
	public DetallePrestamo( String fecha, double saldoAnterior, double pagoActual, double saldoActual, double interes, double amortizacion){
		this.fecha = new SimpleStringProperty(fecha);
		this.saldoAnterior= new SimpleDoubleProperty(saldoAnterior);
		this.pagoActual= new SimpleDoubleProperty(pagoActual);
		this.saldoActual= new SimpleDoubleProperty(saldoActual);
		this.interes= new SimpleDoubleProperty(interes);
		this.amortizacion= new SimpleDoubleProperty(amortizacion);
	}
	
	public DetallePrestamo( String fecha,  double saldoAnterior, double pagoActual, 
			double saldoActual){
		this.fecha = new SimpleStringProperty(fecha);
		this.saldoAnterior= new SimpleDoubleProperty(saldoAnterior);
		this.pagoActual= new SimpleDoubleProperty(pagoActual);
		this.saldoActual= new SimpleDoubleProperty(saldoActual);
	}
	
	public IntegerProperty codigoDetallePrestamoProperty() {
		return codigoDetallePrestamo;
	}

	public int getCodigoDetallePrestamo() {
		return codigoDetallePrestamo.get();
	}
	
	public void setCodigoDetallePrestamo(int codigoDetallePrestamo) {
		this.codigoDetallePrestamo= new SimpleIntegerProperty(codigoDetallePrestamo);
	}

	public IntegerProperty codigoPrestamoProperty() {
		return codigoPrestamo;
	}

	public int getCodigoPrestamo() {
		return codigoPrestamo.get();
	}
	
	public void setCodigoPrestamo(int codigoPrestamo) {
		this.codigoPrestamo= new SimpleIntegerProperty(codigoPrestamo);
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
	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Date getFechaAPagar() {
		return fechaAPagar;
	}

	public void setFechaAPagar(Date fechaAPagar) {
		this.fechaAPagar = fechaAPagar;
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
	
	public DoubleProperty pagoActualProperty() {
		return pagoActual;
	}
	
	public double getPagoActual() {
		return pagoActual.get();
	}
	
	public void setPagoActual(double pagoActual) {
		this.pagoActual= new SimpleDoubleProperty(pagoActual);
	}
	
	public DoubleProperty saldoActualProperty() {
		return saldoActual;
	}
	
	public double getSaldoActual() {
		return saldoActual.get();
	}
	
	public void setSaldoActual(double saldoActual) {
		this.saldoActual= new SimpleDoubleProperty(saldoActual);
	}
	
	public StringProperty fechaProperty() {
		return fecha;
	}
	
	public String getFecha() {
		return fecha.get();
	}
	
	public void setFecha(String fecha) {
		this.fecha= new SimpleStringProperty(fecha);
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
	public DoubleProperty amortizacionProperty() {
		return amortizacion;
	}
	
	public double getAmortizacion() {
		return amortizacion.get();
	}
	
	public void setAmortizacion(double amortizacion) {
		this.amortizacion= new SimpleDoubleProperty(amortizacion);
	}
	
	@Override
	public String toString() {
		return codigoDetallePrestamo.get() + "\t\t"
				;
	}	
}
