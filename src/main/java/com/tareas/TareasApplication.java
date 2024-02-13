package com.tareas;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tareas.presentacion.SistemasTareasFX;

import javafx.application.Application;

@SpringBootApplication
public class TareasApplication {

	public static void main(String[] args) {
		// SpringApplication.run(TareasApplication.class, args);
		Application.launch(SistemasTareasFX.class, args);
	}

}
