package view;

import java.awt.*;
import java.awt.event.*;

/**
 * @author rubisetcie
 */
public class MessageBox extends Dialog implements ActionListener
{
    /** Bouton OK. */
    private Button ok;

    /**
     * Le constructeur.
     *
     * @param frame     cadre parent.
     * @param message   message à afficher.
     */
    public MessageBox(final Frame frame, final String message)
    {
        // Appel du constructeur supérieur :
        super(frame, "Erreur", true);
        
        // Création du panneau :
        Panel p = new Panel();
        
        p.setLayout(new FlowLayout());
        p.add(this.ok = new Button("OK"));
        
        this.ok.addActionListener(this);

        this.setLayout(new BorderLayout());
        this.add("Center", new Label(message));
        this.add("South", p);
        
        // Configuration de la dimension :
        Dimension d = getToolkit().getScreenSize();
        this.setLocation(d.width / 3, d.height / 3);
        this.setResizable(false);
        
        this.pack();
        this.setVisible(true);
    }

    /**
     * Callback pour une action.
     * @param ae évènement à traiter.
     */
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        this.setVisible(false);
    }
}
