package org.servidor.uni.models.grado;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.servidor.uni.models.asignatura.Asignatura;

@Entity
@Table(name="grado")
public class Grado implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String nombre;
	
	@OneToMany(mappedBy="grado", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Asignatura> asignaturas = new HashSet<>();
	
	

	public Grado() {
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grado other = (Grado) obj;
		return Objects.equals(id, other.id);
	}
	
	public void addAsignatura(Asignatura asignatura) {
		this.asignaturas.add(asignatura);
		asignatura.setGrado(this);
	}
	
	public void removeAsignatura(Asignatura asignatura) {
		this.asignaturas.remove(asignatura);
		asignatura.setGrado(null);
	}

	@Override
	public String toString() {
		return "Grado [id=" + id + ", nombre=" + nombre + ", asignaturas=" + asignaturas + "]";
	}
	
	
}
