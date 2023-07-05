package com.integrador.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO para el manejo de la informacion
 * @author srJJ
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO implements Serializable {

    private Integer id;

    private String name;

    private String description;

    private Integer stock;

    private String price;

    private String id_subcategory;

    private Date create_at;

    private Date update_at;

}


