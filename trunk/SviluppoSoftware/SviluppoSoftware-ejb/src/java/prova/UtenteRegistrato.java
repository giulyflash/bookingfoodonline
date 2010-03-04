/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; //libreria per chiavi esterne di tipo semplice

/**
 *
 * @author Matteo
 */
@Entity
public class UtenteRegistrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String password;
    private String Nome;
    private String Cognome;
    private String Mail;
    private String N_CartaCredito;
    private String Telefono;
    private int N_Acquisti;
    private String zona;
    private String Indirizzo;
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
     * Get the value of N_Acquisti
     *
     * @return the value of N_Acquisti
     */
    public int getN_Acquisti() {
        return N_Acquisti;
    }

    /**
     * Get the value of Telefono
     *
     * @return the value of Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * Set the value of Telefono
     *
     * @param Telefono new value of Telefono
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }


    /**
     * Get the value of N_CartaCredito
     *
     * @return the value of N_CartaCredito
     */
    public String getN_CartaCredito() {
        return N_CartaCredito;
    }

    /**
     * Set the value of N_CartaCredito
     *
     * @param N_CartaCredito new value of N_CartaCredito
     */
    public void setN_CartaCredito(String N_CartaCredito) {
        this.N_CartaCredito = N_CartaCredito;
    }

   /**
     * Get the value of Mail
     *
     * @return the value of Mail
     */
    public String getMail() {
        return Mail;
    }

    /**
     * Set the value of Mail
     *
     * @param Mail new value of Mail
     */
    public void setMail(String Mail) {
        this.Mail = Mail;
    }


    /**
     * Get the value of Indirizzo
     *
     * @return the value of Indirizzo
     */
    public String getIndirizzo() {
        return Indirizzo;
    }

    /**
     * Set the value of Indirizzo
     *
     * @param Indirizzo new value of Indirizzo
     */
    public void setIndirizzo(String Indirizzo) {
        this.Indirizzo = Indirizzo;
    }


    /**
     * Get the value of Cognome
     *
     * @return the value of Cognome
     */
    public String getCognome() {
        return Cognome;
    }

    /**
     * Set the value of Cognome
     *
     * @param Cognome new value of Cognome
     */
    public void setCognome(String Cognome) {
        this.Cognome = Cognome;
    }


    /**
     * Get the value of Nome
     *
     * @return the value of Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * Set the value of Nome
     *
     * @param Nome new value of Nome
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "Prova.UtenteRegistrato[id=" + id + "]";
    }

}
