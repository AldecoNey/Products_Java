/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcialprogiii;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author neyda
 */
@Entity
public class ProductoManufacturado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "tiempo_fabricacion")
    private int tiempoFabricacion;
    @Column(name = "denominacion")
    private String denominacion;
    @Column(name = "precio_venta")
    private double precioVenta;
    @Column(name = "margen_ganancia")
    private double margenGanancia;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_rubro")
    private Rubro rubro;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "producto_sucursal",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_sucursal")
    )
    private List<SucursalEmpresa> sucursales;

    @OneToMany(mappedBy = "productoManu")
    private List<ProductoManufacturadoDetalle> detallesProducto;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getTiempoFabricacion() {
        return tiempoFabricacion;
    }

    public void setTiempoFabricacion(int tiempoFabricacion) {
        this.tiempoFabricacion = tiempoFabricacion;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getMargenGanancia() {
        return margenGanancia;
    }

    public void setMargenGanancia(double margenGanancia) {
        this.margenGanancia = margenGanancia;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public List<SucursalEmpresa> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<SucursalEmpresa> sucursales) {
        this.sucursales = sucursales;
    }

    public List<ProductoManufacturadoDetalle> getDetallesProducto() {
        return detallesProducto;
    }

    public void setDetallesProducto(List<ProductoManufacturadoDetalle> detallesProducto) {
        this.detallesProducto = detallesProducto;
    }

    //METODOS PUNTO 3
    public void getPrecioVentaCalculado() {
        double costoInsumos = 0.0;

        if (detallesProducto != null) {
            for (ProductoManufacturadoDetalle detalle : detallesProducto) {
                costoInsumos += detalle.getInsumo().getPrecioCosto() * detalle.getCantidad();
            }
        }

        double margenGanancia = this.margenGanancia;
        double precioVentaCalculado = costoInsumos * (1 + margenGanancia);

        this.precioVenta = precioVentaCalculado;
    }
}
