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
import javax.persistence.ManyToMany;

/**
 *
 * @author neyda
 */
@Entity
public class SucursalEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSucursal;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "cuit")
    private String cuit;
    @Column(name = "telefono")
    private long telefono;
    @Column(name = "email")
    private String email;
    
    @ManyToMany(mappedBy = "sucursales")
    private List<ProductoManufacturado> productos;

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ProductoManufacturado> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoManufacturado> productos) {
        this.productos = productos;
    }
    
    //METODOS PUNTO 3
    public List<ProductoManufacturado> getProductosXTiempoFabricacion(int tiempoMaximo){
        List<ProductoManufacturado> productosXtiempo = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getTiempoFabricacion() <= tiempoMaximo) {
                productosXtiempo.add(productos.get(i));
            }
        }
        return productosXtiempo;
    }
    
    
    
}
