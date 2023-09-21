package com.alura.domain.topico;

import com.alura.domain.curso.Curso;
import com.alura.domain.respuesta.Respuesta;
import com.alura.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Topico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensaje;
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NO_RESPONDIDO;
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario autor;
	@ManyToOne(fetch = FetchType.LAZY)
	private Curso curso;
	@OneToMany(mappedBy = "topico")
	private List<Respuesta> respuestas = new ArrayList<>();

	public Topico(String titulo, String mensaje, Curso curso) {
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.curso = curso;
	}

	public Topico(DatosRegistroTopico datosRegistroTopico, Usuario autor, Curso curso) {
		this.titulo=datosRegistroTopico.titulo();
		this.mensaje=datosRegistroTopico.mensaje();
		this.autor = autor;
		this.curso=curso;
	}

	public void actualizarDatos(DatosActualizarTopico datosActualizarTopico,Curso curso) {
	if(datosActualizarTopico.titulo()!=null){
		this.titulo= datosActualizarTopico.titulo();
	}
	if (datosActualizarTopico.mensaje()!=null){
		this.mensaje= datosActualizarTopico.mensaje();
	}
	if(datosActualizarTopico.curso()!=null){
		this.curso= curso;
	}
	}

	public void agregarRespuesta(Respuesta respuesta) {
		this.respuestas.add(respuesta);
	}
}
