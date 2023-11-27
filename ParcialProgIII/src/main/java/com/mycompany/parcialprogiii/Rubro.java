/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcialprogiii;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author neyda
 */
@Entity
public class Rubro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRubro;
    @Column(name = "denominacion")
    private String denominacion;

    @OneToMany(mappedBy = "rubro")
    private List<ProductoManufacturado> productos;

    @ManyToOne
    @JoinColumn(name = "id_rubro_padre")
    private Rubro rubroPadre;

    @OneToMany(mappedBy = "rubroPadre")
    private List<Rubro> rubrosHijos;

    public void agregarRubro(Rubro otroRubro) {
        rubrosHijos.add(otroRubro);
    }

    public int getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(int idRubro) {
        this.idRubro = idRubro;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public List<ProductoManufacturado> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoManufacturado> productos) {
        this.productos = productos;
    }

    public Rubro getRubroPadre() {
        return rubroPadre;
    }

    public void setRubroPadre(Rubro rubroPadre) {
        this.rubroPadre = rubroPadre;
    }

    public List<Rubro> getRubrosHijos() {
        return rubrosHijos;
    }

    public void setRubrosHijos(List<Rubro> rubrosHijos) {
        this.rubrosHijos = rubrosHijos;
    }

    //METODOS PUNTO 3
    public List<ProductoManufacturado> getProductosXRubro() {
        List<ProductoManufacturado> productos = new ArrayList<>();

        if (this.productos != null) {
            productos.addAll(this.productos);
        }

        if (this.rubrosHijos != null) {
            for (Rubro hijo : this.rubrosHijos) {
                productos.addAll(hijo.getProductosXRubro());
            }
        }
        return productos;
    }

    public ProductoManufacturado getProductoMayorPrecio() {
        List<ProductoManufacturado> productos = getProductosXRubro();
        
        ProductoManufacturado productoMayorPrecio = productos.get(0);

        for (ProductoManufacturado producto : productos) {
            if (producto.getPrecioVenta() > productoMayorPrecio.getPrecioVenta()) {
                productoMayorPrecio = producto;
            }
        }

        return productoMayorPrecio;
    }
}
