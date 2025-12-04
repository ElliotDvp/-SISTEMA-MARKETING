package com.fia.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fia.models.entity.Producto;

public interface IProductoDao {
	
	public List<Producto> findAll();

	public void save(Producto producto);

	public interface iProductoDao extends JpaRepository<Producto, Long> {
		List<Producto> findByCampañaId(Long campañaId);
	}

	public List<Producto> findByCampañaId(Long campañaId);

	
		
}
