package repositorios;

import entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente, UUID> {
    Optional<Paciente> findById(Integer id);
}
