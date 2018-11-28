package Model;

import Controller.Controller;

/**
 *
 * @author rubisetcie
 */
public class Model
{
    /** Réference vers le contrôleur. */
    private final Controller controller;
    
    /**
     * Le constructeur.
     * 
     * @param controller référence vers le contrôleur.
     */
    public Model(final Controller controller)
    {
        // On définit les attributs :
        this.controller = controller;
    }
}
