package application;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Conexion;
import model.TipoCuenta;

public class AgregarCuentaAhorroController implements Initializable {
	private Main main;
	@FXML
	private TextField txtCodigoCliente;
	@FXML
	private ComboBox<TipoCuenta> cboTipoCuenta;
	@FXML
	private DatePicker dpFechaFinalizacion;
	@FXML
	private Label lblFechaFinalizacion;
	@FXML
	private Button btnAceptar;
	@FXML
	private Button btnCancelar;
	@FXML
	private TextField txtBeneficiario;
	@FXML
	private ImageView ivErrorCodigoCliente;
	@FXML
	private ImageView ivErrorTipoCuenta;
	@FXML
	private ImageView ivErrorFechaFinalizacion;
	@FXML
	private ImageView ivErrorBeneficiario;
	private Image imageError;
	private ObservableList<TipoCuenta> listaTipoCuenta;
	private Conexion conexion;
	private String patronCodigoCliente = "[0-9]{12}";
	private Pattern patternCodigoCliente;
	private Matcher matcherCodigoCliente;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imageError = new Image("application/Image/error.png");
		dpFechaFinalizacion.setVisible(false);
		lblFechaFinalizacion.setVisible(false);
		conexion = new Conexion();
		listaTipoCuenta = FXCollections.observableArrayList();
		conexion.llenarInformacionTipoCuenta(listaTipoCuenta);
		cboTipoCuenta.setItems(listaTipoCuenta);

		cboTipoCuenta.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TipoCuenta>() {
			@Override
			public void changed(ObservableValue<? extends TipoCuenta> lista, TipoCuenta oldValue, TipoCuenta newValue) {
				if (newValue!=null){
					if (newValue.getCodigoTipoCuenta() == 2) {
						dpFechaFinalizacion.setVisible(true);
						lblFechaFinalizacion.setVisible(true);
					}else{
						dpFechaFinalizacion.setVisible(false);
						lblFechaFinalizacion.setVisible(false);
					}
				}else{
					dpFechaFinalizacion.setVisible(false);
					lblFechaFinalizacion.setVisible(false);
				}
			}
		});
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	@FXML
	public void guardarCuentaAhorro() {
		String resultado = validarDatos();
		if (!resultado.equals("")) {
			Alert cuadroDialogo = new Alert(AlertType.ERROR);
			cuadroDialogo.setContentText(resultado + ".");
			cuadroDialogo.setTitle("Error");
			cuadroDialogo.setHeaderText("Error ");
			cuadroDialogo.showAndWait();
		} else {
			conexion = new Conexion();
			if (cboTipoCuenta.getSelectionModel().getSelectedItem().getCodigoTipoCuenta() == 2) {
				if (dpFechaFinalizacion.getValue() != null) {
					String mensajeCuentaAhorro = conexion.insertarCuentaAhorroPlazo(txtCodigoCliente.getText(),
							cboTipoCuenta.getSelectionModel().getSelectedItem().getCodigoTipoCuenta(),
							Date.valueOf(dpFechaFinalizacion.getValue()), txtBeneficiario.getText());
					Alert cuadroDialogo = new Alert(AlertType.INFORMATION);
					cuadroDialogo.setContentText(mensajeCuentaAhorro + ".");
					cuadroDialogo.setTitle("Resultado");
					cuadroDialogo.setHeaderText("Resultado:");
					cuadroDialogo.showAndWait();
					conexion.cerrarConexion();
					limpiarComponentes();
				} else {
					Alert cuadroDialogo = new Alert(AlertType.ERROR);
					dpFechaFinalizacion.setStyle("-fx-text-fill: red;");
					cuadroDialogo.setContentText("Debe ingresar la fecha de finalizacion.");
					ivErrorFechaFinalizacion.setImage(imageError);
					cuadroDialogo.setTitle("Error");
					cuadroDialogo.setHeaderText("Error ");
					cuadroDialogo.showAndWait();
				}
			} else {
				String mensajeCuentaAhorro = conexion.insertarCuentaAhorro(txtCodigoCliente.getText(),
						cboTipoCuenta.getSelectionModel().getSelectedItem().getCodigoTipoCuenta(),
						txtBeneficiario.getText());
				Alert cuadroDialogo = new Alert(AlertType.INFORMATION);
				cuadroDialogo.setContentText(mensajeCuentaAhorro + ".");
				cuadroDialogo.setTitle("Resultado");
				cuadroDialogo.setHeaderText("Resultado:");
				cuadroDialogo.showAndWait();
				conexion.cerrarConexion();
				limpiarComponentes();
			}
		}
	}

	public String validarDatos() {
		if (txtCodigoCliente.getText().isEmpty()){
			ivErrorCodigoCliente.setImage(imageError);
			return "El numero de Cliente esta vacio";
		}
		patternCodigoCliente = Pattern.compile(patronCodigoCliente);
		matcherCodigoCliente = patternCodigoCliente.matcher(txtCodigoCliente.getText());
		if (!matcherCodigoCliente.matches()){
			txtCodigoCliente.setStyle("-fx-text-fill: red;");
			ivErrorCodigoCliente.setImage(imageError);
			return "El Numero de Cliente debe tener 12 caracteres numericos";
		}
		if (cboTipoCuenta.getSelectionModel().getSelectedIndex() < 0){
			ivErrorTipoCuenta.setImage(imageError);
			cboTipoCuenta.setStyle("-fx-text-fill: red;");
			return "debe seleccionar Un tipo de Cuenta para el cliente";
		}
		if (txtBeneficiario.getText().isEmpty()){
			ivErrorBeneficiario.setImage(imageError);
			return "El nombre de Beneficiario esta vacio";
		}
		return "";
	}

	@FXML
	public void limpiarComponentes() {
		txtCodigoCliente.setText("");
		cboTipoCuenta.getSelectionModel().select(null);
		dpFechaFinalizacion.setVisible(false);
		lblFechaFinalizacion.setVisible(false);
		txtBeneficiario.setText("");
	}
	@FXML
	public void restablecerTextField() {
		ivErrorCodigoCliente.setImage(null);
		ivErrorBeneficiario.setImage(null);
		ivErrorTipoCuenta.setImage(null);
		ivErrorFechaFinalizacion.setImage(null);
		cboTipoCuenta.setStyle("-fx-text-fill: black;");
		txtCodigoCliente.setStyle("-fx-text-fill: black;");
		txtBeneficiario.setStyle("-fx-text-fill: black;");
		dpFechaFinalizacion.setStyle("-fx-text-fill: black;");
	}
}
