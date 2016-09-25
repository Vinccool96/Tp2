package modele;

import exception.FormeException;
import javafx.scene.shape.Polygon;

public class Triangle extends Forme {
	private double coteA = 0;
	private double coteB = 0;
	private double coteC = 0;
	private Polygon triangle;

	public Triangle(double a, double b, double c) throws FormeException {
		if (estTriangle(a, b, c) && validerTriangle(a, b, c)) {
			coteA = a;
			coteB = b;
			coteC = c;
		} else {
			throw new FormeException();
		}
	}

	private static boolean estTriangle(double a, double b, double c) {
		boolean realy = false;

		double[] table = { a, b, c };
		int n = table.length - 1;

		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++)
				if (table[j - 1] > table[j]) {
					double temp = table[j - 1];
					table[j - 1] = table[j];
					table[j] = temp;
				}
		}

		if ((table[2]) < ((table[0]) + (table[1]))) {

			realy = true;

		}

		return realy;

	}

	private static boolean validerTriangle(double a, double b, double c) {
		boolean realy = false;

		if (((MIN_VAL <= a) && (a <= MAX_VAL)) && ((MIN_VAL <= b) && (b <= MAX_VAL))
				&& ((MIN_VAL <= c) && (c <= MAX_VAL))) {
			realy = true;
		}

		return realy;
	}

	/**
	 * @return coteA
	 */
	public double getCoteA() {
		return coteA;
	}

	/**
	 * @return coteB
	 */
	public double getCoteB() {
		return coteB;
	}

	/**
	 * @return coteC
	 */
	public double getCoteC() {
		return coteC;
	}

	public Polygon getTriangle() {
		return triangle;
	}

	public void setTriangle() {
		this.triangle = new Polygon();
		triangle.getPoints().addAll(new Double[] { 0.0, getCoteA(), 0.0, getCoteB(), 0.0, getCoteC() });
	}
}