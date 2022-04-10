
package newCrud.crud.controller;

import java.util.List;
import javax.validation.Valid;
import newCrud.crud.entidades.Producto;
import newCrud.crud.repo.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/")
@CrossOrigin("*")
public class ProductoRestController {
    
    @Autowired
    private ProductoRepo repo;
    
    @GetMapping(value="/all")
    public List<Producto> getAll(){
        return repo.findAll();
    }
    
    @PostMapping(value = "/save")
	public ResponseEntity<Producto> save(@RequestBody @Valid Producto producto) {
		Producto obj = repo.save(producto);
		return new ResponseEntity<Producto>(obj, HttpStatus.OK);
	}
    
}
