package model;

import java.util.Date;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Cliente extends Persona {
	
	private IntegerProperty codigoProfesion;
	private IntegerProperty codigoDireccion;
	private IntegerProperty codigoEmpresa;
	private IntegerProperty codigoCargo;
	private DoubleProperty salario;
	
	
	public Cliente(String codigoPersona,int codigoEstadoCivil,int codigoDireccion,
				   String numeroIdentidad,String nombres,String apellidos, 
				   String telefono,String celular,String correoElectronico, 
			       String genero, Date fechaNacimiento,int codigoProfesion,
			       int codigoEmpresa,int codigoCargo,double salario){
		super(codigoPersona,codigoEstadoCivil,codigoDireccion,
			  numeroIdentidad,nombres,apellidos,telefono,celular,
			  correoElectronico,genero,fechaNacimiento);
		
		this.codigoProfesion=new SimpleIntegerProperty(codigoProfesion);
		this.codigoDireccion=new SimpleIntegerProperty(codigoDireccion);
		this.codigoEmpresa=new SimpleIntegerProperty(codigoEmpresa);
		this.codigoCargo= new SimpleIntegerProperty(codigoCargo);
		this.salario= new SimpleDoubleProperty(salario);	
	}
	
	public Cliente(int codigoEstadoCivil,int codigoDireccion,
			   String numeroIdentidad,String nombres,String apellidos, 
			   String telefono,String celular,String correoElectronico, 
		       String genero, Date fechaNacimiento,int codigoProfesion,
		       int codigoEmpresa,int codigoCargo,double salario){
	super(codigoEstadoCivil,codigoDireccion,
		  numeroIdentidad,nombres,apellidos,telefono,celular,
		  correoElectronico,genero,fechaNacimiento);
	
	this.codigoProfesion=new SimpleIntegerProperty(codigoProfesion);
	this.codigoDireccion=new SimpleIntegerProperty(codigoDireccion);
	this.codigoEmpresa=new SimpleIntegerProperty(codigoEmpresa);
	this.codigoCargo= new SimpleIntegerProperty(codigoCargo);
	this.salario= new SimpleDoubleProperty(salario);	
}
	public IntegerProperty codigoProfesionProperty() {
		return codigoProfesion;
	}

	public int getCodigoProfesion() {
		return codigoProfesion.get();
	}
	
	public void setCodigoProfesion(int codigoProfesion) {
		this.codigoProfesion= new SimpleIntegerProperty(codigoProfesion);
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
	public IntegerProperty codigoEmpresaProperty() {
		return codigoEmpresa;
	}

	public int getCodigoEmpresa() {
		return codigoEmpresa.get();
	}
	
	public void setCodigoEmpresa(int codigoEmpresa) {
		this.codigoEmpresa= new SimpleIntegerProperty(codigoEmpresa);
	}
	
	public IntegerProperty codigoCargoProperty() {
		return codigoCargo;
	}

	public int getCodigoCargo() {
		return codigoCargo.get();
	}
	
	public void setCodigoCargo(int codigoCargo) {
		this.codigoCargo= new SimpleIntegerProperty(codigoCargo);
	}
	
	public DoubleProperty salarioProperty() {
		return salario;
	}
	
	public double getSalario() {
		return salario.get();
	}
	
	public void setSalario(double salario) {
		this.salario= new SimpleDoubleProperty(salario);
	}
	@Override
	public String toString() {
		return codigoCargo.get() + "\t\t";
	}	
}
