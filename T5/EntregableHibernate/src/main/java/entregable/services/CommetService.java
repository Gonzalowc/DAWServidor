package entregable.services;

import java.util.List;

import entregable.models.Comment;
import entregable.models.Post;

public interface CommetService {
	public void insertNewComment(final Comment comment);

	public void updateUser(final Comment comment);

	public void deleteUser(final Comment comment);

	public Comment searchById(final Long commentId);
	
	public List<Comment> searchAll();

	public List<Comment> getAllCommentsContains(String palabra);
}
