package triSelectifACompleter;

import java.util.ArrayList;
import java.util.Collections;

// Agent qui va trier les déchets
public class AgentTri extends Objet {
    protected final static double PAS = 3;
    protected final static double PROB_CHGT_DIRECTION = 0.05;
    
    protected Dechet charge;
    
    // TODO GRETA : 2 lignes : vitesse en x et en y.
    
    protected boolean occupe = false;
    
    // Constructeur.
    public AgentTri(double _posX, double _posY) {
    	// TODO GRETA : 2 lignes : initialisation de la position.
    	
    	// TODO GRETA : 2 débuts de ligne : remplacer les ??? par l'attribut adéquat :
        ??? = Environnement.getInstance().generateur.nextDouble() - 0.5;
        ??? = Environnement.getInstance().generateur.nextDouble() - 0.5;
        
        Normaliser();
    }

    // Permet de normaliser la vitesse selon les deux axes.
    protected void Normaliser() {
        double longueur = Math.sqrt(vitesseX * vitesseX + vitesseY * vitesseY);
        vitesseX /= longueur;
        vitesseY /= longueur;
    }
    
    // Permet de savoir si l'agent est chargé ou pas.
    public boolean estCharge() {
    	// TODO GRETA : remplacer ??? par la bonne expression.
        return ???
    }

    // Permet de mettre à jour la position de l'agent dans l'univers.
    public void MiseAJourPosition() {
    	// TODO GRETA : 2 lignes : mise à jour de la position à partir de la vitesse.
    	
        double largeur = Environnement.getInstance().getLargeur();
        double hauteur = Environnement.getInstance().getHauteur();
        
        // TODO GRETA : 8 lignes : remplacer les ??? par les bons attributs.
        if (??? < 0) {
        	??? = 0;
        } else if (??? > largeur) {
        	??? = largeur;
        }
        if (??? < 0) {
        	??? = 0;
        } else if (??? > hauteur) {
        	??? = hauteur;
        }
    }
    
    // Permet de mettre à jour la direction de l'agent.
    protected void MiseAJourDirection(ArrayList<Dechet> dechets) {
        // Où aller ?
        ArrayList<Dechet> dansZone = new ArrayList();
        dansZone.addAll(dechets);
        dansZone.removeIf(d -> (Distance(d) > d.ZoneInfluence()));
        Collections.sort(dansZone, (Dechet d1, Dechet d2) -> (Distance(d1) < Distance(d2) ? -1: 1));
        Dechet but = null;
        
        if (charge != null) {
            dansZone.removeIf(d -> d.type != charge.type);
        }
        if (!dansZone.isEmpty()) {
            but = dansZone.get(0);
        }
        
        // Avons-nous un but ?
        if (but == null || occupe) {
            // Déplacement aléatoire
            if (Environnement.getInstance().generateur.nextDouble() < PROB_CHGT_DIRECTION) {
            	// TODO GRETA : 2 débuts de ligne : utiliser le bon attributs.
                ??? = Environnement.getInstance().generateur.nextDouble() - 0.5;
                ??? = Environnement.getInstance().generateur.nextDouble() - 0.5;
            }
            if (occupe && but == null) {
                occupe = false;
            }
        } else {
            // Aller au but
            vitesseX = but.posX - posX;
            vitesseY = but.posY - posY;
            // But atteint ?
            if (Distance(but) < PAS) {
                if (charge == null) {
                    if (Environnement.getInstance().generateur.nextDouble() < but.ProbaDePrendre()) {
                        charge = Environnement.getInstance().PrendreDechet(but);
                    }
                } else {
                    Environnement.getInstance().PoserDechet(but);
                    charge = null;
                }
                occupe = true;
            }
        }
        Normaliser();
    }
}
