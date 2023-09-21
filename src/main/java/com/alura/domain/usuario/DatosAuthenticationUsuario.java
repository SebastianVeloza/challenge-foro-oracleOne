package com.alura.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosAuthenticationUsuario(@NotBlank String nombre, @NotBlank String contrasena) {
}
