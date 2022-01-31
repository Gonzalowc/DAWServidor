package entregable.services.impl;

import java.util.List;

import org.hibernate.Session;

import entregable.models.Comment;
import entregable.models.Post;
import entregable.services.CommetService;
import entregable.utils.dao.CommentDAO;
import entregable.utils.dao.impl.CommentDAOImpl;

public class CommentServiceImpl implements CommetService{

	private CommentDAO commentDao;
	
	public CommentServiceImpl(Session session) {
		commentDao = new CommentDAOImpl(session);
	}
	
	@Override
	public void insertNewComment(Comment comment) {
		if(comment !=null  && comment.getId() == null) {
			commentDao.insert(comment);
		}
		
	}

	@Override
	public void updateUser(Comment comment) {
		if(comment !=null  && comment.getId() != null) {
			commentDao.update(comment);
		}		
	}

	@Override
	public void deleteUser(Comment comment) {
		if(comment !=null  && comment.getId() != null) {
			commentDao.delete(comment);
		}		
	}

	@Override
	public Comment searchById(Long commentId) {
		if(commentId !=null) {
			return commentDao.searchById(commentId);
		}
		return null;
	}

	@Override
	public List<Comment> searchAll() {
		return commentDao.searchAll();
	}

	@Override
	public List<Comment> getAllCommentsContains(String palabra) {
		if(palabra!=null) {
			return commentDao.getAllCommentsContains(palabra);
		}
		return null;
	}

}
