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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reto.Reto01.model.Provincia;
import com.reto.Reto01.service.IProvinciaService;

@Controller
@RequestMapping(value="/provincias")
public class ProvinciaController {
	
	@Autowired(required=false)
	private IProvinciaService serviceProvincias;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Provincia> lista = serviceProvincias.buscarTodas();
    	model.addAttribute("provincias", lista);
		return "provincias/listProvincias";		
	}
	
	@GetMapping("/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Provincia> lista = serviceProvincias.buscarTodas(page);
		model.addAttribute("provincias", lista);
		return "provincias/listProvincias";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crear(Provincia provincia) {
		return "provincias/formProvincia";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Provincia provincia, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()){		
			System.out.println("Existieron errores");
			return "provincias/formProvincia";
		}
		serviceProvincias.guardar(provincia);
		attributes.addFlashAttribute("msg", "Los datos de la provincia fueron guardados!");		
		return "redirect:/provincias/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int IDPROVINCIA, Model model) {		
		Provincia provincia = serviceProvincias.buscarPorId(IDPROVINCIA);			
		model.addAttribute("provincia", provincia);
		return "provincias/formProvincia";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int IDPROVINCIA, RedirectAttributes attributes) {		
		serviceProvincias.eliminar(IDPROVINCIA);			
		attributes.addFlashAttribute("msg", "La provincia fue eliminada!.");
		return "redirect:/provincias/index";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}

	
	
