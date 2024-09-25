package com.todocodeacademy.pruebaJPA.service;

import com.todocodeacademy.pruebaJPA.model.Persona;
import com.todocodeacademy.pruebaJPA.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private IPersonaRepository personaRepo;


    @Override
    public List<Persona> getPersonas() {
        List<Persona> listapersonas = personaRepo.findAll();
        return listapersonas;
    }

    @Override
    public void savePersona(Persona p) {
        personaRepo.save(p);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = personaRepo.findById(id).orElse(null);
        return persona;
    }

    @Override // por si hay que cambiar el id (mala practica)
    public void editPersona(Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad) {
        Persona perso = this.findPersona(idOriginal);

        perso.setId(idNueva);
        perso.setEdad(nuevaEdad);
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);

        this.savePersona(perso);
    }

    @Override
    public void editPersona(Persona persona) {
        this.savePersona(persona);
    }
}
