package org.servidor.uni.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.servidor.uni.models.alumno.Alumno;
import org.servidor.uni.models.asignatura.Asignatura;

@Entity
@Table(name="alumno_se_matricula_asignatura")
public class AlumnoAsignatura implements Serializable{
	
	

	@Id
	@ManyToOne
	@JoinColumn(name="id_alumno", insertable=false,updatable=false)
	private Alumno alumno;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_asignatura", insertable=false,updatable=false)
	private Asignatura asignatura;
	
	@Column(nullable=false)
	private int nota;
	
	public AlumnoAsignatura() {}
	
	public AlumnoAsignatura(Alumno alumno, Asignatura asignatura, int nota) {
		this.alumno = alumno;
		this.asignatura = asignatura;
		this.nota = nota;
	}

	public AlumnoAsignatura(Alumno alumno, Asignatura asignatura) {
		this(alumno,asignatura, 0);
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alumno, asignatura);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlumnoAsignatura other = (AlumnoAsignatura) obj;
		return Objects.equals(alumno, other.alumno) && Objects.equals(asignatura, other.asignatura);
	}
	
	
}
