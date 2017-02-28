package application;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Conexion;
import model.DetalleCliente;

public class BuscadorClienteController implements Initializable{
	private Main main;
	@FXML
	private TextField txtBuscador;
	@FXML
	private ComboBox<String> cboBuscarPor;
	@FXML
	private TableView<DetalleCliente> tblDetalleCliente;
	@FXML
	private TableView<DetalleCliente> tblCliente;
	@FXML
	private TableColumn<DetalleCliente, String> columnaNumeroCuenta;
	@FXML
	private TableColumn<DetalleCliente, String> columnaTipoCuenta;
	@FXML
	private TableColumn<DetalleCliente, String> columnaDetalle;
	@FXML
	private TableColumn<DetalleCliente, String> columnaNombreCliente;
	private ObservableList<DetalleCliente> listaDetalleCliente;
	private ObservableList<String> listaBusquedas;
	private ObservableList<DetalleCliente> listaCliente;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listaDetalleCliente = FXCollections.observableArrayList();
		listaCliente = FXCollections.observableArrayList();
		listaBusquedas = FXCollections.observableArrayList();
		columnaNumeroCuenta.setCellValueFactory(new PropertyValueFactory<DetalleCliente, String>("numeroCuenta"));
		columnaTipoCuenta.setCellValueFactory(new PropertyValueFactory<DetalleCliente, String>("tipoCuenta"));
		columnaDetalle.setCellValueFactory(new PropertyValueFactory<DetalleCliente, String>("detalle"));
		columnaNombreCliente.setCellValueFactory(new PropertyValueFactory<DetalleCliente, String>("nombre"));
		tblDetalleCliente.setItems(listaDetalleCliente);
		tblCliente.setItems(listaCliente);
		llenarCombobox();
		tblCliente.
		getSelectionModel().
		selectedItemProperty().
		addListener(
				new ChangeListener<DetalleCliente>() {
					@Override
					public void changed(
							ObservableValue<? extends DetalleCliente> arg0,
							DetalleCliente valorAnterior, 
							DetalleCliente valorNuevo) {
								Conexion conexion = new Conexion();
								conexion.buscadorDetalleCliente(valorNuevo.getNumeroCuenta(), listaDetalleCliente);
								conexion.cerrarConexion();
						}
						
					}
				
		);
		
		tblDetalleCliente.
		getSelectionModel().
		selectedItemProperty().
		addListener(
				new ChangeListener<DetalleCliente>() {
					@Override
					public void changed(
							ObservableValue<? extends DetalleCliente> arg0,
							DetalleCliente valorAnterior, 
							DetalleCliente valorNuevo) {
								StringSelection data = new StringSelection(valorNuevo.getNumeroCuenta());
								Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
								clipboard.setContents(data, null);
						}
						
					}
				
		);
		
		
	}
	@FXML
	public void buscarCliente() {
		Conexion conexion = new Conexion();
		listaCliente.clear();
		if (cboBuscarPor.getValue()!=null){
			conexion.buscadorCliente(txtBuscador.getText(), cboBuscarPor.getValue(), listaCliente);
		}else{
			conexion.buscadorCliente(txtBuscador.getText(), "Todos", listaCliente);
		}
	}
	@FXML
	public void llenarCombobox() {
		listaBusquedas.add("Nombre del Cliente");
		listaBusquedas.add("Numero de Identidad");
		listaBusquedas.add("Todos");
		cboBuscarPor.setItems(listaBusquedas);
	}
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
}
