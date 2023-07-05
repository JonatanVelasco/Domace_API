    package com.integrador.services;

import com.integrador.dto.ProductoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductoService {

    public ResponseEntity<ProductoDTO[]> findAllProduct();

    public ProductoDTO insertProduct(ProductoDTO productoDTO);

    /*
    public ProductoDTO findByIdProduct(Integer id);



    public ProductoDTO updateProduct(ProductoDTO productoDTO);

    public boolean findByIdDeleteProduct(Integer id);
    */

}
