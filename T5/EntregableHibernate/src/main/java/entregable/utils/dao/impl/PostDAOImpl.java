package entregable.utils.dao.impl;

import org.hibernate.Session;

import entregable.models.Post;
import entregable.utils.dao.PostDAO;
import entregable.utils.dao.generic.GenericDAOImpl;

public class PostDAOImpl extends GenericDAOImpl<Post> implements PostDAO{

	private Session session;
	public PostDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	
	
}
