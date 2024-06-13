package A_Snake_Spiel;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
/**
 * Diese Klasse ist f�r das Startet ein neues Snake-Spiels mit den im
 * Konstruktor �bergebenen Parameter und der H�he und Breite, die das Fenster
 * haben soll. Sie stellt auch die Gettermethoden f�r die H�he und die Breite
 * zur Verf�gung.
 */
public class Startspiel extends JDialog {

	private static final int HOEHE = 720;
	private static final int BREITE = 1200;

	/**
	 * Startet ein neues Snake-Spiel mit den �bergebenen Parameter mit einer Gr��e
	 * von Breite mal Hoehe.
	 * 
	 * @param nickname
	 *            Nickname vom Spieler
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
	public Startspiel(String nickname, boolean goldapfel, int goldapfelwahrscheinlichkeit, boolean apfelnachzeit,
			int apfelintervall, boolean spiegeln, boolean turbo, boolean hindernisse, int hindernissmodus, boolean maus,
			int skinnr) {
		add(new Spiel(nickname, HOEHE, BREITE, goldapfel, goldapfelwahrscheinlichkeit, apfelnachzeit, apfelintervall,
				spiegeln, turbo, hindernisse, hindernissmodus, maus, skinnr));
		setResizable(false);
		pack();
		setTitle("Snake");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	/**
	 * Gibt die Variable HOEHE zur�ck.
	 *
	 * @return HOEHE
	 */
	public static int getHoehe() {
		return HOEHE;
	}

	/**
	 * Gibt die Variable BREITE zur�ck.
	 *
	 * @return BREITE
	 */
	public static int getBreite() {
		return BREITE;
	}

	/**
	 * Zu testzwecken verwendete main-Methode. Im richtigen Snake-Spiel wird sie
	 * nicht verwendet.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(() -> {
//			JDialog s = new Startspiel("test", true, 2, true, 0, false, false, false, 0, false, 2);
//			s.setVisible(true);
//		});
//	}
}
