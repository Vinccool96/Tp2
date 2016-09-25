package modele;

import exception.FormeException;
import javafx.scene.shape.Ellipse;

public class Ovale extends Forme {

	private double largeur = MIN_VAL;
	private double hauteur = MIN_VAL;
	private Ellipse ellipse;

	/**
	 * méthode construisant un objet de type Cercle avec un rayon valide, tout
	 * en lui assignant une couleur par défaut.
	 */
	public Ovale(double largeur, double hauteur) throws FormeException {
		boolean ok = validerEllipse(largeur, hauteur);
		if (ok) {
			setDimensions(largeur, hauteur);
			setEllipse();
		} else {
			throw new FormeException();
		}
	}

	public double getHauteur() {
		return hauteur;
	}

	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	public void setDimensions(double largeur, double hauteur) {
		setLargeur(largeur);
		setHauteur(hauteur);
	}

	public Ellipse getEllipse() {
		return ellipse;
	}

	public void setEllipse() {
		this.ellipse = new Ellipse(largeur, hauteur);
		this.ellipse.setCenterX(getLargeur() / 2);
		this.ellipse.setCenterY(getHauteur() / 2);
	}

	/**
	 * Vérifie si le rayon est valide, soit entre 1 et 30 inclus
	 * 
	 * @param largeur
	 *            double, le rayon voulant être appliqué devant être vérifié
	 * @return true le rayon est valide
	 */
	private static boolean validerEllipse(double largeur, double hauteur) {
		return ((MIN_VAL <= largeur) && (largeur <= MAX_VAL)) && ((MIN_VAL <= hauteur) && (hauteur <= MAX_VAL));
	}

}