package com.omar.primerapp.service.impl;

import com.omar.primerapp.entities.Persona;
import com.omar.primerapp.repository.PersonaRepository;
import com.omar.primerapp.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository PerRep;

    @Override
    public List<Persona> obtenerTodas() {
        return PerRep.findAll();
    }

    @Override
    public Persona obtenerPorId(Long Id) {
        return PerRep.findById(Id).orElse(null);
    }

    @Override
    public Persona crearPersona(Persona Per) {
        return PerRep.save(Per);
    }

    @Override
    public Persona actualizarPersona(Long Id, Persona Per) {
        Persona PerDb = PerRep.findById(Id).orElse(null);
        if (PerDb != null){
            PerDb.setNombre(Per.getNombre());
            PerDb.setEdad(Per.getEdad());
            return PerRep.save(PerDb);
        }
        return null;
    }

    @Override
    public void eliminarPersona(Long Id) {
        PerRep.deleteById(Id);
    }

    @Override
    public Long contarPersonas() {
        return PerRep.count();
    }
}
