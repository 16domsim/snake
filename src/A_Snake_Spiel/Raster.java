package A_Snake_Spiel;

/**
 * Klasse welches ein zweidimensionales Boolean-Raster mit spalten Spalten und
 * zeilen Zeilen zur verfügung zur Verfügung stellt. true bedeutet besetzt,
 * false bedeutet frei.
 */
public class Raster {

	private final int spalten;
	private final int zeilen;
	private boolean[][] raster;

	/**
	 * Dieser Konstruktor erstellt ein neues Raster, die Anzahl der Zeilen und
	 * Spalten werden aus den Übergebenen Parameter breite und hoehe in Relation zur
	 * festgelegten Iconengroesse berechnet. Anschließend füllt es das Raster mit
	 * dem Defaultwert false.
	 * 
	 * @param breite
	 *            Breite (in Pixel) vom Fenster
	 * @param hoehe
	 *            Hoehe (in Pixel) vom Fenster
	 */
	public Raster(int breite, int hoehe) {
		spalten = breite / Spiel.getIconengroesse();
		zeilen = hoehe / Spiel.getIconengroesse();
		raster = new boolean[spalten][zeilen];
		for (int i = 0; i < spalten; i++) {
			for (int j = 0; j < zeilen; j++)
				raster[i][j] = false;
		}
	}

	/**
	 * Sperrt ein Feld im Raster, es setz das Feld an der Stelle, die mit den
	 * übergebenen Parameter x und y in Relation zur festgelegten Iconengroesse
	 * berechnet wird, auf true.
	 * 
	 * @param x
	 *            x-Position (in Pixel)
	 * @param y
	 *            y-Position (in Pixel)
	 */
	public void sperre(int x, int y) {
		raster[x / Spiel.getIconengroesse()][y / Spiel.getIconengroesse()] = true;
	}

	/**
	 * Sperrt alle im Array übergebenen Felder im Raster, es setz die Felder an der
	 * Stelle, die mit den übergebenen Parameter x und y in Relation zur
	 * festgelegten Iconengroesse berechnet werden, auf true. Dabei wird das Feld
	 * nur auf true gesetzt wenn die koordinate größer oder gleich 0 ist.
	 * 
	 * @param xy
	 *            Array mit den X,Y-Koordinaten der Felder, die zu sperren sind.
	 */
	public void sperre(int[][] xy) {
		for (int i = 0; i < xy.length; i++) {
			if (xy[i][0] >= 0 && xy[i][1] >= -1 && (xy[i][0] / Spiel.getIconengroesse()) < this.spalten
					&& (xy[i][1] / Spiel.getIconengroesse()) < this.zeilen)
				raster[xy[i][0] / Spiel.getIconengroesse()][xy[i][1] / Spiel.getIconengroesse()] = true;
		}
	}

	/**
	 * Setz das gesamte Raster wieder auf false.
	 */
	public void entsperrealles() {
		for (int i = 0; i < spalten; i++) {
			for (int j = 0; j < zeilen; j++)
				raster[i][j] = false;
		}
	}

	/**
	 * Überprüft ob im Raster das Feld an der Übergebene Stelle, die mit den
	 * übergebenen Parameter x und y in Relation zur festgelegten Iconengroesse
	 * berechnet wird, true ist. Wenn dies der Fall ist wird true zurückgeliefert,
	 * ansonsten false.
	 * 
	 * @param x
	 *            x-Position (in Pixel)
	 * @param y
	 *            y-Position (in Pixel)
	 * @return true wenn besetzt, sonst false
	 */
	public boolean istbesetzt(int x, int y) {
		return raster[x / Spiel.getIconengroesse()][y / Spiel.getIconengroesse()];
	}
}
