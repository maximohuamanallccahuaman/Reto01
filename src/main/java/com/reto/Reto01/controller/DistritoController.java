package com.reto.Reto01.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reto.Reto01.model.Distrito;
import com.reto.Reto01.service.IDistritoService;
import com.reto.Reto01.service.IProvinciaService;

@Controller
@RequestMapping("/distritos")
public class DistritoController {
	
	@Autowired
	private IDistritoService serviceDistrito;
	
	@Autowired
	private IProvinciaService serviceProvincia;

	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Distrito> lista = serviceDistrito.buscarTodas();
    	model.addAttribute("distritos", lista);
		return "distritos/listDistritos";		
	}
	
	@GetMapping("/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Distrito> lista = serviceDistrito.buscarTodas(page);
		model.addAttribute("distritos", lista);
		return "distritos/listDistritos";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crear(Distrito distrito) {
		return "distritos/formDistrito";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Distrito distrito, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()){		
			System.out.println("Existieron errores");
			return "distritos/formDistrito";
		}
		serviceDistrito.guardar(distrito);
		attributes.addFlashAttribute("msg", "Los datos del distrito fueron guardados!");		
		return "redirect:/distritos/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int IDDISTRITO, Model model) {		
		Distrito distrito = serviceDistrito.buscarPorId(IDDISTRITO);			
		model.addAttribute("distrito", distrito);
		return "distritos/formDistrito";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int IDDISTRITO, RedirectAttributes attributes) {		
		serviceDistrito.eliminar(IDDISTRITO);			
		attributes.addFlashAttribute("msg", "El distrito fue eliminado!.");
		return "redirect:/distritos/index";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("provincias", serviceProvincia.buscarTodas() );
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
