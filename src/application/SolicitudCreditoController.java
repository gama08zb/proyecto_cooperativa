package application;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Conexion;
import model.DetallePrestamo;
import model.FormaPago;
import model.InformacionSolicitud;
import model.JasperReportX;
import model.TipoGarantia;

public class SolicitudCreditoController implements Initializable {
	private Main main;
	@FXML
	private ComboBox<FormaPago> cboFormaPago;
	@FXML
	private ComboBox<TipoGarantia> cboTipoGarantia;
	@FXML
	private Label lblMensaje;
	@FXML
	private Label lblDescripcionGarantia;
	@FXML
	private Label lblNombreAval1;
	@FXML
	private Label lblNumeroIdentidadAval1;
	@FXML
	private Label lblTelefonoAval1;
	@FXML
	private Label lblCelularAval1;
	@FXML
	private Label lblDireccionAval1;
	@FXML
	private Label lblNombreAval2;
	@FXML
	private Label lblNumeroIdentidadAval2;
	@FXML
	private Label lblTelefonoAval2;
	@FXML
	private Label lblCelularAval2;
	@FXML
	private Label lblDireccionAval2;
	@FXML
	private TextField txtCodigoCliente;
	@FXML
	private TextField txtMontoSolicitado;
	@FXML
	private TextField txtTasaInteres;
	@FXML
	private TextField txtCantidadMeses;
	@FXML
	private TextField txtNombreProyecto;
	@FXML
	private TextField txtDescripcionProyecto;
	@FXML
	private TextArea txaDescripcionGarantia;
	@FXML
	private TextField txtNombreAval1;
	@FXML
	private TextField txtNumeroIdentidadAval1;
	@FXML
	private TextField txtTelefonoAval1;
	@FXML
	private TextField txtCelularAval1;
	@FXML
	private TextField txtDireccionAval1;
	@FXML
	private TextField txtNombreAval2;
	@FXML
	private TextField txtNumeroIdentidadAval2;
	@FXML
	private TextField txtTelefonoAval2;
	@FXML
	private TextField txtCelularAval2;
	@FXML
	private TextField txtDireccionAval2;
	private String patronNumeroCliente = "[0-9]{12}";
	private Pattern patternNumeroCliente;
	private Matcher matcherNumeroCliente;
	private String patronNumeroIdentidadAval1 = "[0-9]{13}";
	private Pattern patterNumeroIdentidadAval1;
	private Matcher matcherNumeroIdentidadAval1;
	private Pattern patternNumeroIdentidadAval2;
	private Matcher matcherNumeroIdentidadAval2;
	@FXML
	private Button btnCalcular;
	@FXML
	private Button btnBuscar;
	@FXML
	private Button btnAceptar;
	@FXML
	private TableView<DetallePrestamo> tblDetallePrestamo;
	@FXML
	private TableColumn<DetallePrestamo, String> columnaFechaPago;
	@FXML
	private TableColumn<DetallePrestamo, Double> columnaSaldoAnterior;
	@FXML
	private TableColumn<DetallePrestamo, Double> columnaCuota;
	@FXML
	private TableColumn<DetallePrestamo, Double> columnaSaldoActual;
	@FXML
	private TableColumn<DetallePrestamo, Double> columnaInteres;
	@FXML
	private TableColumn<DetallePrestamo, Double> columnaAmortizacion;
	@FXML
	private ImageView ivErrorNumeroCliente;
	@FXML
	private ImageView ivErrorNombreProyecto;
	@FXML
	private ImageView ivErrorDescripcionProyecto;
	@FXML
	private ImageView ivErrorTipoGarantia;
	@FXML
	private ImageView ivErrorNombreAval1;
	@FXML
	private ImageView ivErrorNumeroIdentidadAval1;
	@FXML
	private ImageView ivErrorTelefonoAval1;
	@FXML
	private ImageView ivErrorCelularAval1;
	@FXML
	private ImageView ivErrorDireccionAval1;
	@FXML
	private ImageView ivErrorNombreAval2;
	@FXML
	private ImageView ivErrorNumeroIdentidadAval2;
	@FXML
	private ImageView ivErrorTelefonoAval2;
	@FXML
	private ImageView ivErrorCelularAval2;
	@FXML
	private ImageView ivErrorDireccionAval2;
	@FXML
	private ImageView ivErrorFormaPago;
	@FXML
	private ImageView ivErrorMontoSolicitado;
	@FXML
	private ImageView ivErrorTasaInteres;
	@FXML
	private ImageView ivErrorCantidadMeses;
	@FXML
	private ImageView ivError;
	private Image imageError;
	private Conexion conexion;
	private ObservableList<DetallePrestamo> listaDetallePrestamo;
	private ObservableList<FormaPago> listaFormaPago;
	private ObservableList<TipoGarantia> listaTipoGarantia;
	private double cuota;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		imageError = new Image("application/Image/error.png");
		conexion = new Conexion();
		iniciarComponentes();
		listaDetallePrestamo = FXCollections.observableArrayList();
		listaFormaPago = FXCollections.observableArrayList();
		listaTipoGarantia = FXCollections.observableArrayList();
		columnaFechaPago.setCellValueFactory(new PropertyValueFactory<DetallePrestamo, String>("fecha"));
		columnaSaldoAnterior.setCellValueFactory(new PropertyValueFactory<DetallePrestamo, Double>("saldoAnterior"));
		columnaCuota.setCellValueFactory(new PropertyValueFactory<DetallePrestamo, Double>("pagoActual"));
		columnaSaldoActual.setCellValueFactory(new PropertyValueFactory<DetallePrestamo, Double>("saldoActual"));
		columnaInteres.setCellValueFactory(new PropertyValueFactory<DetallePrestamo, Double>("interes"));
		columnaAmortizacion.setCellValueFactory(new PropertyValueFactory<DetallePrestamo, Double>("amortizacion"));
		tblDetallePrestamo.setItems(listaDetallePrestamo);
		conexion.llenarInformacionFormaPago(listaFormaPago);
		conexion.llenarInformacionTipoGarantia(listaTipoGarantia);
		cboFormaPago.setItems(listaFormaPago);
		cboTipoGarantia.setItems(listaTipoGarantia);
		conexion.cerrarConexion();
		cboFormaPago.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<FormaPago>() {
			@Override
			public void changed(ObservableValue<? extends FormaPago> lista, FormaPago oldValue, FormaPago newValue) {
				if (newValue!=null){
					if (newValue.getCodigoFormaPago() == 1) {
						txtCantidadMeses.setText("1");
						txtCantidadMeses.setDisable(true);
					} else
						txtCantidadMeses.setDisable(false);
					}
				}
			});
		cboTipoGarantia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TipoGarantia>() {
			@Override
			public void changed(ObservableValue<? extends TipoGarantia> lista, TipoGarantia oldValue,
					TipoGarantia newValue) {
				if (newValue!=null){
					if (newValue.getCodigoTipoGarantia() == 1 || (newValue.getCodigoTipoGarantia() == 2)) {
						lblNombreAval1.setText("Descripcion Garantia: ");
						lblNumeroIdentidadAval1.setText("");
						lblTelefonoAval1.setText("");
						lblCelularAval1.setText("");
						lblDireccionAval1.setText("");
						lblNombreAval2.setText("");
						lblNumeroIdentidadAval2.setText("");
						lblTelefonoAval2.setText("");
						lblCelularAval2.setText("");
						lblDireccionAval2.setText("");
						lblDescripcionGarantia.setText("");
						txaDescripcionGarantia.setDisable(true);
						txtNombreAval1.setDisable(false);
						txtNumeroIdentidadAval1.setDisable(true);
						txtTelefonoAval1.setDisable(true);
						txtCelularAval1.setDisable(true);
						txtDireccionAval1.setDisable(true);
						txtNombreAval2.setDisable(true);
						txtNumeroIdentidadAval2.setDisable(true);
						txtTelefonoAval2.setDisable(true);
						txtCelularAval2.setDisable(true);
						txtDireccionAval2.setDisable(true);
					} else if (newValue.getCodigoTipoGarantia() == 3) {
						lblDescripcionGarantia.setText("Descripcion Garantia: ");
						lblNombreAval1.setText("Nombre Completo del Aval: ");
						lblNumeroIdentidadAval1.setText("Numero de Identidad Aval: ");
						lblTelefonoAval1.setText("Numero de Telefono: ");
						lblCelularAval1.setText("Numero de Celular: ");
						lblDireccionAval1.setText("Direccion: ");
						lblNombreAval2.setText("Nombre Completo Aval: ");
						lblNumeroIdentidadAval2.setText("Numero de Identidad Aval: ");
						lblTelefonoAval2.setText("Numero de Telefono: ");
						lblCelularAval2.setText("Numero de Celular: ");
						lblDireccionAval2.setText("Direccion: ");
						txtNombreAval1.setDisable(false);
						txtNumeroIdentidadAval1.setDisable(false);
						txtTelefonoAval1.setDisable(false);
						txtCelularAval1.setDisable(false);
						txtDireccionAval1.setDisable(false);
						txtNombreAval2.setDisable(false);
						txtNumeroIdentidadAval2.setDisable(false);
						txtTelefonoAval2.setDisable(false);
						txtCelularAval2.setDisable(false);
						txtDireccionAval2.setDisable(false);
						txaDescripcionGarantia.setDisable(false);
					}
				}
				}
			});
		conexion.cerrarConexion();
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	@FXML
	public void calcular() {
		String resultado = validar();
		if (!resultado.equals("")) {
			Alert cuadroDialogo = new Alert(AlertType.ERROR);
			cuadroDialogo.setContentText(resultado + ".");
			cuadroDialogo.setTitle("Error");
			cuadroDialogo.setHeaderText("Error ");
			cuadroDialogo.showAndWait();
		} else {
			btnAceptar.setDisable(false);
			listaDetallePrestamo.clear();
			double montoSolicitado = Double.valueOf(txtMontoSolicitado.getText());
			double tasaInteres = Double.valueOf(txtTasaInteres.getText());
			double totalAPagar = 0;
			double totalAPagarAnterior = 0;
			
			if (cboFormaPago.getSelectionModel().getSelectedItem().getCodigoFormaPago() == 1) {
				int contador = 0;
				tasaInteres = (tasaInteres / 100) + 1;
				totalAPagar = tasaInteres * montoSolicitado;
				double interes = (montoSolicitado*(Double.valueOf(txtTasaInteres.getText()) / 100))/23;
				double amortizacion= montoSolicitado/23;
				cuota = totalAPagar / 23;
				Date fechaActual = new Date();
				fechaActual = sumarRestarDiasFecha(fechaActual, 1);
				while (contador != 23) {
					if (getDayOfTheWeek(fechaActual) == 1) {
						fechaActual = sumarRestarDiasFecha(fechaActual, 1);
					} else {
						totalAPagarAnterior = totalAPagar;
						totalAPagar = totalAPagar - cuota;
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(fechaActual);
						DetallePrestamo detallePrestamo = new DetallePrestamo(calendar.get(calendar.DAY_OF_MONTH) + "/"
								+ (calendar.get(calendar.MONTH) + 1) + "/" + calendar.get(calendar.YEAR),
								totalAPagarAnterior, cuota, totalAPagar, interes, amortizacion);
						listaDetallePrestamo.add(detallePrestamo);
						contador++;
						fechaActual = sumarRestarDiasFecha(fechaActual, 1);

					}
				}
			} else if (cboFormaPago.getSelectionModel().getSelectedItem().getCodigoFormaPago() == 2) {
				int contador = 0;
				tasaInteres = (tasaInteres * Integer.valueOf(txtCantidadMeses.getText())) / 100;
				totalAPagar = montoSolicitado + (tasaInteres * montoSolicitado);
				cuota = totalAPagar / Integer.valueOf(txtCantidadMeses.getText());
				double interes = (montoSolicitado*((Double.valueOf(txtTasaInteres.getText())*Integer.valueOf(txtCantidadMeses.getText())/ 100) ))/Integer.valueOf(txtCantidadMeses.getText());
				double amortizacion= montoSolicitado/Integer.valueOf(txtCantidadMeses.getText());
				Date fechaActual = new Date();
				fechaActual = sumarRestarMesFecha(fechaActual, 1);
				while (contador != Integer.valueOf(txtCantidadMeses.getText())) {
					totalAPagarAnterior = totalAPagar;
					totalAPagar = totalAPagar - cuota;
					totalAPagar = Math.round(totalAPagar * 100.0) / 100.0;
					cuota=Math.round(cuota * 100.0) / 100.0;
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(fechaActual);
					DetallePrestamo detallePrestamo = new DetallePrestamo(calendar.get(calendar.DAY_OF_MONTH) + "/"
							+ (calendar.get(calendar.MONTH) + 1) + "/" + calendar.get(calendar.YEAR),
							totalAPagarAnterior, cuota, totalAPagar, interes, amortizacion);
					listaDetallePrestamo.add(detallePrestamo);
					contador++;
					fechaActual = sumarRestarMesFecha(fechaActual, 1);
				}

			} else if (cboFormaPago.getSelectionModel().getSelectedItem().getCodigoFormaPago() == 3) {
				int contador = 0;
				double interes=0;
				double cuotaMonto=0;
				tasaInteres = (tasaInteres / 100);
				totalAPagar = montoSolicitado;
				cuotaMonto = montoSolicitado / Integer.valueOf(txtCantidadMeses.getText());
				Date fechaActual = new Date();
				fechaActual = sumarRestarMesFecha(fechaActual, 1);
				while (contador != Integer.valueOf(txtCantidadMeses.getText())) {
					interes=totalAPagar*tasaInteres;
					cuota=cuotaMonto+interes;
					totalAPagarAnterior = totalAPagar;
					totalAPagar = totalAPagar - cuotaMonto;
					totalAPagar = Math.round(totalAPagar * 100.0) / 100.0;
					cuota=Math.round(cuota * 100.0) / 100.0;
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(fechaActual);
					DetallePrestamo detallePrestamo = new DetallePrestamo(calendar.get(calendar.DAY_OF_MONTH) + "/"
							+ (calendar.get(calendar.MONTH) + 1) + "/" + calendar.get(calendar.YEAR),
							totalAPagarAnterior, cuota, totalAPagar, interes, cuotaMonto);
					listaDetallePrestamo.add(detallePrestamo);
					contador++;
					fechaActual = sumarRestarMesFecha(fechaActual, 1);
				}
				cuota=0;
			}	
		}
	}

	@FXML
	public void buscarCliente() {
		patternNumeroCliente = Pattern.compile(patronNumeroCliente);
		matcherNumeroCliente = patternNumeroCliente.matcher(txtCodigoCliente.getText());
		if (!matcherNumeroCliente.matches()||txtCodigoCliente.getText().isEmpty()){
			ivErrorNumeroCliente.setImage(imageError);
			txtCodigoCliente.setStyle("-fx-text-fill: red;");
			Alert cuadroDialogo = new Alert(AlertType.ERROR);
			cuadroDialogo.setContentText("El Numero de Identidad debe tener 12 caracteres numericos" + ".");
			cuadroDialogo.setTitle("Error");
			cuadroDialogo.setHeaderText("Error ");
			cuadroDialogo.showAndWait();
			
		}else{
			conexion = new Conexion();
			InformacionSolicitud informacionSolicitud = new InformacionSolicitud();
			informacionSolicitud.setCodigoPersona(txtCodigoCliente.getText());
			informacionSolicitud = conexion.llenarInformacionSolicitud(informacionSolicitud);
			lblMensaje.setText(informacionSolicitud.getMensaje());
			if (lblMensaje.getText().equals("ERROR: EL CLIENTE NO EXISTE")) {
				btnAceptar.setDisable(true);
			} else {
	
				txtNombreProyecto.setText(informacionSolicitud.getNombreProyecto());
				txtDescripcionProyecto.setText(informacionSolicitud.getDescripcion());
				txtDescripcionProyecto.setDisable(false);
				cboTipoGarantia.setDisable(false);
				txtNombreProyecto.setDisable(false);
				cboTipoGarantia.getSelectionModel().select(informacionSolicitud.getCodigoTipoGarantia() - 1);
				if ((informacionSolicitud.getCodigoTipoGarantia() == 1)
						|| (informacionSolicitud.getCodigoTipoGarantia() == 2)) {
					txtNombreAval1.setText(informacionSolicitud.getDescripcionGarantia());
					lblNombreAval1.setText("Descripcion Garantia: ");
					lblNumeroIdentidadAval1.setText("");
					lblTelefonoAval1.setText("");
					lblCelularAval1.setText("");
					lblDireccionAval1.setText("");
					lblNombreAval2.setText("");
					lblNumeroIdentidadAval2.setText("");
					lblTelefonoAval2.setText("");
					lblCelularAval2.setText("");
					lblDireccionAval2.setText("");
					cboFormaPago.setDisable(false);
					txtMontoSolicitado.setDisable(false);
					txtTasaInteres.setDisable(false);
					txtCantidadMeses.setDisable(false);
					btnCalcular.setDisable(false);
	
				} else if (informacionSolicitud.getCodigoTipoGarantia() == 3) {
					txtNombreAval1.setText(informacionSolicitud.getNombreCompletoAval1());
					txtNumeroIdentidadAval1.setText(informacionSolicitud.getNumeroIdentidadAval1());
					txtTelefonoAval1.setText(informacionSolicitud.getTelefonoAval1());
					txtCelularAval1.setText(informacionSolicitud.getCelularAval1());
					txtDireccionAval1.setText(informacionSolicitud.getDireccionAval1());
					txtNombreAval2.setText(informacionSolicitud.getNombreCompletoAval2());
					txtNumeroIdentidadAval2.setText(informacionSolicitud.getNumeroIdentidadAval2());
					txtTelefonoAval2.setText(informacionSolicitud.getTelefonoAval2());
					txtCelularAval2.setText(informacionSolicitud.getCelularAval2());
					txtDireccionAval2.setText(informacionSolicitud.getDireccionAval2());
					txaDescripcionGarantia.setText(informacionSolicitud.getDescripcionGarantia());
					lblDescripcionGarantia.setText("Descripcion Garantia: ");
					lblNombreAval1.setText("Nombre Completo del Aval: ");
					lblNumeroIdentidadAval1.setText("Numero de identidad del Aval: ");
					lblTelefonoAval1.setText("Numero de Telefono: ");
					lblCelularAval1.setText("Numero de Celular: ");
					lblDireccionAval1.setText("Direccion: ");
					lblNombreAval2.setText("Nombre Completo Aval: ");
					lblNumeroIdentidadAval2.setText("Numero de identidad del Aval: ");
					lblTelefonoAval2.setText("Numero de Telefono: ");
					lblCelularAval2.setText("Numero de Celular: ");
					lblDireccionAval2.setText("Direccion: ");
					cboFormaPago.setDisable(false);
					txtMontoSolicitado.setDisable(false);
					txtTasaInteres.setDisable(false);
					txtCantidadMeses.setDisable(false);
					btnCalcular.setDisable(false);
					txtNombreAval1.setDisable(false);
					txtNumeroIdentidadAval1.setDisable(false);
					txtTelefonoAval1.setDisable(false);
					txtCelularAval1.setDisable(false);
					txtDireccionAval1.setDisable(false);
					txtNombreAval2.setDisable(false);
					txtNumeroIdentidadAval2.setDisable(false);
					txtTelefonoAval2.setDisable(false);
					txtCelularAval2.setDisable(false);
					txtDireccionAval2.setDisable(false);
					txaDescripcionGarantia.setDisable(false);
					cboFormaPago.setDisable(false);
					txtMontoSolicitado.setDisable(false);
					txtTasaInteres.setDisable(false);
					txtCantidadMeses.setDisable(false);
					btnCalcular.setDisable(false);
				} else {
					cboFormaPago.setDisable(false);
					txtMontoSolicitado.setDisable(false);
					txtTasaInteres.setDisable(false);
					txtCantidadMeses.setDisable(false);
					btnCalcular.setDisable(false);
					cboFormaPago.setDisable(false);
					txtMontoSolicitado.setDisable(false);
					txtTasaInteres.setDisable(false);
					txtCantidadMeses.setDisable(false);
					btnCalcular.setDisable(false);
				}
			}
			conexion.cerrarConexion();
		}
	}

	@FXML
	public void aceptar() {
		conexion = new Conexion();
		if (cboTipoGarantia.getSelectionModel().getSelectedItem().getCodigoTipoGarantia() == 1
				|| cboTipoGarantia.getSelectionModel().getSelectedItem().getCodigoTipoGarantia() == 2) {
			InformacionSolicitud informacionSolicitud = new InformacionSolicitud(txtCodigoCliente.getText(),
					txtNombreProyecto.getText(), txtDescripcionProyecto.getText(),
					cboTipoGarantia.getSelectionModel().getSelectedItem().getCodigoTipoGarantia(), null, txtNumeroIdentidadAval1.getText(),
					txtTelefonoAval1.getText(), txtCelularAval1.getText(), txtDireccionAval1.getText(),
					txtNombreAval2.getText(),txtNumeroIdentidadAval1.getText(), txtTelefonoAval2.getText(), txtCelularAval2.getText(),
					txtDireccionAval2.getText(), txtNombreAval1.getText(),
					cboFormaPago.getSelectionModel().getSelectedItem().getCodigoFormaPago(),
					Double.valueOf(txtMontoSolicitado.getText()), Double.valueOf(txtTasaInteres.getText()),
					Integer.valueOf(txtCantidadMeses.getText()), cuota, null);
			informacionSolicitud = conexion.llenarSolicitud(informacionSolicitud);
			Alert cuadroDialogo = new Alert(AlertType.INFORMATION);
			cuadroDialogo.setContentText(informacionSolicitud.getMensaje() + "\n Numero de Solicitud: "
					+ informacionSolicitud.getCodigoSolicitud());
			cuadroDialogo.setTitle("Resultado");
			cuadroDialogo.setHeaderText("Resultado:");
			cuadroDialogo.showAndWait();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("prtIdSolicitud", informacionSolicitud.getCodigoSolicitud());
			JasperReportX.crearReport(conexion.getConexion(), "C:\\Users\\Zelaya\\JaspersoftWorkspace\\PrimerProyecto\\NuevaSolicitud.jasper",parametros);
			JasperReportX.showViewer();
			conexion.cerrarConexion();
			limpiarComponentes();
		} else {
			InformacionSolicitud informacionSolicitud = new InformacionSolicitud(txtCodigoCliente.getText(),
					txtNombreProyecto.getText(), txtDescripcionProyecto.getText(),
					cboTipoGarantia.getSelectionModel().getSelectedItem().getCodigoTipoGarantia(),
					txtNombreAval1.getText(), txtNumeroIdentidadAval1.getText(),txtTelefonoAval1.getText(), txtCelularAval1.getText(),
					txtDireccionAval1.getText(), txtNombreAval2.getText(),txtNumeroIdentidadAval2.getText(), txtTelefonoAval2.getText(),
					txtCelularAval2.getText(), txtDireccionAval2.getText(), txaDescripcionGarantia.getText(),
					cboFormaPago.getSelectionModel().getSelectedItem().getCodigoFormaPago(),
					Double.valueOf(txtMontoSolicitado.getText()), Double.valueOf(txtTasaInteres.getText()),
					Integer.valueOf(txtCantidadMeses.getText()), cuota, null);
			informacionSolicitud = conexion.llenarSolicitud(informacionSolicitud);
			Alert cuadroDialogo = new Alert(AlertType.INFORMATION);
			cuadroDialogo.setContentText(informacionSolicitud.getMensaje() + " Numero de Solicitud: "
					+ informacionSolicitud.getCodigoSolicitud());
			cuadroDialogo.setTitle("Resultado");
			cuadroDialogo.setHeaderText("Resultado:");
			cuadroDialogo.showAndWait();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("prtIdSolicitud", informacionSolicitud.getCodigoSolicitud());
			JasperReportX.crearReport(conexion.getConexion(), "C:\\Users\\Zelaya\\JaspersoftWorkspace\\PrimerProyecto\\NuevaSolicitud.jasper",parametros);
			JasperReportX.showViewer();
			conexion.cerrarConexion();
			limpiarComponentes();
		}

	}

	public String validar() {
		if (txtCodigoCliente.getText().isEmpty()){
			ivErrorNumeroCliente.setImage(imageError);
			return "El numero de cliente esta vacio";}
		patternNumeroCliente = Pattern.compile(patronNumeroCliente);
		matcherNumeroCliente = patternNumeroCliente.matcher(txtCodigoCliente.getText());
		if (!matcherNumeroCliente.matches()){
			ivErrorNumeroCliente.setImage(imageError);
			txtCodigoCliente.setStyle("-fx-text-fill: red;");
			return "El Numero de Cliente debe tener 12 caracteres numericos";
		}
		if (txtNombreProyecto.getText().isEmpty()){
			ivErrorNombreProyecto.setImage(imageError);
			return "El nombre de proyecto esta vacio";
		}
		if (txtDescripcionProyecto.getText().isEmpty()){
			ivErrorNumeroCliente.setImage(imageError);
			return "La descripcion del proyecto esta vacio";
		}
		if (cboTipoGarantia.getSelectionModel().getSelectedIndex() < 0){
			ivErrorTipoGarantia.setImage(imageError);
			cboTipoGarantia.setStyle("-fx-text-fill: red;");
			return "debe seleccionar Un tipo de Garantia";}
		if (cboTipoGarantia.getSelectionModel().getSelectedItem().getCodigoTipoGarantia() == 1
				|| cboTipoGarantia.getSelectionModel().getSelectedItem().getCodigoTipoGarantia() == 2) {
			if (txtNombreAval1.getText().isEmpty()){
				ivErrorNombreAval1.setImage(imageError);
				return "la descripcion del tipo de garantia esta vacio";}
		} else {
			if (txtNombreAval1.getText().isEmpty() || txtNombreAval2.getText().isEmpty()){
				ivErrorNombreAval1.setImage(imageError);
				ivErrorNombreAval2.setImage(imageError);
				return "debe agregar un nombre de aval";
			}
			if (txtNumeroIdentidadAval1.getText().isEmpty() || txtNumeroIdentidadAval2.getText().isEmpty()){
				ivErrorNumeroIdentidadAval1.setImage(imageError);
				ivErrorNumeroIdentidadAval2.setImage(imageError);
				return "debe agregar por lo menos un numero identidad para el aval";
			}
			patterNumeroIdentidadAval1 = Pattern.compile(patronNumeroIdentidadAval1);
			matcherNumeroIdentidadAval1 = patterNumeroIdentidadAval1.matcher(txtNumeroIdentidadAval1.getText());
			if (!matcherNumeroIdentidadAval1.matches()){
				ivErrorNumeroIdentidadAval1.setImage(imageError);
				txtNumeroIdentidadAval1.setStyle("-fx-text-fill: red;");
				return "El Numero de Identidad debe tener 12 caracteres numericos";
			}
			
			patternNumeroIdentidadAval2 = Pattern.compile(patronNumeroIdentidadAval1);
			matcherNumeroIdentidadAval2 = patternNumeroIdentidadAval2.matcher(txtNumeroIdentidadAval2.getText());
			if (!matcherNumeroIdentidadAval2.matches()){
				ivErrorNumeroIdentidadAval2.setImage(imageError);
				txtNumeroIdentidadAval2.setStyle("-fx-text-fill: red;");
				return "El Numero de Identidad debe tener 12 caracteres numericos";
			}
			
			if (txtTelefonoAval1.getText().isEmpty() || txtTelefonoAval2.getText().isEmpty()){
				ivErrorTelefonoAval1.setImage(imageError);
				ivErrorTelefonoAval2.setImage(imageError);
				return "debe agregar un numero de telefono del aval";
				}
			if (txtCelularAval1.getText().isEmpty() || txtCelularAval2.getText().isEmpty()){
				ivErrorCelularAval1.setImage(imageError);
				ivErrorCelularAval2.setImage(imageError);
				return "debe agregar un numero de celular de aval";}
			if (txtDireccionAval1.getText().isEmpty() || txtDireccionAval2.getText().isEmpty()){
				ivErrorDireccionAval1.setImage(imageError);
				ivErrorDireccionAval2.setImage(imageError);
				return "debe agregar una direccion del aval";}
		}
		if (cboFormaPago.getSelectionModel().getSelectedIndex() < 0){
			ivErrorFormaPago.setImage(imageError);
			cboFormaPago.setStyle("-fx-text-fill: red;");
			return "debe seleccionar Una forma de pago";
			}
		if (txtMontoSolicitado.getText().isEmpty()){
			ivErrorMontoSolicitado.setImage(imageError);
			return "El Monto Solicitado esta vacio";
			}
		if (!isNumeric(txtMontoSolicitado.getText())) {
			ivErrorMontoSolicitado.setImage(imageError);
			txtMontoSolicitado.setStyle("-fx-text-fill: red;");
			return "la Cantidad de Monto debe ser numerico";
		}
		if (txtTasaInteres.getText().isEmpty()){
			ivErrorTasaInteres.setImage(imageError);
			return "La tasa de Interes esta vacio";}
		
		if (!isNumeric(txtTasaInteres.getText())) {
			ivErrorTasaInteres.setImage(imageError);
			txtTasaInteres.setStyle("-fx-text-fill: red;");
			return "la Cantidad de tasa interes debe ser numerico";
		}
		
		if (txtCantidadMeses.getText().isEmpty()){
			ivErrorCantidadMeses.setImage(imageError);
			return "La cantidad de Meses esta vacio";
		}
		
		if (!isNumeric(txtCantidadMeses.getText())) {
			ivErrorCantidadMeses.setImage(imageError);
			txtCantidadMeses.setStyle("-fx-text-fill: red;");
			return "la Cantidad de meses debe ser numerico";
		}
		return "";
	}

	public void iniciarComponentes() {
		lblDescripcionGarantia.setText("");
		lblNombreAval1.setText("");
		lblNumeroIdentidadAval1.setText("");
		lblTelefonoAval1.setText("");
		lblCelularAval1.setText("");
		lblDireccionAval1.setText("");
		lblNombreAval2.setText("");
		lblNumeroIdentidadAval2.setText("");
		lblTelefonoAval2.setText("");
		lblCelularAval2.setText("");
		lblDireccionAval2.setText("");
		txtNombreProyecto.setDisable(true);
		txtDescripcionProyecto.setDisable(true);
		txaDescripcionGarantia.setDisable(true);
		txtNombreAval1.setDisable(true);
		txtNumeroIdentidadAval1.setDisable(true);
		txtTelefonoAval1.setDisable(true);
		txtCelularAval1.setDisable(true);
		txtDireccionAval1.setDisable(true);
		txtNombreAval2.setDisable(true);
		txtNumeroIdentidadAval2.setDisable(true);
		txtTelefonoAval2.setDisable(true);
		txtCelularAval2.setDisable(true);
		txtDireccionAval2.setDisable(true);
		cboTipoGarantia.setDisable(true);
		txtNombreProyecto.setText("");
		txtDescripcionProyecto.setText("");
		txaDescripcionGarantia.setText("");
		txtNombreAval1.setText("");
		txtNumeroIdentidadAval1.setText("");
		txtTelefonoAval1.setText("");
		txtCelularAval1.setText("");
		txtDireccionAval1.setText("");
		txtNombreAval2.setText("");
		txtNumeroIdentidadAval2.setText("");
		txtTelefonoAval2.setText("");
		txtCelularAval2.setText("");
		txtDireccionAval2.setText("");
		btnAceptar.setDisable(true);
		cboFormaPago.setDisable(true);
		txtMontoSolicitado.setDisable(true);
		txtTasaInteres.setDisable(true);
		txtCantidadMeses.setDisable(true);
		btnCalcular.setDisable(true);
	}

	public void limpiarComponentes() {
		txtCodigoCliente.setText("");
		lblMensaje.setText("");
		lblDescripcionGarantia.setText("");
		lblNombreAval1.setText("");
		lblNumeroIdentidadAval1.setText("");
		lblTelefonoAval1.setText("");
		lblCelularAval1.setText("");
		lblDireccionAval1.setText("");
		lblNombreAval2.setText("");
		lblNumeroIdentidadAval2.setText("");
		lblTelefonoAval2.setText("");
		lblCelularAval2.setText("");
		lblDireccionAval2.setText("");
		txaDescripcionGarantia.setDisable(true);
		txtNombreAval1.setDisable(true);
		txtNumeroIdentidadAval1.setDisable(true);
		txtTelefonoAval1.setDisable(true);
		txtCelularAval1.setDisable(true);
		txtDireccionAval1.setDisable(true);
		txtNombreAval2.setDisable(true);
		txtNumeroIdentidadAval2.setDisable(true);
		txtTelefonoAval2.setDisable(true);
		txtCelularAval2.setDisable(true);
		txtDireccionAval2.setDisable(true);
		txtNombreProyecto.setText("");
		txtDescripcionProyecto.setText("");
		txaDescripcionGarantia.setText("");
		txtNombreAval1.setText("");
		txtNumeroIdentidadAval1.setText("");
		txtTelefonoAval1.setText("");
		txtCelularAval1.setText("");
		txtDireccionAval1.setText("");
		txtNombreAval2.setText("");
		txtNumeroIdentidadAval2.setText("");
		txtTelefonoAval2.setText("");
		txtCelularAval2.setText("");
		txtDireccionAval2.setText("");
		cboTipoGarantia.getSelectionModel().select(null);
		cboFormaPago.getSelectionModel().select(null);
		txtMontoSolicitado.setText("");
		txtTasaInteres.setText("");
		txtCantidadMeses.setText("");
		listaDetallePrestamo.clear();
		btnAceptar.setDisable(true);
	}

	public Date sumarRestarDiasFecha(Date fecha, int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, dias);
		return calendar.getTime();
	}

	public Date sumarRestarMesFecha(Date fecha, int meses) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.MONTH, meses);
		return calendar.getTime();
	}

	public int getDayOfTheWeek(Date d) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(d);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	public int getMonthOfYear(Date d) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(d);
		return cal.get(Calendar.MONTH);
	}

	public int getDayOfMonth(Date d) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(d);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public static boolean isNumeric(String str) {
		return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("") == false);
	}
	
	@FXML
	public void restablecerTextField() {
		ivErrorNumeroCliente.setImage(null);
		ivErrorNombreProyecto.setImage(null);
		ivErrorDescripcionProyecto.setImage(null);
		ivErrorNombreAval1.setImage(null);
		ivErrorNumeroIdentidadAval1.setImage(null);
		ivErrorTelefonoAval1.setImage(null);
		ivErrorCelularAval1.setImage(null);
		ivErrorDireccionAval1.setImage(null);
		ivErrorNombreAval2.setImage(null);
		ivErrorNumeroIdentidadAval2.setImage(null);
		ivErrorTelefonoAval2.setImage(null);
		ivErrorCelularAval2.setImage(null);
		ivErrorDireccionAval2.setImage(null);
		ivErrorFormaPago.setImage(null);
		ivErrorMontoSolicitado.setImage(null);
		ivErrorTasaInteres.setImage(null);
		ivErrorCantidadMeses.setImage(null);
		txtCodigoCliente.setStyle("-fx-text-fill: Black;");
		cboTipoGarantia.setStyle("-fx-text-fill: Black;");
		cboFormaPago.setStyle("-fx-text-fill: Black;");
		txtMontoSolicitado.setStyle("-fx-text-fill: Black;");
		txtTasaInteres.setStyle("-fx-text-fill: Black;");
		txtCantidadMeses.setStyle("-fx-text-fill: Black;");
	}

}
