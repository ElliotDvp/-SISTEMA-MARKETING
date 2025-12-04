package com.fia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fia.models.dao.IUsuarioDao;
import com.fia.models.entity.Usuario;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
    private IUsuarioDao usuarioDao;
	
	@GetMapping("/listar")
    public String listarUsuarios(Model model) {
        model.addAttribute("titulo", "Listado de Usuarios");
        model.addAttribute("usuarios", usuarioDao.findAll()); // Asegúrate de que `findAll` está bien implementado
        return "listarUsuarios"; // Nombre del archivo HTML en `templates`
    }
	
	@GetMapping("/form")
    public String formUsuario(@RequestParam(name = "id", required = false) Long id, Model model) {
		Usuario usuario = id != null ? (usuarioDao.findById(id) != null ? usuarioDao.findById(id) : new Usuario()) : new Usuario();

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", id != null ? "Editar Usuario" : "Crear Usuario");
        return "formUsuario";
    }
	
	@PostMapping("/form")
    public String guardarUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", usuario.getId() != null ? "Editar Usuario" : "Crear Usuario");
            return "formUsuario";
        }
        usuarioDao.save(usuario);
        return "redirect:/usuarios/listar";
    }
	
	@GetMapping("/eliminar")
    public String eliminarUsuario(@RequestParam(name = "id") Long id) {
        usuarioDao.delete(id);
        return "redirect:/usuarios/listar";
    }
	
	@PostMapping("/login")
    public String login(
            @RequestParam("nombre") String nombre,
            @RequestParam("contra") String contra,
            Model model) {
        
        Usuario usuario = usuarioDao.findByNombreAndContraseña(nombre, contra);
        
        if (usuario != null) {
            if ("admin".equalsIgnoreCase(usuario.getFuncion())) {
                return "redirect:/usuarios/listar";
            } else if ("marketing".equalsIgnoreCase(usuario.getFuncion())) {
                return "redirect:/listarC";
            } else {
                model.addAttribute("error", "Función no autorizada");
                return "login";
            }
        } else {
            model.addAttribute("error", "Nombre o contraseña incorrectos");
            return "login";
        }
    }

}
