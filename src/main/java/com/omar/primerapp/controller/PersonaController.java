package com.omar.primerapp.controller;

import com.omar.primerapp.entities.Persona;
import com.omar.primerapp.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService PerSer;

    //El modelo es usado para transferir objetos del controller a la vista
    @GetMapping
    public String listaPersonas (Model Mdl){
        List<Persona> Personas = PerSer.obtenerTodas();
        Mdl.addAttribute("ListaPersonas",Personas); //key-valor
        return "listar";
    }

    @GetMapping("/nueva")
    public String mostraFormularioNuevaPersona(Model mdl){
        mdl.addAttribute("persona",new Persona());
        mdl.addAttribute("accion","/personas/nueva");
        return "formulario";
    }

    @PostMapping("/nueva")
    public String guardarNuevaPersona(@ModelAttribute Persona Per){
        PerSer.crearPersona(Per);
        return "redirect:/personas";
    }

    @GetMapping("/editar/{Id}")
    public String mostrarFormularioEditarPersona(@PathVariable Long Id,@ModelAttribute Persona Per, Model mdl){
        mdl.addAttribute("persona", Per);
        mdl.addAttribute("accion","/personas/editar/"+Id);
        return "formulario";
    }

    @PostMapping("/editar/{Id}")
    public String actualizarPersona(@PathVariable Long Id, @ModelAttribute Persona Per){
        PerSer.actualizarPersona(Id,Per);
        return "redirect:/personas";
    }

    @GetMapping("/eliminar/{Id}")
    public String eliminarPersona(@PathVariable Long Id){
        PerSer.eliminarPersona(Id);
        return "redirect:/personas";
    }
}
