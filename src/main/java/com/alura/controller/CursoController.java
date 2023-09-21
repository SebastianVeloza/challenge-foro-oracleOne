package com.alura.controller;

import com.alura.domain.curso.*;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaCurso> registroCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso,
                                                             UriComponentsBuilder uriComponentsBuilder) {
        Curso curso = cursoRepository.save(new Curso(datosRegistroCurso));
        URI url = uriComponentsBuilder.path("cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(url).body(new DatosRespuestaCurso(curso));
    }

    @GetMapping("/{id}")
    public ResponseEntity retornaDatosCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosRespuestaCurso(curso));
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaCurso>> listarCursos(@Parameter(hidden = true) Pageable pageable){
        return ResponseEntity.ok(cursoRepository.findAll(pageable).map(DatosRespuestaCurso::new));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaCurso> actualizarCurso(@PathVariable Long id,@RequestBody @Valid DatosActualizarCurso datosActualizarCurso){
        Curso curso=cursoRepository.getReferenceById(id);
        curso.actualizarCurso(datosActualizarCurso);
        return ResponseEntity.ok(new DatosRespuestaCurso(curso));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaCurso> eliminarCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.getReferenceById(id);
        cursoRepository.delete(curso);
        return ResponseEntity.noContent().build();
    }
}