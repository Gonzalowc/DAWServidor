package entregable;

import java.util.Date;

import org.hibernate.Session;

import entregable.models.Comment;
import entregable.models.Post;
import entregable.models.User;
import entregable.services.CommetService;
import entregable.services.PostService;
import entregable.services.UserService;
import entregable.services.impl.CommentServiceImpl;
import entregable.services.impl.PostServiceImpl;
import entregable.services.impl.UserServiceImpl;
import entregable.utils.HibernateUtils;

public class mainProyecto {
	public static void main(String[] args) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		UserService userService = new UserServiceImpl(session);
		PostService postService = new PostServiceImpl(session);
		CommetService commentService = new CommentServiceImpl(session);
		
		User u1 = new User();
		u1.setFirstName("Gonzalo");
		u1.setPassword("1234");
		u1.setUserName("Gonwc");
		u1.setEmail("Gonzalowc@gmail.com");
		
		User u2 = new User();
		u2.setFirstName("Pepe");
		u2.setPassword("12345");
		u2.setUserName("pepewc");
		u2.setEmail("pepewc@gmail.com");
		
		userService.insertNewUser(u1);
		userService.insertNewUser(u2);
		
		
		Post p1 = new Post();
		p1.setTitle("La cancion de eurovision");
		p1.setContent("La cancion no es la que querian en eurovision");
		//CREAR EL DATE
		Date fecha1 = new Date(122,0,30);
		p1.setDate(fecha1);
		p1.setUser(u2);
		
		Post p2 = new Post();
		p2.setTitle("Chanel a eurovision");
		p2.setContent("La cantante no es la favorita en eurovision");
		//CREAR EL DATE
		Date fecha2 = new Date(122,0,31);
		p2.setDate(fecha2);
		p2.setUser(u2);
		
		Post p3 = new Post();
		p3.setTitle("Medidas de seguridad eurovision");
		p3.setContent("El covid amenaza eurovision 2022");
		//CREAR EL DATE
		Date fecha3 = new Date(122,0,25);
		p3.setDate(fecha3);
		p3.setUser(u2);
		
		Post p4 = new Post();
		p4.setTitle("Los monos tienen 99& ADN Como los Humanos");
		p4.setContent("Los monos son los parientes directos del Ser Humano");
		//CREAR EL DATE
		Date fecha4 = new Date(121,8,25);
		p4.setDate(fecha4);
		p4.setUser(u1);
		
		Post p5 = new Post();
		p5.setTitle("Los monos tienen pelo para resguardarse del frio");
		p5.setContent("Los monos tienen un pelo que muchos envidian");
		//CREAR EL DATE
		Date fecha5 = new Date(121,8,28);
		p5.setDate(fecha5);
		p5.setUser(u1);
		
		postService.insertNewPost(p1);
		postService.insertNewPost(p2);
		postService.insertNewPost(p3);
		postService.insertNewPost(p4);
		postService.insertNewPost(p5);
		
		Comment c1 = new Comment();
		c1.setTitle("Chanel no eurovision");
		c1.setContent("No me gusta Chanel para eurovision");
		
		Comment c2 = new Comment();
		c2.setTitle("De vdd??");
		c2.setContent("No me puedo creer que los monos sean nuestros parientes y encima no sean calvos");
		
		Comment c3 = new Comment();
		c3.setTitle("Chanel");
		c3.setContent("Creo que la decisión del jurado no es la decisión del pueblo");
		
		commentService.insertNewComment(c1);
		commentService.insertNewComment(c2);
		commentService.insertNewComment(c3);
		
		
		u1.addComments(c1);
		u1.addComments(c3);
		u2.addComments(c2);
		
		
		u1.addPuntuacion(p1, 2.5);
		u1.addPuntuacion(p2, 1);
		u1.addPuntuacion(p3, 2);
		u1.addPuntuacion(p4, 3);
		u1.addPuntuacion(p5, 5);
		u2.addPuntuacion(p1, 0);
		u2.addPuntuacion(p2, 1.5);
		u2.addPuntuacion(p3, 1);
		u2.addPuntuacion(p4, 4);
		u2.addPuntuacion(p5, 2);
		
		p1.addComments(c1);
		p2.addComments(c2);
		p3.addComments(c3);
		
		
		
		userService.updateUser(u1);
		userService.updateUser(u2);
		
		postService.updateUser(p1);
		postService.updateUser(p2);
		postService.updateUser(p3);
		
		
		
		
		
		
		
	}
}
