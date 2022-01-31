package entregable.utils.dao;

import java.util.List;

import entregable.models.User;
import entregable.utils.dao.generic.GenericDAO;

public interface UserDAO extends GenericDAO<User>{

	public List<User> getUser(final String email);
	
	public List<String> getAllTitlesPost(User user);
}
