package com.alura.domain.topico;

import com.alura.domain.curso.DatosRespuestaCurso;
import com.alura.domain.usuario.DatosRespuestaUsuario;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, StatusTopico status, DatosRespuestaUsuario usuario,
        DatosRespuestaCurso curso
        ) {
    public DatosRespuestaTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(),topico.getStatus(),
                new DatosRespuestaUsuario(topico .getAutor().getId(), topico.getAutor().getNombre(),topico.getAutor().getEmail())
                ,new DatosRespuestaCurso(topico.getCurso().getId(), topico.getCurso().getNombre(),topico.getCurso().getCategoria()));
    }
}
