package com.ejercicio.back.controladores;


import com.ejercicio.back.entidades.Producto;
import com.ejercicio.back.repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductoController {
    @Autowired
    ProductoRepository productoRepository;
    ///// GET
    @GetMapping("/productos")
    public List<Producto> productos(){
        return productoRepository.findAll();
    }
    //// POST
    @PostMapping("/productos")
    public Producto crear(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }
    //Editar//
    @GetMapping("/productos/{id}")
    public Optional<Producto> getProductosById(@PathVariable Integer id) {
    return productoRepository.findById(id);
}
    //////  DELETE
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Boolean> eliminarProducto(@PathVariable int id){
        Optional <Producto> producto = productoRepository.findById(id);
        productoRepository.delete(producto.get());
        return ResponseEntity.ok(true);
    }
    /////// PUT
    @PutMapping("/productos/{id}")
    public  ResponseEntity <Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto productoData){
        Optional <Producto> opcionalProducto = productoRepository.findById(id);

        Producto producto = opcionalProducto.get();
        //actualizar
        producto.setNombre( productoData.getNombre() );
        producto.setPrecio( productoData.getPrecio());
        producto.setCategoria( productoData.getCategoria());

        Producto productoGuardado = productoRepository.save(producto);
        return ResponseEntity.ok(productoGuardado);

    }


}
