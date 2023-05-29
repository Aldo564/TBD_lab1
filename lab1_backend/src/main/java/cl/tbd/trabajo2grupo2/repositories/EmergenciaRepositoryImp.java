package cl.tbd.trabajo2grupo2.repositories;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.trabajo2grupo2.models.Emergencia;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository
{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Long getIdNuevaEmergencia() {
        Long id_emergencia_nueva;
        String sqlQuery = "SELECT MAX(id_emergencia) FROM emergencia";
        try (Connection con = sql2o.open()){
            id_emergencia_nueva = con.createQuery(sqlQuery).executeScalar(Long.class);
        }  catch (Exception e) {
            // Conexion a sql ha fallado
            id_emergencia_nueva = (long) -1;
        }
        return id_emergencia_nueva;
    }

    @Override
    public List<Emergencia> getAllEmergencias() {
        List<Emergencia> emergencias = new ArrayList<>();
        String sqlQuery = "SELECT * FROM public.emergencia ORDER BY id_emergencia ASC";
        try (Connection con = sql2o.open()){
            emergencias = con.createQuery(sqlQuery).executeAndFetch(Emergencia.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
            
        }
        return emergencias;
    }

    @Override
    public void createEmergencia(Emergencia emergencia) {
        String sqlQuery = "INSERT INTO emergencia (id_emergencia, asunto, fecha, descripcion, direccion, activa,id_institucion) VALUES (:id_emergencia, :asunto, :fecha, :descripcion, :direccion, :activa, :id_institucion)";
        Long id = getIdNuevaEmergencia()+1;
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_emergencia", id)
            .addParameter("asunto", emergencia.getasunto())
            .addParameter("fecha", emergencia.getfecha())
            .addParameter("descripcion", emergencia.getdescripcion())
            .addParameter("direccion", emergencia.getdireccion())
            .addParameter("activa", emergencia.getactiva())
            .addParameter("id_institucion", emergencia.getId_institucion())
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public Emergencia findByIdEmergencia(Long entrada) {
        List<Emergencia> emergencias = null;
        Emergencia emergencia = null;
        String sqlQuery = "SELECT * FROM emergencia WHERE id_emergencia = :entrada";
        try (Connection con = sql2o.open()){
            emergencias = con.createQuery(sqlQuery).addParameter("entrada", entrada).executeAndFetch(Emergencia.class);
            emergencia = emergencias.get(0);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return emergencia;
    }

    @Override
    public void updateEmergencia(Long id_emergencia, String asunto, String descripcion, String direccion, Date fecha, Boolean activa) {
        Emergencia emergencia = findByIdEmergencia(id_emergencia);
        String sqlQuery = "UPDATE emergencia SET asunto = :asunto, descripcion = :descripcion, direccion = :direccion, fecha =:fecha, activa = :activa, id_institucion = :id_institucion WHERE id_emergencia = :id_emergencia";
        try (Connection con = sql2o.beginTransaction()){
            if(activa != null)
            {
                con.createQuery(sqlQuery)
                .addParameter("id_emergencia", id_emergencia)
                .addParameter("asunto", asunto)
                .addParameter("fecha", emergencia.getfecha())
                .addParameter("descripcion", descripcion)
                .addParameter("direccion", direccion)
                .addParameter("activa", activa)
                .addParameter("id_institucion", emergencia.getId_institucion()) //Falto agregar una opcion en la vista, por eso, quedara con este valor "por defecto"
                .executeUpdate();
                con.commit();
            }
            else
            {
                con.createQuery(sqlQuery)
                .addParameter("id_emergencia", id_emergencia)
                .addParameter("asunto", asunto)
                .addParameter("fecha", emergencia.getfecha())
                .addParameter("descripcion", descripcion)
                .addParameter("direccion", direccion)
                .addParameter("activa", emergencia.getactiva())
                .addParameter("id_institucion", emergencia.getId_institucion()) //Falto agregar una opcion en la vista, por eso, quedara con este valor "por defecto"
                .executeUpdate();
                con.commit();
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
    }

    @Override
    public void cambiarEstado(Long id_emergencia) { 
        System.out.println("id_emergencia: " + id_emergencia);
        Emergencia emergencia = findByIdEmergencia(id_emergencia);
        String sqlQuery = "";
        if(emergencia.activa)
        {
            sqlQuery = "UPDATE emergencia SET activa = FALSE WHERE id_emergencia = :id_emergencia"; 
        }
        else
        {
            sqlQuery = "UPDATE emergencia SET activa = TRUE WHERE id_emergencia = :id_emergencia"; 

        }
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_emergencia", id_emergencia)
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public void deleteEmergenciaById(Long id_emergencia) {
        String sqlQuery = "DELETE FROM emergencia WHERE id_emergencia = :id_emergencia";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_emergencia", id_emergencia)
            .executeUpdate();
            con.commit();
        }
    }
    
}