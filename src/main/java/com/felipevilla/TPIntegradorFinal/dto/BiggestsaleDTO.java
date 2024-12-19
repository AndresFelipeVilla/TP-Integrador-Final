

package com.felipevilla.TPIntegradorFinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BiggestsaleDTO {
    private Long codigoVenta;
    private Double total;
    private int cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;
}

