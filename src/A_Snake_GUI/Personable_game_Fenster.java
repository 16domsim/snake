package A_Snake_GUI;

import java.awt.BorderLayout;


/**
 * Benutzer kann hier zwischen verschiedenen Spielmodi w�hlen und ein neues Spiel starten. 
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;


import A_Snake_Spiel.Startspiel;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Personable_game_Fenster extends JDialog {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JLabel punktewerttext;

	/**
	 *  Startet das Personable_game_Fenster.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Personable_game_Fenster frame = new Personable_game_Fenster();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	/**
	 * Instanziiert ein neues Personable_game_Fenster.
	 */
	public Personable_game_Fenster() {
		setTitle("Personable game options");
		setType(Type.UTILITY);
		setBounds(100, 100, 772, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Startfenster.apfelintervall = 10000;
		Startfenster.goldapfelwahrscheinlichkeit = 5;

		JLabel lblSelectYourGame = new JLabel("Select your game options");
		lblSelectYourGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectYourGame.setFont(new Font("Consolas", Font.PLAIN, 26));

		punktewerttext = new JLabel("Point value:");
		punktewerttext.setFont(new Font("Consolas", Font.PLAIN, 16));

		JCheckBox chckbxGoldapple = new JCheckBox("goldapple");
		chckbxGoldapple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startfenster.goldapfel = !Startfenster.goldapfel;
				displaypuktewert();
			}
		});
		chckbxGoldapple.setFont(new Font("Consolas", Font.PLAIN, 20));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/domsim/Developing/Java/Games/Snake_Projekt/src/Bilder/Apfel/goldapfel.png"));

		JLabel label = new JLabel("");

		JCheckBox chckbxAppleAfterTime = new JCheckBox("apple-time function");
		chckbxAppleAfterTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startfenster.apfelnachzeit = !Startfenster.apfelnachzeit;
				displaypuktewert();
			}
		});
		chckbxAppleAfterTime.setFont(new Font("Consolas", Font.PLAIN, 20));

		JRadioButton radioButton = new JRadioButton("1/5");
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startfenster.goldapfelwahrscheinlichkeit = 5;
				displaypuktewert();
			}
		});
		radioButton.setSelected(true);
		buttonGroup.add(radioButton);
		radioButton.setFont(new Font("Consolas", Font.PLAIN, 16));

		JRadioButton radioButton_1 = new JRadioButton("1/3");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startfenster.goldapfelwahrscheinlichkeit = 3;
				displaypuktewert();
			}
		});
		buttonGroup.add(radioButton_1);
		radioButton_1.setFont(new Font("Consolas", Font.PLAIN, 16));

		JRadioButton radioButton_2 = new JRadioButton("1/2");
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startfenster.goldapfelwahrscheinlichkeit = 2;
				displaypuktewert();
			}
		});
		buttonGroup.add(radioButton_2);
		radioButton_2.setFont(new Font("Consolas", Font.PLAIN, 16));

		JRadioButton rdbtns = new JRadioButton("10s");
		rdbtns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startfenster.apfelintervall = 10000;
				displaypuktewert();
			}
		});
		buttonGroup_1.add(rdbtns);
		rdbtns.setFont(new Font("Consolas", Font.PLAIN, 18));
		rdbtns.setSelected(true);

		JRadioButton rdbtns_1 = new JRadioButton("6s");
		rdbtns_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startfenster.apfelintervall = 6000;
				displaypuktewert();
			}
		});
		buttonGroup_1.add(rdbtns_1);
		rdbtns_1.setFont(new Font("Consolas", Font.PLAIN, 18));

		JRadioButton rdbtns_2 = new JRadioButton("4s");
		rdbtns_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startfenster.apfelintervall = 4000;
				displaypuktewert();
			}
		});
		buttonGroup_1.add(rdbtns_2);
		rdbtns_2.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton btnLetsStart = new JButton("Let's start");
		btnLetsStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Startspiel s = new Startspiel(Startfenster.txtNickname.getText(), Startfenster.goldapfel,
						Startfenster.goldapfelwahrscheinlichkeit, Startfenster.apfelnachzeit,
						Startfenster.apfelintervall, Startfenster.spiegeln, Startfenster.turbo, Startfenster.hinderniss,
						Startfenster.hindernissmodus, Startfenster.maus, Startfenster.skinnr);
				s.setModal(true);
				s.setVisible(true);
			}
		});
		btnLetsStart.setFont(new Font("Consolas", Font.PLAIN, 20));
		btnLetsStart.setIcon(
				new ImageIcon("/Users/domsim/Developing/Java/Games/Snake_Projekt/src/Bilder/Schlange/gruen/kopflinks.png"));

		JCheckBox chckbxTurbo = new JCheckBox("turbosnake");
		chckbxTurbo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startfenster.turbo = !Startfenster.turbo;
				displaypuktewert();
			}
		});
		chckbxTurbo.setFont(new Font("Consolas", Font.PLAIN, 20));

		JCheckBox chckbxBstacles = new JCheckBox("obstacles");
		chckbxBstacles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startfenster.hinderniss = !Startfenster.hinderniss;
				displaypuktewert();
			}
		});
		chckbxBstacles.setFont(new Font("Consolas", Font.PLAIN, 20));

		JRadioButton rdbtnNewRadioButton = new JRadioButton("20 obstacles at beginning map");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startfenster.hindernissmodus = 0;
				displaypuktewert();
			}
		});
		rdbtnNewRadioButton.setSelected(true);
		buttonGroup_2.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Consolas", Font.PLAIN, 16));

		JRadioButton rdbtnAddObsatcleEvry = new JRadioButton("add obsatcle every apple eat (max 20)");
		rdbtnAddObsatcleEvry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startfenster.hindernissmodus = 1;
				displaypuktewert();
			}
		});
		buttonGroup_2.add(rdbtnAddObsatcleEvry);
		rdbtnAddObsatcleEvry.setFont(new Font("Consolas", Font.PLAIN, 16));

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("/Users/domsim/Developing/Java/Games/Snake_Projekt/src/Bilder/Hindernisse/h1.png"));

		JCheckBox chckbxMouse = new JCheckBox("mouse");
		chckbxMouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startfenster.maus = !Startfenster.maus;
				displaypuktewert();
			}
		});
		chckbxMouse.setFont(new Font("Consolas", Font.PLAIN, 20));

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("/Users/domsim/Developing/Java/Games/Snake_Projekt/src/Bilder/Maus/mauslinks.png"));

		JLabel lblNewLabel_1 = new JLabel("-10%");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 14));

		JLabel label_3 = new JLabel("-15%");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Consolas", Font.PLAIN, 14));

		JLabel label_4 = new JLabel("-20%");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Consolas", Font.PLAIN, 14));

		JLabel label_5 = new JLabel("+30%");
		label_5.setForeground(new Color(34, 139, 34));
		label_5.setFont(new Font("Consolas", Font.PLAIN, 14));

		JLabel label_6 = new JLabel("+25%");
		label_6.setForeground(new Color(34, 139, 34));
		label_6.setFont(new Font("Consolas", Font.PLAIN, 14));

		JLabel label_7 = new JLabel("-10%");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Consolas", Font.PLAIN, 14));

		JLabel label_8 = new JLabel("-15%");
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Consolas", Font.PLAIN, 14));

		JLabel label_9 = new JLabel("-20%");
		label_9.setForeground(Color.RED);
		label_9.setFont(new Font("Consolas", Font.PLAIN, 14));

		JLabel label_11 = new JLabel("-10%");
		label_11.setForeground(Color.RED);
		label_11.setFont(new Font("Consolas", Font.PLAIN, 14));

		JLabel label_12 = new JLabel("-10%");
		label_12.setForeground(Color.RED);
		label_12.setFont(new Font("Consolas", Font.PLAIN, 14));

		displaypuktewert();

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(338)
					.addComponent(chckbxBstacles, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(216))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(punktewerttext, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
							.addComponent(btnLetsStart, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
							.addGap(194))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(170)
											.addComponent(label))
										.addComponent(chckbxAppleAfterTime, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(chckbxGoldapple, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblNewLabel))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(radioButton)
											.addGap(57)
											.addComponent(lblNewLabel_1))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(radioButton_2, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addGap(57)
									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(radioButton_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addGap(57)
									.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(8)
											.addComponent(rdbtns))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addContainerGap()
											.addComponent(rdbtns_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addContainerGap()
											.addComponent(rdbtns_2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
									.addGap(39)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(label_7, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
										.addComponent(label_8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(label_9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							.addGap(85)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(chckbxMouse, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addComponent(chckbxTurbo, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnNewRadioButton)
								.addComponent(rdbtnAddObsatcleEvry))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(label_11, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
							.addComponent(label_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(label_12, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
					.addGap(129))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(138)
					.addComponent(lblSelectYourGame, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(287, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSelectYourGame, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(chckbxTurbo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(chckbxGoldapple)
										.addComponent(lblNewLabel)))))
						.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(radioButton)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(6)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(radioButton_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(6)
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(radioButton_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxBstacles, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnNewRadioButton)
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))))
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(chckbxAppleAfterTime, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtns)
								.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtns_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(6)
									.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(rdbtnAddObsatcleEvry, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addGap(45)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
										.addComponent(chckbxMouse, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))))))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtns_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnLetsStart)
						.addComponent(punktewerttext))
					.addContainerGap())
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {chckbxGoldapple, lblNewLabel});
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {radioButton, radioButton_1, radioButton_2});
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {radioButton, radioButton_1, radioButton_2});
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * Zeigt den aktuellen Punktewert an.
	 */
	private void displaypuktewert() {
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
		punktewerttext.setText("Point value: " + String.valueOf(wert) + "%");
		if (wert >= 0)
			punktewerttext.setForeground(Color.green);
		else
			punktewerttext.setForeground(Color.red);
	}
}
