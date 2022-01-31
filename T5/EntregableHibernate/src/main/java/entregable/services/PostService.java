package entregable.services;

import java.util.List;

import entregable.models.Post;

public interface PostService {
	public void insertNewPost(final Post post);

	public void updateUser(final Post post);

	public void deleteUser(final Post post);

	public Post searchById(final Long postId);
	
	public List<Post> searchAll();
}
