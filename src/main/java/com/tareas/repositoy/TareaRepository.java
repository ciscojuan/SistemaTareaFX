package com.tareas.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tareas.models.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {

}
