package cl.tbd.trabajo2grupo2.repositories;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.trabajo2grupo2.models.Habilidad;

@Repository
public class HabilidadRepositoryImp implements HabilidadRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public long getIdNuevaHabilidad() {
        long id_habilidad_nueva;
        String sqlQuery = "SELECT MAX(id_habilidad) FROM habilidad";
        try (Connection con = sql2o.open()){
            id_habilidad_nueva = con.createQuery(sqlQuery).executeScalar(Long.class);
        }  catch (Exception e) {
            // Conexion a sql ha fallado
            id_habilidad_nueva = -1;
        }
        return id_habilidad_nueva;
    }

    @Override
    public List<Habilidad> getAllHabilidades() {
        List<Habilidad> habilidades = new ArrayList<>();
        String sqlQuery = "SELECT * FROM public.habilidad ORDER BY id_habilidad ASC";
        try (Connection con = sql2o.open()){
            habilidades = con.createQuery(sqlQuery).executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
            
        }
        return habilidades;
    }

    @Override
    public void createHabilidad(Habilidad habilidad) {
        String sqlQuery = "INSERT INTO habilidad (id_habilidad, nombre_habilidad) VALUES (:id_habilidad, :nombre_habilidad)";
        long id = getIdNuevaHabilidad();
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_habilidad", id)
            .addParameter("nombre_habilidad", habilidad.getNombre_habilidad())
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public Habilidad findByIdHabilidad(long id_habilidad) {
        Habilidad habilidad = null;
        String sqlQuery = "SELECT * FROM habilidad WHERE id_habilidad = :id_habilidad";
        try (Connection con = sql2o.open()){
            habilidad = (Habilidad)con.createQuery(sqlQuery).addParameter("id_habilidad", id_habilidad).executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado//
        }
        return habilidad;
    }

    @Override
    public void updateHabilidad(long id_habilidad, Habilidad habilidad) {
        String sqlQuery = "UPDATE habilidad SET nombre_habilidad = :nombre_habilidad WHERE id_habilidad = :id_habilidad";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_habilidad", id_habilidad)
            .addParameter("nombre_habilidad", habilidad.getNombre_habilidad())
            .executeUpdate();
            con.commit();
        }
    }

    @Override
    public void deleteHabilidadById(Long id_habilidad) {
        String sqlQuery = "DELETE FROM habilidad WHERE id_habilidad = :id_habilidad";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
            .addParameter("id_habilidad", id_habilidad)
            .executeUpdate();
            con.commit();
        }
    }
    
}
