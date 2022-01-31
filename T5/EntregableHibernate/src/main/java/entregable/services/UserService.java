package entregable.services;

import java.util.List;

import entregable.models.User;

public interface UserService {

	public void insertNewUser(final User usuario);

	public void updateUser(final User usuario);

	public void deleteUser(final User usuario);

	public User searchById(final Long userId);

	public List<User> searchAll();

	public List<User> getUser(final String email);

	public List<String> getAllTitlesPost(User user);
}
