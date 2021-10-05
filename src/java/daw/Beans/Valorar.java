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
    @NamedQuery(name = "Valorar.all", query = "SELECT a FROM Valorar a")
})
public class Valorar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALORACION")
    private String valoracion;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DISENO")
    private String diseno;
    
    
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
        if (!(object instanceof Valorar)) {
            return false;
        }
        Valorar other = (Valorar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "daw.Beans.Valorar[ id=" + id + " ]";
    }

    /**
     * @return the valoracion
     */
    public String getValoracion() {
        return valoracion;
    }

    /**
     * @param valoracion the valoracion to set
     */
    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    /**
     * @return the diseno
     */
    public String getDiseno() {
        return diseno;
    }

    /**
     * @param diseno the diseno to set
     */
    public void setDiseno(String diseno) {
        this.diseno = diseno;
    }
    
}
