package com.bytecode.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bytecode.core.components.PostComponent;
import com.bytecode.core.model.Conexion;
import com.bytecode.core.services.PostService;

@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("beanConexion")
	private Conexion conexion;
	
	@Autowired
	@Qualifier("com.bytecode.core.components.PostComponent")
	public PostComponent postComponent;
	
	
	public PostService postService;

	@Autowired
	public CursoSpringApplication(@Qualifier("serviceDecorado")PostService postService) {
		this.postService = postService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			postService.validation(postComponent.getPosts())
			.forEach((post) -> {
				System.out.println(post.getTitulo());
			});
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
