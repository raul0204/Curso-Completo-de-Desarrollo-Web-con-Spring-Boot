package com.bytecode.core.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bytecode.core.model.Post;

@Controller
@RequestMapping("/home")
public class ControllerBasic {
	
	public List<Post> getPosts(){
		
		ArrayList<Post> post = new ArrayList<>();
		
		post.add(new Post(1, "Desarrollo web es un término que define la creación de sitios web para Internet o una intranet.", "http://localhost/img/post.jpg", new Date(), "Desarollo web"));
		post.add(new Post(2, "Desarrollo web es un término que define la creación de sitios web para Internet o una intranet.", "http://localhost/img/post.jpg", new Date(), "Desarollo web Front-End"));
		post.add(new Post(3, "Desarrollo web es un término que define la creación de sitios web para Internet o una intranet.", "http://localhost/img/post.jpg", new Date(), "Desarollo web Black-End"));
		post.add(new Post(4, "Desarrollo web es un término que define la creación de sitios web para Internet o una intranet.", "http://localhost/img/post.jpg", new Date(), "Desarollo web UX/UI"));
		
		
		return post;
	}

	@GetMapping(path= {"/post","/"})
	public String saludar(Model model) {
		model.addAttribute("Posts", this.getPosts());
		
		return "index";
	}
	
}
