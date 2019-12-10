package triSelectifACompleter;


// Représente un déchet dans l'environnement
public class Dechet extends Objet {
    protected final static double DECROISSANCE = 0.6;
    
    protected int type;
    protected int taille = 1;

    // Constructeur.
    public Dechet(double _posX, double _posY, int _type) {
        type = _type;
        // TODO GRETA : 2 lignes : initialiser la position.
    }
    
    // Constructeur par copie.
    public Dechet(Dechet d) {
        // TODO GRETA : 2 lignes : initialiser la position.
    	
        type = d.type;
    }

    // Retourne le type.
    public int getType() {
        return type;
    }
    
    // Retourne la taille.
    public int getTaille() {
        return taille;
    }
    
    
    public int ZoneInfluence() {
        return 10 + 8 * (taille - 1);
    }

    // Permet d'augmenter la taille de la zone.
    protected void AugmenterTaille() {
    	// TODO GRETA : 1 ligne à trouver !
    }
    
    // Permet de diminuer la taille de la zone.
    protected void DiminuerTaille() {
    	// TODO GRETA : 1 ligne à trouver !
    }
    
    // Permet de calculer la probabilité de "prendre de la matière".
    // Cette probabilité est proportionnelle à la taille de l'objet.
    protected double ProbaDePrendre() {
        return Math.pow(DECROISSANCE, taille-1);
    }
}
