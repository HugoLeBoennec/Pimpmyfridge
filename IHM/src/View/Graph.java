package view;

import controller.Controller;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author rubisetcie
 */
public class Graph extends Canvas
{
    /** Réference vers le contrôleur. */
    private final Controller controller;
    
    /** Représente l'image d'avertissement. */
    private Image avertissement = null;
    
    /**
     * Le constructeur.
     * 
     * @param controller référence vers le contrôleur.
     */
    public Graph(final Controller controller)
    {
        this.controller = controller;
        
        try
        {
            this.avertissement = ImageIO.read(new File("Icon.png"));
        }
        catch (final IOException e)
        {
            this.controller.notify("Echec du chargement de l'image d'avertissement !");
        }
    }
    
    /**
     * Dessine le graphe.
     * 
     * @param g objet permettant de dessiner.
     */
    @Override
    public void paint(final Graphics g)
    {
        // On récupère les dimensions du graphe :
        final Dimension d = this.getSize();
        String s;
        int x, y, xb, yb, i, num;
        
        g.setColor(Color.black);
        
        // Dessin des axes :
        g.drawLine(0, d.height-24, d.width, d.height-24);
        g.drawLine(38, 0, 38, d.height);
        
        // Dessin des graduations horizontales :
        for (x = 70; x < d.width; x += 32)
        {
            g.drawLine(x, d.height-30, x, d.height-18);
        }
        
        // Dessin des graduations verticales :
        num = (d.height - 16) / 32;
        for (i = 0; i < num; i++)
        {
            y = 16 + (i - 0) * (d.height - 40) / (num - 0);
            s = Double.toString(26.0d + (i - 0.0d) * -11.0d / num);
            
            g.drawLine(32, y, 44, y);
            g.drawChars(s.toCharArray(), 0, 4, 4, y+4);
        }
        
        g.drawChars("15.0".toCharArray(), 0, 4, 4, d.height-6);
        
        // Dessin de l'évolution de la température :
        if (!this.controller.getTemperatures().isEmpty())
        {
            g.setColor(Color.red);

            x = 38;
            xb = 38;
            y = (int) ((d.height - 24.0d) + (this.controller.getTemperatures().get(0) - 15.0d) * (16.0d - (d.height - 24.0d)) / 11.0d);

            for (double t : this.controller.getTemperatures())
            {
                yb = (int) ((d.height - 24.0d) + (t - 15.0d) * (16.0d - (d.height - 24.0d)) / 11.0d);

                g.drawLine(x, y, xb, yb);

                y = yb;
                x = xb;
                xb += 32;
            }
        }
        
        // Dessin de l'évolution de l'humidité :
        if (!this.controller.getHumidite().isEmpty())
        {
            g.setColor(Color.blue);

            x = 38;
            xb = 38;
            y = (int) ((d.height - 24.0d) + this.controller.getHumidite().get(0) * (16.0d - (d.height - 24.0d)) / 100.0d);

            for (double h : this.controller.getHumidite())
            {
                yb = (int) ((d.height - 24.0d) + h * (16.0d - (d.height - 24.0d)) / 100.0d);

                g.drawLine(x, y, xb, yb);

                y = yb;
                x = xb;
                xb += 32;
            }
        }
        
        // Dessin de l'avertissement si présent :
        if (this.controller.getAvertissement())
        {
            g.setColor(Color.red);
            g.drawImage(this.avertissement, 48, 8, null);
            g.drawBytes("Avertissement condensation !".getBytes(), 0, 28, 86, 20);
            g.drawBytes("Veuillez baisser la temperature.".getBytes(), 0, 32, 86, 36);
        }
    }
}
