package entregable.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(UserPostId.class)
public class UserPost implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name="user_id", insertable=false, updatable=false) //name nombre en la base de datos, no relacionado
	private User user;
	
	@Id
	@ManyToOne
	@JoinColumn(name="post_id", insertable=false, updatable=false) //name nombre en la base de datos, no relacionado
	private Post post;

	@Column()
	private double puntuacion;
	
	public UserPost() {
	}
	
	public UserPost(User user, Post post) {
		this.user = user;
		this.post = post;
	}
	public UserPost(User user, Post post, double puntuacion) {
		this.user = user;
		this.post = post;
		this.puntuacion = puntuacion;
	}
	
	

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(post, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPost other = (UserPost) obj;
		return Objects.equals(post, other.post) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "UserPost [userPost=" + user + ", post=" + post + ", puntuacion=" + puntuacion + "]";
	}
	
	
}
