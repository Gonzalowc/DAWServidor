package entregable.utils.dao;

import java.util.List;

import entregable.models.Comment;
import entregable.utils.dao.generic.GenericDAO;

public interface CommentDAO extends GenericDAO<Comment> {

	public List<Comment> getAllCommentsContains(String palabra);
}
