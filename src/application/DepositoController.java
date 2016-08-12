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

public class DepositoController implements Initializable {
	private Main main;

	@FXML
	private TextField txtNumeroCuenta;
	@FXML
	private TextField txtCantidadDeposito;
	@FXML
	private TextField txtNombreDepositante;
	@FXML
	private ImageView ivErrorNumeroCuenta;
	@FXML
	private ImageView ivErrorCantidadDeposito;
	@FXML
	private ImageView ivErrorNombreDepositante;
	@FXML
	private Label lblNombreCliente;
	@FXML
	private TableView<DetalleCuentaAhorro> tblDeposito;
	@FXML
	private TableColumn<DetalleCuentaAhorro, Date> columnaFecha;
	@FXML
	private TableColumn<DetalleCuentaAhorro, Double> columnaSaldoAnterior;
	@FXML
	private TableColumn<DetalleCuentaAhorro, Double> columnaDeposito;
	@FXML
	private TableColumn<DetalleCuentaAhorro, Double> columnaSaldoActual;
	@FXML
	private TableColumn<DetalleCuentaAhorro, String> columnaMensaje;
	@FXML
	private Button btnAceptar;
	private String patronNumeroCuenta = "[0-9]{12}";
	private Pattern patternNumeroCuenta;
	private Matcher matcherNumeroCuenta;
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
		columnaDeposito.setCellValueFactory(new PropertyValueFactory<DetalleCuentaAhorro, Double>("deposito"));
		columnaSaldoActual.setCellValueFactory(new PropertyValueFactory<DetalleCuentaAhorro, Double>("saldo"));
		columnaMensaje.setCellValueFactory(new PropertyValueFactory<DetalleCuentaAhorro, String>("mensaje"));
		tblDeposito.setItems(listaDetalleCuentaAhorro);
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
					Double.valueOf(txtCantidadDeposito.getText()), txtNombreDepositante.getText(),
					Integer.valueOf(txtNumeroCuenta.getText().substring(7, 8)));
			detalleCuentaAhorro = conexion.insertarDeposito(detalleCuentaAhorro);
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
			txtNumeroCuenta.setStyle("-fx-text-fill: red;");
			ivErrorNumeroCuenta.setImage(imageError);
			return "El Numero de Cuenta debe tener 12 caracteres numericos";
		}
		if (txtCantidadDeposito.getText().isEmpty()){
			ivErrorCantidadDeposito.setImage(imageError);
			return "La cantidad a depositar esta vacia";
		}
		if (!isNumeric(txtCantidadDeposito.getText())){
			txtCantidadDeposito.setStyle("-fx-text-fill: red;");
			ivErrorCantidadDeposito.setImage(imageError);
			return "la Cantidad de deposito debe ser numerico";
		}
		if (Double.valueOf(txtCantidadDeposito.getText()) <= 0){
			txtCantidadDeposito.setStyle("-fx-text-fill: red;");
			ivErrorCantidadDeposito.setImage(imageError);
			return "La cantidad a depositar debe ser mayor a cero";
		}	
		if (txtNombreDepositante.getText().isEmpty()){
			ivErrorNombreDepositante.setImage(imageError);
			return "El nombre del depositante esta vacio";
		}
		return "";
	}

	@FXML
	public void limpiarComponentes() {
		txtCantidadDeposito.setText("");

	}
	
	@FXML
	public void restablecerTextField() {
		ivErrorNumeroCuenta.setImage(null);
		ivErrorCantidadDeposito.setImage(null);
		ivErrorNombreDepositante.setImage(null);
		txtNumeroCuenta.setStyle("-fx-text-fill: black;");
		txtNombreDepositante.setStyle("-fx-text-fill: black;");
		txtCantidadDeposito.setStyle("-fx-text-fill: black;");
	}
	
	@FXML
	public void nuevo() {
		txtNumeroCuenta.setText("");
		txtNumeroCuenta.setDisable(false);
		txtNombreDepositante.setText("");
		txtCantidadDeposito.setText("");
		lblNombreCliente.setText("");
		btnAceptar.setDisable(true);
		listaDetalleCuentaAhorro.clear();
	}
}
