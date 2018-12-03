package model;

import controller.Controller;
import java.util.ArrayList;

/**
 *
 * @author rubisetcie
 */
public class Model
{
    /** Réference vers le contrôleur. */
    private final Controller controller;
    
    /** Réference vers le dialogueur avec l'Arduino. */
    private final Speaker speaker;
    
    /** Historique des températures mesurées. */
    private final ArrayList<Double> temperatures;
    
    /** Historique des humidités mesurées. */
    private final ArrayList<Double> humidites;
    
    /**
     * Le constructeur.
     * 
     * @param controller référence vers le contrôleur.
     */
    public Model(final Controller controller)
    {
        // On définit les attributs :
        this.controller = controller;
        this.speaker = new Speaker(this);
        
        this.temperatures = new ArrayList<>();
        this.humidites = new ArrayList<>();
    }
    
    /**
     * @return le contrôleur.
     */
    public Controller getController()
    {
        return this.controller;
    }
    
    /**
     * @return le dialogueur.
     */
    public Speaker getSpeaker()
    {
        return this.speaker;
    }
    
    /**
     * Ajoute une température à l'historique.
     * 
     * @param temperature la température à ajouter.
     */
    public void addTemperature(final double temperature)
    {
        this.temperatures.add(temperature);
        
        // Supprime le premier élement de la liste si celle-ci dépasse 64 éléments :
        if (this.temperatures.size() > 64)
            this.temperatures.remove(0);
    }
    
    /**
     * Ajoute une humidité à l'historique.
     * 
     * @param humidite l'humidité à ajouter.
     */
    public void addHumidite(final double humidite)
    {
        this.humidites.add(humidite);
        
        // Supprime le premier élement de la liste si celle-ci dépasse 64 éléments :
        if (this.humidites.size() > 64)
            this.humidites.remove(0);
    }
    
    /**
     * Retourne l'historique des températures mesurées.
     * 
     * @return tableau de températures
     */
    public ArrayList<Double> getTemperatures()
    {
        return this.temperatures;
    }
    
    /**
     * Retourne l'historique des humidités mesurées.
     * 
     * @return tableau d'humidités
     */
    public ArrayList<Double> getHumidites()
    {
        return this.humidites;
    }
}
