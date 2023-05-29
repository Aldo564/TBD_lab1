package cl.tbd.trabajo2grupo2.repositories;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.trabajo2grupo2.models.Voluntario;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository
{
    @Autowired
    private Sql2o sql2o;

    @Override
    public long getIdNuevoVoluntario() {
        long id_voluntario_nuevo;
        String sqlQuery = "SELECT MAX(id_voluntario) FROM voluntario";
        try (Connection con = sql2o.open()){
            id_voluntario_nuevo = con.createQuery(sqlQuery).executeScalar(Long.class);
        }  catch (Exception e) {
            // Conexion a sql ha fallado
            id_voluntario_nuevo = -1;
        }
        return id_voluntario_nuevo;
    }

    @Override
    public List<Voluntario> getAllVoluntarios() {
        List<Voluntario> voluntarios = new ArrayList<>();
        String sqlQuery = "SELECT * FROM public.voluntario ORDER BY id_voluntario ASC";
        try (Connection con = sql2o.open()){
            voluntarios = con.createQuery(sqlQuery).executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
            
        }
        return voluntarios;
    }

    @Override
    public void createVoluntario(Voluntario voluntario) {
        String sqlQuery = "INSERT INTO voluntario (id_voluntario, nombre_voluntario, fecha_registro) VALUES (:id_emergencia, :nombre_voluntario, :fecha_registro)";
        long id = getIdNuevoVoluntario();
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_voluntario", id)
            .addParameter("nombre_voluntario", voluntario.getNombre_voluntario())
            .addParameter("fecha_registro", voluntario.getFecha_registro())
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public Voluntario findByIdVoluntario(long id_voluntario) {
        Voluntario voluntario = null;
        String sqlQuery = "SELECT * FROM voluntario WHERE id_voluntario = :id_voluntario";
        try (Connection con = sql2o.open()){
            voluntario = (Voluntario)con.createQuery(sqlQuery).addParameter("id_voluntario", id_voluntario).executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
        }
        return voluntario;
    }

    @Override
    public void updateVoluntario(long id_voluntario, Voluntario voluntario) {
        String sqlQuery = "UPDATE voluntario SET nombre_voluntario = :nombre_voluntario, fecha_registro= :fecha_registro WHERE id_voluntario = :id_voluntario";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_voluntario", id_voluntario)
            .addParameter("nombre_voluntario", voluntario.getNombre_voluntario())
            .addParameter("fecha_registro", voluntario.getFecha_registro())
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public void deleteVoluntarioById(Long id_voluntario) {
        String sqlQuery = "DELETE FROM voluntario WHERE id_voluntario = :id_voluntario";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_voluntario", id_voluntario)
            .executeUpdate();
            con.commit();
        }
    }
    
}