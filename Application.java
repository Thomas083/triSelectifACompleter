package triSelectifACompleter;

import javax.swing.JFrame;

// Classe contenant le main et cr�ant la fen�tre. Permet de lancer la simulation
public class Application {
    public static void main(String[] args) {
    	JFrame fenetre = null;
    	
        // Cr�ation de la fen�tre.
    	// TODO GRETA (5 lignes � rajouter) :
    	// - Cr�ation de la fen�tre.
    	// - Ajout d'un titre � la fen�tre.
    	// - Sp�cification des dimensions, par exemple 1280 par 1024.
    	// - Positionnement de la fen�tre en x=50, y=50.
    	// - Emp�cher la fen�tre d'�tre redimenssionn�e.
    	
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Cr�ation du contenu
        TriJPanel panel = new TriJPanel();
        fenetre.setContentPane(panel);
        
        // TODO GRETA (1 ligne) : afficher la fen�tre.

        // TODO GRETA (1 ligne) : lancer la simulation.
    }
}
