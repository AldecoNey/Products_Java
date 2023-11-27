/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcialprogiii;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author neyda
 */
@Entity
public class ProductoManufacturadoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleProducto;
    @Column(name = "cantidad")
    private int cantidad;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_insumo")
    private Insumo insumo;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_producto")
    private ProductoManufacturado productoManu;

    public int getIdDetalleProducto() {
        return idDetalleProducto;
    }

    public void setIdDetalleProducto(int idDetalleProducto) {
        this.idDetalleProducto = idDetalleProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public ProductoManufacturado getProductoManu() {
        return productoManu;
    }

    public void setProductoManu(ProductoManufacturado productoManu) {
        this.productoManu = productoManu;
    }
    
    
}
