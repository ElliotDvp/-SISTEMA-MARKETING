package com.fia.controllers;

import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fia.models.dao.ICampañaDao;
import com.fia.models.dao.IClienteDao;
import com.fia.models.entity.Cliente;

import jakarta.validation.Valid;

@Controller
public class ClienteController {
	@Autowired
	@Qualifier("clienteDaoJpa")
	private IClienteDao clienteDao;
	@Autowired
	@Qualifier("campañaDaoJpa")
	private ICampañaDao campañaDao;
	
	@RequestMapping(value={"/login", "/", ""}, method= RequestMethod.GET)
    public String redirigirALogin() {
        return "login";  // Redirige al HTML llamado "login" al abrir la aplicación
    }
	
	@RequestMapping(value="/listarCli", method= RequestMethod.GET)
	public String ListarCliente(Model model) {
		model.addAttribute("titulo", "Listado de Clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		return "listarCli";
	}
	
	@RequestMapping(value="/formCli")
	public String CrearCliente(Map<String, Object> model) {
		Cliente cliente= new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario del cliente");
		return "formCli";
	}
	
	@RequestMapping(value="/formCli", method= RequestMethod.POST)
	public String GuardarCliente(@Valid Cliente cliente, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			return "formCli";
		}
		
		clienteDao.save(cliente);
		return "redirect:listarCampa";
	}
	 @RequestMapping(value = "/inicio", method = RequestMethod.GET)
	    public String lista(Model model) {
	        return "inicio";
	    }
	
	@RequestMapping(value={"/listarCampa"}, method= RequestMethod.GET)
	public String ListarCampañas(Model model) {
			model.addAttribute("titulo", "Listado de Campañas");
			model.addAttribute("campañas", campañaDao.findAll());
			return "listarCampa";
	}
		
}

