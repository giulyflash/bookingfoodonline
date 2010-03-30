/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Matteo
 */
public class Prenotazione {
    private Long id;
    private long idUtente;
    private HashMap<Integer,ConfigurazionePiatto> mappaPiatti;
    private double prezzo=0;
    private String zona;
    private String indirizzo;

    /**
     * Get the value of indirizzo
     *
     * @return the value of indirizzo
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * Set the value of indirizzo
     *
     * @param indirizzo new value of indirizzo
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }


    /**
     * Get the value of zona
     *
     * @return the value of zona
     */
    public String getZona() {
        return zona;
    }

    /**
     * Set the value of zona
     *
     * @param zona new value of zona
     */
    public void setZona(String zona) {
        this.zona = zona;
    }


    /**
     * Get the value of prezzo
     *
     * @return the value of prezzo
     */
    public double getPrezzo() {
        //if(Math.floor(prezzo * 100.0) / 100.0<1)
          // return 0;
        return Math.floor(prezzo * 100.0) / 100.0;
    }

    /**
     * Set the value of prezzo
     *
     * @param prezzo new value of prezzo
     */
    public void setPrezzo(double p) {
        if((Math.floor(p * 100.0) / 100.0)<1)
            this.prezzo = 0.0;
        else
            this.prezzo = Math.floor(p * 100.0) / 100.0;
    }


    /**
     * Get the value of ListaPiatti
     *
     * @return the value of ListaPiatti
     */
    public HashMap<Integer,ConfigurazionePiatto> getMappaPiatti(){
        return this.mappaPiatti;
    }

    /**
     * Set the value of ListaPiatti
     *
     * @param ListaPiatti new value of ListaPiatti
     */
    public void setMappaPiatti(HashMap<Integer,ConfigurazionePiatto> mappaPiatti) {
        this.mappaPiatti = mappaPiatti;
    }

    

    /**
     * Get the value of idUtente
     *
     * @return the value of idUtente
     */
    public long getIdUtente() {
        return idUtente;
    }

    /**
     * Set the value of idUtente
     *
     * @param idUtente new value of idUtente
     */
    public void setIdUtente(long idUtente) {
        this.idUtente = idUtente;
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
        if (!(object instanceof Prenotazione)) {
            return false;
        }
        Prenotazione other = (Prenotazione) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prova.Prenotazione[id=" + id + "]";
    }

}

