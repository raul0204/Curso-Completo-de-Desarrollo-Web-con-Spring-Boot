package com.bytecode.core.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bytecode.core.configuration.Paginas;
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

	@GetMapping(path= {"/posts","/"})
	public String saludar(Model model) {
		model.addAttribute("Posts", this.getPosts());
		
		return "index";
	}
	
	/**@GetMapping(path="/public")
	public ModelAndView post() {
		ModelAndView modelAndView = new ModelAndView(Paginas.HOME);
		modelAndView.addObject("Posts", this.getPosts());
		return modelAndView;
	}**/
	
	@GetMapping(path = {"/post", "/post/p/{post}"})
	public ModelAndView getPostIndividual(
			/**@RequestParam(defaultValue = "1", name = "id", required = true)**/ @PathVariable(required = true, name = "post" ) int id
			) {
		ModelAndView modelAndView = new ModelAndView(Paginas.POST);
		
		List<Post> postFiltrado = this.getPosts()
								.stream()
								.filter( (p) -> {
									return p.getId() == id;
								}).collect(Collectors.toList());
		modelAndView.addObject("post", postFiltrado.get(0));
		return modelAndView;
	}
}
