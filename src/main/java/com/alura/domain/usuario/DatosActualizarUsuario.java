package com.alura.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosActualizarUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email
) {
}
