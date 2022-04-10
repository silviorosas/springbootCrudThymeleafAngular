/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newCrud.crud.controller;

import newCrud.crud.entidades.Producto;
import newCrud.crud.repo.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Soda
 */
@Controller
@RequestMapping("/")
public class ProductoController {
    
    @Autowired
    ProductoRepo repo;
    
    
    @GetMapping("/productos")
    public String home(Model model){
        model.addAttribute("productos", repo.findAll());
        return "home";
    }
    
     @GetMapping("/create")
    public String create(){        
        return "create";
    }
    
     @PostMapping("/save")
    public String save(Producto p){
        repo.save(p);
        return "redirect:/productos";
    }
    
     @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Producto p =repo.getById(id);
        model.addAttribute("producto", p);
        return "edit";
    }
    
      @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        repo.deleteById(id);
        return "redirect:/productos";
    }
    
     
     @GetMapping("/buscar/{id}")
    public String buscar(@PathVariable("id") Long id, Model model){
        Producto p =repo.getById(id);
        model.addAttribute("producto", p);
        return "detalles";
    }
      
  
    
}
