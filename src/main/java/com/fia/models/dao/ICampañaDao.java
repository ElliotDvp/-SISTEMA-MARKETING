package com.fia.models.dao;

import java.util.List;

import com.fia.models.entity.Campaña;

public interface ICampañaDao {
	
	
	public List<Campaña> findAll();

	public void save(Campaña campaña);

	public Campaña findOne(Long campañaId);
	
	public void delete(Long id);
	
	public List<Campaña> findByNombre(String nombre);
	
	public List<Campaña> findByDistrito(String dist);
}
