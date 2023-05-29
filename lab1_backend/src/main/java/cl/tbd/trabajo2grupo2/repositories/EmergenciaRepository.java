package cl.tbd.trabajo2grupo2.repositories;

import java.sql.Date;
import java.util.List;

import cl.tbd.trabajo2grupo2.models.Emergencia;


public interface EmergenciaRepository
{
    public Long getIdNuevaEmergencia();
    public List<Emergencia> getAllEmergencias();
    public void createEmergencia(Emergencia emergencia);
    public Emergencia findByIdEmergencia(Long id_emergencia);
    public void updateEmergencia(Long id_emergencia, String asunto, String descripcion, String direccion, Date fecha, Boolean activa);
    public void deleteEmergenciaById(Long id_emergencia);
    public void cambiarEstado(Long id_emergencia);
}