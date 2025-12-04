package com.fia.models.dao;
import java.util.List;

import com.fia.models.entity.Cliente;

public interface IClienteDao {
	
	public List<Cliente> findAll();
    public void save(Cliente cliente);
    

}
