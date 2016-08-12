package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class DecisionJunta {
	private IntegerProperty codigoDecisionJunta;
	private IntegerProperty codigoFormaPago;
	private IntegerProperty estadoDecision;
	private DoubleProperty montoAprobado;
	private DoubleProperty tasaInteres;
	private IntegerProperty plazoMeses;
	private DoubleProperty cuota;
	private StringProperty revisadoPorNombre;
	private StringProperty vistoBuenoNombre;
	private StringProperty nombrePresidente;
	private StringProperty nombreCliente;
	private StringProperty formaPago;
	private StringProperty numeroCliente;
	public DecisionJunta( int codigoDecisionJunta,int codigoFormaPago,
						  int estadoDecision,double montoAprobado,double tasaInteres,
						  int plazoMeses, double cuota, String revisadoPorNombre, 
						  String vistoBuenoNombre, String nombrePresidente){
		this.codigoDecisionJunta= new SimpleIntegerProperty(codigoDecisionJunta);
		this.codigoFormaPago= new SimpleIntegerProperty(codigoFormaPago);
		this.estadoDecision= new SimpleIntegerProperty(estadoDecision);
		this.montoAprobado= new SimpleDoubleProperty(montoAprobado);
		this.tasaInteres= new SimpleDoubleProperty(tasaInteres);
		this.plazoMeses= new SimpleIntegerProperty(plazoMeses);
		this.cuota= new SimpleDoubleProperty(cuota);
		this.revisadoPorNombre= new SimpleStringProperty(revisadoPorNombre);
		this.vistoBuenoNombre= new SimpleStringProperty(vistoBuenoNombre);
		this.nombrePresidente= new SimpleStringProperty(nombrePresidente);
	}
	
	public DecisionJunta(String numeroCliente, String nombreCliente, String formaPago, double montoAprobado,double tasaInteres,
			  int plazoMeses, double cuota){
			this.montoAprobado= new SimpleDoubleProperty(montoAprobado);
			this.tasaInteres= new SimpleDoubleProperty(tasaInteres);
			this.plazoMeses= new SimpleIntegerProperty(plazoMeses);
			this.cuota= new SimpleDoubleProperty(cuota);
			this.formaPago= new SimpleStringProperty(formaPago);
			this.nombreCliente= new SimpleStringProperty(nombreCliente);
			this.numeroCliente= new SimpleStringProperty(numeroCliente);
	}
	
	public DecisionJunta(){}
	
	public StringProperty numeroClienteProperty() {
		return numeroCliente;
	}
	
	public String getNumeroCliente() {
		return numeroCliente.get();
	}
	
	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente= new SimpleStringProperty(numeroCliente);
	}
	
	public StringProperty formaPagoProperty() {
		return formaPago;
	}
	
	public String getFormaPago() {
		return formaPago.get();
	}
	
	public void setFormaPago(String formaPago) {
		this.formaPago= new SimpleStringProperty(formaPago);
	}
	
	public StringProperty nombreClienteProperty() {
		return nombreCliente;
	}
	
	public String getNombreCliente() {
		return nombreCliente.get();
	}
	
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente= new SimpleStringProperty(nombreCliente);
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

	public IntegerProperty codigoFormaPagoProperty() {
		return codigoFormaPago;
	}

	public int getCodigoFormaPago() {
		return codigoFormaPago.get();
	}
	
	public void setCodigoFormaPago(int codigoFormaPago) {
		this.codigoFormaPago= new SimpleIntegerProperty(codigoFormaPago);
	}
	
	public IntegerProperty estadoDecisionProperty() {
		return estadoDecision;
	}

	public int getEstadoDecision() {
		return estadoDecision.get();
	}
	
	public void setEstadoDecision(int estadoDecision) {
		this.estadoDecision= new SimpleIntegerProperty(estadoDecision);
	}

	public DoubleProperty montoAprobadoProperty() {
		return montoAprobado;
	}
	
	public double getMontoAprobado() {
		return montoAprobado.get();
	}
	
	public void setMontoAprobado(double montoAprobado) {
		this.montoAprobado= new SimpleDoubleProperty(montoAprobado);
	}
	
	public DoubleProperty tasaInteresProperty() {
		return tasaInteres;
	}
	
	public double getTasaInteres() {
		return tasaInteres.get();
	}
	
	public void setTasaInteres(double tasaInteres) {
		this.tasaInteres= new SimpleDoubleProperty(tasaInteres);
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
	
	public StringProperty revisadoPorNombreProperty() {
		return revisadoPorNombre;
	}
	
	public String getRevisadoPorNombre() {
		return revisadoPorNombre.get();
	}
	
	public void setRevisadoPorNombre(String revisadoPorNombre) {
		this.revisadoPorNombre= new SimpleStringProperty(revisadoPorNombre);
	}
	
	public StringProperty vistoBuenoNombreProperty() {
		return vistoBuenoNombre;
	}
	
	public String getVistoBuenoNombre() {
		return vistoBuenoNombre.get();
	}
	
	public void setVistoBuenoNombre(String vistoBuenoNombre) {
		this.vistoBuenoNombre= new SimpleStringProperty(vistoBuenoNombre);
	}
	
	public StringProperty nombrePresidenteProperty() {
		return nombrePresidente;
	}
	
	public String getNombrePresidente() {
		return nombrePresidente.get();
	}
	
	public void setNombrePresidente(String nombrePresidente) {
		this.nombrePresidente= new SimpleStringProperty(nombrePresidente);
	}
	
	@Override
	public String toString() {
		return codigoDecisionJunta.get() + "\t\t"
				;
	}	
}
