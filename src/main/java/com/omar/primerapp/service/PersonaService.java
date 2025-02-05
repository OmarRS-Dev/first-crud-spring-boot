package com.omar.primerapp.service;

import com.omar.primerapp.entities.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> obtenerTodas();

    Persona obtenerPorId(Long Id);

    Persona crearPersona(Persona Per);

    Persona actualizarPersona(Long Id,Persona Per);

    void eliminarPersona(Long Id);

    Long contarPersonas();
}
