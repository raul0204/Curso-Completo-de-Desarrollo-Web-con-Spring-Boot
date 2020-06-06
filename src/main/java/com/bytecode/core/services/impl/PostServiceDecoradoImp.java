package com.bytecode.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytecode.core.model.Post;
import com.bytecode.core.services.PostService;

@Service("serviceDecorado")
public class PostServiceDecoradoImp implements PostService {
	
	@Autowired
	private PostServiceImpl postServiceImpl;
	
	@Autowired
	private PostServiceImplDos postServiceImplDos;

	@Override
	public List<Post> validation(List<Post> posts) {
		posts = postServiceImpl.validation(posts);
		posts = postServiceImplDos.validation(posts);
		for(Post post: posts) {
			if(post.getDescripcion() == null) {
				throw new NullPointerException("La descrpcion esta nulo");
			}
			if(post.getFecha() == null) {
				throw new NullPointerException("La fecha esta nulo");
			}
		}
		System.out.println("Esto es la clase decoradora");
		return posts;
	}
	
	@Override
	public void addClass(Class clazz) {
		System.out.println(clazz.getName());
	}

}
