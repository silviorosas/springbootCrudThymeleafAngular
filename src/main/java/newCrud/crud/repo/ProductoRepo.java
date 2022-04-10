/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newCrud.crud.repo;

import newCrud.crud.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Soda
 */
@Repository
public interface ProductoRepo extends JpaRepository<Producto, Long>{
    
}
