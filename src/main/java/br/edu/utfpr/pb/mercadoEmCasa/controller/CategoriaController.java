package br.edu.utfpr.pb.mercadoEmCasa.controller;

import br.edu.utfpr.pb.mercadoEmCasa.model.Categoria;
import br.edu.utfpr.pb.mercadoEmCasa.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("categorias", categoriaService.findAll());
		return "categoria/list";
	}
	
	@GetMapping(value = {"new", "novo", "form"})
	public String form(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "categoria/form";
	}

	@PostMapping
	public String save(@Valid Categoria categoria, BindingResult result, Model model, RedirectAttributes attributes) {
		if ( result.hasErrors() ) {
			model.addAttribute("categoria", categoria);
			return "categoria/form";
		}
		
		categoriaService.save(categoria);
		attributes.addFlashAttribute("sucesso", "Registro salvo com sucesso!");
		return "redirect:/categoria";
	}

	@GetMapping("{id}") // /categoria/25
 	public String form(@PathVariable Long id, Model model) {
		model.addAttribute("categoria", categoriaService.findOne(id));
		return "categoria/form";
	}
	
	@DeleteMapping("{id}") // /categoria/25
	public String delete(@PathVariable Long id, RedirectAttributes attributes) {
		try {
			categoriaService.delete(id);
			attributes.addFlashAttribute("sucesso", "Registro removido com sucesso!");
		} catch (Exception e) {
			attributes.addFlashAttribute("erro", "Falha ao remover o registro!");
		}
		return "redirect:/categoria";
	}
}






