package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class InformacionPrestamo {
	private IntegerProperty codigoInformacionPrestamo;
	private IntegerProperty codigoFormaPago;
	private DoubleProperty montoSolicitado;
	private IntegerProperty plazoMeses;
	private DoubleProperty cuota;
	
	
	public InformacionPrestamo( int codigoInformacionPrestamo,int codigoFormaPago,
								double montoSolicitado, int plazoMeses, double cuota){
		this.codigoInformacionPrestamo= new SimpleIntegerProperty(codigoInformacionPrestamo);
		this.codigoFormaPago= new SimpleIntegerProperty(codigoFormaPago);
		this.montoSolicitado= new SimpleDoubleProperty(montoSolicitado);
		this.plazoMeses= new SimpleIntegerProperty(plazoMeses);
		this.cuota= new SimpleDoubleProperty(cuota);
	}

	public IntegerProperty codigoInformacionPrestamoProperty() {
		return codigoInformacionPrestamo;
	}

	public int getCodigoInformacionPrestamo() {
		return codigoInformacionPrestamo.get();
	}
	
	public void setCodigoInformacionPrestamo(int codigoInformacionPrestamo) {
		this.codigoInformacionPrestamo= new SimpleIntegerProperty(codigoInformacionPrestamo);
	}

	public IntegerProperty codigoFormaPagoProperty() {
		return codigoFormaPago;
	}

	public int getCodigoFormaPago() {
		return codigoFormaPago.get();
	}
	
	public void setCodigoFormaPago(int codigoFormaPago) {
		this.codigoFormaPago= new SimpleIntegerProperty(codigoFormaPago);
	}
	
	public DoubleProperty montoSolicitadoProperty() {
		return montoSolicitado;
	}
	
	public double getMontoSolicitado() {
		return montoSolicitado.get();
	}
	
	public void setMontoSolicitado(double montoSolicitado) {
		this.montoSolicitado= new SimpleDoubleProperty(montoSolicitado);
	}
	
	public IntegerProperty plazoMesesProperty() {
		return plazoMeses;
	}

	public int getPlazoMeses() {
		return plazoMeses.get();
	}
	
	public void setPlazoMeses(int  plazoMeses) {
		this.plazoMeses= new SimpleIntegerProperty(plazoMeses);
	}
	
	public DoubleProperty cuotaProperty() {
		return cuota;
	}
	
	public double getCuota() {
		return cuota.get();
	}
	
	public void setCuota(double cuota) {
		this.cuota= new SimpleDoubleProperty(cuota);
	}
	@Override
	public String toString() {
		return codigoInformacionPrestamo.get() + "\t\t"
				;
	}	
}
