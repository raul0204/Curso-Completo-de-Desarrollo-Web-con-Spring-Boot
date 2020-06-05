package com.bytecode.core.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bytecode.core.model.Post;

@Component
public class PostComponent {

public List<Post> getPosts(){
		
		ArrayList<Post> post = new ArrayList<>();
		
		post.add(new Post(1, "Desarrollo web es un término que define la creación de sitios web para Internet o una intranet.", "http://localhost/img/post.jpg", new Date(), "Desarollo web"));
		post.add(new Post(2, "Desarrollo web es un término que define la creación de sitios web para Internet o una intranet.", "http://localhost/img/post.jpg", new Date(), "Desarollo web Front-End"));
		post.add(new Post(3, "Desarrollo web es un término que define la creación de sitios web para Internet o una intranet.", "http://localhost/img/post.jpg", new Date(), "Desarollo web Black-End"));
		post.add(new Post(4, "Desarrollo web es un término que define la creación de sitios web para Internet o una intranet.", "http://localhost/img/post.jpg", new Date(), "Desarollo web UX/UI"));
		
		
		return post;
	}
}
