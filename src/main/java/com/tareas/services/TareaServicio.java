package com.tareas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tareas.models.Tarea;
import com.tareas.repositoy.TareaRepository;

@Service
public class TareaServicio implements ITareaServicio {

	@Autowired
	TareaRepository tareaRepository;

	@Override
	public List<Tarea> getTareas() {
		// TODO Auto-generated method stub
		return tareaRepository.findAll();
	}

	@Override
	public Tarea getTarea(Integer tareaId) {
		// TODO Auto-generated method stub
		Tarea tarea = tareaRepository.findById(tareaId).orElse(null);
		return tarea;
	}

	@Override
	public void addTarea(Tarea tarea) {
		tareaRepository.save(tarea);

	}

	@Override
	public void deleteTarea(Tarea tarea) {
		tareaRepository.delete(tarea);

	}

}
