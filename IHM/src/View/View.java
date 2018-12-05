package view;

import controller.Controller;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
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
        this.frame = new Frame(this.controller);
        
        try
        {
            this.frame.setIconImage(ImageIO.read(new File("Star.png")));
        }
        catch (final IOException e)
        {
            this.controller.notify(e.getMessage());
        }
        
        this.frame.setVisible(true);
    }
    
    /**
     * @return le cadre de l'interface.
     */
    public Frame getFrame()
    {
        return this.frame;
    }
    
    /**
     * @return le contrôleur.
     */
    public Controller getController()
    {
        return this.controller;
    }
}
