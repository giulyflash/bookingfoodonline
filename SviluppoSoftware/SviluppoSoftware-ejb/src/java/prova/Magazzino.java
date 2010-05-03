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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Matteo
 */
@Entity
public class Magazzino implements Serializable {

    @OneToMany(mappedBy = "mag")    
    private List<LineaMagazzino> lineaMagazzinos;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Localita;




    public List<LineaMagazzino> getLineaMagazzinos() {
        return lineaMagazzinos;
    }

    public void setLineaMagazzinos(List<LineaMagazzino> lineaMagazzinos) {
        this.lineaMagazzinos = lineaMagazzinos;
    }

    /**
     * Get the value of Località
     *
     * @return the value of Località
     */
    public String getLocalita() {
        return Localita;
    }

    /**
     * Set the value of Località
     *
     * @param Località new value of Località
     */
    public void setLocalita(String Localita) {
        this.Localita = Localita;
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
        if (!(object instanceof Magazzino)) {
            return false;
        }
        Magazzino other = (Magazzino) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prova.Magazzino[id=" + id + "]";
    }
    

}
