package com.estudo.turismo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.estudo.turismo.model.Atrativo;
import com.estudo.turismo.repository.TurismoRepository;
import com.estudo.turismo.service.TurismoService;

@Controller
@RequestMapping(path="/turismo")
public class TurismoController {
	
	@Autowired
	private TurismoRepository turismoRepository;
	@Autowired
	private TurismoService turismoService;
	
	@RequestMapping(value = "/atrativos", method = RequestMethod.GET)
	public ModelAndView getAtrativos() {
		ModelAndView mv = new ModelAndView("atrativos");
		List<Atrativo> atrativos = turismoService.findAll();
		mv.addObject("atrativos", atrativos);
		return mv;
	}
	
	@RequestMapping(value = "/atrativos/{id}", method = RequestMethod.GET)
	public ModelAndView getAtrativoDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("atrativoDetails");
		Atrativo atrativo = turismoService.findById(id);
		mv.addObject("atrativo", atrativo);
		return mv;
	}
	
	@RequestMapping(value = "/newatrativo", method = RequestMethod.GET)
	public String getAtrativoForm() {
		return "atrativoForm";
	}
	
	@RequestMapping(value = "/newatrativo", method = RequestMethod.POST)
	public String saveAtrativo (@Validated Atrativo atrativo, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos foram preenchidos");
			return "redirect:/newatrativo";
		}
		
		turismoService.save(atrativo);
		return "redirect:/turismo/atrativos";
	}
	

	
	@GetMapping("/atrativoEdit")
	public ModelAndView editAtrativo(@RequestParam long id) {
		ModelAndView mv = new ModelAndView("atrativoEdit");
		
		Atrativo atrativo = turismoService.findById(id);
		mv.addObject("atrativo", atrativo);
		
		return mv;
	}
	
	@GetMapping("/removeAtrativo")
	public String removeAtrativo(@RequestParam long id) {
		
		Atrativo atrativo = turismoService.findById(id);
		turismoService.delete(atrativo);
		
		return "redirect:/turismo/atrativos";
	}
	
	@GetMapping("/saveAtrativo")
	public String saveAtrativo(@ModelAttribute Atrativo atrativo) {
		
		turismoService.save(atrativo);
		
		return "redirect:/turismo/atrativos";
	}
	
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewUser (
		@RequestParam String nome, @RequestParam String cidade, 
		@RequestParam String estado, @RequestParam String tipo,
		@RequestParam String descricao, @RequestParam String fonte) {
	
		Atrativo n = new Atrativo();
		n.setNome(nome);
		n.setCidade(cidade);
		n.setEstado(estado);
		n.setTipo(tipo);
		n.setDescricao(descricao);
		n.setFonte(fonte);
		
		turismoRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Atrativo> getAllAtrativos() {
		return turismoRepository.findAll();
	}

}
