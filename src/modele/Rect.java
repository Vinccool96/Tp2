package modele;

import javafx.scene.shape.Rectangle;
import exception.FormeException;

public class Rect extends Forme {
	private double hauteur = MIN_VAL;
	private double largeur = MIN_VAL;
	private Rectangle rect;

	/**
	 * @return @throws Exception
	 */
	public Rect(double largeur, double hauteur) throws FormeException {
		if (validerLargeur(largeur) && validerHauteur(hauteur)) {
		}
	}

	/**
	 * Vérifie si la hauteur est valide, soit entre 1 et 2000 inclus
	 * 
	 * @param hauteur
	 *            int, la hauteur voulant être appliqué devant être vérifié
	 * @return true si la hauteur est valide
	 */
	private boolean validerHauteur(double hauteur) {
		return ((MIN_VAL <= hauteur) && (hauteur <= MAX_VAL));
	}

	/**
	 * Vérifie si la largeur est valide, soit entre 1 et 2000 inclus
	 * 
	 * @return true si la largeur est valide
	 */
	private boolean validerLargeur(double largeur) {
		return ((MIN_VAL <= largeur) && (largeur <= MAX_VAL));
	}

	public Rectangle getRect() {
		return this.rect;
	}

	public void setRect() {
		throw new UnsupportedOperationException();
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public double getHauteur() {
		return this.hauteur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public double getLargeur() {
		return this.largeur;
	}
}