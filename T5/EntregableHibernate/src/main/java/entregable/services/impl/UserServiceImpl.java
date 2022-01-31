package entregable.services.impl;

import java.util.List;

import org.hibernate.Session;

import entregable.models.User;
import entregable.services.UserService;
import entregable.utils.dao.UserDAO;
import entregable.utils.dao.impl.UserDAOImpl;

public class UserServiceImpl implements UserService {

	UserDAO userDao;

	public UserServiceImpl(Session session) {
		userDao = new UserDAOImpl(session);
	}

	@Override
	public void insertNewUser(User usuario) {
		if (usuario != null && usuario.getId() == null) {
			userDao.insert(usuario);
		}
	}

	@Override
	public void updateUser(User usuario) {
		if (usuario != null && usuario.getId() != null) {
			userDao.update(usuario);
		}
	}

	@Override
	public void deleteUser(User usuario) {
		if (usuario != null && usuario.getId() != null) {
			userDao.delete(usuario);
		}
	}

	@Override
	public User searchById(Long userId) {
		if (userId != null) {
			return userDao.searchById(userId);
		}
		return null;
	}

	@Override
	public List<User> searchAll() {
		
		return userDao.searchAll();
	}

	@Override
	public List<User> getUser(String email) {
		return userDao.getUser(email);
	}

	@Override
	public List<String> getAllTitlesPost(User user) {
		if(user!=null && user.getId()!=null) {
			return userDao.getAllTitlesPost(user);
		}
		return null;
	}

}
