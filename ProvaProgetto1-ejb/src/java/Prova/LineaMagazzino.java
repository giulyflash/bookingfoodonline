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
public class LineaMagazzino implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantita;
    private String sogliaMinima;
    private String n_rif;
    
    @ManyToOne
    private MateriaPrima matPrima;
    @ManyToOne
    private Magazzino mag;

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
   

    /**
     * Get the value of mag
     *
     * @return the value of mag
     */
    public Magazzino getMag() {
        return mag;
    }

    /**
     * Set the value of mag
     *
     * @param mag new value of mag
     */
    public void setMag(Magazzino mag) {
        this.mag = mag;
    }


    /**
     * Get the value of n_rif
     *
     * @return the value of n_rif
     */
    public String getN_rif() {
        return n_rif;
    }

    /**
     * Set the value of n_rif
     *
     * @param n_rif new value of n_rif
     */
    public void setN_rif(String n_rif) {
        this.n_rif = n_rif;
    }

    /**
     * Get the value of sogliaMinima
     *
     * @return the value of sogliaMinima
     */
    public String getSogliaMinima() {
        return sogliaMinima;
    }

    /**
     * Set the value of sogliaMinima
     *
     * @param sogliaMinima new value of sogliaMinima
     */
    public void setSogliaMinima(String sogliaMinima) {
        this.sogliaMinima = sogliaMinima;
    }





    
    /**
     * Get the value of quantita
     *
     * @return the value of quantita
     */
    public int getQuantita() {
        return quantita;
    }

    /**
     * Set the value of quantita
     *
     * @param quantita new value of quantita
     */
    public void setQuantita(int quantita) {
        this.quantita = quantita;
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
        if (!(object instanceof LineaMagazzino)) {
            return false;
        }
        LineaMagazzino other = (LineaMagazzino) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prova.LineaMagazzino[id=" + id + "]";
    }

}
