package cl.tbd.trabajo2grupo2.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.trabajo2grupo2.models.Institucion;
import cl.tbd.trabajo2grupo2.repositories.InstitucionRepository;

@RestController
@RequestMapping("/institucion")
public class InstitucionService {
        
    private final InstitucionRepository institucionRepository;
    InstitucionService(InstitucionRepository institucionRepository)
    {
        this.institucionRepository = institucionRepository;
    }

    //Obtener todas las Instituciones
    @GetMapping("/getAll")
    public List<Institucion> getAllInstituciones(){
        return institucionRepository.getAllInstituciones();
    }

    //Registrar una Institucion en la base de datos
    @PostMapping("/create")
    public void createInstitucion(Institucion institucion){
        institucionRepository.createInstitucion(institucion);
    }

    //Obtener una Institucion por su id
    @RequestMapping(value = "/getById/{id_institucion}", method = RequestMethod.GET)
    public Institucion getInstitucionById(long id_institucion){
        return institucionRepository.findByIdInstitucion(id_institucion);
    }

    //Actualizar una Institucion
    @RequestMapping(value = "/updateById/{id_institucion}", method = RequestMethod.PUT)
    public void updateInstitucion (long id_institucion, @RequestBody Institucion institucion){
        institucionRepository.updateInstitucion(id_institucion, institucion);
    }

    //Eliminar una Institucion
    @RequestMapping(value = "/deleteById/{id_institucion}", method = RequestMethod.DELETE)
    public void deleteInstitucionById(@PathVariable Long id_institucion){
        institucionRepository.deleteInstitucionById(id_institucion);
    }    
}
