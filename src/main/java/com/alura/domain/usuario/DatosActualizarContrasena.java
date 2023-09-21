package com.alura.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizarContrasena(

        @NotBlank
        String contrasenaActual,
        @NotBlank
        String contrasenaNueva
) {
}
