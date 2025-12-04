package com.fia.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fia.models.dao.ICampañaDao;
import com.fia.models.entity.Campaña;


import jakarta.validation.Valid;

@Controller
public class CampañaController {
	
	@Autowired
	@Qualifier("campañaDaoJpa")
	private ICampañaDao campañaDao;
	
	@RequestMapping(value={"/listarC"}, method= RequestMethod.GET)
	public String ListarCampañas(Model model) {
		model.addAttribute("titulo", "Listado de Campañas");
		model.addAttribute("campañas", campañaDao.findAll());
		return "listarC";
	}
	
	@RequestMapping(value="/formC")
	public String CrearCampaña(Map<String, Object> model) {
		Campaña campaña= new Campaña();
		
		model.put("campaña", campaña);
		model.put("titulo", "Formulario de campaña");
		return "formC";
	}
	
	@RequestMapping(value="/formC", method= RequestMethod.POST)
	public String GuardarCampaña(@Valid Campaña campaña, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("titulo","Formulario de Campaña");
			return "formC";
		}
		
		campañaDao.save(campaña);
		return "redirect:listarC";
	}
	
	@RequestMapping(value="/formC/{id}")
	public String editarCampaña(@PathVariable(value="id")Long id, Map<String, Object> model) {
		Campaña campaña= null;
		
		if(id>0) {
			campaña=campañaDao.findOne(id);
		}
		else {
			return "redirect:/listarC";
			
		}
		model.put("campaña", campaña);
		model.put("titulo", " Editar Campaña");
		return "formC";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminarcampaña(@PathVariable(value="id") Long id) {
		if(id>0) {
			campañaDao.delete(id);
		}
		return "redirect:/listarC";
	}
	
	@RequestMapping(value="/buscar", method=RequestMethod.GET)
    public String buscarCampaña(@RequestParam("nombre") String nombre, Model model) {
        List<Campaña> campañas = campañaDao.findByNombre(nombre);
        if (campañas.isEmpty()) {
            return "redirect:/noEncontrado";
        }
        model.addAttribute("titulo", "Resultados de la Búsqueda");
        model.addAttribute("campañas", campañas);
        return "listarC";
    }
	
	@RequestMapping(value="/noEncontrado", method=RequestMethod.GET)
    public String campañaNoEncontrada(Model model) {
        model.addAttribute("mensaje", "No está esa campaña registrada en la lista de campañas.");
        return "noEncontrado";
    }
	
	public List<Campaña> getCampañasXDistrito() {
        List<Campaña> campañasXDist = new ArrayList<>();
        List<Campaña> todasLasCampañas = campañaDao.findAll();
        for (Campaña campaña : todasLasCampañas) {
            if ("La Molina".equalsIgnoreCase(campaña.getDist())) {
                campañasXDist.add(campaña);
            }
        }
        return campañasXDist;
    }
	
	@GetMapping("/listarCxDist")
	public String getListaXDist(Model model) {
	    List<Campaña> listaCampañasXDist = campañaDao.findByDistrito("La Molina");
	    model.addAttribute("listaC", listaCampañasXDist);
	    model.addAttribute("titulo", "Listado de Campañas en La Molina");
	    return "frmCampañasXDistrito";
	}

	
}

