package A_Snake_Spiel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.GregorianCalendar;

import javax.swing.*;

import A_Snake_GUI.Startfenster;
import A_Snake_GUI.Top_10_Fenster;

/**
 * In dieser Klasse l�uft das Snakespiel. Der vom Spieler ereichte Punktestand
 * wird an der Top_10_Fenster Klasse weitergegeben.
 */

class Spiel extends JPanel implements ActionListener {

	// Spielfunktionsvariablen, werden beim Starten des Spiels festgelegt
	private int BREITE;
	private int HOEHE;
	private int MAX_DOTS;
	private boolean GOLDAPFEL;
	private int GOLDAPFELWAHRSCHEINLICHKEIT;
	private boolean APFELNACHZEIT;
	private int APFELINTERVALL;
	private boolean SPIEGELN;
	private boolean TURBO;
	private boolean HINDERNISSE;
	private int HINDERNISSMODUS;
	private boolean MAUS;
	private int skinnr;
	private String nickname;

	// Spielstartvariablen
	private final int ANFANGSTEILE = 3;
	private final int ZUWACHS = 1;
	private final int BREMSE = 40;
	private final int TURBOINTERVALL = 5;
	private final int HINDERNISSEMAX = 20;
	private boolean istTurbo = false;
	private int turbozaehler = 2;
	private Timer timer;

	// Richtungsvariablen vom Kopf der Schlange
	private boolean oben = false;
	private boolean unten = false;
	private boolean rechts = true;
	private boolean links = false;

	// Bildbreite/ -h�he der im Spiel verwendeten Bilder
	private static final int ICONENGROESSE = 30;

	// Bildvariablen
	private Image beet1;
	private Image beet2;
	private Image beet3;
	private Image beet4;
	private Image beet5;
	private Image h1;
	private Image h2;
	private Image h3;
	private Image apfel;
	private Image goldapfel;
	private Image kopfrechts;
	private Image kopflinks;
	private Image kopfunten;
	private Image kopfoben;
	private Image koerperrechts;
	private Image koerperlinks;
	private Image koerperunten;
	private Image koerperoben;
	private Image schwanzrechts;
	private Image schwanzlinks;
	private Image schwanzoben;
	private Image schwanzunten;
	private Image kurverechtsrechts;
	private Image kurverechtslinks;
	private Image kurverechtsunten;
	private Image kurverechtsoben;
	private Image kurvelinksrechts;
	private Image kurvelinkslinks;
	private Image kurvelinksunten;
	private Image kurvelinksoben;

	// Variablen f�r den Aktuellen Spielfluss
	private int teile = ANFANGSTEILE;
	private int XY_pos[][];
	private int[][] aepfel;
	private int apfelindex = 0;
	private Image[] schlangebilder;
	private char[] richtungen;
	private int zeit;
	private Hinderniss hindernisse[];
	private Image[] beet;
	private Maus maus;
	public static Raster raster;

	// Quellenvariablen
	private static final String hauptquelle = "/Users/domsim/Developing/Java/Games/";
	private static final String skinquelle = hauptquelle + "Snake_Projekt/src/Skinquelle/skin.txt";
	private static final String aepfelquelle = hauptquelle + "Snake_Projekt/src/Bilder/Apfel/";
	private static final String hindernissquelle = hauptquelle + "Snake_Projekt/src/Bilder/Hindernisse/";
	private final static String beetquelle = hauptquelle + "Snake_Projekt/src/Bilder/Beet/";
	private final static String mausquelle = hauptquelle + "Snake_Projekt/src/Bilder/Maus/";

	/**
	 * Startet ein neues Snake-Spiel mit den �bergebenen Parameter mit einer Gr��e
	 * von Breite mal Hoehe nachdem die Spielvariablen gesetzt, ein neues Raster
	 * angelegt und die gesamten Bilder geladen wurden.
	 * 
	 * @param nickname
	 *            Nickname vom Spieler.
	 * @param hoehe
	 *            Hoehe vom Spielfenster.
	 * @param breite
	 *            Breite vom Spielfenster.
	 * @param goldapfel
	 *            Goldapfel-Spielmodus, wenn die Schlange einen Goldapfel isst
	 *            w�chst sie um 3 K�rperl�ngen.
	 * @param goldapfelwahrscheinlichkeit
	 *            Wahrscheinlichkeit dass ein Goldapfel gespawnt wird (wenn sie 2
	 *            ist, ist die Wahrscheinlichkeit von eienn Goldapfel zu eienen
	 *            normalen Apfel 1/2).
	 * @param apfelnachzeit
	 *            Apfelnachzeit-Spielmodus, jede x Sekunden erscheint ein neuer
	 *            Apfel.
	 * @param apfelintervall
	 *            Abstand in x Sekunden zwischen dass Spawnen von zwei �pfel.
	 * @param spiegeln
	 *            Spiegeln-Spielmodus, wenn die Schlange �ber dem Rand geht kommt
	 *            sie auf der andaren Seite wieder raus.
	 * @param turbo
	 *            Turbo-Spielmodus, wenn man die Leertaste dr�ckt wird die Schlange
	 *            schneller als wie �blich, wenn man sie wider dr�ckt bewegt sie
	 *            sich wieder mit normaler schnelle. Dieser Spielmodus wird
	 *            automatisch aktiviert wenn der Maus-Spielmodus aktiviert ist.
	 * @param hindernisse
	 *            Hinderniss-Spielmodus, erzeugt Hindernisse im Spielfeld. Wenn die
	 *            Schlange damit zusammensto�t ist das Spiel verloren.
	 * @param hindernissmodus
	 *            Beim Hindernissmodus 0 werden beim Starten des Spieles 20
	 *            Hindernisse generiert. Beim Hindernissmodus 1 wird immer nachdem
	 *            ein Apfel oder eine Maus gegessen wurde ein neues Hinderniss
	 *            generiert bis es 20 werden.
	 * @param maus
	 *            Maus-Spielmodus, Maus bewegt sich im Spielfeld und weicht der
	 *            Schlange aus. Wenn dieser Spielmodus aktiviert ist wird
	 *            automatisch der Turbo-Spielmodus aktiviert.
	 * @param skinnr
	 *            Skinnnummer der Schlange, sie geht aktuell von 0-2.
	 */
	public Spiel(String nickname, int hoehe, int breite, boolean goldapfel, int goldapfelwahrscheinlichkeit,
			boolean apfelnachzeit, int apfelintervall, boolean spiegeln, boolean turbo, boolean hinderniss,
			int hindernissmodus, boolean maus, int skinnr) {
		this.nickname = nickname;
		this.BREITE = breite;
		this.HOEHE = hoehe;
		MAX_DOTS = get_MAX_DOTS(BREITE, HOEHE);
		XY_pos = new int[MAX_DOTS][2];
		aepfel = new int[100000][3];
		schlangebilder = new Image[MAX_DOTS];
		richtungen = new char[MAX_DOTS];
		hindernisse = new Hinderniss[HINDERNISSEMAX];
		beet = new Image[MAX_DOTS];
		this.skinnr = skinnr;
		setDefault();
		this.GOLDAPFEL = goldapfel;
		if (GOLDAPFEL)
			this.GOLDAPFELWAHRSCHEINLICHKEIT = goldapfelwahrscheinlichkeit;
		else
			GOLDAPFELWAHRSCHEINLICHKEIT = 0;
		this.APFELNACHZEIT = apfelnachzeit;
		if (APFELNACHZEIT)
			this.APFELINTERVALL = apfelintervall;
		else
			APFELINTERVALL = 0;
		this.SPIEGELN = spiegeln;
		this.TURBO = turbo;
		this.HINDERNISSE = hinderniss;
		if (HINDERNISSE)
			this.HINDERNISSMODUS = hindernissmodus;
		this.MAUS = maus;
		if (MAUS) {
			this.TURBO = true;
		}
		raster = new Raster(BREITE, HOEHE);
		addKeyListener(new Tastatur());
		setBackground(Color.BLACK);
		setFocusable(true);
		setPreferredSize(new Dimension(BREITE, HOEHE));
		loadImages();
		start();
		timer = new Timer(BREMSE, this);
		timer.start();
	}

	/**
	 * Gibt die Variable ICONENGROESSE zur�ck.
	 *
	 * @return ICONENGROESSE
	 */
	public static int getIconengroesse() {
		return ICONENGROESSE;
	}

	/**
	 * Gibt die Variable hindernissquelle zur�ck.
	 *
	 * @return hindernissquelle
	 */
	public static String getHindernissquelle() {
		return hindernissquelle;
	}

	/**
	 * Gibt die Variable mausquelle zur�ck.
	 *
	 * @return mausquelle
	 */
	public static String getMausquelle() {
		return mausquelle;
	}

	/**
	 * Diese Methode sezt die Default-Werte f�r folgende variablen: GOLDAPFEL,
	 * GOLDAPFELWAHRSCHEINLICHKEIT, APFELNACHZEIT, APFELINTERVALL, SPIEGELN,
	 * HINDERNISSE, HINDERNISSMODUS, TURBO, und MAUS.
	 * 
	 */
	private void setDefault() {
		GOLDAPFEL = false;
		GOLDAPFELWAHRSCHEINLICHKEIT = 0;
		APFELNACHZEIT = false;
		APFELINTERVALL = 0;
		SPIEGELN = false;
		HINDERNISSE = false;
		HINDERNISSMODUS = 0;
		TURBO = false;
		MAUS = false;
	}

	/**
	 * Diese Methode rechnet die maximale Anzahl von K�rperteile aus, die die
	 * Schlange in den Spielfenster haben kann.
	 * 
	 * @param BREITE
	 *            die Breite des Spielfensters
	 * @param HOEHE
	 *            die Hoehe des Spielfeldes
	 * @return maximale Anzahl von K�rperteilen
	 * 
	 */
	public int get_MAX_DOTS(int BREITE, int HOEHE) {
		return (BREITE / ICONENGROESSE) * (HOEHE / ICONENGROESSE);
	}

	/**
	 * Diese Methode wird vom Konstruktor aufgerufen, sobald die Spielparameter
	 * gesetzt wurden. Sie ladet die Bilder mithilfe vom Skin a in die private
	 * Mempervariablen der Klasse Spiel:apfel, goldapfel, kopfrechts, kopflinks,
	 * kopfunten, kopfoben, koerperrechts, koerperlinks, koerperunten, koerperoben,
	 * schwanzrechts, schwanzlinks, schwanzoben, schwanzunten, kurverechtsrechts,
	 * kurverechtslinks, kurverechtsunten, kurverechtsoben, kurvelinksrechts,
	 * kurvelinkslinks, kurvelinksunten, kurvelinksoben,h1 ,h2 und h3.
	 * 
	 */
	private void loadImages() {
		String skin = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(skinquelle));
			skin = reader.readLine();
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Datei konnte nicht gefunden werden!");
		} catch (IOException e) {
			System.out.println("Datei konnte nicht gelesen werden!");
		}
		Skin a = Skin.loadSkins(skin, '%', skinnr);

		ImageIcon aa = new ImageIcon(a.getKopfrechts());
		ImageIcon b = new ImageIcon(a.getKopflinks());
		ImageIcon c = new ImageIcon(a.getKopfunten());
		ImageIcon dd = new ImageIcon(a.getKopfoben());
		ImageIcon e = new ImageIcon(a.getKoerperrechts());
		ImageIcon f = new ImageIcon(a.getKoerperlinks());
		ImageIcon g = new ImageIcon(a.getKoerperunten());
		ImageIcon h = new ImageIcon(a.getKoerperoben());
		ImageIcon i = new ImageIcon(a.getSchwanzrechts());
		ImageIcon j = new ImageIcon(a.getSchwanzlinks());
		ImageIcon k = new ImageIcon(a.getSchwanzoben());
		ImageIcon l = new ImageIcon(a.getSchwanzunten());
		ImageIcon m = new ImageIcon(a.getKurverechtsrechts());
		ImageIcon n = new ImageIcon(a.getKurverechtslinks());
		ImageIcon o = new ImageIcon(a.getKurverechtsunten());
		ImageIcon p = new ImageIcon(a.getKurverechtsoben());
		ImageIcon q = new ImageIcon(a.getKurvelinksrechts());
		ImageIcon r = new ImageIcon(a.getKurvelinkslinks());
		ImageIcon s = new ImageIcon(a.getKurvelinksunten());
		ImageIcon t = new ImageIcon(a.getKurvelinksoben());

		kopfrechts = aa.getImage();
		kopflinks = b.getImage();
		kopfunten = c.getImage();
		kopfoben = dd.getImage();
		koerperrechts = e.getImage();
		koerperlinks = f.getImage();
		koerperunten = g.getImage();
		koerperoben = h.getImage();
		schwanzrechts = i.getImage();
		schwanzlinks = j.getImage();
		schwanzoben = k.getImage();
		schwanzunten = l.getImage();
		kurverechtsrechts = m.getImage();
		kurverechtslinks = n.getImage();
		kurverechtsunten = o.getImage();
		kurverechtsoben = p.getImage();
		kurvelinksrechts = q.getImage();
		kurvelinkslinks = r.getImage();
		kurvelinksunten = s.getImage();
		kurvelinksoben = t.getImage();

		ImageIcon u = new ImageIcon(aepfelquelle + "apfel.png");
		ImageIcon v = new ImageIcon(aepfelquelle + "goldapfel.png");

		apfel = u.getImage();
		goldapfel = v.getImage();

		ImageIcon w = new ImageIcon(hindernissquelle + "h1.png");
		ImageIcon x = new ImageIcon(hindernissquelle + "h2.png");
		ImageIcon y = new ImageIcon(hindernissquelle + "h3.png");

		h1 = w.getImage();
		h2 = x.getImage();
		h3 = y.getImage();

		ImageIcon z = new ImageIcon(beetquelle + "beet1.png");
		ImageIcon ab = new ImageIcon(beetquelle + "beet2.png");
		ImageIcon ac = new ImageIcon(beetquelle + "beet3.png");
		ImageIcon ad = new ImageIcon(beetquelle + "beet4.png");
		ImageIcon ae = new ImageIcon(beetquelle + "beet5.png");

		beet1 = z.getImage();
		beet2 = ab.getImage();
		beet3 = ac.getImage();
		beet4 = ad.getImage();
		beet5 = ae.getImage();

	}

	/**
	 * Diese Methode wird vom Konstruktor aufgerufen, sobald die Spielparameter
	 * gesetzt und die Bilder geladen wurden. Sie f�llt im bidimensionalen Array die
	 * X- und Y-Koordinaten der Schlange mit ANFANGSTEILE teilen nachdem sie das
	 * Array mit den Defaultwert -1 gef�llt hat, setzt die Richtungen der Teile im
	 * Richrungsarray richtungen. Sie �bertr�gt die Positionen der Schlange im
	 * Raster. Anschlie�end generiert sie wenn der Spielmodus HINDERNISSE aktiviert
	 * ist je nach Hindernissmodus 1 BIS HINDERNISSEMAX Hindernisse, und ruft die
	 * Methode setzapfel auf. Wenn der Spielmodus Maus aktiviert ist wird ein neues
	 * Mausobjekt instanziiert .Zuletzt wird mit der Methode generierebeet()
	 * zuf�llig ein Beet generiert.
	 * 
	 */
	public void start() {
		teile = ANFANGSTEILE;
		for (int i = 0; i < XY_pos.length; i++) {
			XY_pos[i][0] = -1;
			XY_pos[i][1] = -1;
		}
		for (int z = 0; z < teile; z++) {
			XY_pos[z][0] = 180 - z * ICONENGROESSE;
			XY_pos[z][1] = 60;
		}
		for (int i = 0; i < teile; i++)
			richtungen[i] = 'l';
		raster.sperre(XY_pos);
		if (HINDERNISSE) {
			Image[] hilfe = new Image[3];
			hilfe[0] = h1;
			hilfe[1] = h2;
			hilfe[2] = h3;
			if (HINDERNISSMODUS == 0) {
				for (int i = 0; i < HINDERNISSEMAX; i++) {
					hindernisse[i] = Hinderniss.generiereHinderniss(hilfe);
					raster.sperre(hindernisse[i].getXposition(), hindernisse[i].getYposition());
				}
			} else {
				hindernisse[0] = Hinderniss.generiereHinderniss(hilfe);
				raster.sperre(hindernisse[0].getXposition(), hindernisse[0].getYposition());
			}
		}
		if (MAUS) {
			maus = new Maus(BREITE - ICONENGROESSE, HOEHE - ICONENGROESSE);
			raster.sperre(maus.getXposition(), maus.getYposition());
		}
		setzapfel();
		generierebeet();
	}

	/**
	 * Diese Methode generiert ein Beet dass aus MAX_DOTS Bilder besteht. Dabei wird
	 * jedes einzelne Bild zuf�llig aus den 5 Bildern generiert.
	 */
	private void generierebeet() {
		for (int i = 0; i < MAX_DOTS; i++) {
			Image hilfe;
			int pos = (int) (Math.random() * 5);
			switch (pos) {
			case (0): {
				hilfe = beet1;
				break;
			}
			case (1): {
				hilfe = beet2;
				break;
			}
			case (2): {
				hilfe = beet3;
				break;
			}
			case (3): {
				hilfe = beet4;
				break;
			}
			default:
				hilfe = beet5;
			}
			beet[i] = hilfe;
		}
	}

	/**
	 * Diese Methode �berpr�ft ob die X- und Y-Koordinaten vom Kopf der Schlange mit
	 * jenen des Apfels bzw. wenn die Apfel-nach-Zeit Funktion aktiviert ist der
	 * �pfel �berenistimmt. Wenn dies der Fall ist wird die Schlange (je nach
	 * Spielmodus) um ZUWACHS bzw. um 3*ZUWACHS teile gr��er. Wenn man die
	 * Apfel-nach-Zeit Funktion nicht aktivert hat ruft Sie die Methode setzapfel
	 * auf. Au�erdem setzt diese Methoden wenn die Schlange einen Apfel gegessen hat
	 * einen neuen Hinderniss wenn die Hindernissfunktion aktiviert ist und der
	 * Hindernissmodus gleich 1 ist.
	 */
	public void checkapfel() {
		boolean apfelgetroffen = false;
		if (APFELNACHZEIT) {
			for (int i = 0; i < apfelindex; i++) {
				if (XY_pos[0][0] == aepfel[i][0] && XY_pos[0][1] == aepfel[i][1]) {
					if (aepfel[i][2] == 0)
						teile += ZUWACHS;
					if (aepfel[i][2] == 1)
						teile += 3 * ZUWACHS;
					aepfel[i][0] = -1;
					apfelgetroffen = true;
				}
			}
		} else {
			if (XY_pos[0][0] == aepfel[apfelindex][0] && XY_pos[0][1] == aepfel[apfelindex][1]) {
				if (aepfel[apfelindex][2] == 0)
					teile += ZUWACHS;
				if (aepfel[apfelindex][2] == 1)
					teile += 3 * ZUWACHS;
				setzapfel();
				apfelgetroffen = true;
			}
		}
		if (apfelgetroffen && HINDERNISSE && HINDERNISSMODUS != 0 && hindernisse[HINDERNISSEMAX - 1] == null) {
			Image[] hilfe = new Image[3];
			hilfe[0] = h1;
			hilfe[1] = h2;
			hilfe[2] = h3;
			int index = 0;
			for (int i = 0; i < HINDERNISSEMAX && hindernisse[i] != null; i++)
				index++;
			hindernisse[index] = Hinderniss.generiereHinderniss(hilfe);
			raster.sperre(hindernisse[index].getXposition(), hindernisse[index].getYposition());
		}
	}

	/**
	 * Diese Methode �berpr�ft ob die X- und Y-Koordinaten vom Kopf der Schlange mit
	 * jenen , wenn der Mausmodus aktiviert ist, der Maus �berenistimmt. Wenn dies
	 * der Fall ist wird die Schlange um 5*ZUWACHS gr��er und eine neue Maus wird
	 * generiert.
	 */
	private void checkmaus() {
		if (MAUS) {
			if (maus.checkgegessen(XY_pos[0][0], XY_pos[0][1])) {
				teile += 5 * ZUWACHS;
				maus = new Maus(BREITE - ICONENGROESSE, HOEHE - ICONENGROESSE);
			}
		}
	}

	/**
	 * Diese Methode �berpr�ft ob die X- und Y-Koordinaten vom Kopf mit den X- und
	 * Y-Koordinaten vom K�rper und vom Schwanz �bereinstimmen. Falls dies der Fall
	 * ist wird true zur�ckgeliefert, ansonsten false.
	 * 
	 * @return true wenn sich die Schlange selbst gebissen hat
	 */
	public boolean checkselbstgebissen() {
		boolean ret = false;
		for (int i = 3; i <= teile && !ret; i++) {
			if (XY_pos[0][0] == XY_pos[i][0] && XY_pos[0][1] == XY_pos[i][1])
				ret = true;
		}
		return ret;
	}

	/**
	 * Diese Methode �berpr�ft ob die X- und Y-Koordinaten vom Kopf �ber den den X-
	 * und Y-Koordinaten vom Rand hinausragen wenn der Spielmodus Spiegeln nicht
	 * aktiviert ist. Wenn er aktiv ist werden X- und Y-Koordinaten vom Kopf der
	 * Schlange am entgegengesetzten Bildrand gesetzt.
	 * 
	 * @return true wenn Kopf der Schlange �ber den Bildschrirm hinausragt und der
	 *         Spielmodus SPIEGELN deaktiviert ist
	 */
	public boolean checkrandgestossen() {
		boolean ret = false;
		if (SPIEGELN) {
			if (XY_pos[0][0] > BREITE)
				XY_pos[0][0] = 0;
			if (XY_pos[0][1] > HOEHE)
				XY_pos[0][1] = 0;
			if (XY_pos[0][0] < 0)
				XY_pos[0][0] = BREITE - ICONENGROESSE;
			if (XY_pos[0][1] < 0)
				XY_pos[0][1] = HOEHE - ICONENGROESSE;
		} else
			ret = XY_pos[0][0] > BREITE || XY_pos[0][1] > HOEHE || XY_pos[0][0] < 0 || XY_pos[0][1] < 0;
		return ret;
	}

	/**
	 * Diese Methode �berpr�ft ob die X- und Y-Koordinaten vom Kopf �ber den den X-
	 * und Y-Koordinaten von allen Hindernissen �bereinstimmen wenn die
	 * Hindernissfunktion aktiviert ist. Wenn die Hindernissfunktion nicht aktiviert
	 * ist oder die Schlange nicht mit einen Hinderniss zusammengesto�en ist liefert
	 * diese Methode false zur�ck,sonst true.
	 * 
	 * @return true wenn Kopf der Schlange mit einen Hinderniss zusammengestossen
	 *         ist false wenn Spielfunktion HINDERNISS deaktiviert ist,oder wenn
	 *         Kopf der Schlange mit keinen Hinderniss zusammengestossen ist
	 */
	public boolean checkhindernissgestossen() {
		boolean ret = false;
		if (HINDERNISSE) {
			for (int i = 0; i < HINDERNISSEMAX && hindernisse[i] != null && !ret; i++) {
				if (hindernisse[i].checkangestossen(XY_pos[0][0], XY_pos[0][1]))
					ret = true;
			}
		}
		return ret;
	}

	/**
	 * Diese Methode ruft die drei Methoden checkrandgestossen(),
	 * checkselbstgebissen() und checkhindernissgestossen() auf. Wenn mindestens
	 * eine der drei Methoden true zur�ckliefert, liefert diese Methode false
	 * zur�ck, ansonsten true.
	 * 
	 * @return false wenn mindestens eine Methode true zur�ckliefert
	 */
	public boolean spielgueltig() {
		return !(checkselbstgebissen() || checkrandgestossen() || checkhindernissgestossen());
	}

	/**
	 * Diese Methode bewegt die Schlange auf Koordinatenebene weiter. Die X- und
	 * Y-Koordinaten vom Kopf werden neu berechnet, der Rest der K�rperteile bekommt
	 * die X- und Y-Koordinaten vom folgenden K�rperteil. Au�erdem bewgt sie wenn
	 * der Mausmodus aktiviert ist die Maus weiter.
	 */
	public void bewege() {
		for (int i = teile; i > 0; i--) {
			XY_pos[i][0] = XY_pos[i - 1][0];
			XY_pos[i][1] = XY_pos[i - 1][1];
		}
		if (rechts) {
			XY_pos[0][0] = XY_pos[1][0] + ICONENGROESSE;
			XY_pos[0][1] = XY_pos[1][1];
		}
		if (links) {
			XY_pos[0][0] = XY_pos[1][0] - ICONENGROESSE;
			XY_pos[0][1] = XY_pos[1][1];
		}
		if (oben) {
			XY_pos[0][0] = XY_pos[1][0];
			XY_pos[0][1] = XY_pos[1][1] - ICONENGROESSE;
		}
		if (unten) {
			XY_pos[0][0] = XY_pos[1][0];
			XY_pos[0][1] = XY_pos[1][1] + ICONENGROESSE;
		}
	}

	/**
	 * Diese Methode bewegt die Maus, falls vorhanden, weiter.
	 */
	private void bewegemaus() {
		if (MAUS) {
			maus.bewege();
		}
	}

	/**
	 * Diese Methode setzt auf dem Spielfeld zuf�llig einen Apfel. Dabei sind die X-
	 * und Y-Koordinaten vom Apfel ungleich von jenen der gesamten K�rperteile der
	 * Schlange und jenen der, falls vorhanden, andaren �pfel und Hindernisse sein.
	 * Wenn nach 10000-mailgen Versuch immernoch keine g�ltige Koordinate gefunden
	 * wurde wird kein Apfel gesetzt.
	 */
	public void setzapfel() {
		boolean istfrei = false;
		int z = 0;
		while (!istfrei && z < 10000) {
			aepfel[apfelindex][0] = (int) (Math.random() * (BREITE / ICONENGROESSE)) * ICONENGROESSE;
			aepfel[apfelindex][1] = (int) (Math.random() * (HOEHE / ICONENGROESSE)) * ICONENGROESSE;
			istfrei = !raster.istbesetzt(aepfel[apfelindex][0], aepfel[apfelindex][1]);
			z++;
		}
		if (istfrei) {
			aepfel[apfelindex][2] = 0;
			if (GOLDAPFEL) {
				int h = (int) (Math.random() * GOLDAPFELWAHRSCHEINLICHKEIT);
				if (h == 0)
					h = 1;
				else
					h = 0;
				aepfel[apfelindex][2] = h;
			}
			raster.sperre(aepfel[apfelindex][0], aepfel[apfelindex][1]);
			if (APFELNACHZEIT)
				apfelindex++;
		}
	}

	/**
	 * Diese Paintmethode umfasst alle f�nf Unterpaintmethoden zeichnebeet(g),
	 * zeichneaepfel(g), zeichnehindernisse(g), zeichneschlange(g) und
	 * zeichnegameover(g). Wenn das Spiel g�ltig ist, werden die Methoden
	 * zeichneaepfel(g), zeichnemaus(g), und zeichneschlange(g) aufgerufen. Wenn
	 * nicht die zeichnegameover(g) Methode.
	 */
	public void paint(Graphics g) {
		super.paintComponent(g);
		if (spielgueltig()) {
			zeichnebeet(g);
			zeichneaepfel(g);
			zeichnehindernisse(g);
			zeichnemaus(g);
			zeichneschlange(g);
			Toolkit.getDefaultToolkit().sync();
		} else {
			zeichnegameover(g);
		}
	}

	/**
	 * Diese Unterpaintmethode zeichnet das Spielraster.
	 */
	private void zeichnebeet(Graphics g) {
		int hilfe = 0;
		for (int i = 0; i < BREITE / ICONENGROESSE; i++) {
			for (int j = 0; j < HOEHE / ICONENGROESSE; j++) {
				g.drawImage(beet[hilfe], i * ICONENGROESSE, j * ICONENGROESSE, this);
				hilfe++;
			}
		}
	}

	/**
	 * Diese Unterpaintmethode zeichnet alle momentan im Spielfeld vorhandene �pfel.
	 */
	public void zeichneaepfel(Graphics g) {
		for (int i = 0; i < apfelindex || !(APFELNACHZEIT || i > 0); i++) {
			if (aepfel[i][2] == 0 && aepfel[i][0] != -1)
				g.drawImage(apfel, aepfel[i][0], aepfel[i][1], this);
			if (aepfel[i][2] == 1 && aepfel[i][0] != -1)
				g.drawImage(goldapfel, aepfel[i][0], aepfel[i][1], this);
		}
	}

	/**
	 * Diese Unterpaintmethode zeichnet alle im Spielfeld vorhandene Hindernisse.
	 */
	private void zeichnehindernisse(Graphics g) {
		if (HINDERNISSE) {
			for (int i = 0; i < HINDERNISSEMAX && hindernisse[i] != null; i++)
				g.drawImage(hindernisse[i].getH(), hindernisse[i].getXposition(), hindernisse[i].getYposition(), this);
		}
	}

	/**
	 * Diese Unterpaintmethode zeichnet, wenn vorhanden, die Maus.
	 */
	private void zeichnemaus(Graphics g) {
		if (MAUS)
			g.drawImage(maus.getAktuellesbild(), maus.getXposition(), maus.getYposition(), this);
	}

	/**
	 * Diese Unterpaintmethode zeichnet die Schlange. Sie selbst ruft drei Methoden
	 * berechnekopf(),berechnek�rperteil() und berechneschwanz() auf, die lediglich
	 * zur Berechnung des aktuellen Bildes dienen.
	 */
	public void zeichneschlange(Graphics g) {
		richtungen[0] = zeichnenrichtung();
		berechnekopf();
		if (teile > 3) {
			for (int i = teile - 2; i > 1; i--)
				schlangebilder[i] = schlangebilder[i - 1];
		}
		berechnekoerperteil();
		berechneschwanz();
		for (int i = 0; i < teile; i++)
			g.drawImage(schlangebilder[i], XY_pos[i][0], XY_pos[i][1], null);
		verschieberichtungen();
	}

	/**
	 * Diese Methode verschiebt im Richtungsarray alle Richtungen um eins nach
	 * hinten.
	 */
	private void verschieberichtungen() {
		for (int i = teile - 2; i > 0; i--)
			richtungen[i] = richtungen[i - 1];
		richtungen[teile - 1] = richtungen[teile - 2];
	}

	/**
	 * Diese Methode berechnet welches Kopfbild gezeichnet werden soll.
	 */
	private void berechnekopf() {
		switch (richtungen[0]) {
		case ('l'): {
			schlangebilder[0] = kopflinks;
			break;
		}
		case ('r'): {
			schlangebilder[0] = kopfrechts;
			break;
		}
		case ('o'): {
			schlangebilder[0] = kopfoben;
			break;
		}
		case ('u'): {
			schlangebilder[0] = kopfunten;
			break;
		}
		}
	}

	/**
	 * Diese Methode berechnet welches erstes K�rperbild gezeichnet wird.
	 */
	private void berechnekoerperteil() {
		switch (richtungen[0]) {
		case ('l'): {
			switch (richtungen[1]) {
			case ('l'): {
				schlangebilder[1] = koerperlinks;
				break;
			}
			case ('o'): {
				schlangebilder[1] = kurvelinksoben;
				break;
			}
			case ('u'): {
				schlangebilder[1] = kurverechtsunten;
				break;
			}
			}
			break;
		}
		case ('r'): {
			switch (richtungen[1]) {
			case ('r'): {
				schlangebilder[1] = koerperrechts;
				break;
			}
			case ('o'): {
				schlangebilder[1] = kurverechtsoben;
				break;
			}
			case ('u'): {
				schlangebilder[1] = kurvelinksunten;
				break;
			}
			}
			break;
		}
		case ('o'): {
			switch (richtungen[1]) {
			case ('l'): {
				schlangebilder[1] = kurverechtslinks;
				break;
			}
			case ('r'): {
				schlangebilder[1] = kurvelinksrechts;
				break;
			}
			case ('o'): {
				schlangebilder[1] = koerperoben;
				break;
			}
			}
			break;
		}
		case ('u'): {
			switch (richtungen[1]) {
			case ('l'): {
				schlangebilder[1] = kurvelinkslinks;
				break;
			}
			case ('r'): {
				schlangebilder[1] = kurverechtsrechts;
				break;
			}
			case ('u'): {
				schlangebilder[1] = koerperunten;
				break;
			}
			}
			break;
		}
		}
	}

	/**
	 * Diese Methode berechnet welches Schwanzbild gezeichnet wird.
	 */
	private void berechneschwanz() {
		switch (richtungen[teile - 1]) {
		case ('l'): {
			schlangebilder[teile - 1] = schwanzlinks;
			break;
		}
		case ('r'): {
			schlangebilder[teile - 1] = schwanzrechts;
			break;
		}
		case ('o'): {
			schlangebilder[teile - 1] = schwanzoben;
			break;
		}
		case ('u'): {
			schlangebilder[teile - 1] = schwanzunten;
			break;
		}
		}
	}

	/**
	 * Diese Methode gibt je nach der aktuellen Richtung vom Kopf der Schlange einen
	 * verschiedenen Character zur�ck: 'l','r','o' oder 'u'.
	 * 
	 * @return aktuelle Richtung vom Kopf der Schlange
	 */
	public char zeichnenrichtung() {
		char ret = 'f';
		if (rechts)
			ret = 'l';
		if (links)
			ret = 'r';
		if (oben)
			ret = 'u';
		if (unten)
			ret = 'o';
		return ret;
	}

	/**
	 * Diese Unterpaintmethode zeichnet das Game-over-Fenster mit den im Spiel
	 * erreichten Punkten. Sie gibt au�erdem den ereichten Punktestand (wenn
	 * mindestens eine der drei Spielfunktionen Goldapfel, Apfelnachzeit oder
	 * Spiegeln aktiviert sind wird der Punktestand vor der �bergabe halbiert und
	 * eventuell abgerundet) der Top-10 Rangliste weiter.
	 * 
	 * @return aktuelle Richtung vom Kopf der Schlange
	 */
	public void zeichnegameover(Graphics g) {
		String resultat = "";
		for (int i = 0; i < Top_10_Fenster.zahlenanfangsstelle; i++) {
			if (i < nickname.length())
				resultat += nickname.charAt(i);
			else
				resultat += " ";
		}
		int wert = 0;
		if (Startfenster.goldapfel) {
			if (Startfenster.goldapfelwahrscheinlichkeit == 5)
				wert -= 10;
			if (Startfenster.goldapfelwahrscheinlichkeit == 3)
				wert -= 15;
			if (Startfenster.goldapfelwahrscheinlichkeit == 2)
				wert -= 20;
		}
		if (Startfenster.apfelnachzeit) {
			if (Startfenster.apfelintervall == 10000)
				wert -= 10;
			if (Startfenster.apfelintervall == 6000)
				wert -= 15;
			if (Startfenster.apfelintervall == 4000)
				wert -= 20;
		}
		if (Startfenster.hinderniss) {
			if (Startfenster.hindernissmodus == 0)
				wert += 30;
			if (Startfenster.hindernissmodus == 1)
				wert += 25;
		}
		if (Startfenster.spiegeln)
			wert -= 10;
		if (Startfenster.turbo)
			wert -= 10;
		if (Startfenster.maus)
			wert -= 10;
		resultat += String.valueOf((int) ((double) teile * (1D + wert)));
		Top_10_Fenster.reload_Rangliste(resultat);
		setBackground(Color.BLACK);
		String text = "Game Over!";
		String punkte = "Score: " + String.valueOf(teile);
		Font stil = new Font("Consolas", Font.BOLD, 50);
		Font stil2 = new Font("Consolas", Font.BOLD, 20);
		FontMetrics metr = getFontMetrics(stil);
		FontMetrics metr2 = getFontMetrics(stil2);
		g.setColor(Color.red);
		g.setFont(stil);
		g.drawString(text, (BREITE - metr.stringWidth(text)) / 2, HOEHE / 2);
		g.setFont(stil2);
		g.drawString(punkte, (BREITE - metr2.stringWidth(punkte)) / 2, HOEHE / 2 + metr2.getHeight() + 30);
	}

	/**
	 * Diese Methode ist f�r den Spielfluss verantwortlich und arbeitet mit der
	 * Klasse Tastatur zusammen.
	 */
	public void actionPerformed(ActionEvent e) {
		if (turbozaehler % TURBOINTERVALL == 0 || istTurbo) {
			if (spielgueltig()) {
				raster.sperre(XY_pos);
				raster.sperre(aepfel);
				for (int i = 0; HINDERNISSE && i < HINDERNISSEMAX && hindernisse[i] != null; i++)
					raster.sperre(hindernisse[i].getXposition(), hindernisse[i].getYposition());
				if (MAUS)
					raster.sperre(maus.getXposition(), maus.getYposition());
				if (APFELNACHZEIT) {
					if (APFELINTERVALL <= zeit) {
						setzapfel();
						zeit = 0;
					}
				}
				if (SPIEGELN)
					checkrandgestossen();
				checkapfel();
				checkmaus();
				if (turbozaehler % TURBOINTERVALL == 0)
					bewegemaus();
				bewege();
				Toolkit.getDefaultToolkit().sync();
				raster.entsperrealles();
				repaint();
			}
		}
		if (APFELNACHZEIT)
			zeit += BREMSE;
		turbozaehler++;
	}

	private class Tastatur extends KeyAdapter {
		/**
		 * Diese Klasse nimmt die Benutzereingaben �ber der Tastatur auf.
		 */

		/**
		 * Diese Methode �bergiebt dem Spiel welche der vier Feiltasten gedr�ckt bzw.
		 * nicht gedr�ckt sind.
		 */
		public void keyPressed(KeyEvent e) {
			int taste = e.getKeyCode();

			if ((taste == KeyEvent.VK_A) && (!rechts)||(taste == KeyEvent.VK_LEFT) && (!rechts)) {
				rechts = false;
				links = true;
				oben = false;
				unten = false;
			}

			if ((taste == KeyEvent.VK_D) && (!links)||(taste == KeyEvent.VK_RIGHT) && (!links)) {
				rechts = true;
				links = false;
				oben = false;
				unten = false;
			}

			if ((taste == KeyEvent.VK_W) && (!unten)||(taste == KeyEvent.VK_UP) && (!unten)) {
				rechts = false;
				links = false;
				oben = true;
				unten = false;
			}

			if ((taste == KeyEvent.VK_S) && (!oben)||(taste == KeyEvent.VK_DOWN) && (!oben)) {
				rechts = false;
				links = false;
				oben = false;
				unten = true;
			}

			if (TURBO) {
				if (taste == KeyEvent.VK_SPACE) {
					istTurbo = !istTurbo;
				}
			}
		}
	}
}