package model;

import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Solicitud {
	private IntegerProperty codigoSolicitud;
	private IntegerProperty codigoInformacionProyecto;
	private IntegerProperty codigoInformacionPrestamo;
	private IntegerProperty codigoInformacionGarantia;
	private IntegerProperty codigoDecisionJunta;
	private IntegerProperty codigoPrestamo;
	private Date fechaSolicitud;
	private Date fechaPagoPrestamo;
	private StringProperty cantidadLetras;
	
	public Solicitud(	int codigoSolicitud,int codigoInformacionProyecto,
						int codigoInformacionPrestamo,int codigoInformacionGarantia	,
						int codigoDecisionJunta,int codigoPrestamo, Date fechaSolicitud,
						Date fechaPagoPrestamo,String cantidadLetras){
		this.codigoSolicitud= new SimpleIntegerProperty(codigoSolicitud);
		this.codigoInformacionProyecto= new SimpleIntegerProperty(codigoInformacionProyecto);
		this.codigoInformacionPrestamo=new SimpleIntegerProperty(codigoInformacionPrestamo);
		this.codigoInformacionGarantia=new SimpleIntegerProperty(codigoInformacionGarantia);
		this.codigoDecisionJunta=new SimpleIntegerProperty(codigoDecisionJunta);
		this.codigoPrestamo=new SimpleIntegerProperty(codigoPrestamo);
		this.fechaSolicitud= fechaSolicitud;
		this.fechaPagoPrestamo=fechaPagoPrestamo;
		this.cantidadLetras= new SimpleStringProperty(cantidadLetras);
	}
	public IntegerProperty codigoSolicitudProperty() {
		return codigoSolicitud;
	}

	public int getCodigoSolicitud() {
		return codigoSolicitud.get();
	}
	
	public void setCodigoSolicitud(int codigoSolicitud) {
		this.codigoSolicitud= new SimpleIntegerProperty(codigoSolicitud);
	}
	
	public IntegerProperty codigoInformacionProyectoProperty() {
		return codigoInformacionProyecto;
	}

	public int getCodigoInformacionProyectoProperty() {
		return codigoInformacionProyecto.get();
	}
	
	public void setCodigoInformacionProyecto(int codigoInformacionProyecto) {
		this.codigoInformacionProyecto= new SimpleIntegerProperty(codigoInformacionProyecto);
	}
	
	public IntegerProperty codigoInformacionPrestamoProperty() {
		return codigoInformacionPrestamo;
	}

	public int getCodigoInformacionPrestamoProperty() {
		return codigoInformacionPrestamo.get();
	}
	
	public void setCodigoInformacionPrestamo(int codigoInformacionPrestamo) {
		this.codigoInformacionPrestamo= new SimpleIntegerProperty(codigoInformacionPrestamo);
	}
	
	public IntegerProperty codigoInformacionGarantiaProperty() {
		return codigoInformacionGarantia;
	}

	public int getCodigoInformacionGarantiaProperty() {
		return codigoInformacionGarantia.get();
	}
	
	public void setCodigoInformacionGarantia(int codigoInformacionGarantia) {
		this.codigoInformacionGarantia= new SimpleIntegerProperty(codigoInformacionGarantia);
	}
	public IntegerProperty codigoDecisionJuntaProperty() {
		return codigoDecisionJunta;
	}

	public int getCodigoDecisionJunta() {
		return codigoDecisionJunta.get();
	}
	
	public void setCodigoDecisionJunta(int codigoDecisionJunta) {
		this.codigoDecisionJunta= new SimpleIntegerProperty(codigoDecisionJunta);
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
	
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public Date getFechaPagoPrestamo() {
		return fechaPagoPrestamo;
	}
	public void setFechaPagoPrestamo(Date fechaPagoPrestamo) {
		this.fechaPagoPrestamo = fechaPagoPrestamo;
	}

	public StringProperty cantidadLetrasProperty() {
		return cantidadLetras;
	}
	
	public String getCantidadLetras() {
		return cantidadLetras.get();
	}
	
	public void setCantidadLetras(String cantidadLetras) {
		this.cantidadLetras= new SimpleStringProperty(cantidadLetras);
	}
	
	@Override
	public String toString() {
		return codigoInformacionProyecto.get() + "\t\t"
				;
	}	
}
