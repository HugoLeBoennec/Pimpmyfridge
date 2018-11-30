package model;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;

/**
 *
 * @author rubisetcie
 */
public class Speaker implements SerialPortEventListener
{
    /** Nom du port connecté à l'Arduino. */
    private static final String NAME = "COM3";
    
    /** le temps en millisecondes de blocage en attendant l'ouverture du port. */
    private static final int TIME_OUT = 2000;
    
    /** Le bitrate par défaut pour le port (en bauds). */
    private static final int DATA_RATE = 9600;
    
    /** Représentant du port connecté à l'Arduino. */
    private SerialPort port;
    
    /** Le tampon de lecture. */
    private BufferedReader input;
    
    /** Le flux d'écriture. */
    private OutputStream output;
    
    /** Réference vers le modèle. */
    private final Model model;
    
    /**
     * Le constructeur, initialise le dialogue.
     * @param model référence vers le modèle.
     */
    public Speaker(final Model model)
    {
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
        
        // On définit les attributs :
        this.model = model;

        // On commence par assigner le port parmis ceux du système :
	while (portEnum.hasMoreElements())
        {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            
            if (currPortId.getName().equals(NAME))
            {
                portId = currPortId;
                break;
            }
	}
        
	if (portId == null)
        {
            this.model.getController().notify("Port introuvable !");
            return;
	}

        try
        {
            // On ouvre le port série en utilisant le nom de la classe :
            this.port = (SerialPort) portId.open("Speaker", TIME_OUT);

            // On configure les paramètres du port :
            this.port.setSerialPortParams(DATA_RATE,
                                          SerialPort.DATABITS_8,
                                          SerialPort.STOPBITS_1,
                                          SerialPort.PARITY_NONE);

            // On ouvre les tampons et flux :
            this.input = new BufferedReader(new InputStreamReader(this.port.getInputStream()));
            this.output = this.port.getOutputStream();

            // On ajoute l'écouteur d'évènements :
            this.port.addEventListener(this);
            this.port.notifyOnDataAvailable(true);
            
        }
        catch (final PortInUseException | UnsupportedCommOperationException | IOException | TooManyListenersException e)
        {
            this.model.getController().notify(e.toString());
        }
    }
    
    /**
     * Permet de fermer le port.
     */
    public synchronized void close()
    {
	if (this.port != null)
        {
            this.port.removeEventListener();
            this.port.close();
	}
    }
    
    /**
     * Permet de gérer les évènements sur le port série.
     * 
     * @param spe l'évènement à traiter.
     */
    @Override
    public synchronized void serialEvent(final SerialPortEvent spe)
    {
        if (spe.getEventType() == SerialPortEvent.DATA_AVAILABLE)
        {
            try
            {
		String inputLine = input.readLine();
		System.out.println(inputLine);
            }
            catch (final IOException e)
            {
                this.model.getController().notify(e.toString());
            }
	}
    }
}
