package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DetalleCliente {
	private StringProperty nombre;
	private StringProperty numeroCuenta;
	private StringProperty tipoCuenta;
	private StringProperty detalle;
	
	public DetalleCliente(String numeroCuenta , String tipoCuenta, String detalle){
		this.numeroCuenta= new SimpleStringProperty(numeroCuenta);
		this.tipoCuenta= new SimpleStringProperty(tipoCuenta);
		this.detalle= new SimpleStringProperty(detalle);
	}
	
	public DetalleCliente(String nombre, String numeroCuenta){
		this.nombre= new SimpleStringProperty(nombre);
		this.numeroCuenta= new SimpleStringProperty(numeroCuenta);
	}
	public StringProperty numeroCuentaProperty() {
		return numeroCuenta;
	}
	
	public String getNumeroCuenta() {
		return numeroCuenta.get();
	}
	
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta= new SimpleStringProperty(numeroCuenta);
	}
	
	public StringProperty tipoCuentaProperty() {
		return tipoCuenta;
	}
	
	public String getTipoCuenta() {
		return tipoCuenta.get();
	}
	
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta= new SimpleStringProperty(tipoCuenta);
	}
	
	public StringProperty detalleProperty() {
		return detalle;
	}
	
	public String getDetalle() {
		return detalle.get();
	}
	
	public void setDetalle(String detalle) {
		this.detalle= new SimpleStringProperty(detalle);
	}
	
	public StringProperty nombreProperty() {
		return nombre;
	}
	
	public String getNombre() {
		return nombre.get();
	}
	
	public void setNombre(String nombre) {
		this.nombre= new SimpleStringProperty(nombre);
	}
}
