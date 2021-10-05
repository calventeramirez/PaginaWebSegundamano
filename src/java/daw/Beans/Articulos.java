/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Pablo
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Articulos.all", query = "SELECT a FROM Articulos a"),
    @NamedQuery(name = "Articulos.findNombre", query = "SELECT a FROM Articulos a WHERE a.nombre = :name"),
    @NamedQuery(name = "Articulos.findID", query = "SELECT a FROM Articulos a WHERE a.id = :id"),
    @NamedQuery(name = "Articulos.findCategoria", query = "SELECT a FROM Articulos a WHERE a.categoria = :categoria"),
    @NamedQuery(name="Articulos.findPrecioMinimo", query="SELECT a FROM Articulos a WHERE a.precio >= :pmenor"),
    @NamedQuery(name="Articulos.findPrecioMaximo", query="SELECT a FROM Articulos a WHERE a.precio <= :pmayor"),
    @NamedQuery(name="Articulo.findRangoPrecio", query="SELECT a FROM Articulos a WHERE a.precio >= :pmenor AND a.precio <= :pmayor")
})
public class Articulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String categoria;

    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Size(max = 50)
    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "FECHA")
    private String fecha;

    @Column(name = "PRECIO")
    private double precio;

    @ManyToOne
    private Usuario user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulos)) {
            return false;
        }
        Articulos other = (Articulos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "daw.Beans.Productos[ id=" + id + " ]";
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the user
     */
    public Usuario getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Usuario user) {
        this.user = user;
    }

}