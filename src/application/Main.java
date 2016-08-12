package application;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Usuario;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	private Image imageIcono;
	private Stage frmPrincipal;
	private Stage frmLogin;
	private Stage frmAgregarCliente;
	private Stage frmEditarCliente;
	private Stage frmAgregarCuentaAhorro;
	private Stage frmAgregarSolicitud;
	private Stage frmAgregarPrestamo;
	private Stage frmDepositar;
	private Stage frmRetirar;
	private Stage frmPagarPrestamo;
	private PrincipalController controladorPrincipal;
	private LoginController controladorLogin;
	private EditarClienteController editarClienteController;
	private AgregarClienteController agregarClienteController;
	private AgregarCuentaAhorroController agregarCuentaAhorroController;
	private SolicitudCreditoController solicitudCreditoController;
	private AprobarPrestamoController aprobarPrestamoController;
	private DepositoController depositoController;
	private RetiroController retiroController;
	private PagarPrestamoController pagarPrestamoController;

	@Override
	public void start(Stage primaryStage) {
		frmLogin = primaryStage;
		imageIcono = new Image("application/Image/icono.png");
		try { 
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("Login.fxml")); AnchorPane
			root = (AnchorPane) loader.load(); Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("styleLogin.css").
			toExternalForm()); primaryStage.setScene(scene);
			primaryStage.resizableProperty().setValue(Boolean.FALSE);
			controladorLogin = loader.getController();
			controladorLogin.setMain(this); primaryStage.setTitle("Login");
			primaryStage.getIcons().add(imageIcono); primaryStage.show(); 
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
	}

	public void abrirFormularioPrincipal(Usuario usuario) {
		if (frmPrincipal == null) {
			imageIcono = new Image("application/Image/icono.png");
			try {
				frmPrincipal = new Stage();
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("Principal.fxml"));
				AnchorPane root = (AnchorPane) loader.load();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				controladorPrincipal = loader.getController();
				controladorPrincipal.setMain(this);
				controladorPrincipal.setUsuario(usuario);
				controladorPrincipal.setLblFooter(usuario.getNombreUsuario(), usuario.getTipoUsuario());
				frmPrincipal.setScene(scene);
				frmPrincipal.setTitle("Principal");
				frmPrincipal.getIcons().add(imageIcono);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		frmLogin.hide();
		frmPrincipal.show();
	}

	public void abrirFormularioAgregarCliente() {
		if (agregarClienteController == null) {
			imageIcono = new Image("application/Image/icono.png");
			try {
				frmAgregarCliente = new Stage();
				frmAgregarCliente.initOwner(frmPrincipal);
				frmAgregarCliente.initModality(Modality.WINDOW_MODAL);
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("AgregarCliente.fxml"));
				AnchorPane root = (AnchorPane) loader.load();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("styleCliente.css").toExternalForm());
				agregarClienteController = loader.getController();
				agregarClienteController.setMain(this);
				frmAgregarCliente.setScene(scene);
				frmAgregarCliente.setTitle("Nuevo Cliente");
				frmAgregarCliente.getIcons().add(imageIcono);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		frmAgregarCliente.show();
	}

	public void abrirFormularioEditarCliente() {
		if (editarClienteController == null) {
			imageIcono = new Image("application/Image/icono.png");
			try {
				frmEditarCliente = new Stage();
				frmEditarCliente.initOwner(frmPrincipal);
				frmEditarCliente.initModality(Modality.WINDOW_MODAL);
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("EditarCliente.fxml"));
				AnchorPane root = (AnchorPane) loader.load();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("styleCliente.css").toExternalForm());
				editarClienteController = loader.getController();
				editarClienteController.setMain(this);
				frmEditarCliente.setScene(scene);
				frmEditarCliente.setTitle("Editar Cliente");
				frmEditarCliente.getIcons().add(imageIcono);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		frmEditarCliente.show();
	}
	
	
	public void abrirFormularioAgregarCuentaAhorro() {
		if (agregarCuentaAhorroController == null) {
			imageIcono = new Image("application/Image/icono.png");
			try {
				frmAgregarCuentaAhorro = new Stage();
				frmAgregarCuentaAhorro.initOwner(frmPrincipal);
				frmAgregarCuentaAhorro.initModality(Modality.WINDOW_MODAL);
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("AgregarCuentaAhorro.fxml"));
				AnchorPane root = (AnchorPane) loader.load();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("styleCuentaAhorro.css").toExternalForm());
				agregarCuentaAhorroController = loader.getController();
				agregarCuentaAhorroController.setMain(this);
				frmAgregarCuentaAhorro.setScene(scene);
				frmAgregarCuentaAhorro.setTitle("Nueva Cuenta Ahorrro");
				frmAgregarCuentaAhorro.getIcons().add(imageIcono);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		frmAgregarCuentaAhorro.show();
	}

	public void abrirFormularioAgregarSolicitud() {
		if (solicitudCreditoController == null) {
			imageIcono = new Image("application/Image/icono.png");
			try {
				frmAgregarSolicitud = new Stage();
				frmAgregarSolicitud.initOwner(frmPrincipal);
				frmAgregarSolicitud.initModality(Modality.WINDOW_MODAL);
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("SolicitudCredito.fxml"));
				AnchorPane root = (AnchorPane) loader.load();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("stylePrestamos.css").toExternalForm());
				solicitudCreditoController = loader.getController();
				solicitudCreditoController.setMain(this);
				frmAgregarSolicitud.setScene(scene);
				frmAgregarSolicitud.setTitle("Nueva Solicitud");
				frmAgregarSolicitud.getIcons().add(imageIcono);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		frmAgregarSolicitud.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void abrirFormularioAgregarPrestamo() {
		if (aprobarPrestamoController == null) {
			imageIcono = new Image("application/Image/icono.png");
			try {
				frmAgregarPrestamo = new Stage();
				frmAgregarPrestamo.initOwner(frmPrincipal);
				frmAgregarPrestamo.initModality(Modality.WINDOW_MODAL);
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("AprobarPrestamo.fxml"));
				AnchorPane root = (AnchorPane) loader.load();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				aprobarPrestamoController = loader.getController();
				aprobarPrestamoController.setMain(this);
				frmAgregarPrestamo.setScene(scene);
				frmAgregarPrestamo.setTitle("Aprobar Prestamo");
				frmAgregarPrestamo.getIcons().add(imageIcono);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		frmAgregarPrestamo.show();
	}

	public void abrirFormularioDepositar() {
		if (depositoController == null) {
			imageIcono = new Image("application/Image/icono.png");
			try {
				frmDepositar = new Stage();
				frmDepositar.initOwner(frmPrincipal);
				frmDepositar.initModality(Modality.WINDOW_MODAL);
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("Deposito.fxml"));
				AnchorPane root = (AnchorPane) loader.load();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("styleCuentaAhorro.css").toExternalForm());
				depositoController = loader.getController();
				depositoController.setMain(this);
				frmDepositar.setScene(scene);
				frmDepositar.setTitle("Depositar");
				frmDepositar.getIcons().add(imageIcono);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		frmDepositar.show();
	}

	public void abrirFormularioRetirar() {
		if (retiroController == null) {
			imageIcono = new Image("application/Image/icono.png");
			try {
				frmRetirar = new Stage();
				frmRetirar.initOwner(frmPrincipal);
				frmRetirar.initModality(Modality.WINDOW_MODAL);
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("Retiro.fxml"));
				AnchorPane root = (AnchorPane) loader.load();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("styleCuentaAhorro.css").toExternalForm());
				retiroController = loader.getController();
				retiroController.setMain(this);
				frmRetirar.setScene(scene);
				frmRetirar.setTitle("Retirar");
				frmRetirar.getIcons().add(imageIcono);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		frmRetirar.show();
	}

	public void abrirFormularioPagarPrestamo() {
		if (pagarPrestamoController == null) {
			imageIcono = new Image("application/Image/icono.png");
			try {
				frmPagarPrestamo = new Stage();
				frmPagarPrestamo.initOwner(frmPrincipal);
				frmPagarPrestamo.initModality(Modality.WINDOW_MODAL);
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("PagarPrestamo.fxml"));
				AnchorPane root = (AnchorPane) loader.load();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				pagarPrestamoController = loader.getController();
				pagarPrestamoController.setMain(this);
				frmPagarPrestamo.setScene(scene);
				frmPagarPrestamo.setTitle("Pagar Cuota Prestamo");
				frmPagarPrestamo.getIcons().add(imageIcono);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		frmPagarPrestamo.show();
	}
}
