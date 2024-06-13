package A_Snake_Spiel;

/**
 * Skinobjektbauplan welches den Verzeichnispfad der Bilder und die ganzen Pfade der
 * folgenden Bilder vom Skin hat:kopfrechts, kopflinks, kopfunten, kopfoben,
 * koerperrechts, koerperlinks, koerperunten, koerperoben, schwanzrechts,
 * schwanzlinks, schwanzoben, schwanzunten, kurverechtsrechts, kurverechtslinks,
 * kurverechtsunten, kurverechtsoben, kurvelinksrechts, kurvelinkslinks,
 * kurvelinksunten und kurvelinksoben.
 */

class Skin {
	
	private String verzeichnispfad;
	private String kopfrechts;
	private String kopflinks;
	private String kopfunten;
	private String kopfoben;
	private String koerperrechts;
	private String koerperlinks;
	private String koerperunten;
	private String koerperoben;
	private String schwanzrechts;
	private String schwanzlinks;
	private String schwanzoben;
	private String schwanzunten;
	private String kurverechtsrechts;
	private String kurverechtslinks;
	private String kurverechtsunten;
	private String kurverechtsoben;
	private String kurvelinksrechts;
	private String kurvelinkslinks;
	private String kurvelinksunten;
	private String kurvelinksoben;

	/**
	 * Konstruktor erstell ein neues Skinobjekt, welches als Grundpfad den
	 * Verzeichnispfad hat.
	 */
	public Skin(String verzeichnispfad) {
		this.setVerzeichnispfad(verzeichnispfad);
		String f = ".png";
		String r = "rechts" + f;
		String l = "links" + f;
		String o = "oben" + f;
		String u = "unten" + f;
		this.kopfrechts = verzeichnispfad + "kopf" + r;
		this.kopflinks = verzeichnispfad + "kopf" + l;
		this.kopfunten = verzeichnispfad + "kopf" + u;
		this.kopfoben = verzeichnispfad + "kopf" + o;
		this.koerperrechts = verzeichnispfad + "körper" + r;
		this.koerperlinks = verzeichnispfad + "körper" + l;
		this.koerperunten = verzeichnispfad + "körper" + u;
		this.koerperoben = verzeichnispfad + "körper" + o;
		this.schwanzrechts = verzeichnispfad + "schwanz" + r;
		this.schwanzlinks = verzeichnispfad + "schwanz" + l;
		this.schwanzunten = verzeichnispfad + "schwanz" + u;
		this.schwanzoben = verzeichnispfad + "schwanz" + o;
		this.kurverechtsrechts = verzeichnispfad + "kurverechts" + r;
		this.kurverechtslinks = verzeichnispfad + "kurverechts" + l;
		this.kurverechtsunten = verzeichnispfad + "kurverechts" + u;
		this.kurverechtsoben = verzeichnispfad + "kurverechts" + o;
		this.kurvelinksrechts = verzeichnispfad + "kurvelinks" + r;
		this.kurvelinkslinks = verzeichnispfad + "kurvelinks" + l;
		this.kurvelinksunten = verzeichnispfad + "kurvelinks" + u;
		this.kurvelinksoben = verzeichnispfad + "kurvelinks" + o;
	}

	/**
	 * Gibt die Variable kopfrechts zur�ck.
	 *
	 * @return kopfrechts
	 */
	public String getKopfrechts() {
		return kopfrechts;
	}

	/**
	 * Gibt die Variable kopflinks zur�ck.
	 *
	 * @return kopflinks
	 */
	public String getKopflinks() {
		return kopflinks;
	}

	/**
	 * Gibt die Variable kopfunten zur�ck.
	 *
	 * @return kopfunten
	 */
	public String getKopfunten() {
		return kopfunten;
	}

	/**
	 * Gibt die Variable kopfoben zur�ck.
	 *
	 * @return kopfoben
	 */
	public String getKopfoben() {
		return kopfoben;
	}

	/**
	 * Gibt die Variable koerperrechts zur�ck.
	 *
	 * @return koerperrechts
	 */
	public String getKoerperrechts() {
		return koerperrechts;
	}

	/**
	 * Gibt die Variable koerperlinks zur�ck.
	 *
	 * @return koerperlinks
	 */
	public String getKoerperlinks() {
		return koerperlinks;
	}

	/**
	 * Gibt die Variable koerperunten zur�ck.
	 *
	 * @return koerperunten
	 */
	public String getKoerperunten() {
		return koerperunten;
	}

	/**
	 * Gibt die Variable koerperoben zur�ck.
	 *
	 * @return koerperoben
	 */
	public String getKoerperoben() {
		return koerperoben;
	}

	/**
	 * Gibt die Variable schwanzrechts zur�ck.
	 *
	 * @return schwanzrechts
	 */
	public String getSchwanzrechts() {
		return schwanzrechts;
	}

	/**
	 * Gibt die Variable schwanzlinks zur�ck.
	 *
	 * @return schwanzlinks
	 */
	public String getSchwanzlinks() {
		return schwanzlinks;
	}

	/**
	 * Gibt die Variable schwanzoben zur�ck.
	 *
	 * @return schwanzoben
	 */
	public String getSchwanzoben() {
		return schwanzoben;
	}

	/**
	 * Gibt die Variable schwanzunten zur�ck.
	 *
	 * @return schwanzunten
	 */
	public String getSchwanzunten() {
		return schwanzunten;
	}

	/**
	 * Gibt die Variable kurverechtsrechts zur�ck.
	 *
	 * @return kurverechtsrechts
	 */
	public String getKurverechtsrechts() {
		return kurverechtsrechts;
	}

	/**
	 * Gibt die Variable kurverechtslinks zur�ck.
	 *
	 * @return kurverechtslinks
	 */
	public String getKurverechtslinks() {
		return kurverechtslinks;
	}

	/**
	 * Gibt die Variable kurverechtsunten zur�ck.
	 *
	 * @return kurverechtsunten
	 */
	public String getKurverechtsunten() {
		return kurverechtsunten;
	}

	/**
	 * Gibt die Variable kurverechtsoben zur�ck.
	 *
	 * @return kurverechtsoben
	 */
	public String getKurverechtsoben() {
		return kurverechtsoben;
	}

	/**
	 * Gibt die Variable kurvelinksrechts zur�ck.
	 *
	 * @return kurvelinksrechts
	 */
	public String getKurvelinksrechts() {
		return kurvelinksrechts;
	}

	/**
	 * Gibt die Variable kurvelinkslinks zur�ck.
	 *
	 * @return kurvelinkslinks
	 */
	public String getKurvelinkslinks() {
		return kurvelinkslinks;
	}

	/**
	 * Gibt die Variable kurvelinksunten zur�ck.
	 *
	 * @return kurvelinksunten
	 */
	public String getKurvelinksunten() {
		return kurvelinksunten;
	}

	/**
	 * Gibt die Variable kurvelinksoben zur�ck.
	 *
	 * @return kurvelinksoben
	 */
	public String getKurvelinksoben() {
		return kurvelinksoben;
	}

	/**
	 * Gibt die Variable verzeichnispfad zur�ck.
	 *
	 * @return verzeichnispfad
	 */
	public String getVerzeichnispfad() {
		return verzeichnispfad;
	}

	/**
	 * Setzt den Verzeichnispfad verzeichnispfad. Dabei muss der �bergeben Parameter
	 * ungleich null sein und mindestens 1 Zeichen enthalten,ansonsten wird der alte
	 * Wert der Variable verzeichnispfad behalten und der neue Wert wird nicht
	 * gesetzt.
	 *
	 * @param verzeichnispfad
	 *            Variable verzeichnispfad die gesetzt wird
	 */
	public void setVerzeichnispfad(String verzeichnispfad) {
		if (verzeichnispfad != null && !verzeichnispfad.isEmpty())
			this.verzeichnispfad = verzeichnispfad;
	}

	/**
	 * Setzt in einen Skin-Array die Skinns die in dem String text �bergeben werden.
	 * Die einzelnen Skins sind dabei von einen Zeichen trenner voneinander
	 * getrennt. Es k�nnen maximal 100 Skins �bergeben werden. Die Variable text
	 * muss ungleich null sein, und mindestens ein Zeichen enthalten.
	 *
	 * @param text
	 *            Text in welchem die Skins vorhanden sind
	 * @param trenner
	 *            Trennzeichen um Skins in Text zu unterscheiden
	 */
	public static Skin loadSkins(String text, char trenner, int skinnr) {
		Skin ret;
		String hilfe = "";
		int z = 0;
		if (text != null && !text.isEmpty()) {
			for (int i = 0; i < text.length() && z <= skinnr; i++) {
				if (z == skinnr) {
					for (int j = 0; (i + j) < text.length() && text.charAt(i + j) != trenner; j++)
						hilfe += text.charAt(i + j);
					i = text.length() - 1;
				}
				if (text.charAt(i) == trenner)
					z++;
			}
		}
		System.out.println(hilfe);
		ret = new Skin(hilfe + "/");
		return ret;
	}
}