package application;
import java.util.Map;
import java.util.HashMap;
import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Cargo;
import model.Cliente;
import model.Colonia;
import model.Conexion;
import model.Direccion;
import model.Empresa;
import model.Estado;
import model.EstadoCivil;
import model.JasperReportX;
import model.Municipio;
import model.Profesion;
import model.TipoTrabajo;

public class AgregarClienteController implements Initializable {
	private Main main;
	@FXML
	private TextField txtNumeroIdentidad;
	@FXML
	private TextField txtNombres;
	@FXML
	private TextField txtApellidos;
	@FXML
	private TextField txtNumeroTelefono;
	@FXML
	private TextField txtNumeroCelular;
	@FXML
	private RadioButton rbnMasculino;
	@FXML
	private RadioButton rbnFemenino;
	@FXML
	private DatePicker dprFechaNacimiento;
	@FXML
	private TextField txtCorreoElectronico;
	@FXML
	private ComboBox<EstadoCivil> cboEstadoCivil;
	@FXML
	private ComboBox<Colonia> cboColonia;
	@FXML
	private ComboBox<Estado> cboEstado;
	@FXML
	private ComboBox<Municipio> cboMunicipio;
	@FXML
	private TextField txtDireccion;
	@FXML
	private ComboBox<Colonia> cboColoniaEmpresa;
	@FXML
	private ComboBox<Estado> cboEstadoEmpresa;
	@FXML
	private ComboBox<Municipio> cboMunicipioEmpresa;
	@FXML
	private TextField txtDireccionEmpresa;
	@FXML
	private TextField txtNombreEmpresa;
	@FXML
	private TextField txtTelefonoEmpresa;
	@FXML
	private ComboBox<TipoTrabajo> cboTipoTrabajo;
	@FXML
	private ComboBox<Cargo> cboCargo;
	@FXML
	private ComboBox<Profesion> cboProfesion;
	@FXML
	private TextField txtSalario;
	@FXML
	private Button btnAceptar;
	@FXML
	private Button btnCancelar;
	@FXML
	private ImageView ivErrorNumeroIdentidad;
	@FXML
	private ImageView ivErrorNombres;
	@FXML
	private ImageView ivErrorApellidos;
	@FXML
	private ImageView ivErrorNumeroTelefono;
	@FXML
	private ImageView ivErrorNumeroCelular;
	@FXML
	private ImageView ivErrorGenero;
	@FXML
	private ImageView ivErrorFechaNacimiento;
	@FXML
	private ImageView ivErrorEstadoCivil;
	@FXML
	private ImageView ivErrorDepartamento;
	@FXML
	private ImageView ivErrorMunicipio;
	@FXML
	private ImageView ivErrorColonia;
	@FXML
	private ImageView ivErrorDireccion;
	@FXML
	private ImageView ivErrorDepatamentoEmpresa;
	@FXML
	private ImageView ivErrorMunicipioEmpresa;
	@FXML
	private ImageView ivErrorColoniaEmpresa;
	@FXML
	private ImageView ivErrorDireccionEmpresa;
	@FXML
	private ImageView ivErrorNombreEmpresa;
	@FXML
	private ImageView ivErrorTelefonoEmpresa;
	@FXML
	private ImageView ivErrorTipoTrabajo;
	@FXML
	private ImageView ivErrorCargo;
	@FXML
	private ImageView ivErrorProfesion;
	@FXML
	private ImageView ivErrorSalario;
	@FXML
	private ImageView ivErrorCorreoElectonico;
	@FXML
	private javafx.scene.control.Button closeButton;
	private Image imageError;
	private String patronNumeroIdentidad = "[0-9]{13}";
	private Pattern patternNumeroIdentidad;
	private Matcher matcherNumeroIdentidad;
	private String patronNumeroTelefono = "[0-9]{8}";
	private Pattern patternNumeroTelefono;
	private Matcher matcherNumeroTelefono;
	private String patronNumeroCelular = "[0-9]{8}";
	private Pattern patternNumeroCelular;
	private Matcher matcherNumeroCelular;
	private String patronNumeroTelefonoEmpresa = "[0-9]{8}";
	private Pattern patternNumeroTelefonoEmpresa;
	private Matcher matcherNumeroTelefonoEmpresa;
	private ObservableList<EstadoCivil> listaEstadoCivil;
	private ObservableList<Colonia> listaColonia;
	private ObservableList<Profesion> listaProfesion;
	private ObservableList<Estado> listaEstado;
	private ObservableList<Municipio> listaMunicipio;
	private ObservableList<Cargo> listaCargo;
	private ObservableList<TipoTrabajo> listaTipoTrabajo;
	private ObservableList<Colonia> listaColoniaEmpresa;
	private ObservableList<Estado> listaEstadoEmpresa;
	private ObservableList<Municipio> listaMunicipioEmpresa;
	private Conexion conexion;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		imageError = new Image("application/Image/error.png");
		cboMunicipio.setDisable(true);
		cboColonia.setDisable(true);
		cboMunicipioEmpresa.setDisable(true);
		cboColoniaEmpresa.setDisable(true);
		cboCargo.setDisable(true);
		conexion = new Conexion();
		listaEstadoCivil = FXCollections.observableArrayList();
		listaColonia = FXCollections.observableArrayList();
		listaEstado = FXCollections.observableArrayList();
		listaMunicipio = FXCollections.observableArrayList();
		listaColoniaEmpresa = FXCollections.observableArrayList();
		listaEstadoEmpresa = FXCollections.observableArrayList();
		listaMunicipioEmpresa = FXCollections.observableArrayList();
		listaCargo = FXCollections.observableArrayList();
		listaTipoTrabajo = FXCollections.observableArrayList();
		listaProfesion = FXCollections.observableArrayList();
		llenarListas();
		cboEstadoCivil.setItems(listaEstadoCivil);
		cboEstado.setItems(listaEstado);
		cboEstadoEmpresa.setItems(listaEstadoEmpresa);
		cboTipoTrabajo.setItems(listaTipoTrabajo);
		cboProfesion.setItems(listaProfesion);

		cboEstado.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Estado>() {
			@Override
			public void changed(ObservableValue<? extends Estado> lista, Estado oldValue, Estado newValue) {
				listaMunicipio.clear();
				if (newValue != null) {
					conexion = new Conexion();
					conexion.llenarInformacionMunicipio(newValue, listaMunicipio);
					cboMunicipio.setItems(listaMunicipio);
					cboMunicipio.setDisable(false);
					conexion.cerrarConexion();
				}
			}
		});

		cboEstadoEmpresa.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Estado>() {
			@Override
			public void changed(ObservableValue<? extends Estado> lista, Estado oldValue, Estado newValue) {
				listaMunicipioEmpresa.clear();
				if (newValue != null) {
					conexion = new Conexion();
					conexion.llenarInformacionMunicipio(newValue, listaMunicipioEmpresa);
					cboMunicipioEmpresa.setItems(listaMunicipioEmpresa);
					cboMunicipioEmpresa.setDisable(false);
					conexion.cerrarConexion();
				}
			}
		});

		cboMunicipio.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Municipio>() {
			@Override
			public void changed(ObservableValue<? extends Municipio> lista, Municipio oldValue, Municipio newValue) {
				listaColonia.clear();
				if (newValue != null) {
					conexion = new Conexion();
					conexion.llenarInformacionColonia(newValue, listaColonia);
					cboColonia.setItems(listaColonia);
					cboColonia.setDisable(false);
					conexion.cerrarConexion();
				}
			}
		});
		cboMunicipioEmpresa.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Municipio>() {
			@Override
			public void changed(ObservableValue<? extends Municipio> lista, Municipio oldValue, Municipio newValue) {
				listaColoniaEmpresa.clear();
				if (newValue != null) {
					conexion = new Conexion();
					conexion.llenarInformacionColonia(newValue, listaColoniaEmpresa);
					cboColoniaEmpresa.setItems(listaColoniaEmpresa);
					cboColoniaEmpresa.setDisable(false);
					conexion.cerrarConexion();
				}
			}
		});

		cboTipoTrabajo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TipoTrabajo>() {
			@Override
			public void changed(ObservableValue<? extends TipoTrabajo> lista, TipoTrabajo oldValue,
					TipoTrabajo newValue) {
				listaCargo.clear();
				if (newValue != null) {
					conexion = new Conexion();
					conexion.llenarInformacionCargo(newValue, listaCargo);
					cboCargo.setItems(listaCargo);
					cboCargo.setDisable(false);
					conexion.cerrarConexion();
				}
			}
		});

	}

	public void llenarListas() {
		conexion.llenarInformacionEstadoCivil(listaEstadoCivil);
		conexion.llenarInformacionEstado(listaEstado);
		conexion.llenarInformacionTipoTrabajo(listaTipoTrabajo);
		conexion.llenarInformacionProfesion(listaProfesion);
		conexion.llenarInformacionEstado(listaEstadoEmpresa);
		conexion.cerrarConexion();
	}

	@FXML
	public void guardarCliente() {
		String resultado = validarDatos();
		if (!resultado.equals("")) {
			Alert cuadroDialogo = new Alert(AlertType.ERROR);
			cuadroDialogo.setContentText(resultado + ".");
			cuadroDialogo.setTitle("Error");
			cuadroDialogo.setHeaderText("Error ");
			cuadroDialogo.showAndWait();
		} else {
			conexion = new Conexion();
			Direccion direccionCliente = new Direccion(
					cboColonia.getSelectionModel().getSelectedItem().getCodigoColonia(), txtDireccion.getText());
			String codigoDireccion = conexion.insertarDireccion(direccionCliente);
			Direccion direccionEmpresa = new Direccion(
					cboColoniaEmpresa.getSelectionModel().getSelectedItem().getCodigoColonia(),
					txtDireccionEmpresa.getText());
			String codigoDireccionEmpresa = conexion.insertarDireccion(direccionEmpresa);
			Empresa empresa = new Empresa(Integer.valueOf(codigoDireccionEmpresa), txtNombreEmpresa.getText(),
					txtTelefonoEmpresa.getText());
			String codigoEmpresa = conexion.insertarEmpresa(empresa);
			Cliente cliente = new Cliente(cboEstadoCivil.getSelectionModel().getSelectedItem().getCodigoEstadoCivil(),
					Integer.valueOf(codigoDireccion), txtNumeroIdentidad.getText(), txtNombres.getText(),
					txtApellidos.getText(), txtNumeroTelefono.getText(), txtNumeroCelular.getText(),
					txtCorreoElectronico.getText(), rbnMasculino.isSelected() ? "M" : "F",
					Date.valueOf(dprFechaNacimiento.getValue()),
					cboProfesion.getSelectionModel().getSelectedItem().getCodigoProfesion(),
					Integer.valueOf(codigoEmpresa), cboCargo.getSelectionModel().getSelectedItem().getCodigoCargo(),
					Double.valueOf(txtSalario.getText()));
			String mensajeCliente = conexion.insertarCliente(cliente);
			Alert cuadroDialogo = new Alert(AlertType.INFORMATION);
			cuadroDialogo.setContentText("CLIENTE AGREGADO CON EXITO: "+mensajeCliente + ".");
			cuadroDialogo.setTitle("Resultado");
			cuadroDialogo.setHeaderText("Resultado:");
			cuadroDialogo.showAndWait();
			Map<String, Object> parametros = new HashMap();
			parametros.put("prtIdCliente", mensajeCliente);
			JasperReportX.crearReport(conexion.getConexion(), "C:\\Users\\Zelaya\\JaspersoftWorkspace\\PrimerProyecto\\NuevoCliente.jasper",parametros);
			JasperReportX.showViewer();
			limpiarComponentes();
			conexion.cerrarConexion();
		}
	}

	public String validarDatos() {
		Calendar fechaActual = new GregorianCalendar();
		conexion = new Conexion();
		if (txtNumeroIdentidad.getText().isEmpty()) {
			ivErrorNumeroIdentidad.setImage(imageError);
			return "El numero de Identidad esta vacio";
		}
		patternNumeroIdentidad = Pattern.compile(patronNumeroIdentidad);
		matcherNumeroIdentidad = patternNumeroIdentidad.matcher(txtNumeroIdentidad.getText());
		if (!matcherNumeroIdentidad.matches()) {
			txtNumeroIdentidad.setStyle("-fx-text-fill: red;");
			ivErrorNumeroIdentidad.setImage(imageError);
			return "El Numero de Identidad debe tener 13 caracteres numericos";
		}
		if (conexion.buscarClienteByIdentidad(txtNumeroIdentidad.getText()) > 0) {
			conexion.cerrarConexion();
			ivErrorNumeroIdentidad.setImage(imageError);
			txtNumeroIdentidad.setStyle("-fx-text-fill: red;");
			return "Ya existe este Numero de Identidad";
		}
		if (conexion.buscarClienteByIdentidad(txtNumeroIdentidad.getText()) < 0) {
			conexion.cerrarConexion();
			ivErrorNumeroIdentidad.setImage(imageError);
			txtNumeroIdentidad.setStyle("-fx-text-fill: red;");
			return "error al buscar el cliente";
		}
		if (txtNombres.getText().isEmpty()) {
			ivErrorNombres.setImage(imageError);
			return "El Nombre esta vacio";

		}
		if (txtNombres.getText().length() > 250) {
			ivErrorNombres.setImage(imageError);
			txtNombres.setStyle("-fx-text-fill: red;");
			return "El Nombre debe tener menos de 250 caracteres";
		}

		if (txtApellidos.getText().isEmpty()) {
			ivErrorApellidos.setImage(imageError);
			return "El apellido Vacio";
		}
		if (txtApellidos.getText().length() > 250) {
			ivErrorApellidos.setImage(imageError);
			txtApellidos.setStyle("-fx-text-fill: red;");
			return "El apellido debe tener menos de 250 caracteres";
		}

		if (txtNumeroTelefono.getText().isEmpty()) {
			ivErrorNumeroTelefono.setImage(imageError);
			return "El Numero de Telefono esta vacio";
		}
		patternNumeroTelefono = Pattern.compile(patronNumeroTelefono);
		matcherNumeroTelefono = patternNumeroTelefono.matcher(txtNumeroTelefono.getText());
		if (!matcherNumeroTelefono.matches()) {
			ivErrorNumeroTelefono.setImage(imageError);
			txtNumeroTelefono.setStyle("-fx-text-fill: red;");
			return "El Numero de Telefono debe tener 8 caracteres numericos";
		}
		if (txtNumeroCelular.getText().isEmpty()) {
			ivErrorNumeroCelular.setImage(imageError);
			txtNumeroCelular.setStyle("-fx-text-fill: red;");
			return "El Numero de Celular esta Vacio";
		}
		patternNumeroCelular = Pattern.compile(patronNumeroCelular);
		matcherNumeroCelular = patternNumeroCelular.matcher(txtNumeroCelular.getText());
		if (!matcherNumeroCelular.matches()) {
			ivErrorNumeroCelular.setImage(imageError);
			txtNumeroCelular.setStyle("-fx-text-fill: red;");
			return "El Numero de Celular debe tener 8 caracteres numericos";
		}
		if ((!rbnFemenino.isSelected()) && (!rbnMasculino.isSelected())) {
			ivErrorGenero.setImage(imageError);
			rbnFemenino.setStyle("-fx-text-fill: red;");
			rbnMasculino.setStyle("-fx-text-fill: red;");
			return "debe seleccionar un Genero";
		}
		if (dprFechaNacimiento.getValue() == null) {
			ivErrorFechaNacimiento.setImage(imageError);
			dprFechaNacimiento.setStyle("-fx-text-fill: red;");
			return "Debe seleccionar fecha nacimiento";
		}
		if ((fechaActual.get(Calendar.YEAR) - dprFechaNacimiento.getValue().getYear()) < 0) {
			ivErrorFechaNacimiento.setImage(imageError);
			dprFechaNacimiento.setStyle("-fx-text-fill: red;");
			return "El cliente no ha nacido";
		}
		if (txtCorreoElectronico.getText().length() > 300) {
			ivErrorCorreoElectonico.setImage(imageError);
			txtCorreoElectronico.setStyle("-fx-text-fill: red;");
			return "El Correo electronico debe tener menos de 300 caracteres";
		}
		if (cboEstadoCivil.getSelectionModel().getSelectedIndex() < 0) {
			ivErrorEstadoCivil.setImage(imageError);
			cboEstadoCivil.setStyle("-fx-text-fill: red;");
			return "debe seleccionar Un estado Civil";
		}
		if (cboEstado.getSelectionModel().getSelectedIndex() < 0) {
			ivErrorDepartamento.setImage(imageError);
			cboEstado.setStyle("-fx-text-fill: red;");
			return "debe seleccionar Un Departamento para el cliente";
		}
		if (cboMunicipio.getSelectionModel().getSelectedIndex() < 0) {
			ivErrorMunicipio.setImage(imageError);
			cboMunicipio.setStyle("-fx-text-fill: red;");
			return "debe seleccionar Un Municipio para el cliente";
		}
		if (cboColonia.getSelectionModel().getSelectedIndex() < 0) {
			ivErrorColonia.setImage(imageError);
			cboColonia.setStyle("-fx-text-fill: red;");
			return "debe seleccionar Una Colonia para el cliente";
		}
		if (txtDireccion.getText().isEmpty()) {
			ivErrorDireccion.setImage(imageError);
			txtDireccion.setStyle("-fx-text-fill: red;");
			return "La Direccion esta Vacia";
		}
		if (cboEstadoEmpresa.getSelectionModel().getSelectedIndex() < 0) {
			ivErrorDepatamentoEmpresa.setImage(imageError);
			cboEstadoEmpresa.setStyle("-fx-text-fill: red;");
			return "debe seleccionar Un Departamento para la Empresa";
		}
		if (cboMunicipioEmpresa.getSelectionModel().getSelectedIndex() < 0) {
			ivErrorMunicipioEmpresa.setImage(imageError);
			cboMunicipioEmpresa.setStyle("-fx-text-fill: red;");
			return "debe seleccionar Un Municipio para la Empresa";
		}
		if (cboColoniaEmpresa.getSelectionModel().getSelectedIndex() < 0) {
			ivErrorColoniaEmpresa.setImage(imageError);
			return "debe seleccionar Una Colonia para la Empresa";
		}
		if (txtDireccionEmpresa.getText().isEmpty()) {
			ivErrorDireccionEmpresa.setImage(imageError);
			return "La Direccion de la Empresa esta Vacia";
		}
		if (txtNombreEmpresa.getText().isEmpty()) {
			ivErrorNombreEmpresa.setImage(imageError);
			return "El nombre de la Empresa esta Vacia";
		}
		if (txtTelefonoEmpresa.getText().isEmpty()) {
			ivErrorTelefonoEmpresa.setImage(imageError);
			return "El Numero de Telefono de la Empresa esta Vacio";
		}
		patternNumeroTelefonoEmpresa = Pattern.compile(patronNumeroTelefonoEmpresa);
		matcherNumeroTelefonoEmpresa = patternNumeroTelefonoEmpresa.matcher(txtTelefonoEmpresa.getText());
		if (!matcherNumeroTelefonoEmpresa.matches()) {
			ivErrorTelefonoEmpresa.setImage(imageError);
			txtTelefonoEmpresa.setStyle("-fx-text-fill: red;");
			return "El Numero de Telefono de la Empresa debe tener 8 caracteres numericos";
		}
		if (cboTipoTrabajo.getSelectionModel().getSelectedIndex() < 0) {
			ivErrorTipoTrabajo.setImage(imageError);
			return "debe seleccionar Un Tipo de Trabajo";
		}
		if (cboCargo.getSelectionModel().getSelectedIndex() < 0) {
			ivErrorCargo.setImage(imageError);
			return "debe seleccionar Un Cargo";
		}
		if (cboProfesion.getSelectionModel().getSelectedIndex() < 0) {
			ivErrorProfesion.setImage(imageError);
			return "debe seleccionar Una Profesion";
		}
		if (txtSalario.getText().isEmpty()) {
			ivErrorSalario.setImage(imageError);
			return "El Salario esta Vacia";
		}
		if (!isNumeric(txtSalario.getText())) {
			ivErrorSalario.setImage(imageError);
			return "la Cantidad de salario debe ser numerico";
		}

		conexion.cerrarConexion();
		return "";
	}

	@FXML
	public void limpiarComponentes() {
		txtNumeroIdentidad.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtNumeroTelefono.setText("");
		txtNumeroCelular.setText("");
		rbnFemenino.setSelected(false);
		rbnMasculino.setSelected(false);
		dprFechaNacimiento.setValue(null);
		txtCorreoElectronico.setText("");
		cboEstadoCivil.getSelectionModel().select(null);
		txtDireccion.setText("");
		txtDireccionEmpresa.setText("");
		txtNombreEmpresa.setText("");
		txtTelefonoEmpresa.setText("");
		cboTipoTrabajo.getSelectionModel().select(null);
		cboCargo.getSelectionModel().select(null);
		cboProfesion.getSelectionModel().select(null);
		txtSalario.setText("");
		cboColoniaEmpresa.getSelectionModel().select(null);
		cboMunicipioEmpresa.getSelectionModel().select(null);
		cboEstadoEmpresa.getSelectionModel().select(null);
		cboMunicipioEmpresa.setDisable(true);
		cboColoniaEmpresa.setDisable(true);
		cboColonia.getSelectionModel().select(null);
		cboMunicipio.getSelectionModel().select(null);
		cboEstado.getSelectionModel().select(null);
		cboMunicipio.setDisable(true);
		cboColonia.setDisable(true);
		cboCargo.setDisable(true);

	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	@FXML
	public void restablecerTextField() {
		ivErrorNumeroIdentidad.setImage(null);
		ivErrorNombres.setImage(null);
		ivErrorApellidos.setImage(null);
		ivErrorNumeroTelefono.setImage(null);
		ivErrorNumeroCelular.setImage(null);
		ivErrorGenero.setImage(null);
		ivErrorFechaNacimiento.setImage(null);
		ivErrorEstadoCivil.setImage(null);
		ivErrorDepartamento.setImage(null);
		ivErrorMunicipio.setImage(null);
		ivErrorColonia.setImage(null);
		ivErrorDireccion.setImage(null);
		ivErrorDepatamentoEmpresa.setImage(null);
		ivErrorMunicipioEmpresa.setImage(null);
		ivErrorColoniaEmpresa.setImage(null);
		ivErrorDireccionEmpresa.setImage(null);
		ivErrorNombreEmpresa.setImage(null);
		ivErrorTelefonoEmpresa.setImage(null);
		ivErrorTipoTrabajo.setImage(null);
		ivErrorCargo.setImage(null);
		ivErrorProfesion.setImage(null);
		ivErrorSalario.setImage(null);
		ivErrorCorreoElectonico.setImage(null);
		txtNumeroIdentidad.setStyle("-fx-text-fill: Black;");
		txtNombres.setStyle("-fx-text-fill: Black;");
		txtApellidos.setStyle("-fx-text-fill: Black;");
		txtNumeroTelefono.setStyle("-fx-text-fill: Black;");
		txtNumeroCelular.setStyle("-fx-text-fill: Black;");
		rbnMasculino.setStyle("-fx-text-fill: white;");
		rbnFemenino.setStyle("-fx-text-fill: white;");
		dprFechaNacimiento.setStyle("-fx-text-fill: Black;");
		txtCorreoElectronico.setStyle("-fx-text-fill: Black;");
		cboEstadoCivil.setStyle("-fx-text-fill: Black;");
		cboColonia.setStyle("-fx-text-fill: Black;");
		cboEstado.setStyle("-fx-text-fill: Black;");
		cboMunicipio.setStyle("-fx-text-fill: Black;");
		txtDireccion.setStyle("-fx-text-fill: Black;");
		cboColoniaEmpresa.setStyle("-fx-text-fill: Black;");
		cboEstadoEmpresa.setStyle("-fx-text-fill: Black;");
		cboMunicipioEmpresa.setStyle("-fx-text-fill: Black;");
		txtDireccionEmpresa.setStyle("-fx-text-fill: Black;");
		txtNombreEmpresa.setStyle("-fx-text-fill: Black;");
		txtTelefonoEmpresa.setStyle("-fx-text-fill: Black;");
		cboTipoTrabajo.setStyle("-fx-text-fill: Black;");
		cboCargo.setStyle("-fx-text-fill: Black;");
		cboProfesion.setStyle("-fx-text-fill: Black;");
		txtSalario.setStyle("-fx-text-fill: Black;");
	}

	public static boolean isNumeric(String str) {
		return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("") == false);
	}

	@FXML
	private void cerrar() {
		limpiarComponentes();
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}
}
