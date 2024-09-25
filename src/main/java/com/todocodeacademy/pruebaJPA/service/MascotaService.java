package com.todocodeacademy.pruebaJPA.service;

import com.todocodeacademy.pruebaJPA.model.Mascota;
import com.todocodeacademy.pruebaJPA.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService implements IMascotaService {
    @Autowired
    private IMascotaRepository mascotaService;

    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> listaMascotas = mascotaService.findAll();
        return listaMascotas;
    }

    @Override
    public void saveMascota(Mascota mascota) {
        mascotaService.save(mascota);
    }

    @Override
    public void deleteMascota(Long id_mascota) {
        mascotaService.deleteById(id_mascota);
    }

    @Override
    public Mascota findMascota(Long id_mascota) {
        return mascotaService.findById(id_mascota).orElse(null);
    }

    @Override
    public void editMascota(Long idOriginal, Long idNueva, String nuevoNombre, String nuevaEspecie, String nuevaRaza, String nuevoColor) {
        Mascota mascoNueva = this.findMascota(idOriginal);

        mascoNueva.setId_mascota(idNueva);
        mascoNueva.setRaza(nuevaRaza);
        mascoNueva.setColor(nuevoColor);
        mascoNueva.setNombre(nuevoNombre);
        mascoNueva.setEspecie(nuevaEspecie);

        this.saveMascota(mascoNueva);
    }
}
