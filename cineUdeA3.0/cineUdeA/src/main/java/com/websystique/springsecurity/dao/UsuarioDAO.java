package com.websystique.springsecurity.dao;

import com.websystique.springsecurity.model.Usuario;

public interface UsuarioDAO {
    
    public void saveOrUpdate(Usuario usuario);
     
    public void delete(String cedula);
     
    public Usuario get(String cedula);
     
}


     

