package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Estado {
	private IntegerProperty codigoEstado;
	private IntegerProperty codigoPais;
	private StringProperty nombreEstado;
	
	public Estado(int codigoEstado, String nombreEstado){
		this.codigoEstado= new SimpleIntegerProperty(codigoEstado);
		this.nombreEstado= new SimpleStringProperty(nombreEstado);		
	}
	
	public Estado(int codigoEstado, int codigoPais,String nombreEstado){
		this.codigoEstado= new SimpleIntegerProperty(codigoEstado);
		this.codigoPais= new SimpleIntegerProperty(codigoPais);
		this.nombreEstado= new SimpleStringProperty(nombreEstado);		
	}

	public IntegerProperty codigoEstadoProperty() {
		return codigoEstado;
	}

	public int getCodigoEstado() {
		return codigoEstado.get();
	}
	
	public void setCodigoEstado(int codigoEstado) {
		this.codigoEstado= new SimpleIntegerProperty(codigoEstado);
	}

	public StringProperty nombreEstadoProperty() {
		return nombreEstado;
	}
	
	public String getNombreEstado() {
		return nombreEstado.get();
	}
	
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado= new SimpleStringProperty(nombreEstado);
	}
	
	public IntegerProperty codigoPaisProperty() {
		return codigoPais;
	}

	public int getCodigoPais() {
		return codigoPais.get();
	}
	
	public void setCodigoPais(int codigoPais) {
		this.codigoPais= new SimpleIntegerProperty(codigoPais);
	}

	@Override
	public String toString() {
		return nombreEstado.get();
	}	
}
