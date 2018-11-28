package View;

import Controller.Controller;

/**
 *
 * @author rubisetcie
 */
public class View
{
    /** Réference vers le contrôleur. */
    private final Controller controller;
    
    /** Le cadre de l'interface graphique AWT. */
    private final Frame frame;
    
    /**
     * Le constructeur.
     * 
     * @param controller référence vers le contrôleur.
     */
    public View(final Controller controller)
    {
        // On définit les attributs :
        this.controller = controller;
        this.frame = new Frame();
        
        this.frame.setVisible(true);
    }
}
