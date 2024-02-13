package com.tareas.presentacion;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.tareas.TareasApplication;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SistemasTareasFX extends Application {

	private ConfigurableApplicationContext applicationContext;

	@Override
	public void init() {
		this.applicationContext = new SpringApplicationBuilder(TareasApplication.class).run();

	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(TareasApplication.class.getResource("/templates/index.fxml"));
		loader.setControllerFactory(applicationContext::getBean);
		Scene escena = new Scene(loader.load());
		stage.setScene(escena);
		stage.show();
	}

	public void stop() {

		applicationContext.stop();
		Platform.exit();
	}

}
