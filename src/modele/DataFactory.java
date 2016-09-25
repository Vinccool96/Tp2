package modele;

import javafx.scene.paint.Color;

public class DataFactory {
	private String forme;
	private Color couleur;
	private boolean effet;
	private double positionX;
	private double positionY;
	private double largeur;
	private double hauteur;
	private double coteC;
	private double opacite;

	public DataFactory(Forme forme, Couleur couleur, boolean effet, double positionX, double positionY, double largeur,
			double hauteur, double coteC, double opacite) {
		throw new UnsupportedOperationException();
	}

	public String getForme() {
		return this.forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}

	public Color getCouleur() {
		return this.couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public boolean getEffet() {
		return this.effet;
	}

	public void setEffet(boolean effet) {
		this.effet = effet;
	}

	public double getPositionX() {
		return this.positionX;
	}

	public void setPositionX(double aPositionX) {
		this.positionX = aPositionX;
	}

	public double getPositionY() {
		return this.positionY;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	public double getLargeur() {
		return this.largeur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	public double getHauteur() {
		return this.hauteur;
	}

	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}

	public double getCoteC() {
		return this.coteC;
	}

	public void setCoteC(double coteC) {
		this.coteC = coteC;
	}

	public double getOpacite() {
		return this.opacite;
	}

	public void setOpacite(double opacite) {
		this.opacite = opacite;
	}
}