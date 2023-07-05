package com.integrador.controller;

import com.integrador.dto.ProductoDTO;
import com.integrador.services.IProductoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador orquestador de las peticiones
 * @author srJJ
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("producto")
@Slf4j
public class ProductoController {

    private final IProductoService iProductoService;

    @GetMapping("listAll")
    public ResponseEntity<?> allProduct() {
        return iProductoService.findAllProduct();
    }

    @PostMapping("create")
    public ResponseEntity<?> insertProduct(@RequestBody ProductoDTO productoDto) {
        return new ResponseEntity<>(iProductoService.insertProduct(productoDto), HttpStatus.CREATED);
    }

    /*
    @GetMapping("byId/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(iProductoService.findByIdProduct(id), HttpStatus.OK);
    }



    @PutMapping("update")
    public ResponseEntity<?> updateInfoProduct(@RequestBody ProductoDTO productoDto) {
        return new ResponseEntity<>(iProductoService.updateProduct(productoDto), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteInfoProduct(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(iProductoService.findByIdDeleteProduct(id), HttpStatus.OK);
    }

     */


}

