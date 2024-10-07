package dtos;

import entity.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PacienteRecordDto(@NotBlank String nm_completo, @NotNull Integer nr_idade, @NotBlank Genero tp_sexo) {
}
