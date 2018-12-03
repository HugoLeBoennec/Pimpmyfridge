package controller;

import java.util.ArrayList;
import model.Model;
import view.MessageBox;
import view.View;

/**
 *
 * @author rubisetcie
 */
public class Controller
{
    /** Réference vers le modèle. */
    private final Model model;
    
    /** Réference vers la vue. */
    private final View view;
    
    /** Timer pour réguler l'historique des mesures. */
    private int timer;
    
    /**
     * Le constructeur.
     */
    public Controller()
    {
        // On créé le modèle et la vue :
        this.model = new Model(this);
        this.view = new View(this);
        
        this.timer = 1;
    }
    
    /**
     * Envoie une nouvelle consigne.
     * 
     * @param consigne la consigne
     */
    public void setConsigne(final int consigne)
    {
        this.model.getSpeaker().serialSend(consigne);
    }
    
    /**
     * Règle les valeurs lues dans la vue.
     * 
     * @param values un tableau de chaînes de caractères contenant les valeurs.
     */
    public void setValues(final String[] values)
    {
        this.view.getFrame().num_t.setText(values[0] + " °C");
        this.view.getFrame().num_h.setText(Double.valueOf(values[1]) * 100.0d + " %");
        this.view.getFrame().num_r.setText(values[2] + " °C");
        this.view.getFrame().num_c.setText("0".equals(values[3]) ? "Non" : "Oui");
        
        this.timer--;
        
        if (this.timer == 0)
        {
            // On ajoute une température à l'historique :
            this.model.addTemperature(Double.valueOf(values[0]));

            // On ajoute une humidité relative à l'historique :
            this.model.addHumidite(Double.valueOf(values[1]) * 100.0d);

            // On redessine le graphe :
            this.view.getFrame().graph.repaint();
            
            this.timer = 100;
        }
    }
    
    /**
     * Retourne le tableau des températures mesurées.
     * 
     * @return tableau de températures
     */
    public ArrayList<Double> getTemperatures()
    {
        return this.model.getTemperatures();
    }
    
    /**
     * Retourne le tableau des humidités mesurées.
     * 
     * @return tableau de températures
     */
    public ArrayList<Double> getHumidite()
    {
        return this.model.getHumidites();
    }
    
    /**
     * Affiche un message de notification.
     * 
     * @param message le message à afficher.
     */
    public void notify(final String message)
    {
        new MessageBox(this.view.getFrame(), message);
    }
}
