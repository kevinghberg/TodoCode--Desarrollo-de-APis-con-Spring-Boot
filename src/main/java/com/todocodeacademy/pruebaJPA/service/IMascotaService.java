package com.todocodeacademy.pruebaJPA.service;

import com.todocodeacademy.pruebaJPA.model.Mascota;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IMascotaService {
    public List<Mascota> getMascotas();

    public void saveMascota(Mascota mascota);

    public void deleteMascota(Long id_mascota);

    public Mascota findMascota(Long id_mascota);

    public void editMascota(Long idOriginal, Long idNueva, String nuevoNombre, String nuevaEspecie, String nuevaRaza, String nuevoColor);
}
