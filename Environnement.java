package triSelectifACompleter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Random;

// Environnement, contenant les d�chets et les agents
public class Environnement extends Observable {
    // Gestion du singleton. Un singleton permet de n'avoir qu'une seule instance
	// de la classe. En effet, un seul environnement doit exister.
    private static Environnement instance;
    
    // M�thode statique permettant d'acc�der au singleton.
    public static Environnement getInstance() {
    	// TODO GRETA : 4 lignes � trouver. Le code d'un singleton est quelque chose
    	// de tr�s connu et de tr�s utilis� (cf. Google).
    }
    
    // Attributs
    protected Random generateur;
    protected double largeur;
    protected double hauteur;
    protected ArrayList<Dechet> dechets;
    protected ArrayList<AgentTri> agents;
    protected int nbIterations = 0;

    
    // Constructeur.
    private Environnement() {
        dechets = new ArrayList();
        agents = new ArrayList();
        generateur = new Random();
    }
    
    // Permet d'initialiser l'environnement.
    public void Initialiser(int _nbDechets, int _nbAgents, double _largeur, double _hauteur, int _nbTypesDechets) {
        largeur = _largeur;
        hauteur = _hauteur;
        dechets.clear();
        // TODO GRETA : une boucle comportant 2 lignes : initialisation des d�chets.
        
        agents.clear();
        // TODO GRETA : une boucle comportant 2 lignes : initialisation des agents.
    }
   
    public double getLargeur() {
        return largeur;
    }
    
    public double getHauteur() {
        return hauteur;
    }
    
    public void PoserDechet(Dechet d) {
        d.AugmenterTaille();        
    }
    
    public Dechet PrendreDechet(Dechet d) {
        if (d.taille == 1) {
            dechets.remove(d);
            return d;
        }
        else {
            d.DiminuerTaille();
            Dechet charge = new Dechet(d);
            return charge;
        }
    }
    
    public void MiseAJour() {
        for (AgentTri agent : agents) {
            agent.MiseAJourDirection(dechets);
            agent.MiseAJourPosition();
        }
        
        nbIterations++;
        if (nbIterations % 500 == 0) {
            Collections.reverse(dechets);
        }
        
        setChanged();
        notifyObservers();
    }
}
