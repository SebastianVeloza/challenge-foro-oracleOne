package com.alura.controller;

import com.alura.domain.usuario.*;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaUsuario> registroUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario,
                                                                 UriComponentsBuilder uriComponentsBuilder){
        Usuario usuario = usuarioRepository.save(new Usuario(datosRegistroUsuario));
        URI url=uriComponentsBuilder.path("usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(url).body(new DatosRespuestaUsuario(usuario));
    }
    @GetMapping("/{id}")
    public ResponseEntity retornaDatosUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosRespuestaUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaUsuario>> listarUsuarios(@Parameter(hidden = true) Pageable pageable){
        return ResponseEntity.ok(usuarioRepository.findAll(pageable).map(DatosRespuestaUsuario:: new));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaUsuario> actualizarUsuario(@PathVariable Long id
            , @RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuario.actualizarUsuario(datosActualizarUsuario);
        return ResponseEntity.ok(new DatosRespuestaUsuario(usuario));
    }

    @PutMapping("/contraseña/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaUsuario> cambiarContrasena(@PathVariable Long id,@RequestBody @Valid DatosActualizarContrasena datosActualizarContrasena){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuario.actualizarContrasena(datosActualizarContrasena);
        return ResponseEntity.ok(new DatosRespuestaUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarUsuario(@PathVariable Long id){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuarioRepository.delete(usuario);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/setAdmin/{id}")
    @Transactional
    @Secured("ROLE_ADMIN")
    public ResponseEntity<DatosRespuestaUsuario> setAdmin(@PathVariable Long id){
    Usuario usuario= usuarioRepository.getReferenceById(id);
    usuario.setAdministrador(true);
    return ResponseEntity.ok(new DatosRespuestaUsuario(usuario));
    }

}
