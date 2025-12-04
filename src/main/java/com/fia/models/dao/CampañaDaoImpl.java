package com.fia.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fia.models.entity.Campaña;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;


@Repository("campañaDaoJpa")
public class CampañaDaoImpl implements ICampañaDao {
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly= true)
	@Override
	public List<Campaña> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Campaña").getResultList();
	}
	
	
	@Override
	@Transactional
	public void save(Campaña campaña) {
		// TODO Auto-generated method stub
		if(campaña.getId() !=null && campaña.getId()>0) {
			em.merge(campaña);
		}else {
			em.persist(campaña);
		}
		
	}


	@Override
	@Transactional(readOnly= true)
	public Campaña findOne(Long campañaId) {
		// TODO Auto-generated method stub
		return em.find(Campaña.class, campañaId);
	}


	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		em.remove(findOne(id));
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Campaña> findByNombre(String nombre) {
	    return em.createQuery("SELECT c FROM Campaña c WHERE LOWER(c.nombre_campaña) LIKE LOWER(CONCAT('%', :nombre, '%'))", Campaña.class)
	             .setParameter("nombre", nombre)
	             .getResultList();
	}
		
	
	@Override
	@Transactional(readOnly = true)
	public List<Campaña> findByDistrito(String dist) {
	    TypedQuery<Campaña> query = em.createQuery(
	        "SELECT c FROM Campaña c WHERE LOWER(c.dist) = LOWER(:dist)", 
	        Campaña.class
	    );
	    query.setParameter("dist", dist);
	    return query.getResultList();
	}


}
