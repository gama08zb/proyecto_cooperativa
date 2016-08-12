package application;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Conexion;
import model.DetalleCuentaAhorro;

public class RetiroController implements Initializable {
	private Main main;
	@FXML
	private TextField txtNumeroCuenta;
	@FXML
	private TextField txtCantidadRetiro;
	@FXML
	private TextField txtNumeroIdentidad;
	@FXML
	private ImageView ivErrorNumeroCuenta;
	@FXML
	private ImageView ivErrorCantidadRetiro;
	@FXML
	private ImageView ivErrorNumeroIdentidad;
	@FXML
	private Label lblNombreCliente;
	@FXML
	private TableView<DetalleCuentaAhorro> tblRetiro;
	@FXML
	private TableColumn<DetalleCuentaAhorro, Date> columnaFecha;
	@FXML
	private TableColumn<DetalleCuentaAhorro, Double> columnaSaldoAnterior;
	@FXML
	private TableColumn<DetalleCuentaAhorro, Double> columnaRetiro;
	@FXML
	private TableColumn<DetalleCuentaAhorro, Double> columnaSaldoActual;
	@FXML
	private TableColumn<DetalleCuentaAhorro, String> columnaMensaje;
	@FXML
	private Button btnAceptar;
	private String patronNumeroCuenta = "[0-9]{12}";
	private Pattern patternNumeroCuenta;
	private Matcher matcherNumeroCuenta;
	private String patronNumeroIdentidad = "[0-9]{13}";
	private Pattern patternNumeroIdentidad;
	private Matcher matcherNumeroIdentidad;
	private Conexion conexion;
	private ObservableList<DetalleCuentaAhorro> listaDetalleCuentaAhorro;
	private Image imageError;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		imageError = new Image("application/Image/error.png");
		lblNombreCliente.setText("");
		btnAceptar.setDisable(true);
		listaDetalleCuentaAhorro = FXCollections.observableArrayList();
		columnaFecha.setCellValueFactory(new PropertyValueFactory<DetalleCuentaAhorro, Date>("fechaActual"));
		columnaSaldoAnterior
				.setCellValueFactory(new PropertyValueFactory<DetalleCuentaAhorro, Double>("saldoAnterior"));
		columnaRetiro.setCellValueFactory(new PropertyValueFactory<DetalleCuentaAhorro, Double>("retiro"));
		columnaSaldoActual.setCellValueFactory(new PropertyValueFactory<DetalleCuentaAhorro, Double>("saldo"));
		columnaMensaje.setCellValueFactory(new PropertyValueFactory<DetalleCuentaAhorro, String>("mensaje"));
		tblRetiro.setItems(listaDetalleCuentaAhorro);
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	@FXML
	public void buscarCliente() {
		String resultado = validarDatos();
		if (!resultado.equals("")) {
			Alert cuadroDialogo = new Alert(AlertType.ERROR);
			cuadroDialogo.setContentText(resultado + ".");
			cuadroDialogo.setTitle("Error");
			cuadroDialogo.setHeaderText("Error ");
			cuadroDialogo.showAndWait();
		} else {
			conexion = new Conexion();
			String mensaje = conexion.buscarClienteCuentaRetirable(txtNumeroCuenta.getText(),
					txtNumeroCuenta.getText().substring(6, 8));
			conexion.cerrarConexion();
			if (mensaje == "")
				lblNombreCliente.setText("El Cliente No Existe");
			else {
				lblNombreCliente.setText(mensaje);
				btnAceptar.setDisable(false);
			}
		}
	}

	@FXML

	public void aceptar() {
		String resultado = validarDatos();
		if (!resultado.equals("")) {
			Alert cuadroDialogo = new Alert(AlertType.ERROR);
			cuadroDialogo.setContentText(resultado + ".");
			cuadroDialogo.setTitle("Error");
			cuadroDialogo.setHeaderText("Error ");
			cuadroDialogo.showAndWait();
		} else {

			conexion = new Conexion();
			DetalleCuentaAhorro detalleCuentaAhorro = new DetalleCuentaAhorro(txtNumeroCuenta.getText(),
					txtNumeroIdentidad.getText(), Double.valueOf(txtCantidadRetiro.getText()),
					Integer.valueOf(txtNumeroCuenta.getText().substring(6, 8)));
			detalleCuentaAhorro = conexion.insertarRetiro(detalleCuentaAhorro);
			listaDetalleCuentaAhorro.add(detalleCuentaAhorro);
			limpiarComponentes();
			txtNumeroCuenta.setDisable(true);
		}
	}

	public static boolean isNumeric(String str) {
		return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("") == false);
	}

	public String validarDatos() {
		if (txtNumeroCuenta.getText().isEmpty()){
			ivErrorNumeroCuenta.setImage(imageError);
			return "El numero de cuenta esta vacio";
		}
		patternNumeroCuenta = Pattern.compile(patronNumeroCuenta);
		matcherNumeroCuenta = patternNumeroCuenta.matcher(txtNumeroCuenta.getText());
		if (!matcherNumeroCuenta.matches()){
			ivErrorNumeroCuenta.setImage(imageError);
			txtNumeroCuenta.setStyle("-fx-text-fill: red;");
			return "El Numero de Cuenta debe tener 12 caracteres numericos";
		}
		if (txtCantidadRetiro.getText().isEmpty())
			return "La cantidad a retirar esta vacia";
		if (!isNumeric(txtCantidadRetiro.getText())){
			txtCantidadRetiro.setStyle("-fx-text-fill: red;");
			ivErrorCantidadRetiro.setImage(imageError);
			return "la Cantidad de retirar debe ser numerico";
		}
		if (Double.valueOf(txtCantidadRetiro.getText()) <= 0){
			txtCantidadRetiro.setStyle("-fx-text-fill: red;");
			ivErrorCantidadRetiro.setImage(imageError);
			return "La cantidad a retirar debe ser mayor a cero";
		}
		if (txtNumeroIdentidad.getText().isEmpty()){
			ivErrorNumeroIdentidad.setImage(imageError);
			return "El numero de identidad esta vacio";
		}
		patternNumeroIdentidad = Pattern.compile(patronNumeroIdentidad);
		matcherNumeroIdentidad = patternNumeroIdentidad.matcher(txtNumeroIdentidad.getText());
		if (!matcherNumeroIdentidad.matches()){
			ivErrorNumeroIdentidad.setImage(imageError);
			txtNumeroIdentidad.setStyle("-fx-text-fill: red;");
			return "El Numero de Identidad debe tener 13 caracteres numericos";
		}
		return "";
	}
	
	@FXML
	public void restablecerTextField() {
		ivErrorNumeroCuenta.setImage(null);
		ivErrorCantidadRetiro.setImage(null);
		ivErrorNumeroIdentidad.setImage(null);
		txtNumeroCuenta.setStyle("-fx-text-fill: black;");
		txtCantidadRetiro.setStyle("-fx-text-fill: black;");
		txtNumeroIdentidad.setStyle("-fx-text-fill: black;");
	}
	
	@FXML
	public void limpiarComponentes() {
		txtCantidadRetiro.setText("");

	}

	@FXML
	public void nuevo() {
		txtNumeroCuenta.setText("");
		txtNumeroCuenta.setDisable(false);
		txtNumeroIdentidad.setText("");
		txtCantidadRetiro.setText("");
		lblNombreCliente.setText("");
		btnAceptar.setDisable(true);
		listaDetalleCuentaAhorro.clear();

	}
}
