package entregable.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true, nullable = false)
	private String userName;

	@Column(nullable = false)
	private String password;

	@Column()
	private String firstName;

	@Column(nullable = false)
	private String email;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Comment> comentarios = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Post> posts = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserPost> userpost = new HashSet<>();

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	// METODOS HELPER Comment
	public void addComments(Comment comment) {
		this.comentarios.add(comment);
		comment.setUser(this);
	}

	public void removeComments(Comment comment) {
		this.comentarios.remove(comment);
		comment.setUser(null);
	}

	// METODOS HELPER Post
	public void addPost(Post post, double puntuacion) {
		UserPost usot = new UserPost();
		this.posts.add(post);
		post.setUser(this);
	}

	public void removePost(Post post) {
		this.posts.remove(post);
		post.setUser(null);
	}

	// METODOS HELPERs USERPOST
	public void addPuntuacion(Post post, double puntuacion) {
		UserPost userpost = new UserPost(this, post, puntuacion);
		this.userpost.add(userpost);
		post.getUserpost().add(userpost);
	}

	public void removePuntuacion(Post post) {
		UserPost userpost = new UserPost(this, post);
		this.userpost.remove(userpost);
		post.getUserpost().remove(userpost);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", email=" + email + "]";
	}

}
