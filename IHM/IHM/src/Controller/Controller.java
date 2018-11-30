package controller;

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
    
    /**
     * Le constructeur.
     */
    public Controller()
    {
        // On créé le modèle et la vue :
        this.view = new View(this);
        this.model = new Model(this);
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
