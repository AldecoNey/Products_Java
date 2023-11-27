
package com.mycompany.parcialprogiii;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInsumo;
    @Column(name = "denominacion")
    private String denominacion;
    @Column(name = "precio_costo")
    private double precioCosto;
    @Column(name = "stock_actual")
    private int stockActual;
    @Column(name = "unidad_medida")
    private String unidadMedida;
    
    @OneToMany(mappedBy = "insumo")
    private List<ProductoManufacturadoDetalle> productoDetalles;

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public List<ProductoManufacturadoDetalle> getProductoDetalles() {
        return productoDetalles;
    }

    public void setProductoDetalles(List<ProductoManufacturadoDetalle> productoDetalles) {
        this.productoDetalles = productoDetalles;
    }
    
    
}
