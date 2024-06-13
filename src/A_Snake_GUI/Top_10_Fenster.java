package A_Snake_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

/**
 * Gibt die besten 10 Spieler aus.
 */
public class Top_10_Fenster extends JDialog {
	
	private static String top1;
	private static String top2;
	private static String top3;
	private static String top4;
	private static String top5;
	private static String top6;
	private static String top7;
	private static String top8;
	private static String top9;
	private static String top10;
	private static final String ranglistequelle = "/Users/domsim/Developing/Java/Games/Snake_Projekt/src/Rangliste/rangliste.txt";
	public static final int zahlenanfangsstelle = 33;
	private JPanel contentPane;

	/**
	 * Startet das Top_10_Fenster.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Top_10_Fenster frame = new Top_10_Fenster();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Instanziiert das Top_10_Fenster.
	 */
	public Top_10_Fenster() {
		loadtop10();
		setType(Type.UTILITY);
		setTitle("Top 10");
		setResizable(false);
		setBounds(100, 100, 494, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblTopSnake = new JLabel("Top 10 Snake games");
		lblTopSnake.setIcon(
				new ImageIcon("/Users/domsim/Developing/Java/Games/Snake_Projekt/src/Bilder/Schlange/gruen/kopfoben.png"));
		lblTopSnake.setFont(new Font("Consolas", Font.PLAIN, 26));

		JLabel lblNickname = new JLabel("Nickname                     Score (apples)");
		lblNickname.setFont(new Font("Consolas", Font.PLAIN, 16));

		JLabel label = new JLabel("");

		JLabel lblNewLabel = new JLabel(top1);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 14));

		JLabel label_1 = new JLabel(top2);
		label_1.setFont(new Font("Consolas", Font.PLAIN, 14));

		JLabel label_2 = new JLabel(top3);
		label_2.setFont(new Font("Consolas", Font.PLAIN, 14));

		JLabel label_3 = new JLabel(top4);
		label_3.setFont(new Font("Consolas", Font.PLAIN, 14));

		JLabel label_4 = new JLabel(top5);
		label_4.setFont(new Font("Consolas", Font.PLAIN, 14));

		JLabel label_5 = new JLabel(top6);
		label_5.setFont(new Font("Consolas", Font.PLAIN, 14));

		JLabel label_6 = new JLabel(top7);
		label_6.setFont(new Font("Consolas", Font.PLAIN, 14));

		JLabel label_7 = new JLabel(top8);
		label_7.setFont(new Font("Consolas", Font.PLAIN, 14));

		JLabel label_8 = new JLabel(top9);
		label_8.setFont(new Font("Consolas", Font.PLAIN, 14));

		JLabel label_9 = new JLabel(top10);
		label_9.setFont(new Font("Consolas", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(92).addComponent(lblTopSnake))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(45).addComponent(label).addGap(11)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 342,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 342,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel)
										.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 342,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 342,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 342,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 342,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 342,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 342,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 342,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNickname))))
				.addContainerGap(46, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(41).addComponent(lblTopSnake)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(74).addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(29).addComponent(lblNickname).addGap(38)
								.addComponent(lblNewLabel).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(47, Short.MAX_VALUE)));
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] { lblNickname, lblNewLabel, label_1, label_2,
				label_3, label_4, label_5, label_6, label_7, label_8, label_9 });
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] { lblNickname, lblNewLabel, label_1, label_2,
				label_3, label_4, label_5, label_6, label_7, label_8, label_9 });
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * Ladet die Top-10 Spieler aus einen Textdokument in der GUI.
	 */
	private static void loadtop10() {
		String[] h = new String[10];
		try {
			BufferedReader reader = new BufferedReader(new FileReader(ranglistequelle));
			for (int i = 0; i < 10; i++)
				h[i] = reader.readLine();
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Datei konnte nicht gefunden werden");
		} catch (IOException e) {
			System.out.println("Datei konnte nicht gelesen werden");
		}
		for (int i = 0; i < 10; i++) {
			if (h[i].length() <= 2)
				setzerangliste(i, "-----not avaiable yet-----");
			else
				setzerangliste(i, h[i]);
		}
		String s = "";
		for (int i = 0; i < zahlenanfangsstelle; i++)
			s += " ";
		s += "0";
	}

	/**
	 * Gibt die Rangliste aus.
	 */
	private static void setzerangliste(int s, String text) {
		switch (s) {
		case (0): {
			top1 = text;
			break;
		}
		case (1): {
			top2 = text;
			break;
		}
		case (2): {
			top3 = text;
			break;
		}
		case (3): {
			top4 = text;
			break;
		}
		case (4): {
			top5 = text;
			break;
		}
		case (5): {
			top6 = text;
			break;
		}
		case (6): {
			top7 = text;
			break;
		}
		case (7): {
			top8 = text;
			break;
		}
		case (8): {
			top9 = text;
			break;
		}
		case (9):
			top10 = text;
		}
	}

	/**
	 * Sortiert die Rangliste mit den �bergebenen Parameter neu ein.
	 * 
	 * @param s
	 *            neuer zu sortierender Punktestand.
	 */
	public static void reload_Rangliste(String s) {
		loadtop10();
		String[] h = new String[11];
		h[0] = top1;
		h[1] = top2;
		h[2] = top3;
		h[3] = top4;
		h[4] = top5;
		h[5] = top6;
		h[6] = top7;
		h[7] = top8;
		h[8] = top9;
		h[9] = top10;
		h[10] = s;
		for (int i = 0; i < 11; i++) {
			for (int j = i; j > 0; j--) {
				if (getscore(h[j]) > getscore(h[j - 1])) {
					String h2 = h[j - 1];
					h[j - 1] = h[j];
					h[j] = h2;
				} else
					j = 0;
			}
		}
		for (int i = 0; i < 10; i++)
			setzerangliste(i, h[i]);
		writeback(h);
	}

	/**
	 * Gibt den int-Wert des Punktestandes vom �bergebenen Spielerdate n zur�ck.
	 * 
	 * @param s
	 *            Spielerdaten
	 * @return Punkte im int-Format
	 */
	private static int getscore(String s) {
		int ret = 0;
		if (s.length() > zahlenanfangsstelle && s.charAt(0) != '-')
			ret = Integer.valueOf(s.substring(zahlenanfangsstelle));
		return ret;
	}

	/**
	 * Ladet die Rangliste in einem Textdokument.
	 * 
	 * @param h
	 *            Rangliste
	 */
	private static void writeback(String h[]) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(ranglistequelle));
			for (int i = 0; i < 10; i++) {
				if (h[i].charAt(0) == '-')
					writer.write("0");
				else
					writer.write(h[i]);
				writer.newLine();
			}
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Datei konnte nicht gefunden werden");
		} catch (IOException e) {
			System.out.println("Datei konnte nicht gelesen werden");
		}
	}
}