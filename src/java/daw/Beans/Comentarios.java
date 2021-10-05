/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Pablo
 */
@Entity
@NamedQueries({
   // @NamedQuery(name = "Comentarios.seleccionarIDComentarios", query = "SELECT A FROM Comentarios A WHERE A.articulo.id = :id"),
    @NamedQuery(name = "Comentarios.seleccionarComentarios", query = "SELECT C FROM Comentarios C WHERE C.visibilidad = :visibilidad AND C.articulo = :art")
})
public class Comentarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 200)
    @Column(name = "TEXTO")
    private String texto;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "VISIBILIDAD")
    private String visibilidad; //3 valores
    
    
    @OneToOne
    private Usuario user;

    @OneToMany
    private List<Articulos> articulo;

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
        if (!(object instanceof Comentarios)) {
            return false;
        }
        Comentarios other = (Comentarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "daw.Beans.Comentarios[ id=" + id + " ]";
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the visibilidad
     */
    public String getVisibilidad() {
        return visibilidad;
    }

    /**
     * @param visibilidad the visibilidad to set
     */
    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
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

    /**
     * @return the articulo
     */
    public List<Articulos> getArticulo() {
        return articulo;
    }

    /**
     * @param articulo the articulo to set
     */
    public void setArticulo(List<Articulos> articulo) {
        this.articulo = articulo;
    }

}