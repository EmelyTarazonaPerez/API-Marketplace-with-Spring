package com.proyectospring.proyectomarket.persistencia.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;

    @Column(name = "codigo_barra")
    private String codigoBarra;

    @Column(name = "precio_venta")
    private Double precioVenta;


    public Integer getIdProducto() {
        return idProducto;
    }
    @Column(name = "cantidad_sto")
    private Integer cantidadSto;

    private boolean estado;

    @OneToMany(mappedBy = "producto")
    private List<ComprasProducto> productos;

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadSto() {
        return cantidadSto;
    }

    public void setCantidadSto(Integer cantidadSto) {
        this.cantidadSto = cantidadSto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}