package triSelectifACompleter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

// Panel contenant la simulation de tri sélectif
// TODO GRETA : la classe TriJPanel est un écouteur de souris. Implémenter la bonne interface.
public class TriJPanel extends JPanel implements Observer, ??? {
    Timer timer;
    boolean enCours = false;
    TimerTask tache;
    Environnement env;
    
    public TriJPanel() {
        this.setBackground(Color.WHITE);
        this.addMouseListener(this);
    }
    
    public void Lancer() {
        env = Environnement.getInstance();
        env.Initialiser(500, 300, getWidth(), getHeight(), 3);
        env.addObserver(this);
    }

    // TODO GRETA : ce code est à utiliser pour la gestion du clic souris. A copier-coller
    // dans la bonne méthode suite à l'implémentation de l'interface adéquate.
    /*
        if (enCours) {
            // On arrête le timer
            timer.cancel();
            timer = null;
            enCours = false;
        }
        else {
            // On lance le timer
            timer = new Timer();
            tache = new TimerTask() {
                @Override
                public void run() {
                    env.MiseAJour();
                }
            };
            timer.scheduleAtFixedRate(tache, 0, 10);
            enCours = true;
        }
    */
    
    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
        int agentsCharges = 0;
        for (AgentTri a : env.agents) {
            if (a.estCharge()) {
                agentsCharges++;
            }
        }
        System.out.println(env.dechets.size() + " - " + agentsCharges);
    }
    
    public void DessinerAgent(AgentTri agent, Graphics g) {
    	// TODO GRETA : 5 lignes : choix de la couleur de l'agent selon qu'il est
    	// chargé ou pas. 
    	
    	// TODO GRETA : 1 ligne : dessin de l'agent.
    }
    
    public void DessinerDechet(Dechet d, Graphics g) {
        // Choix de la couleur
        Color couleur;
        // TODO GRETA : switch de 10 lignes : choix de la couleur selon les déchets.
        
        g.setColor(couleur);
        
        // Base : carrée
        g.fillRect((int) d.posX - 1, (int) d.posY - 1, 3, 3);
        
        // Zone d'influence (ronde)
        couleur = new Color(couleur.getRed(), couleur.getGreen(), couleur.getBlue(), 50);
        
        g.setColor(couleur);
        int zone = d.ZoneInfluence();
        g.fillOval((int) d.posX - zone, (int) d.posY - zone, zone * 2, zone * 2);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (AgentTri agent : env.agents) {
        	// TODO GRETA : 1 ligne : ordonner le dessin de l'agent.
        }
        for (Dechet dechet : env.dechets) {
        	// TODO GRETA : 1 ligne : ordonner le dessin du déchet.
        }
    }
}
