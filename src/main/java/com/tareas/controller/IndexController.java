package com.tareas.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tareas.models.Tarea;
import com.tareas.services.TareaServicio;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

@Component
public class IndexController implements Initializable {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private TareaServicio tareaServicio;

	@FXML
	private TableView<Tarea> tareaTabla;

	@FXML
	private TableColumn<Tarea, Integer> idColumn;

	@FXML
	private TableColumn<Tarea, String> TodoColumn;

	@FXML
	private TableColumn<Tarea, String> responsibleColumn;

	@FXML
	private TableColumn<Tarea, String> statusColumn;

	@FXML
	private TextField nombreTarea;

	@FXML
	private TextField responsibleTarea;

	@FXML
	private TextField statusTarea;

	private Integer tareaId;

	private final ObservableList<Tarea> tareaList = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tareaTabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		configurarColumnas();
		listarTareas();
	}

	public void configurarColumnas() {
		idColumn.setCellValueFactory(new PropertyValueFactory<>("tareaId"));
		TodoColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		responsibleColumn.setCellValueFactory(new PropertyValueFactory<>("responsable"));
		statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
	}

	public void listarTareas() {
		logger.info("Ejecutando lista de tareas ...");
		tareaList.clear();
		tareaList.addAll(tareaServicio.getTareas());
		tareaTabla.setItems(tareaList);

	}

	public void agregarTarea() {
		if (nombreTarea.getText().isEmpty()) {

			mostrarMensaje("Error validacion", "Debe proporcionar una Tarea");
			nombreTarea.requestFocus();
			return;
		} else {
			var tarea = new Tarea();
			getFormData(tarea);
			tarea.setTareaId(null);
			tareaServicio.addTarea(tarea);
			mostrarMensaje("informacion", "Tarea agregada");
			limpiarFormulario();
			listarTareas();
		}
	}

	public void cargarRegistro() {
		var tarea = tareaTabla.getSelectionModel().getSelectedItem(); // selecionar el registro
		if (tarea != null) {
			tareaId = tarea.getTareaId();
			nombreTarea.setText(tarea.getNombre());
			responsibleTarea.setText(tarea.getResponsable());
			statusTarea.setText(tarea.getStatus());
		}
	}

	public void editarTarea() {
		if (tareaId == null) {
			mostrarMensaje("info", "Debe seleccionar un registro");
			return;
		}
		if (nombreTarea.getText().isEmpty()) {
			mostrarMensaje("Error Validacion", "Debe proporcionar una tarea");
			nombreTarea.requestFocus();
			return;
		}

		var tarea = new Tarea();
		getFormData(tarea);

		tareaServicio.addTarea(tarea);

		mostrarMensaje("Informacion", "Tarea modificada");
		limpiarFormulario();
		listarTareas();
	}

	public void eliminarTarea() {
		var tarea = tareaTabla.getSelectionModel().getSelectedItem();

		if (tarea != null) {
			logger.info("Tarea a eliminar: " + tarea);

			tareaServicio.deleteTarea(tarea);
			mostrarMensaje("informacion", "Tarea Eliminada");
			limpiarFormulario();
			listarTareas();
		} else
			mostrarMensaje("Error", "No se ha seleccionado ninguna tarea");
	}

	private void getFormData(Tarea tarea) {
		if (tareaId != null)
			tarea.setTareaId(tareaId);
		tarea.setNombre(nombreTarea.getText());
		tarea.setResponsable(responsibleTarea.getText());
		tarea.setStatus(statusTarea.getText());
	}

	public void limpiarFormulario() {
		tareaId = null;
		nombreTarea.clear();
		responsibleTarea.clear();
		statusTarea.clear();
	}

	private void mostrarMensaje(String titulo, String mensaje) {

		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setTitle(titulo);
		alerta.setHeaderText(null);
		alerta.setContentText(mensaje);

		alerta.showAndWait();

	}
}
