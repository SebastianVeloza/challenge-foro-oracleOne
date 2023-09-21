package com.alura.domain.curso;

public record DatosRespuestaCurso(
        Long id,
        String nombre,
        CategoriasCurso categoria
){
    public DatosRespuestaCurso(Curso curso){
        this(curso.getId(), curso.getNombre(),curso.getCategoria());
    }
}
