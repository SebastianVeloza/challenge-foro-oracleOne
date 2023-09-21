package com.alura.domain.respuesta;

import com.alura.domain.topico.Topico;
import com.alura.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensaje;
	@ManyToOne(fetch = FetchType.LAZY)
	private Topico topico;
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario autor;
	private Boolean solucion = false;

	public Respuesta(DatosRegistroRespuesta datosRegistroRespuesta, Topico topico, Usuario autor) {
		this.mensaje=datosRegistroRespuesta.mensaje();
		this.topico=topico;
		this.autor = autor;
	}

	public void actualizarRespuesta(DatosActualizarRespuesta datosActualizarRespuesta) {
		if (datosActualizarRespuesta.mensaje()!=null){
			this.mensaje= datosActualizarRespuesta.mensaje();
		}
	}
}
