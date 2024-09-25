package com.todocodeacademy.pruebaJPA.controller;

import com.todocodeacademy.pruebaJPA.model.Persona;
import com.todocodeacademy.pruebaJPA.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private IPersonaService persoService;

    @GetMapping("/personas/traer")
    public List<Persona> getPersonas() {
        return persoService.getPersonas();
    }

    @PostMapping("/personas/crear")
    public String savePersona(@RequestBody Persona persona) {
        persoService.savePersona(persona);
        return "Persona creada con exito";
    }

    @DeleteMapping("/personas/borra/{id}")
    public String deletePersona(@PathVariable Long id) {
        persoService.deletePersona(id);
        return "Persona eliminada con exito";
    }

    @PutMapping("/personas/editar/{idOriginal}") // en caso de que necesites cambiar el id (mala practica)
    public Persona editPersona(@PathVariable Long idOriginal,
                               @RequestParam(required = false, name = "id") Long nuevaId,
                               @RequestParam(required = false, name = "nombre") String nuevoNombre,
                               @RequestParam(required = false, name = "apellido") String nuevoApellido,
                               @RequestParam(required = false, name = "edad") int nuevaEdad) {

        persoService.editPersona(idOriginal, nuevaId, nuevoNombre, nuevoApellido, nuevaEdad);

        Persona persona = persoService.findPersona(nuevaId);

        return persona;

    }

    @PutMapping("/personas/editar")
    public Persona editPersona(@RequestBody Persona persona) {
        persoService.editPersona(persona);
        return persoService.findPersona(persona.getId());
    }
}
