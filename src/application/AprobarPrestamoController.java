package application;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Conexion;
import model.DecisionJunta;
import model.JasperReportX;

public class AprobarPrestamoController implements Initializable {
	private Main main;
	@FXML
	private TextField txtNumeroSolicitud;
	@FXML
	private Label lblNombreCliente;
	@FXML
	private Label lblNumeroCliente;
	@FXML
	private Label lblMontoAprobado;
	@FXML
	private Label lblTasaInteres;
	@FXML
	private Label lblCantidadMeses;
	@FXML
	private Label lblCuota;
	@FXML
	private Label lblTipoPrestamo;
	@FXML
	private Button btnAceptar;
	@FXML
	private Button btnBuscar;
	private Conexion conexion;
	private String patronNumeroSolicitud = "[0-9]{12}";
	private Pattern patternNumeroSolicitud;
	private Matcher matcherNumeroSolicitud;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lblNombreCliente.setText("");
		lblMontoAprobado.setText("");
		lblTasaInteres.setText("");
		lblCantidadMeses.setText("");
		lblCuota.setText("");
		lblTipoPrestamo.setText("");
		lblNumeroCliente.setText("");
		btnAceptar.setDisable(true);
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	@FXML
	public void buscar() {
		conexion = new Conexion();
		DecisionJunta decisionJunta = conexion.buscarSolicitudPrestamo(txtNumeroSolicitud.getText());
		if (decisionJunta != null) {
			lblMontoAprobado.setText("" + decisionJunta.getMontoAprobado());
			lblTasaInteres.setText("" + decisionJunta.getTasaInteres());
			lblCantidadMeses.setText("" + decisionJunta.getPlazoMeses());
			lblCuota.setText("" + decisionJunta.getCuota());
			lblNombreCliente.setText(decisionJunta.getNombreCliente());
			lblTipoPrestamo.setText(decisionJunta.getFormaPago());
			lblNumeroCliente.setText(decisionJunta.getNumeroCliente());
			btnAceptar.setDisable(false);
		} else {
			lblMontoAprobado.setText("");
			lblTasaInteres.setText("");
			lblCantidadMeses.setText("");
			lblCuota.setText("");
			lblNombreCliente.setText("CLIENTE NO ENCONTRADO");
			lblTipoPrestamo.setText("");
			lblNumeroCliente.setText("");
			btnAceptar.setDisable(true);
		}

		conexion.cerrarConexion();
	}

	public String validarDatos() {
		if (txtNumeroSolicitud.getText().isEmpty())
			return "El numero de Solicitud esta vacio";
		patternNumeroSolicitud = Pattern.compile(patronNumeroSolicitud);
		matcherNumeroSolicitud = patternNumeroSolicitud.matcher(txtNumeroSolicitud.getText());
		if (!matcherNumeroSolicitud.matches())
			return "El Numero de Solicitud debe tener 12 caracteres numericos";
		return "";
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
			String mensaje = conexion.aprobarPrestamo(txtNumeroSolicitud.getText(), lblNumeroCliente.getText());
			if (mensaje != null) {
				Alert cuadroDialogo = new Alert(AlertType.INFORMATION);
				cuadroDialogo.setContentText(mensaje);
				cuadroDialogo.setTitle("Resultado");
				cuadroDialogo.setHeaderText("Resultado:");
				cuadroDialogo.showAndWait();
				Map<String, Object> parametros = new HashMap<String, Object>();
				parametros.put("prtIdSolicitud", txtNumeroSolicitud.getText());
				JasperReportX.crearReport(conexion.getConexion(), "C:\\Users\\Zelaya\\JaspersoftWorkspace\\PrimerProyecto\\NuevaSolicitud.jasper",parametros);
				JasperReportX.showViewer();
				conexion.cerrarConexion();
			}
			btnAceptar.setDisable(true);
			lblMontoAprobado.setText("");
			lblTasaInteres.setText("");
			lblCantidadMeses.setText("");
			lblCuota.setText("");
			lblNombreCliente.setText("");
			lblTipoPrestamo.setText("");
			lblNumeroCliente.setText("");
		}
	}
}
