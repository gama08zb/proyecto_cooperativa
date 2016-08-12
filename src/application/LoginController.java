package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Conexion;
import model.Usuario;

public class LoginController implements Initializable {
	private Main main;
	private Conexion conexion;
	@FXML
	private TextField txtUsuario;
	@FXML
	private PasswordField txtContrasena;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		conexion = new Conexion();
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	@FXML
	public void abrirFormularioPrincipal() {
		Usuario usuario = new Usuario(txtUsuario.getText(), txtContrasena.getText());
		conexion.establecerConexion();
		if (usuario.autenticar(conexion.getConexion()))
			main.abrirFormularioPrincipal(usuario);
		else {
			Alert mensaje = new Alert(AlertType.ERROR);
			mensaje.setContentText("Usuario/Password incorrectos");
			mensaje.show();
		}

		conexion.cerrarConexion();

	}
}
