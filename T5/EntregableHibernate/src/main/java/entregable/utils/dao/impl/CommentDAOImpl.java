package entregable.utils.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entregable.models.Comment;
import entregable.utils.dao.CommentDAO;
import entregable.utils.dao.generic.GenericDAOImpl;

public class CommentDAOImpl extends GenericDAOImpl<Comment> implements CommentDAO{

	private Session session;

	public CommentDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<Comment> getAllCommentsContains(String palabra) {
		if(!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		return session.createQuery("FROM Comment WHERE content LIKE '%:palabra%'").setParameter("palabra", palabra).list();
	}

	

	
	
}
