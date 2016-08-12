package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InformacionSolicitud {
	private IntegerProperty codigoFormaPago;
	private StringProperty codigoPersona;
	private StringProperty codigoSolicitud;
	private StringProperty nombreProyecto;
	private StringProperty descripcion;
	private IntegerProperty codigoTipoGarantia;
	private StringProperty nombreCompletoAval1;
	private StringProperty numeroIdentidadAval1;
	private StringProperty telefonoAval1;
	private StringProperty celularAval1;
	private StringProperty direccionAval1;
	private StringProperty nombreCompletoAval2;
	private StringProperty numeroIdentidadAval2;
	private StringProperty telefonoAval2;
	private StringProperty celularAval2;
	private StringProperty direccionAval2;
	private StringProperty descripcionGarantia;
	private StringProperty mensaje;
	private DoubleProperty montoSolicitado;
	private DoubleProperty tasaInteres;
	private IntegerProperty plazoMeses;
	private DoubleProperty cuota;
	private StringProperty cantidadLetras;
	
    public InformacionSolicitud(String codigoPersona, String nombreProyecto,
			String descripcion, int codigoTipoGarantia,
			String nombreCompletoAval1,
			String telefonoAval1, String celularAval1, String direccionAval1,
			String nombreCompletoAval2, String  telefonoAval2, String celularAval2,
			String direccionAval2, String descripcionGarantia, String mensaje) {
		this.codigoPersona = new SimpleStringProperty(codigoPersona);
		this.nombreProyecto = new SimpleStringProperty(nombreProyecto);
		this.descripcion = new SimpleStringProperty(descripcion);
		this.codigoTipoGarantia = new SimpleIntegerProperty(codigoTipoGarantia);
		this.nombreCompletoAval1 = new SimpleStringProperty(nombreCompletoAval1);
		this.telefonoAval1 = new SimpleStringProperty(telefonoAval1);
		this.celularAval1 = new SimpleStringProperty(celularAval1);
		this.direccionAval1 = new SimpleStringProperty(direccionAval1);
		this.nombreCompletoAval2 = new SimpleStringProperty(nombreCompletoAval2);
		this.telefonoAval2 = new SimpleStringProperty(telefonoAval2);
		this.celularAval2 = new SimpleStringProperty(celularAval2);
		this.direccionAval2 = new SimpleStringProperty(direccionAval2);
		this.descripcionGarantia = new SimpleStringProperty(descripcionGarantia);
	}
    
    public InformacionSolicitud(String codigoPersona, String nombreProyecto,
			String descripcion, int codigoTipoGarantia,
			String nombreCompletoAval1, String numeroIdentidadAval1, 
			String telefonoAval1, String celularAval1, String direccionAval1,
			String nombreCompletoAval2, String numeroIdentidadAval2, String  telefonoAval2, String celularAval2,
			String direccionAval2, String descripcionGarantia, String mensaje) {
		this.codigoPersona = new SimpleStringProperty(codigoPersona);
		this.nombreProyecto = new SimpleStringProperty(nombreProyecto);
		this.descripcion = new SimpleStringProperty(descripcion);
		this.codigoTipoGarantia = new SimpleIntegerProperty(codigoTipoGarantia);
		this.nombreCompletoAval1 = new SimpleStringProperty(nombreCompletoAval1);
		this.numeroIdentidadAval1= new SimpleStringProperty(numeroIdentidadAval1);
		this.telefonoAval1 = new SimpleStringProperty(telefonoAval1);
		this.celularAval1 = new SimpleStringProperty(celularAval1);
		this.direccionAval1 = new SimpleStringProperty(direccionAval1);
		this.nombreCompletoAval2 = new SimpleStringProperty(nombreCompletoAval2);
		this.numeroIdentidadAval2= new SimpleStringProperty(numeroIdentidadAval2);
		this.telefonoAval2 = new SimpleStringProperty(telefonoAval2);
		this.celularAval2 = new SimpleStringProperty(celularAval2);
		this.direccionAval2 = new SimpleStringProperty(direccionAval2);
		this.descripcionGarantia = new SimpleStringProperty(descripcionGarantia);
	}
    
    public InformacionSolicitud(String codigoPersona, String nombreProyecto,
			String descripcion, int codigoTipoGarantia,String nombreCompletoAval1, String numeroIdentidadAval1, 
			String telefonoAval1, String celularAval1, String direccionAval1,
			String nombreCompletoAval2, String numeroIdentidadAval2,  String  telefonoAval2, String celularAval2,
			String direccionAval2, String descripcionGarantia, 
			int codigoFormaPago,double montoSolicitado, double tasaInteres, int plazoMeses, double cuota,
			String cantidadLetras) {
		this.codigoPersona = new SimpleStringProperty(codigoPersona);
		this.nombreProyecto = new SimpleStringProperty(nombreProyecto);
		this.descripcion = new SimpleStringProperty(descripcion);
		this.codigoTipoGarantia = new SimpleIntegerProperty(codigoTipoGarantia);
		this.nombreCompletoAval1 = new SimpleStringProperty(nombreCompletoAval1);
		this.numeroIdentidadAval1 = new SimpleStringProperty(numeroIdentidadAval1);
		this.telefonoAval1 = new SimpleStringProperty(telefonoAval1);
		this.celularAval1 = new SimpleStringProperty(celularAval1);
		this.direccionAval1 = new SimpleStringProperty(direccionAval1);
		this.nombreCompletoAval2 = new SimpleStringProperty(nombreCompletoAval2);
		this.numeroIdentidadAval2 = new SimpleStringProperty(numeroIdentidadAval2);
		this.telefonoAval2 = new SimpleStringProperty(telefonoAval2);
		this.celularAval2 = new SimpleStringProperty(celularAval2);
		this.direccionAval2 = new SimpleStringProperty(direccionAval2);
		this.descripcionGarantia = new SimpleStringProperty(descripcionGarantia);
		this.codigoFormaPago= new SimpleIntegerProperty(codigoFormaPago);
		this.plazoMeses= new SimpleIntegerProperty(plazoMeses);
		this.montoSolicitado= new SimpleDoubleProperty(montoSolicitado);
		this.tasaInteres= new SimpleDoubleProperty(tasaInteres);
		this.cuota= new SimpleDoubleProperty(cuota);
		this.cantidadLetras= new SimpleStringProperty(cantidadLetras);
		
	}
    
    public InformacionSolicitud(String codigoPersona, String nombreProyecto,
			String descripcion, int codigoTipoGarantia,String nombreCompletoAval1,
			String telefonoAval1, String celularAval1, String direccionAval1,
			String nombreCompletoAval2, String  telefonoAval2, String celularAval2,
			String direccionAval2, String descripcionGarantia, 
			int codigoFormaPago,double montoSolicitado, double tasaInteres, int plazoMeses, double cuota,
			String cantidadLetras) {
		this.codigoPersona = new SimpleStringProperty(codigoPersona);
		this.nombreProyecto = new SimpleStringProperty(nombreProyecto);
		this.descripcion = new SimpleStringProperty(descripcion);
		this.codigoTipoGarantia = new SimpleIntegerProperty(codigoTipoGarantia);
		this.nombreCompletoAval1 = new SimpleStringProperty(nombreCompletoAval1);
		this.telefonoAval1 = new SimpleStringProperty(telefonoAval1);
		this.celularAval1 = new SimpleStringProperty(celularAval1);
		this.direccionAval1 = new SimpleStringProperty(direccionAval1);
		this.nombreCompletoAval2 = new SimpleStringProperty(nombreCompletoAval2);
		this.telefonoAval2 = new SimpleStringProperty(telefonoAval2);
		this.celularAval2 = new SimpleStringProperty(celularAval2);
		this.direccionAval2 = new SimpleStringProperty(direccionAval2);
		this.descripcionGarantia = new SimpleStringProperty(descripcionGarantia);
		this.codigoFormaPago= new SimpleIntegerProperty(codigoFormaPago);
		this.plazoMeses= new SimpleIntegerProperty(plazoMeses);
		this.montoSolicitado= new SimpleDoubleProperty(montoSolicitado);
		this.tasaInteres= new SimpleDoubleProperty(tasaInteres);
		this.cuota= new SimpleDoubleProperty(cuota);
		this.cantidadLetras= new SimpleStringProperty(cantidadLetras);
		
	}
    
    public InformacionSolicitud(){};
    
    
    public DoubleProperty tasaInteresProperty() {
		return tasaInteres;
	}
	
	public double getTasaInteres() {
		return tasaInteres.get();
	}
	
	public void setTasaInteres(double tasaInteres) {
		this.tasaInteres= new SimpleDoubleProperty(tasaInteres);
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
	
    public IntegerProperty codigoFormaPagoProperty() {
		return codigoFormaPago;
	}

	public int getCodigoFormaPago() {
		return codigoFormaPago.get();
	}
	
	public void setCodigoFormaPago(int codigoFormaPago) {
		this.codigoFormaPago= new SimpleIntegerProperty(codigoFormaPago);
	}
	public StringProperty codigoPersonaProperty() {
		return codigoPersona;
	}

	public String getCodigoPersona() {
		return codigoPersona.get();
	}
	
	public void setCodigoPersona(String codigoPersona) {
		this.codigoPersona= new SimpleStringProperty(codigoPersona);
	}
	
	public StringProperty codigoSolicitudProperty() {
		return codigoSolicitud;
	}

	public String getCodigoSolicitud() {
		return codigoSolicitud.get();
	}
	
	public void setCodigoSolicitud(String codigoSolicitud) {
		this.codigoSolicitud= new SimpleStringProperty(codigoSolicitud);
	}
	
	public StringProperty nombreProyectoProperty() {
		return nombreProyecto;
	}
	
	public String getNombreProyecto() {
		return nombreProyecto.get();
	}
	
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto= new SimpleStringProperty(nombreProyecto);
	}
	
	public StringProperty descripcionProperty() {
		return nombreProyecto;
	}
	
	public String getDescripcion() {
		return descripcion.get();
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion= new SimpleStringProperty(descripcion);
	}
	
	public IntegerProperty codigoTipoGarantiaProperty() {
		return codigoTipoGarantia;
	}

	public int getCodigoTipoGarantia() {
		return codigoTipoGarantia.get();
	}
	
	public void setCodigoTipoGarantia(int codigoTipoGarantia) {
		this.codigoTipoGarantia= new SimpleIntegerProperty(codigoTipoGarantia);
	}
	
	public StringProperty nombreCompletoAval1Property() {
		return nombreCompletoAval1;
	}
	
	public String getNombreCompletoAval1() {
		return nombreCompletoAval1.get();
	}
	
	public void setNombreCompletoAval1(String nombreCompletoAval1) {
		this.nombreCompletoAval1= new SimpleStringProperty(nombreCompletoAval1);
	}
	
	public StringProperty numeroIdentidadAval1Property() {
		return numeroIdentidadAval1;
	}
	
	public String getNumeroIdentidadAval1() {
		return numeroIdentidadAval1.get();
	}
	
	public void setNumeroIdentidadAval1(String numeroIdentidadAval1) {
		this.numeroIdentidadAval1= new SimpleStringProperty(numeroIdentidadAval1);
	}
	
	public StringProperty telefonoAval1Property() {
		return telefonoAval1;
	}
	
	public String getTelefonoAval1() {
		return telefonoAval1.get();
	}
	
	public void setTelefonoAval1(String telefonoAval1) {
		this.telefonoAval1= new SimpleStringProperty(telefonoAval1);
	}
	
	public StringProperty celularAval1Property() {
		return celularAval1;
	}
	
	public String getCelularAval1() {
		return celularAval1.get();
	}
	
	public void setCelularAval1(String celularAval1) {
		this.celularAval1= new SimpleStringProperty(celularAval1);
	}
	
	public StringProperty direccionAval1Property() {
		return direccionAval1;
	}
	
	public String getDireccionAval1() {
		return direccionAval1.get();
	}
	
	public void setDireccionAval1(String direccionAval1) {
		this.direccionAval1= new SimpleStringProperty(direccionAval1);
	}
	
	public StringProperty nombreCompletoAval2Property() {
		return nombreCompletoAval2;
	}
	
	public String getNombreCompletoAval2() {
		return nombreCompletoAval2.get();
	}
	
	public void setNombreCompletoAval2(String nombreCompletoAval2) {
		this.nombreCompletoAval2= new SimpleStringProperty(nombreCompletoAval2);
	}
	public StringProperty numeroIdentidadAval2Property() {
		return numeroIdentidadAval2;
	}
	
	public String getNumeroIdentidadAval2() {
		return numeroIdentidadAval2.get();
	}
	
	public void setNumeroIdentidadAval2(String numeroIdentidadAval2) {
		this.numeroIdentidadAval2= new SimpleStringProperty(numeroIdentidadAval2);
	}
	
	public StringProperty telefonoAval2Property() {
		return telefonoAval2;
	}
	
	public String getTelefonoAval2() {
		return telefonoAval2.get();
	}
	
	public void setTelefonoAval2(String telefonoAval2) {
		this.telefonoAval2= new SimpleStringProperty(telefonoAval2);
	}
	
	public StringProperty celularAval2Property() {
		return celularAval2;
	}
	
	public String getCelularAval2() {
		return celularAval2.get();
	}
	
	public void setCelularAval2(String celularAval2) {
		this.celularAval2= new SimpleStringProperty(celularAval2);
	}
	
	public StringProperty direccionAval2Property() {
		return direccionAval2;
	}
	
	public String getDireccionAval2() {
		return direccionAval2.get();
	}
	
	public void setDireccionAval2(String direccionAval2) {
		this.direccionAval2= new SimpleStringProperty(direccionAval2);
	}
	
	public StringProperty descripcionGarantiaProperty() {
		return descripcionGarantia;
	}
	
	public String getDescripcionGarantia() {
		return descripcionGarantia.get();
	}
	
	public void setDescripcionGarantia(String descripcionGarantia) {
		this.descripcionGarantia= new SimpleStringProperty(descripcionGarantia);
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
	
	public StringProperty cantidadLetrasProperty() {
		return cantidadLetras;
	}

	public String getCantidadLetras() {
		return cantidadLetras.get();
	}
	
	public void setCantidadLetras(String cantidadLetras) {
		this.cantidadLetras= new SimpleStringProperty(cantidadLetras);
	}
}
