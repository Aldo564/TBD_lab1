package cl.tbd.trabajo2grupo2.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.trabajo2grupo2.models.Voluntario;
import cl.tbd.trabajo2grupo2.repositories.VoluntarioRepository;

@RestController
@RequestMapping("/voluntario")
public class VoluntarioService {
    
    private final VoluntarioRepository voluntarioRepository;
    VoluntarioService(VoluntarioRepository voluntarioRepository)
    {
        this.voluntarioRepository = voluntarioRepository;
    }

    //Obtener todos los voluntarios
    @GetMapping("/getAll")
    public List<Voluntario> getAllvoluntarios(){
        return voluntarioRepository.getAllVoluntarios();
    }

    //Registrar un Voluntario a la base de datos
    @PostMapping("/create")
    public void createVoluntario(Voluntario voluntario){
        voluntarioRepository.createVoluntario(voluntario);
    }

    //Obtener un voluntario por su id
    @RequestMapping(value = "/getById/{id_voluntario}", method = RequestMethod.GET)
    public Voluntario getVoluntarioById(long id_voluntario){
        return voluntarioRepository.findByIdVoluntario(id_voluntario);
    }

    //Actualizar un voluntario
    @RequestMapping(value = "/updateById/{id_voluntario}", method = RequestMethod.PUT)
    public void updateVoluntario (long id_voluntario, @RequestBody Voluntario voluntario){
        voluntarioRepository.updateVoluntario(id_voluntario, voluntario);
    }

    //Eliminar un voluntario
    @RequestMapping(value = "/deleteById/{id_voluntario}", method = RequestMethod.DELETE)
    public void deleteVoluntarioById(@PathVariable Long id_voluntario){
        voluntarioRepository.deleteVoluntarioById(id_voluntario);
    }

}
