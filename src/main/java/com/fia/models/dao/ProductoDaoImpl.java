package com.fia.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fia.models.entity.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository("productoDaoJpa")
public class ProductoDaoImpl implements IProductoDao {
	@PersistenceContext
	private EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly= true)
	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Producto").getResultList();
	}
	@Override
	@Transactional
	public void save(Producto producto) {
		em.persist(producto);
	}
	  @Override
	  @Transactional(readOnly = true)
	  public List<Producto> findByCampañaId(Long campañaId) {
	        // Utiliza JPQL para obtener los productos asociados a la campaña
	        return em.createQuery("SELECT p FROM Producto p WHERE p.campaña.id = :campañaId", Producto.class)
	                 .setParameter("campañaId", campañaId)
	                 .getResultList();
	    }
}
