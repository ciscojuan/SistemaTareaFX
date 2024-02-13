package com.tareas.services;

import java.util.List;

import com.tareas.models.Tarea;

public interface ITareaServicio {

	public List<Tarea> getTareas();

	public Tarea getTarea(Integer tareaId);

	public void addTarea(Tarea tarea);

	public void deleteTarea(Tarea tarea);
}
