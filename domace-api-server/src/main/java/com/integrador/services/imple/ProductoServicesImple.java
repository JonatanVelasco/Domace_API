package com.integrador.services.imple;

import com.google.gson.reflect.TypeToken;
import com.integrador.dto.ProductoDTO;
import com.integrador.services.IProductoService;
import com.integrador.services.RestTemplateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServicesImple implements IProductoService {

    @Value("${config.services.host.inventario}")
    private String hostInventario;

    @Value("${config.services.path.inventario}")
    private String pathInventario;

    @Value("${config.services.path.inventario1}")
    private String pathInventarioCreate;

    private final RestTemplateUtil restTemplateUtil;
    @Override
    public ResponseEntity<ProductoDTO[]> findAllProduct() {

        ResponseEntity<ProductoDTO[]> result = restTemplateUtil.sendRequest(
                hostInventario + pathInventario,
                HttpMethod.GET,
                null,
                ProductoDTO[].class,
                null
                );

        return  result;
    }

    @Override
    public ProductoDTO insertProduct(ProductoDTO productoEntity) {
        ResponseEntity<ProductoDTO> result = restTemplateUtil.sendRequest(
                hostInventario + pathInventarioCreate,
                HttpMethod.POST,
                productoEntity,
                ProductoDTO.class,
                null
        );

        return result.getBody();
    }

    /*
    @Override
    public ProductoDTO findByIdProduct(Integer id) {
        ProductoDTO obj = productoRepository.findById(id).orElseGet(null);
        return obj;
    }



    @Override
    public ProductoDTO updateProduct(ProductoDTO productoEntity) {
        ProductoDTO obj = productoRepository.findById(productoEntity.getId()).orElseGet(null);
        if (obj == null){
            return null;
        }else {
            productoRepository.save(obj);
        }
        return obj;
    }

    @Override
    public boolean findByIdDeleteProduct(Integer id) {
        ProductoDTO obj = productoRepository.findById(id).orElseGet(null);
        if (obj == null){
            return false;
        }else {
            productoRepository.save(obj);
            return true;
        }
    }
    */
}
