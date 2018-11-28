package Controller;

import Model.Model;
import View.View;

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
    
    /**
     * Le constructeur.
     */
    public Controller()
    {
        // On créé le modèle et la vue :
        this.model = new Model(this);
        this.view = new View(this);
    }
}
