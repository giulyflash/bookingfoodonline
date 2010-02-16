/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Prova;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Matteo
 */
@Entity
public class Forniture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
   
    @ManyToOne
    private MateriaPrima matPrima;
    
    @ManyToOne
    private Fornitore forn;

    /**
     * Get the value of forn
     *
     * @return the value of forn
     */
    public Fornitore getForn() {
        return forn;
    }

    /**
     * Set the value of forn
     *
     * @param forn new value of forn
     */
    public void setForn(Fornitore forn) {
        this.forn = forn;
    }

    /**
     * Get the value of matPrima
     *
     * @return the value of matPrima
     */
    public MateriaPrima getMatPrima() {
        return matPrima;
    }

    /**
     * Set the value of matPrima
     *
     * @param matPrima new value of matPrima
     */
    public void setMatPrima(MateriaPrima matPrima) {
        this.matPrima = matPrima;
    }



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
        if (!(object instanceof Forniture)) {
            return false;
        }
        Forniture other = (Forniture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prova.Forniture[id=" + id + "]";
    }

}
