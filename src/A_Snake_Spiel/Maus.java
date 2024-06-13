package A_Snake_Spiel;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Mausobjektbauplan welches eine Maus zur Verfügung stellt die sich mit
 * Zufallszahlen eigenständig umherbewegt wobei sie nicht mit den Übergebenen
 * Koordinaten zusammenstoßt.
 */

class Maus {

	// Aktuelle X- und Y-Koordinaten der Maus
	private int xposition;
	private int yposition;

	// Aktuelles Bild der Maus
	private Image aktuellesbild;

	// Bildvariablen der Maus
	private static Image mausrechts;
	private static Image mauslinks;
	private static Image mausoben;
	private static Image mausunten;
	private static boolean bildergeladen = false;

	// Richtungsvariablen für die Maus
	private boolean rechts = false;
	private boolean links = true;
	private boolean oben = false;
	private boolean unten = false;

	// Distanzzähler der Maus
	private int distanz = 0;

	// Ausenränder von der Minimalen und Maximalen länge, die sich die Maus in einer
	// Richtung bewegen kann
	private static final int DISTANZMAX = 30;
	private static final int DISTANZMIN = 8;

	/**
	 * Konstruktor erstell ein neues Mausobjekt mit den X- und Y-Koordinaten x und
	 * y. Außerdem ladet er die Mausbilder falls sie noch nicht geladen wurden.
	 * 
	 * @param x
	 *            X-Koordinate der Maus
	 * @param y
	 *            Y-Koordinate der Maus
	 */
	public Maus(int x, int y) {
		this.setXposition(x);
		this.setYposition(y);
		if (!bildergeladen)
			loadimages();
		this.aktuellesbild = mausrechts;
	}

	/**
	 * Gibt die Variable xposition zurück.
	 *
	 * @return xposition
	 */
	public int getXposition() {
		return xposition;
	}

	/**
	 * Gibt die Variable yposition zurück.
	 *
	 * @return yposition
	 */
	public int getYposition() {
		return yposition;
	}

	/**
	 * Setzt die Variable xposition. Dabei muss der übergeben Parameter mit dem
	 * Verhältnis BREITE/ICONENGROESSE der Klassen Spiel und Startspiel
	 * übereinstimmen, ansonsten wird der alte Wert der Variable xposition behalten
	 * und der neue Wert wird nicht gesetzt.
	 *
	 * @param xposition
	 *            Variable xposition die gesetzt wird
	 */
	private void setXposition(int xposition) {
		if (xposition % Spiel.getIconengroesse() == 0 && xposition >= 0 && xposition < Startspiel.getBreite())
			this.xposition = xposition;
	}

	/**
	 * Setzt die Variable yposition. Dabei muss der übergeben Parameter mit den
	 * Verhältnis BREITE/ICONENGROESSE der Klassen Spiel und Startspiel
	 * übereinstimmen, ansonsten wird der alte Wert der Variable yposition behalten
	 * und der neue Wert wird nicht gesetzt.
	 *
	 * @param yposition
	 *            Variable yposition die gesetzt wird
	 */
	private void setYposition(int yposition) {
		if (yposition % Spiel.getIconengroesse() == 0 && yposition >= 0 && yposition < Startspiel.getHoehe())
			this.yposition = yposition;
	}

	/**
	 * Gibt die Variable aktuellesbild zurück.
	 *
	 * @return aktuellesbild
	 */
	public Image getAktuellesbild() {
		return aktuellesbild;
	}

	/**
	 * Diese Methode bewegt die Maus in der jeweiligen Richtung wenn sie dabei nicht
	 * mit eine X- und Y-Koordinaten von einem anderen im Spiel vorhandenen Objekt
	 * zusammenstoßt. Wenn schon wird eine neue Richtung, die die Maus distanz mal
	 * folgt, zufällig generiert. Wenn nach 20-maligen Versuch immernoch keine
	 * gültige Richtung berechnet werden konnte bleibt die Maus stehen. Außerdem
	 * ordnet diese Methode der Maus je nach Richtung das jeweilige Bild hinzu.
	 */
	public void bewege() {
		boolean feldfrei = false;
		int z = 0;
		while (!feldfrei && z < 20) {
			z++;
			feldfrei = true;
			if (distanz == 0) {
				this.distanz = (int) (Math.random() * (DISTANZMAX - DISTANZMIN)) + DISTANZMIN;
				int hilfe = (int) (Math.random() * 4);
				switch (hilfe) {
				case (0): {
					rechts = true;
					links = false;
					oben = false;
					unten = false;
					break;
				}
				case (1): {
					rechts = false;
					links = true;
					oben = false;
					unten = false;
					break;
				}
				case (2): {
					rechts = false;
					links = false;
					oben = true;
					unten = false;
					break;
				}
				case (3): {
					rechts = false;
					links = false;
					oben = false;
					unten = true;
				}
				}
			}
			int x = this.xposition;
			int y = this.yposition;
			if (rechts)
				x += Spiel.getIconengroesse();
			if (links)
				x -= Spiel.getIconengroesse();
			if (oben)
				y -= Spiel.getIconengroesse();
			if (unten)
				y += Spiel.getIconengroesse();
			feldfrei = !(x >= Startspiel.getBreite() || x < 0 || y >= Startspiel.getHoehe() || y < 0);
			if (feldfrei)
				feldfrei = !Spiel.raster.istbesetzt(x, y);
			if (feldfrei) {
				this.setXposition(x);
				this.setYposition(y);
				distanz--;
				if (rechts)
					this.aktuellesbild = mauslinks;
				if (links)
					this.aktuellesbild = mausrechts;
				if (oben)
					this.aktuellesbild = mausunten;
				if (unten)
					this.aktuellesbild = mausoben;
			} else
				distanz = 0;
		}
	}

	/**
	 * Diese Methode überprüft ob die übergebenen X- und Y-Koordinate gleich den X-
	 * und Y-Koordinaten von der Maus sind. Sie liefert true wenn dies der Fall ist,
	 * sonst false.
	 * 
	 * @param x
	 *            X-Koordinate
	 * @param y
	 *            Y-Koordinate
	 * @return true wenn Koordinaten übereinstimmen sonst false
	 */
	public boolean checkgegessen(int x, int y) {
		return this.xposition == x && this.yposition == y;
	}

	/**
	 * Ladet die Bilder mausrechts, mauslinks, mausoben und mausunten.
	 */
	private static void loadimages() {
		String quelle = Spiel.getMausquelle();

		ImageIcon a = new ImageIcon(quelle + "mausrechts.png");
		ImageIcon b = new ImageIcon(quelle + "mauslinks.png");
		ImageIcon c = new ImageIcon(quelle + "mausoben.png");
		ImageIcon d = new ImageIcon(quelle + "mausunten.png");

		mausrechts = a.getImage();
		mauslinks = b.getImage();
		mausoben = c.getImage();
		mausunten = d.getImage();
	}
}