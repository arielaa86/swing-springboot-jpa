/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaswing.app.repositorio;

import jpaswing.app.model.Trabajador;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ariel
 */
public interface TrabajadorRepositorio extends CrudRepository<Trabajador, Long>{
    
    Trabajador findByNombre(String nombre);
  
    
}
