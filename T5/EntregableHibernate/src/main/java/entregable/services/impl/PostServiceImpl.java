package entregable.services.impl;

import java.util.List;

import org.hibernate.Session;

import entregable.models.Post;
import entregable.services.PostService;
import entregable.utils.dao.PostDAO;
import entregable.utils.dao.impl.PostDAOImpl;

public class PostServiceImpl implements PostService{

	PostDAO postDao;
	
	public PostServiceImpl(Session session) {
		postDao = new PostDAOImpl(session);
	}

	@Override
	public void insertNewPost(Post post) {
		if(post!=null && post.getId()==null) {
			postDao.insert(post);
		}
		
	}

	@Override
	public void updateUser(Post post) {
		if(post!=null && post.getId()!=null) {
			postDao.update(post);
		}		
	}

	@Override
	public void deleteUser(Post post) {
		if(post!=null && post.getId()!=null) {
			postDao.delete(post);
		}		
	}

	@Override
	public Post searchById(Long postId) {
		if(postId!=null ) {
			return postDao.searchById(postId);
		}
		return null;
	}

	@Override
	public List<Post> searchAll() {
		return postDao.searchAll();
	}
	
}
