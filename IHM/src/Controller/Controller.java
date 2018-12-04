package controller;

import java.awt.Color;
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
     * Augmente la valeur de consigne de 1 degré celsius.
     */
    public void increaseConsigne()
    {
        if (this.model.getConsigne() < 26)
        {
            this.model.setConsigne(this.model.getConsigne() + 1);
        }
    }
    
    /**
     * Diminue la valeur de consigne de 1 degré celsius.
     */
    public void decreaseConsigne()
    {
        if (this.model.getConsigne() > 15)
        {
            this.model.setConsigne(this.model.getConsigne() - 1);
        }
    }
    
    /**
     * Envoie une nouvelle consigne.
     */
    public void sendConsigne()
    {
        this.model.getSpeaker().serialSend(this.model.getConsigne());
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
        
        if (values[3].equals("0"))
        {
            this.view.getFrame().num_c.setText("Non");
            this.view.getFrame().num_c.setForeground(Color.black);
            
            this.model.setAvertissement(false);
        }
        else
        {
            this.view.getFrame().num_c.setText("Oui");
            this.view.getFrame().num_c.setForeground(Color.red);
            
            this.model.setAvertissement(true);
        }
        
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
     * @return tableau de températures.
     */
    public final ArrayList<Double> getTemperatures()
    {
        return this.model.getTemperatures();
    }
    
    /**
     * Retourne le tableau des humidités mesurées.
     * 
     * @return tableau de températures.
     */
    public final ArrayList<Double> getHumidite()
    {
        return this.model.getHumidites();
    }
    
    /**
     * Retourne le flag d'avertissement.
     * 
     * @return le flag d'avertissement
     */
    public boolean getAvertissement()
    {
        return this.model.getAvertissement();
    }
    
    /**
     * Retourne la consigne.
     * 
     * @return la consigne.
     */
    public int getConsigne()
    {
        return this.model.getConsigne();
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
