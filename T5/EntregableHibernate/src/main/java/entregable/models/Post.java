package entregable.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class Post implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private String content;
	
	@Column(nullable=false)
	private Date date;
	
	@OneToMany(mappedBy="post", cascade= CascadeType.ALL, orphanRemoval=true)
	private Set<Comment> comentarios = new HashSet<>();

	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="post" , cascade= CascadeType.ALL, orphanRemoval=true)
	private Set<UserPost> userpost = new HashSet<>();
	
	public Post() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<UserPost> getUserpost() {
		return userpost;
	}

	public void setUserpost(Set<UserPost> userpost) {
		this.userpost = userpost;
	}
	
	public Set<Comment> getComentarios() {
		return comentarios;
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
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}

	//HELPER comments
	//METODOS HELPER Comment
		public void addComments(Comment comment) {
			this.comentarios.add(comment);
			comment.setPost(this);
		}
		
		public void removeComments(Comment comment) {
			this.comentarios.remove(comment);
			comment.setPost(null);
		}
	

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", date=" + date + ", Comentarios="
				+ comentarios + ", user=" + user + ", userpost=" + userpost + "]";
	}

	
	
	
	
	
}
