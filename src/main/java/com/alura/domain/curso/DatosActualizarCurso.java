package com.alura.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarCurso(
        @NotBlank
        String nombre,
        @NotNull
        CategoriasCurso categoria
) {
}
