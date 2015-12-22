
package com.websystique.springsecurity.dao;

import com.websystique.springsecurity.model.Programacion;
import java.util.List;

public interface ProgramacionDAO{

    public void insertar_actualizar(Programacion programacion);
    
    // public void insertar(Programacion programacion);                // no construye
    
    public void eliminar(int programacionID);

    public Programacion buscar(int programacionID);

    public List<Programacion> listar();
}
