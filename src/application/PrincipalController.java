package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.Usuario;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrincipalController implements Initializable {
	private Main main;
	private Usuario usuario;
	private Image imageCliente;
	private Image imageCuentaAhorro;
	private Image imageSolicitudPrestamo;
	private Image imagePrestamo;
	private Image imageNuevo;
	private Image imageEditar;
	private Image imageEliminar;
	private Image imageNuevoCliente;
	private Image imageEditarCliente;
	private Image imageEliminarCliente;
	private Image imageNuevoCuentaAhorro;
	private Image imageNuevoSolicitud;
	private Image imageNuevoPrestamo;
	private Image imageBanner;
	private Image imageDepositar;
	private Image imageRetirar;
	private Image imagePagarPrestamo;
	private Image imageNuevoCuentaAhorroF;
	private Image imageNuevoPrestamoF;
	private Image imageBuscarCliente;
	@FXML private ImageView ivCliente;
	@FXML private ImageView ivCuentaAhorro;
	@FXML private ImageView ivSolicitudPrestamos;
	@FXML private ImageView ivPrestamos;
	@FXML private ImageView ivNuevoCliente;
	@FXML private ImageView ivEditarCliente;
	@FXML private ImageView ivEliminarCliente;
	@FXML private ImageView ivNuevoCuentaAhorro;
	@FXML private ImageView ivNuevoSolicitudPrestamo;
	@FXML private ImageView ivNuevoPrestamo;
	@FXML private ImageView ivBanner;
	@FXML private ImageView ivDepositar;
	@FXML private ImageView ivRetirar;
	@FXML private ImageView ivPagarPrestamo;
	@FXML private ImageView ivNuevoCliente2;
	@FXML private ImageView ivEditarCliente2;
	@FXML private ImageView ivEliminarCliente2;
	@FXML private ImageView ivNuevoCuentaAhorro2;
	@FXML private ImageView ivNuevoSolicitudPrestamo2;
	@FXML private ImageView ivNuevoPrestamo2;
	@FXML private ImageView ivBuscarCliente;
	@FXML private Label lblFooter;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cargarImagenes();
		
	}
	
	public void setLblFooter (String nombreEmpleado, int tipoUsuario){
		String tipo;
		if (tipoUsuario==1){
			tipo="Administrador";
		}else if (tipoUsuario==2){
			tipo="Cajero";
		}else{
			tipo="No encontrado";
		}
		lblFooter.setText("Bienvenido: "+nombreEmpleado+", Tipo de Usuario: "+tipo);
	}
	public void cargarImagenes(){
		imageBanner = new Image("application/Image/banner.png");
		imageCliente = new Image("application/Image/cliente.png");
		imageCuentaAhorro = new Image("application/Image/cuentaAhorro.png");
		imageSolicitudPrestamo = new Image("application/Image/solicitud.png");
		imagePrestamo = new Image("application/Image/prestamos.png");
		imageNuevo= new Image("application/Image/agregar.png");
		imageEditar= new Image("application/Image/editar.png");
		imageEliminar= new Image("application/Image/eliminar.png");
		imageNuevoCuentaAhorroF= new Image("application/Image/agregarCuentaAhorroF.png");
		imageNuevoPrestamoF= new Image("application/Image/agregarPrestamoF.png");
		imageDepositar = new Image("application/Image/depositar.png");
		imageRetirar = new Image("application/Image/retirar.png");
		imagePagarPrestamo = new Image("application/Image/pagarPrestamo.png");
		imageEditarCliente= new Image("application/Image/editarCliente.png");
		imageNuevoCliente= new Image("application/Image/agregarCliente.png");
		imageNuevoCuentaAhorro= new Image("application/Image/agregarCuentaAhorro.png");
		imageNuevoSolicitud= new Image("application/Image/agregarSolicitud.png");
		imageNuevoPrestamo= new Image("application/Image/agregarPrestamo.png");
		imageEliminarCliente= new Image("application/Image/eliminarCliente.png");
		imageBuscarCliente= new Image("application/Image/buscarCliente.png");
		ivCliente.setImage(imageCliente);
		ivCuentaAhorro.setImage(imageCuentaAhorro);
		ivSolicitudPrestamos.setImage(imageSolicitudPrestamo);
		ivPrestamos.setImage(imagePrestamo);
		ivNuevoCliente.setImage(imageNuevo);
		ivNuevoCuentaAhorro.setImage(imageNuevoCuentaAhorroF);
		ivNuevoPrestamo.setImage(imageNuevoPrestamoF);
		ivEditarCliente.setImage(imageEditar);
		ivEliminarCliente.setImage(imageEliminar);
		ivBanner.setImage(imageBanner);
		
		ivNuevoCliente2.setImage(imageNuevoCliente);
		ivEditarCliente2.setImage(imageEditarCliente);
		ivEliminarCliente2.setImage(imageEliminarCliente);
		ivNuevoCuentaAhorro2.setImage(imageNuevoCuentaAhorro);
		ivNuevoSolicitudPrestamo2.setImage(imageNuevoSolicitud);
		ivNuevoPrestamo2.setImage(imageNuevoPrestamo);
		ivDepositar.setImage(imageDepositar);
		ivRetirar.setImage(imageRetirar);
		ivPagarPrestamo.setImage(imagePagarPrestamo);
		ivBuscarCliente.setImage(imageBuscarCliente);
	}
	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@FXML
	public void abrirFormularioAgregarCliente(){
		main.abrirFormularioAgregarCliente();
	}
	
	@FXML
	public void abrirFormularioBuscarCliente(){
		main.abrirFormularioBuscadorCliente();
	}
	
	@FXML
	public void abrirFormularioEditarCliente(){
		main.abrirFormularioEditarCliente();
	}
	
	
	@FXML
	public void abrirFormularioAgregarCuentaAhorro(){
		main.abrirFormularioAgregarCuentaAhorro();
	}
	
	@FXML
	public void abrirFormularioAgregarSolicitud(){
		main.abrirFormularioAgregarSolicitud();
	}
	
	@FXML
	public void abrirFormularioAgregarPrestamo(){
		main.abrirFormularioAgregarPrestamo();
	}
	
	@FXML
	public void abrirFormularioDepositar(){
		main.abrirFormularioDepositar();
	}
	
	@FXML
	public void abrirFormularioRetirar(){
		main.abrirFormularioRetirar();
	}
	
	@FXML
	public void abrirFormularioPagarPrestamo(){
		main.abrirFormularioPagarPrestamo();
	}
	
	@FXML
	public void agregarOscuro(){
		imageNuevo= new Image("application/Image/agregarOscuro.png");
		ivNuevoCliente.setImage(imageNuevo);
	}
	
	@FXML
	public void agregarOscuro1(){
		imageNuevo= new Image("application/Image/agregarOscuro.png");
		ivNuevoCuentaAhorro.setImage(imageNuevo);
	}
	
	@FXML
	public void agregarOscuro2(){
		imageNuevo= new Image("application/Image/agregarOscuro.png");
		ivNuevoSolicitudPrestamo.setImage(imageNuevo);
	}
	
	@FXML
	public void agregarOscuro3(){
		imageNuevo= new Image("application/Image/agregarOscuro.png");
		ivNuevoPrestamo.setImage(imageNuevo);
	}
	
	
	@FXML
	public void agregar(){
		imageNuevo= new Image("application/Image/agregar.png");
		ivNuevoCliente.setImage(imageNuevo);
	}
	
	@FXML
	public void agregar1(){
		imageNuevo= new Image("application/Image/agregar.png");
		ivNuevoCuentaAhorro.setImage(imageNuevo);
	}
	
	@FXML
	public void agregar2(){
		imageNuevo= new Image("application/Image/agregar.png");
		ivNuevoSolicitudPrestamo.setImage(imageNuevo);
	}
	
	@FXML
	public void agregar3(){
		imageNuevo= new Image("application/Image/agregar.png");
		ivNuevoPrestamo.setImage(imageNuevo);
	}
	
	@FXML
	public void agregarClienteOscuro(){
		imageNuevoCliente= new Image("application/Image/agregarClienteOscuro.png");
		ivNuevoCliente2.setImage(imageNuevoCliente);
	}
	
	@FXML
	public void agregarCliente(){
		imageNuevoCliente= new Image("application/Image/agregarCliente.png");
		ivNuevoCliente2.setImage(imageNuevoCliente);
	}
	
	@FXML
	public void eliminarClienteOscuro(){
		imageEliminarCliente= new Image("application/Image/eliminarClienteOscuro.png");
		ivEliminarCliente2.setImage(imageEliminarCliente);
	}
	
	@FXML
	public void eliminarCliente(){
		imageEliminarCliente= new Image("application/Image/eliminarCliente.png");
		ivEliminarCliente2.setImage(imageEliminarCliente);
	}
	
	@FXML
	public void editarClienteOscuro(){
		imageEditarCliente= new Image("application/Image/editarClienteOscuro.png");
		ivEditarCliente2.setImage(imageEditarCliente);
	}
	
	@FXML
	public void editarCliente(){
		imageEditarCliente= new Image("application/Image/editarCliente.png");
		ivEditarCliente2.setImage(imageEditarCliente);
	}
	
	//
	@FXML
	public void agregarCuentaAhorroOscuro(){
		imageNuevoCuentaAhorro= new Image("application/Image/agregarCuentaAhorroOscuro.png");
		ivNuevoCuentaAhorro2.setImage(imageNuevoCuentaAhorro);
	}
	
	@FXML
	public void agregarCuentaAhorro(){
		imageNuevoCuentaAhorro= new Image("application/Image/agregarCuentaAhorro.png");
		ivNuevoCuentaAhorro2.setImage(imageNuevoCuentaAhorro);
	}
	
	
	
	//
	@FXML
	public void agregarSolicitudOscuro(){
		imageNuevoSolicitud= new Image("application/Image/agregarSolicitudOscuro.png");
		ivNuevoSolicitudPrestamo2.setImage(imageNuevoSolicitud);
	}
	
	@FXML
	public void agregarSolicitud(){
		imageNuevoSolicitud= new Image("application/Image/agregarSolicitud.png");
		ivNuevoSolicitudPrestamo2.setImage(imageNuevoSolicitud);
	}
	
	//
	@FXML
	public void agregarPrestamoOscuro(){
		imageNuevoPrestamo= new Image("application/Image/agregarPrestamoOscuro.png");
		ivNuevoPrestamo2.setImage(imageNuevoPrestamo);
	}
	
	@FXML
	public void agregarPrestamo(){
		imageNuevoPrestamo= new Image("application/Image/agregarPrestamo.png");
		ivNuevoPrestamo2.setImage(imageNuevoPrestamo);
	}
	
	//
	public void editarOscuro(){
		imageEditar= new Image("application/Image/editarOscuro.png");
		ivEditarCliente.setImage(imageEditar);
	}
	
	@FXML
	public void editar(){
		imageEditar= new Image("application/Image/Editar.png");
		ivEditarCliente.setImage(imageEditar);
	}

	@FXML
	public void eliminarOscuro(){
		imageEliminar= new Image("application/Image/eliminarOscuro.png");
		ivEliminarCliente.setImage(imageEliminar);
	}
	
	
	
	
	
	
	@FXML
	public void eliminar(){
		imageEliminar= new Image("application/Image/eliminar.png");
		ivEliminarCliente.setImage(imageEliminar);
	}
	
	
	
	
	
	
	@FXML
	public void depositarOscuro(){
		imageDepositar= new Image("application/Image/depositarOscuro.png");
		ivDepositar.setImage(imageDepositar);
	}
	
	@FXML
	public void retirarOscuro(){
		imageRetirar= new Image("application/Image/retirarOscuro.png");
		ivRetirar.setImage(imageRetirar);
	}
	
	@FXML
	public void pagarPrestamoOscuro(){
		imagePagarPrestamo= new Image("application/Image/pagarPrestamoOscuro.png");
		ivPagarPrestamo.setImage(imagePagarPrestamo);
	}
	
	@FXML
	public void depositar(){
		imageDepositar= new Image("application/Image/depositar.png");
		ivDepositar.setImage(imageDepositar);
	}
	
	@FXML
	public void retirar(){
		imageRetirar= new Image("application/Image/retirar.png");
		ivRetirar.setImage(imageRetirar);
	}
	
	@FXML
	public void pagarPrestamo(){
		imagePagarPrestamo= new Image("application/Image/pagarPrestamo.png");
		ivPagarPrestamo.setImage(imagePagarPrestamo);
	}
	
	@FXML
	public void nuevaCuentaAhorroOscuro(){
		imageNuevoCuentaAhorroF= new Image("application/Image/agregarCuentaAhorroFOscuro.png");
		ivNuevoCuentaAhorro.setImage(imageNuevoCuentaAhorroF);
	}
	@FXML
	public void nuevaCuentaAhorro(){
		imageNuevoCuentaAhorroF= new Image("application/Image/agregarCuentaAhorroF.png");
		ivNuevoCuentaAhorro.setImage(imageNuevoCuentaAhorroF);
	}
	
	@FXML
	public void nuevaSolicitudOscuro(){
		imageSolicitudPrestamo = new Image("application/Image/solicitudOscuro.png");
		ivSolicitudPrestamos.setImage(imageSolicitudPrestamo);
	}
	@FXML
	public void nuevaSolicitud(){
		imageSolicitudPrestamo = new Image("application/Image/solicitud.png");
		ivSolicitudPrestamos.setImage(imageSolicitudPrestamo);
	}
	
	@FXML
	public void nuevoPrestamo(){
		imageNuevoPrestamoF= new Image("application/Image/agregarPrestamoF.png");
		ivNuevoPrestamo.setImage(imageNuevoPrestamoF);
	}
	@FXML
	public void nuevoPrestamoOscuro(){
		imageNuevoPrestamoF= new Image("application/Image/agregarPrestamoFOscuro.png");
		ivNuevoPrestamo.setImage(imageNuevoPrestamoF);
	}
	
	
}
