/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import java.util.ArrayList;

/**
 *
 * @author Matteo
 */
public class ConfigurazionePiatto extends Piatto {

    private ArrayList<String> aggiunte; //aggiunte effettuate nella configurazione
    private ArrayList<String> sottratte;
    private int qnt=1;

    /**
     * Get the value of qnt
     *
     * @return the value of qnt
     */
    public int getQnt() {
        return qnt;
    }

    /**
     * Set the value of qnt
     *
     * @param qnt new value of qnt
     */
    public void setQnt(int qnt) {
        this.qnt = qnt;
    }


    /**
     * Get the value of sottratte
     *
     * @return the value of sottratte
     */
    public ArrayList<String> getSottratte() {
        return sottratte;
    }

    /**
     * Set the value of sottratte
     *
     * @param sottratte new value of sottratte
     */
    public void setSottratte(ArrayList<String> sottratte) {
        this.sottratte = sottratte;
    }

    private static final double costoAggiunta = 0.11; //costo di ogni aggiunta

    /**
     * Get the value of aggiunte
     *
     * @return the value of aggiunte
     */
    public ArrayList<String> getAggiunte() {
        return aggiunte;
    }

    /**
     * Set the value of aggiunte
     *
     * @param aggiunte new value of aggiunte
     */
    public void setAggiunte(ArrayList<String> aggiunte) {
        this.aggiunte = aggiunte;
    }


    /*public void addAggiunta(String a){
        aggiunte.add(a);
    }*/

    


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfigurazionePiatto)) {
            return false;
        }
        ConfigurazionePiatto other = (ConfigurazionePiatto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prova.ConfigurazionePiatto[id=" + id + "]";
    }

    public double calcolaTotale(){
        return getCosto()+ (aggiunte.size()*costoAggiunta);
    }

    public ArrayList<String> materiePrime(){
        ArrayList<String> totale = new ArrayList<String>();
        totale.addAll(this.getMaterieNonModificabili());
        totale.addAll(this.getAggiunte());
        totale.addAll(this.getMaterieSottraibili());
        totale.removeAll(this.getSottratte());
        return totale;
    }
}