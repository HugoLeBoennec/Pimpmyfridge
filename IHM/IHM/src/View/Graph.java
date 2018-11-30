package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author rubisetcie
 */
public class Graph extends Canvas
{
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
        int x, y, i, num;
        
        g.setColor(Color.black);
        
        // Dessin des axes :
        g.drawLine(0, d.height-24, d.width, d.height-24);
        g.drawLine(38, 0, 38, d.height);
        
        // Dessin des graduations horizontales :
        i = 1;
        for (x = 70; x < d.width; x += 32)
        {
            g.drawLine(x, d.height-30, x, d.height-18);
        }
        
        // Dessin des graduations verticales :
        num = (d.height - 16) / 32;
        for (i = 0; i < num; i++)
        {
            y = 16 + (i - 0) * (d.height-24 - 16) / (num - 0);
            s = Double.toString(26.0d + (i - 0.0d) * (15.0d - 26.0d) / (num - 0.0d));
            
            g.drawLine(32, y, 44, y);
            g.drawChars(s.toCharArray(), 0, 4, 4, y+4);
        }
        
        g.drawChars("15.0".toCharArray(), 0, 4, 4, d.height-6);
    }
}
