package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InformacionProyecto {
	private IntegerProperty codigoInformacionProyecto;
	private IntegerProperty codigoDireccion;
	private StringProperty nombreProyecto;
	private StringProperty descripcion;
	
	
	public InformacionProyecto(	int codigoInformacionProyecto,int codigoDireccion,
								String nombreProyecto, String descripcion){
		this.codigoInformacionProyecto= new SimpleIntegerProperty(codigoInformacionProyecto);
		this.codigoDireccion= new SimpleIntegerProperty(codigoDireccion);
		this.nombreProyecto= new SimpleStringProperty(nombreProyecto);
		this.descripcion= new SimpleStringProperty(descripcion);
	}

	public IntegerProperty codigoInformacionProyectoProperty() {
		return codigoInformacionProyecto;
	}

	public int getCodigoInformacionProyecto() {
		return codigoInformacionProyecto.get();
	}
	
	public void setCodigoInformacionProyecto(int codigoInformacionProyecto) {
		this.codigoInformacionProyecto= new SimpleIntegerProperty(codigoInformacionProyecto);
	}
	
	public IntegerProperty codigoDireccionProperty() {
		return codigoDireccion;
	}

	public int getCodigoDireccion() {
		return codigoDireccion.get();
	}
	
	public void setCodigoDireccion(int codigoDireccion) {
		this.codigoDireccion= new SimpleIntegerProperty(codigoDireccion);
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
	
	@Override
	public String toString() {
		return codigoInformacionProyecto.get() + "\t\t"
				+ nombreProyecto.get();
	}	
}
