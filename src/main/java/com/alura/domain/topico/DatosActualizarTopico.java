package com.alura.domain.topico;

import com.alura.domain.curso.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotBlank String titulo, @NotBlank String mensaje, @NotNull Long curso) {
}
