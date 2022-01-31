package entregable.utils.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import entregable.models.User;
import entregable.utils.dao.UserDAO;
import entregable.utils.dao.generic.GenericDAOImpl;

public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO{
	private Session session;
	
	public UserDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	
	@Override
	public List<User> getUser(String user) {
		if(!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		Criteria cr = session.createCriteria(User.class);
		
		Criterion usuario = Restrictions.eq("userName", user);
		Criterion email = Restrictions.eq("email", user);
		LogicalExpression orExp = Restrictions.or(usuario, email);
		cr.add(orExp);
		return cr.list();
	}

	@Override
	public List<String> getAllTitlesPost(User user) {
		if(!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		session.createQuery("FROM Comment c JOIN User u ON c.id u.comment_id WHERE u.id=:id_user").setParameter("id_user", user.getId()).list();
		return null;
	}




}
