package com.fia.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fia.models.dao.ICampañaDao;
import com.fia.models.dao.IProductoDao;
import com.fia.models.entity.Campaña;
import com.fia.models.entity.Producto;

import jakarta.validation.Valid;

@Controller
public class ProductoController {
	@Autowired
	@Qualifier("campañaDaoJpa")
	private ICampañaDao campañaDao;
	
	@Autowired
	@Qualifier("productoDaoJpa")
	private IProductoDao productoDao;
	

	@RequestMapping(value="/formP")
	public String CrearProductos(Map<String, Object> model) {
		Producto producto= new Producto();
		model.put("producto", producto);
		model.put("titulo", "Formulario del producto");
		return "formP";
	}
	
	@RequestMapping(value="/formP", method= RequestMethod.POST)
	public String GuardarProducto(@Valid Producto producto, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo","Formulario del Producto");
			return "formP";
		}
		
		productoDao.save(producto);
		status.setComplete();
		return "redirect:/listarP/" + producto.getCampaña().getId();
	}
	
	
	 @RequestMapping(value="/formP/{campañaId}")
	    public String crearProducto(@PathVariable(value="campañaId") Long campañaId, Map<String, Object> model) {
	        Campaña campaña = campañaDao.findOne(campañaId);

	        if (campaña == null) {
	            return "redirect:/listarC"; // redirige si la campaña no existe
	        }

	        Producto producto = new Producto();
	        producto.setCampaña(campaña); // Asociar producto con la campaña

	        
	       
	        List<Producto> productos = productoDao.findByCampañaId(campañaId); // Obtén los productos de la campaña
	        model.put("producto", producto);
	        model.put("titulo", "Formulario de producto para campaña " + campañaId);
	        model.put("campañaNombre", campaña.getNombre_campaña());
	        model.put("productos", productos);
	        return "formP"; // Aquí es el formulario del producto
	    }
	 
	 
	 @RequestMapping(value="/formP/{campañaId}", method= RequestMethod.POST)
	 public String GuardarProductos(@Valid	Producto producto, RedirectAttributes redirectAttributes, BindingResult result, Model model) {

	     if(result.hasErrors()) {
	    	 model.addAttribute("titulo", "Formulario de Producto");
	     }

	     productoDao.save(producto);
	     return "redirect:/listarP/" + producto.getCampaña().getId();
	 }



	 
	 @RequestMapping(value="/listarP", method= RequestMethod.GET)
	 public String listarTodosProductos(Model model) {
	     model.addAttribute("titulo", "Listado de todos los productos");
	     model.addAttribute("productos", productoDao.findAll());
	     return "listarP";
	 }

	 @RequestMapping(value="/listarP/{campañaId}")
	 public String listarProductos(@PathVariable(value="campañaId") Long campañaId, Map<String, Object> model) {
	     Campaña campaña = campañaDao.findOne(campañaId);

	     if (campaña == null) {
	         return "redirect:/listarP"; // Redirige si la campaña no existe
	     }
	     Producto producto = new Producto();
	     producto.setCampaña(campaña);
	     
	     
	     List<Producto> productos = productoDao.findByCampañaId(campañaId); // Método que busca productos por campaña
	     model.put("productos", productos);
	     model.put("titulo", "Lista de productos para la campaña " + campaña.getNombre_campaña());
	     model.put("campañaNombre", campaña.getNombre_campaña());
	     model.put("campañaId", campañaId);
	     

	     return "listarP"; // Devuelve la vista de listar productos
	 }
	 
	 @RequestMapping(value="/productosGen", method= RequestMethod.GET)
	 public String listarProductosGenerales(Model model) {
		 model.addAttribute("productos", productoDao.findAll()); // Obtener todos los productos
		 return "paginaProductos"; // Muestra la página de productos generales
	 }

}
