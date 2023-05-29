package cl.tbd.trabajo2grupo2.models;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name ="voluntario")
public class Voluntario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_voluntario;
    private String nombre_voluntario;
    private Date fecha_registro;

    //Constructor
    public Voluntario(Long id_voluntario, String nombre_voluntario, Date fecha_registro){
        this.id_voluntario = id_voluntario;
        this.nombre_voluntario = nombre_voluntario;
        this.fecha_registro = fecha_registro;
    }

    //Getters
    public Long getId_voluntario(){
        return id_voluntario;
    }

    public String getNombre_voluntario(){
        return nombre_voluntario;
    }

    public Date getFecha_registro(){
        return fecha_registro;
    }

    //Setters
    public void setId_voluntario(Long id_voluntario){
        this.id_voluntario = id_voluntario;
    }

    public void setNombre_voluntario(String nombre_voluntario){
        this.nombre_voluntario = nombre_voluntario;
    }

    public void setFecha_registro(Date fecha_registro){
        this.fecha_registro = fecha_registro;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Voluntario [id_voluntario=" + id_voluntario + ", nombre_voluntario=" + nombre_voluntario
                + ", fecha_registro=" + fecha_registro + "]";
    }

    


}
