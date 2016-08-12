package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InformacionGarantia {
	private IntegerProperty codigoInformacionGarantia;
	private IntegerProperty codigoTipoGarantia;
	private StringProperty descripcionPrendariaHipotecaria;
	private StringProperty nombreCompletoAval1;
	private StringProperty telefonoAval1;
	private StringProperty celularAval1;
	private StringProperty direccionAval1;
	private StringProperty nombreCompletoAval2;
	private StringProperty telefonoAval2;
	private StringProperty celularAval2;
	private StringProperty direccionAval2;
	private StringProperty descripcionGarantia;
	
	public InformacionGarantia( int codigoInformacionGarantia,int codigoTipoGarantia,
			String descripcionPrendariaHipotecaria, String descripcionGarantia){
		this.codigoInformacionGarantia= new SimpleIntegerProperty(codigoInformacionGarantia);
		this.codigoTipoGarantia= new SimpleIntegerProperty(codigoTipoGarantia);
		this.descripcionPrendariaHipotecaria= new SimpleStringProperty(descripcionPrendariaHipotecaria);
		this.descripcionGarantia= new SimpleStringProperty(descripcionGarantia);
	}
	
	public InformacionGarantia( int codigoInformacionGarantia,int codigoTipoGarantia,
								String nombreCompletoAval1,String telefonoAval1,String celularAval1,
								String direccionAval1,String nombreCompletoAval2,
								String telefonoAval2,String celularAval2,String direccionAval2, String descripcionGarantia){
		this.codigoInformacionGarantia= new SimpleIntegerProperty(codigoInformacionGarantia);
		this.codigoTipoGarantia= new SimpleIntegerProperty(codigoTipoGarantia);
		this.nombreCompletoAval1= new SimpleStringProperty(nombreCompletoAval1);
		this.telefonoAval1= new SimpleStringProperty(telefonoAval1);
		this.celularAval1= new SimpleStringProperty(celularAval1);
		this.direccionAval1= new SimpleStringProperty(direccionAval1);
		this.nombreCompletoAval2= new SimpleStringProperty(nombreCompletoAval2);
		this.telefonoAval2= new SimpleStringProperty(telefonoAval2);
		this.celularAval2= new SimpleStringProperty(celularAval2);
		this.direccionAval2= new SimpleStringProperty(direccionAval2);
		this.descripcionGarantia= new SimpleStringProperty(descripcionGarantia);
	}

	public IntegerProperty codigoInformacionGarantiaProperty() {
		return codigoInformacionGarantia;
	}

	public int getCodigoInformacionGarantia() {
		return codigoInformacionGarantia.get();
	}
	
	public void setCodigoInformacionGarantia(int codigoInformacionGarantia) {
		this.codigoInformacionGarantia= new SimpleIntegerProperty(codigoInformacionGarantia);
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
	
	public StringProperty descripcionPrendariaHipotecariaProperty() {
		return descripcionPrendariaHipotecaria;
	}
	
	public String getDescripcionPrendariaHipotecaria() {
		return descripcionPrendariaHipotecaria.get();
	}
	
	public void setDescripcionPrendariaHipotecaria(String descripcionPrendariaHipotecaria) {
		this.descripcionPrendariaHipotecaria= new SimpleStringProperty(descripcionPrendariaHipotecaria);
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
	@Override
	public String toString() {
		return codigoInformacionGarantia.get() + "\t\t"
				+ codigoTipoGarantia.get();
	}	
}
