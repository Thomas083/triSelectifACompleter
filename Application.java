package triSelectifACompleter;

import javax.swing.JFrame;

// Classe contenant le main et créant la fenêtre. Permet de lancer la simulation
public class Application {
    public static void main(String[] args) {
    	JFrame fenetre = null;
    	
        // Création de la fenêtre.
    	// TODO GRETA (5 lignes à rajouter) :
    	// - Création de la fenêtre.
    	// - Ajout d'un titre à la fenêtre.
    	// - Spécification des dimensions, par exemple 1280 par 1024.
    	// - Positionnement de la fenêtre en x=50, y=50.
    	// - Empêcher la fenêtre d'être redimenssionnée.
    	
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Création du contenu
        TriJPanel panel = new TriJPanel();
        fenetre.setContentPane(panel);
        
        // TODO GRETA (1 ligne) : afficher la fenêtre.

        // TODO GRETA (1 ligne) : lancer la simulation.
    }
}
