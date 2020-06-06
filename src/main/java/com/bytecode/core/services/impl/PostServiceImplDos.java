package com.bytecode.core.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bytecode.core.model.Post;
import com.bytecode.core.services.PostService;

@Service("serviceDos")
public class PostServiceImplDos implements PostService {

	@Override
	public List<Post> validationId(List<Post> posts) {
		System.out.println("Segundo Servicio");
		for(Post post: posts) {
			if(post.getId() == 0) {
				throw new NullPointerException("El Id esta nulo");
			}
		}
		return posts;
	}

}
