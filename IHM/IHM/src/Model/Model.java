package model;

import controller.Controller;

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
    }
    
    /**
     * @return le contrôleur.
     */
    public Controller getController()
    {
        return this.controller;
    }
}
