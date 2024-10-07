package Controller;

import dtos.PacienteRecordDto;
import entity.Paciente;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositorios.PacienteRepositorio;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class PacienteController {

    @Autowired
    PacienteRepositorio pacienteRepositorio;

    @PostMapping("/paciente")
    public ResponseEntity<Paciente> savePaciente(@RequestBody @Valid PacienteRecordDto pacienteRecordDto) {
        var paciente = new Paciente();
        BeanUtils.copyProperties(pacienteRecordDto, paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteRepositorio.save(paciente));
    }

    @GetMapping("/paciente")
    public ResponseEntity<List<Paciente>> getAllPacientes(){
        List<Paciente> pacienteList = pacienteRepositorio.findAll();
        if (!pacienteList.isEmpty()) {
            for (Paciente paciente : pacienteList) {
                Integer id = paciente.getId_paciente();
                paciente.add(linkTo(methodOn(PacienteController.class).getOnePaciente(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(pacienteList);
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<Object> getOnePaciente(@PathVariable(value = "id") Integer id) {
        Optional<Paciente> pacienteO = pacienteRepositorio.findById(id);
        if (pacienteO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado.");
        }
        pacienteO.get().add(linkTo(methodOn(PacienteController.class).getAllPacientes()).withRel("Lista de Pacientes"));
        return ResponseEntity.status(HttpStatus.OK).body(pacienteO.get());
    }

    @PutMapping("/paciente/{id}")
    public ResponseEntity<Object> updatePaciente(@PathVariable(value="id") UUID id, @RequestBody @Valid PacienteRecordDto pacienteRecordDto) {
        Optional<Paciente> pacienteO = pacienteRepositorio.findById(id);
        if (pacienteO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado.");
        }
        var Paciente = pacienteO.get();
        BeanUtils.copyProperties(pacienteRecordDto, Paciente);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteRepositorio.save(Paciente));
    }
    @DeleteMapping("/paciente/{id}")
    public ResponseEntity<Object> deletePaciente(@PathVariable(value = "id") UUID id) {
        Optional<Paciente> pacienteO = pacienteRepositorio.findById(id);
        if (pacienteO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado");
        }
        pacienteRepositorio.delete(pacienteO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Paciente deletado com sucesso.");
    }
}
