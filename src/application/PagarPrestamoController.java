package application;

import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Conexion;

import model.DetallePrestamo;

public class PagarPrestamoController implements Initializable {
	private Main main;
	@FXML
	private TextField txtNumeroPrestamo;
	@FXML
	private Label lblNombreCliente;
	@FXML
	private TableView<DetallePrestamo> tblDeposito;
	@FXML
	private TableColumn<DetallePrestamo, Date> columnaFechaPago;
	@FXML
	private TableColumn<DetallePrestamo, Double> columnaSaldoAnterior;
	@FXML
	private TableColumn<DetallePrestamo, Double> columnaPagoActual;
	@FXML
	private TableColumn<DetallePrestamo, Double> columnaSaldoActual;
	@FXML
	private Button btnBuscar;
	@FXML
	private Button btnAceptar;
	Conexion conexion;
	private ObservableList<DetallePrestamo> listaDetallePrestamo;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblNombreCliente.setText("");
		btnAceptar.setDisable(true);
		listaDetallePrestamo = FXCollections.observableArrayList();
		columnaFechaPago.setCellValueFactory(new PropertyValueFactory<DetallePrestamo, Date>("fechaPago"));
		columnaSaldoAnterior.setCellValueFactory(new PropertyValueFactory<DetallePrestamo, Double>("saldoAnterior"));
		columnaPagoActual.setCellValueFactory(new PropertyValueFactory<DetallePrestamo, Double>("pagoActual"));
		columnaSaldoActual.setCellValueFactory(new PropertyValueFactory<DetallePrestamo, Double>("saldoActual"));
	}

	@FXML
	public void buscarCliente() {
		listaDetallePrestamo.clear();
		conexion = new Conexion();
		lblNombreCliente.setText(conexion.buscarPrestamo(txtNumeroPrestamo.getText()));
		if (lblNombreCliente.getText() != "") {
			conexion.llenarListaPrestamos(txtNumeroPrestamo.getText(), listaDetallePrestamo);
			tblDeposito.setItems(listaDetallePrestamo);
			btnAceptar.setDisable(false);

		} else {
			lblNombreCliente.setText("EL CLIENTE NO EXISTE");
			btnAceptar.setDisable(true);
		}
		conexion.cerrarConexion();
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	@FXML
	public void aceptar() {
		conexion = new Conexion();
		String mensaje = conexion.pagarPrestamo(txtNumeroPrestamo.getText());
		if (mensaje.length() >= 42) {
			if (mensaje.substring(0, 42).equals("ERROR: EL CLIENTE ESTA ATRASADO EN SU PAGO")) {
				Alert cuadroDialogo = new Alert(AlertType.CONFIRMATION);
				cuadroDialogo.setContentText(mensaje + "." + " ¿desea pagar su deuda?");
				cuadroDialogo.setTitle("Error");
				cuadroDialogo.setHeaderText("Error ");
				cuadroDialogo.showAndWait();
				Optional<ButtonType> result = cuadroDialogo.showAndWait();
				if (result.get() == ButtonType.OK) {
					mensaje = conexion.pagarPrestamoAtrasado(txtNumeroPrestamo.getText());
				}
			} else {
				conexion = new Conexion();
				listaDetallePrestamo.clear();
				conexion.llenarListaPrestamos(txtNumeroPrestamo.getText(), listaDetallePrestamo);
				Alert cuadroDialogo = new Alert(AlertType.INFORMATION);
				cuadroDialogo.setContentText(mensaje + ".");
				cuadroDialogo.setTitle("INFORMACION");
				cuadroDialogo.setHeaderText("INFORMACION ");
				cuadroDialogo.showAndWait();
			}
		} else {
			Alert cuadroDialogo = new Alert(AlertType.INFORMATION);
			cuadroDialogo.setContentText(mensaje + ".");
			cuadroDialogo.setTitle("INFORMACION");
			cuadroDialogo.setHeaderText("INFORMACION ");
			cuadroDialogo.showAndWait();
		}

		conexion.cerrarConexion();
	}
}
