package com.alura.domain.curso;

import com.alura.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "cursos")
@Entity(name = "Curso")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@Enumerated(EnumType.STRING)
	private CategoriasCurso categoria;

	@OneToMany(mappedBy = "curso")
	private List<Topico> topicos = new ArrayList<>();

	public Curso(String nombre, CategoriasCurso categoria) {
		this.nombre = nombre;
		this.categoria = categoria;
	}

	public Curso(DatosRegistroCurso datosRegistroCurso) {
		this.nombre=datosRegistroCurso.nombre();
		this.categoria=datosRegistroCurso.categoria();
	}

	public void agregarTopico(Topico topico){
		topicos.add(topico);
	}

	public void actualizarCurso(DatosActualizarCurso datosActualizarCurso) {
		if(datosActualizarCurso.nombre()!=null){
			this.nombre=datosActualizarCurso.nombre();
		}
		if (datosActualizarCurso.categoria()!=null){
			this.categoria=datosActualizarCurso.categoria();
		}
	}
}
