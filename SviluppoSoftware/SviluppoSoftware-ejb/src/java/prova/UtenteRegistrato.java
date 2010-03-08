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

/**
 *
 * @author dani1913
 */
@Entity
public class UtenteRegistrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String password;
    private String nome;
    private String cognome;
    private String mail;
    private String indirizzo;
    private String n_cartacredito;
    private String telefono;
    private String n_acquisti;
    private String zona;

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
     * Get the value of n_acquisti
     *
     * @return the value of n_acquisti
     */
    public String getN_acquisti() {
        return n_acquisti;
    }

    /**
     * Set the value of n_acquisti
     *
     * @param n_acquisti new value of n_acquisti
     */
    public void setN_acquisti(String n_acquisti) {
        this.n_acquisti = n_acquisti;
    }


    /**
     * Get the value of telefono
     *
     * @return the value of telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Set the value of telefono
     *
     * @param telefono new value of telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


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
     * Get the value of n_cartacredito
     *
     * @return the value of n_cartacredito
     */
    public String getN_cartacredito() {
        return n_cartacredito;
    }

    /**
     * Set the value of n_cartacredito
     *
     * @param n_cartacredito new value of n_cartacredito
     */
    public void setN_cartacredito(String n_cartacredito) {
        this.n_cartacredito = n_cartacredito;
    }


    /**
     * Get the value of mail
     *
     * @return the value of mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * Set the value of mail
     *
     * @param mail new value of mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }


    /**
     * Get the value of cognome
     *
     * @return the value of cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Set the value of cognome
     *
     * @param cognome new value of cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
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


    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        if (!(object instanceof UtenteRegistrato)) {
            return false;
        }
        UtenteRegistrato other = (UtenteRegistrato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prova.UtenteRegistrato[id=" + id + "]";
    }

}
