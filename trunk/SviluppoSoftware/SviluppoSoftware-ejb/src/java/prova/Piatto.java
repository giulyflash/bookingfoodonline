/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;


/**
 *
 * @author Matteo
 */
@Entity
public class Piatto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String nome;
    private Double costo;
    private String categoria;
    private String url_immagine;
    
    private ArrayList<String> listaMaterieSottraibili= new ArrayList<String>();
    private ArrayList<String> listaMaterieNonModificabili= new ArrayList<String>();
    private ArrayList<String> listaPossibiliAggiunte = new ArrayList<String>();

    /**
     * Get the value of url_immagine
     *
     * @return the value of url_immagine
     */
    public String getUrl_immagine() {
        return url_immagine;
    }

    /**
     * Set the value of url_immagine
     *
     * @param url_immagine new value of url_immagine
     */
    public void setUrl_immagine(String url_immagine) {
        this.url_immagine = url_immagine;
    }



   


    /**
     * Get the value of categoria
     *
     * @return the value of categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Set the value of categoria
     *
     * @param categoria new value of categoria
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Get the value of listaPossibiliAggiunta
     *
     * @return the value of listaPossibiliAggiunta
     */
    public ArrayList<String> getListaPossibiliAggiunte() {
        return listaPossibiliAggiunte;
    }

    /**
     * Set the value of listaPossibiliAggiunta
     *
     * @param listaPossibiliAggiunta new value of listaPossibiliAggiunta
     */
    public void setListaPossibiliAggiunte(ArrayList<String> listaPossibiliAggiunte) {
        this.listaPossibiliAggiunte = listaPossibiliAggiunte;
    }

    public void setListaMaterieNonModificabili(ArrayList<String> materie) {
        this.listaMaterieNonModificabili = materie;
    }

    public void setListaMaterieSottraibili(ArrayList<String> materie) {
        this.listaMaterieSottraibili = materie;
    }
    
    
    /**
     * Get the value of costo
     *
     * @return the value of costo
     */
    public Double getCosto() {
        return   Math.floor(costo * 100.0) / 100.0;
    }

    /**
     * Set the value of costo
     *
     * @param costo new value of costo
     */
    public void setCosto(Double c) {
        if((Math.floor(c * 100.0) / 100.0)<1)
            this.costo=0.0;
        else
            this.costo = Math.floor(c * 100.0) / 100.0;
    }

    /**
     * Get the value of nome
     *
     * @return the value of nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Set the value of nome
     *
     * @param nome new value of nome
     */
    public void setNome(String nome) {
        this.nome = nome;
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
        if (!(object instanceof Piatto)) {
            return false;
        }
        Piatto other = (Piatto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prova.Piatto[id=" + id + "]";
    }

   
    

    public ArrayList<String> getMaterieSottraibili(){
        return listaMaterieSottraibili;
    }

    public ArrayList<String> getMaterieNonModificabili(){
        return listaMaterieNonModificabili;
    }
    

    

}
