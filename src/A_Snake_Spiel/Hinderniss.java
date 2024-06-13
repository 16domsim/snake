package A_Snake_Spiel;

import java.awt.Image;

/**
 * Hindernissobjektbauplan welches ein Hinderniss zur Verfügung stellt. Außerdem
 * bietet diese Klasse zur generierung bzw. zur Prüfung von ein
 * Hindernissobjekt.
 */
class Hinderniss {

	private int xposition;
	private int yposition;
	private Image h;

	/**
	 * Konstruktor welche die X- und Y-Position vom Hinderniss und dessen Bild
	 * verlangt.
	 * 
	 * @param x
	 *            X-Koordinate vom Hinderniss
	 * @param y
	 *            Y-Koordinate vom Hinderniss
	 * @param h
	 *            Bild vom Hinderniss
	 */
	public Hinderniss(int x, int y, Image h) {
		this.setXposition(x);
		this.setYposition(y);
		this.setH(h);
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
	 * Setzt die Variable xposition. Dabei muss der übergeben Parameter größer als 0
	 * und kleiner gleich als der BREITE vom Spielfeld minus der ICONENGROESSE sein,
	 * ansonsten wird der alte Wert der Variable xposition behalten und der neue
	 * Wert wird nicht gesetzt.
	 *
	 * @param xposition
	 *            Variable xposition die gesetzt wird
	 */
	public void setXposition(int xposition) {
		if (xposition > 0 && xposition <= Startspiel.getBreite() - Spiel.getIconengroesse())
			this.xposition = xposition;
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
	 * Setzt die Variable yposition. Dabei muss der übergeben Parameter größer als 0
	 * und kleiner gleich als der HOEHE vom Spielfeld minus der ICONENGROESSE sein,
	 * ansonsten wird der alte Wert der Variable yposition behalten und der neue
	 * Wert wird nicht gesetzt.
	 *
	 * @param yposition
	 *            Variable yposition die gesetzt wird
	 */
	public void setYposition(int yposition) {
		if (yposition > 0 && yposition <= Startspiel.getHoehe() - Spiel.getIconengroesse())
			this.yposition = yposition;
	}

	/**
	 * Gibt die Variable h zurück.
	 *
	 * @return h
	 */
	public Image getH() {
		return h;
	}

	/**
	 * Setzt die Variable h. Dabei muss der übergeben Parameter ungleich null sein,
	 * ansonsten wird der alte Wert der Variable h behalten und der neue Wert wird
	 * nicht gesetzt.
	 *
	 * @param h
	 *            Variable h die gesetzt wird
	 */
	public void setH(Image h) {
		if (h != null)
			this.h = h;
	}

	/**
	 * Diese Methode generiert ein Hindernissobjekt von welchen seine zufällig
	 * erzeugten X-und Y-Koordinate nicht mit jenen der im Spiel angelegten
	 * Objektkoordinate übereinstimmt, und gibt es dann zurück. Dies ist dank des
	 * Rasters von der Klasse Spiel möglich. Das Bild vom Hindernissobjekt wird
	 * zufällig aus den Übergebenen Bildarray berechnet. Wenn nach 1000 versuchen
	 * immernoch keine freie Position erlangt wurde wird die Schleife abgebrochen
	 * und null zurückgegeben.
	 * 
	 * @param xypos
	 *            Koordinate die das Hinderniss nicht haben darf
	 * @param hind
	 *            Bilder von welchen das Hinderniss zufällig eines übernimmt
	 * @return Hindernissobjekt
	 */
	public static Hinderniss generiereHinderniss(Image[] hind) {
		Hinderniss hinderniss = null;
		boolean feldfrei = false;
		int x = 0;
		int y = 0;
		Image h = null;
		int z = 0;
		while (!feldfrei && z < 1000) {
			x = (int) (Math.random() * (Startspiel.getBreite() / Spiel.getIconengroesse())) * Spiel.getIconengroesse();
			y = (int) (Math.random() * (Startspiel.getHoehe() / Spiel.getIconengroesse())) * Spiel.getIconengroesse();
			feldfrei = !Spiel.raster.istbesetzt(x, y);
			z++;
		}
		if (z < 1000) {
			h = hind[(int) (Math.random() * hind.length)];
			hinderniss = new Hinderniss(x, y, h);
		}
		return hinderniss;
	}

	/**
	 * Diese Methode überprüft ob die übergebenen X- und Y-Koordinate gleich den X-
	 * und Y-Koordinaten vom Hinderniss sind. Sie liefert true wenn dies der Fall
	 * ist, sonst false.
	 * 
	 * @param x
	 *            X-Koordinate
	 * @param y
	 *            Y-Koordinate
	 * @return true wenn Koordinaten übereinstimmen sonst false
	 */
	public boolean checkangestossen(int x, int y) {
		return this.xposition == x && this.yposition == y;
	}
}