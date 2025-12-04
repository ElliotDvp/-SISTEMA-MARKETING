package com.fia.models.dao;

import java.util.List;

import com.fia.models.entity.Usuario;

public interface IUsuarioDao {
	
	void save(Usuario usuario);
    Usuario findById(Long id);
    List<Usuario> findAll();
    void delete(Long id);
    Usuario findByNombreAndContraseña(String nombre, String contraseña);

}
