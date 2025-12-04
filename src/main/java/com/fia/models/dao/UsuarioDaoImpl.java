package com.fia.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fia.models.entity.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository("usuarioDaoJpa")
public class UsuarioDaoImpl implements IUsuarioDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
    public void save(Usuario usuario) {
        if (usuario.getId() == null) {
            em.persist(usuario); // Inserta un nuevo usuario
        } else {
            em.merge(usuario); // Actualiza si el usuario ya existe
        }
    }

    @Override
    public Usuario findById(Long id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> findAll() {
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Usuario usuario = findById(id);
        if (usuario != null) {
            em.remove(usuario);
        }
    }
    
    
    @Override
    public Usuario findByNombreAndContraseña(String nombre, String contraseña) {
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.nombre = :nombre AND u.contraseña = :contraseña", Usuario.class)
                     .setParameter("nombre", nombre)
                     .setParameter("contraseña", contraseña)
                     .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
