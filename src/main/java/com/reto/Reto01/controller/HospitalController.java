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
import com.reto.Reto01.model.Hospital;
import com.reto.Reto01.service.ICondicionService;
import com.reto.Reto01.service.IDistritoService;
import com.reto.Reto01.service.IGerenteService;
import com.reto.Reto01.service.IHospitalService;
import com.reto.Reto01.service.ISedeService;

@Controller
@RequestMapping("/hospitales")
public class HospitalController {
	
	@Autowired
	private IHospitalService serviceHospital;
	
	@Autowired
	private IDistritoService serviceDistrito;
	
	@Autowired
	private ISedeService serviceSede;
	
	@Autowired
	private IGerenteService serviceGerente;
	
	@Autowired
	private ICondicionService serviceCondicion;

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Hospital> lista = serviceHospital.buscarTodas();
    	model.addAttribute("hospitales", lista);
		return "hospitales/listHospitales";		
	}
	
	@GetMapping("/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Hospital> lista = serviceHospital.buscarTodas(page);
		model.addAttribute("hospitales", lista);
		return "hospitales/listHospitales";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crear(Hospital hospital) {
		return "hospitales/formHospital";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Hospital hospital, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()){		
			System.out.println("Existieron errores");
			return "hospitales/formHospital";
		}
		serviceHospital.guardar(hospital);
		attributes.addFlashAttribute("msg", "Los datos del hospital fueron guardados!");		
		return "redirect:/hospitales/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int IDHOSPITAL, Model model) {		
		Hospital hospital = serviceHospital.buscarPorId(IDHOSPITAL);			
		model.addAttribute("hospital", hospital);
		return "hospitales/formHospital";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int IDHOSPITAL, RedirectAttributes attributes) {		
		serviceHospital.eliminar(IDHOSPITAL);			
		attributes.addFlashAttribute("msg", "El hospital fue eliminado!.");
		return "redirect:/hospitales/index";
	}
	
	@ModelAttribute
	public void setGenericosDistritos(Model model) {
		model.addAttribute("distritos", serviceDistrito.buscarTodas() );
	}
	
	@ModelAttribute
	public void setGenericosSedes(Model model) {
		model.addAttribute("sedes", serviceSede.buscarTodas() );
	}
	
	@ModelAttribute
	public void setGenericosGerentes(Model model) {
		model.addAttribute("gerentes", serviceGerente.buscarTodas() );
	}
	
	@ModelAttribute
	public void setGenericosCondiciones(Model model) {
		model.addAttribute("condiciones", serviceCondicion.buscarTodas() );
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
}
