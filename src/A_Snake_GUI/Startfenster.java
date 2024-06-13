package A_Snake_GUI;
import java.awt.BorderLayout;


/**
 * Hauptfenster der GUI, �bergibt die Parameter an einem neuen Spiel.
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Window.Type;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import A_Snake_Spiel.Startspiel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Canvas;
import javax.swing.JTextField;

public class Startfenster extends JFrame {

	private JPanel contentPane;
	public static boolean goldapfel = false;
	public static int goldapfelwahrscheinlichkeit = 10;
	public static boolean apfelnachzeit = false;
	public static int apfelintervall = 30;
	public static boolean spiegeln = false;
	public static boolean turbo = false;
	public static boolean hinderniss = false;
	public static int hindernissmodus = 0;
	public static boolean maus = false;
	public static int skinnr = 0;
	public static JTextField txtNickname;

	/**
	 * Startet das Hauptfenster.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Startfenster hauptfenster = new Startfenster();
					hauptfenster.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Instanziiert ein neues Startfenster.
	 */
	public Startfenster() {
		setType(Type.UTILITY);
		setEnabled(true);
		setResizable(false);
		setTitle("Snake                                                 			 by Simone Domenici");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("classic game");
		btnNewButton.setIcon(new ImageIcon("/Users/domsim/Developing/Java/Games/Snake_Projekt/src/Bilder/Apfel/apfel.png"));
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 23));
		btnNewButton.setToolTipText("Your points will have the value of 100% in the Top-10 list.");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startspiel s = new Startspiel(txtNickname.getText(), false, 0, false, 0, false, false, false, 0, false,
						Startfenster.skinnr);
				s.setModal(true);
				s.setVisible(true);
			}
		});

		JLabel lblSnake = new JLabel("Snake");
		lblSnake.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblSnake.setFont(new Font("Consolas", Font.PLAIN, 38));
		lblSnake.setLabelFor(this);
		lblSnake.setForeground(Color.RED);
		lblSnake.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnake.setBackground(Color.RED);
		lblSnake.setIcon(
				new ImageIcon("/Users/domsim/Developing/Java/Games/Snake_Projekt/src/Bilder/Schlange/gruen/kopflinks.png"));

		JButton btnPersonableGame = new JButton("personable game");
		btnPersonableGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personable_game_Fenster a = new Personable_game_Fenster();
				a.setModal(true);
				a.setVisible(true);
			}
		});
		btnPersonableGame
				.setIcon(new ImageIcon("/Users/domsim/Developing/Java/Games/Snake_Projekt/src/Bilder/Apfel/goldapfel.png"));
		btnPersonableGame.setFont(new Font("Consolas", Font.PLAIN, 23));
		btnPersonableGame.setToolTipText("Your points will have the value of 50% in the Top-10 list.");

		JButton btnSelectSkin = new JButton("select skin");
		btnSelectSkin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Skinfenster a = new Skinfenster();
				a.setModal(true);
				a.setVisible(true);
			}
		});
		btnSelectSkin.setIcon(
				new ImageIcon("/Users/domsim/Developing/Java/Games/Snake_Projekt/src/Bilder/Schlange/gruen/kopflinks.png"));
		btnSelectSkin.setFont(new Font("Consolas", Font.PLAIN, 23));

		JButton btnTop = new JButton("top 10 ");
		btnTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Top_10_Fenster a = new Top_10_Fenster();
				a.setModal(true);
				a.setVisible(true);
			}
		});
		btnTop.setFont(new Font("Consolas", Font.PLAIN, 23));

		JButton btnHelp = new JButton("help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hilfefenster a = new Hilfefenster();
				a.setModal(true);
				a.setVisible(true);
			}
		});
		btnHelp.setFont(new Font("Consolas", Font.PLAIN, 23));

		txtNickname = new JTextField();
		txtNickname.setText("Player one");
		txtNickname.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtNickname.setColumns(10);

		JLabel lblGiveInYour = new JLabel("write in your nickname:");
		lblGiveInYour.setFont(new Font("Consolas", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnTop, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSelectSkin, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPersonableGame, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHelp, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE))
				.addGap(100))
				.addGroup(
						gl_contentPane.createSequentialGroup().addContainerGap()
								.addComponent(lblGiveInYour, GroupLayout.PREFERRED_SIZE, 211,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(250, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(txtNickname, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(250, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(72)
						.addComponent(lblSnake, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(74, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(lblSnake, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(btnNewButton).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnPersonableGame, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnSelectSkin, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnTop, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE).addComponent(lblGiveInYour)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtNickname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(28).addComponent(btnHelp, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addGap(32)));
		gl_contentPane.linkSize(SwingConstants.VERTICAL,
				new Component[] { btnNewButton, btnPersonableGame, btnSelectSkin, btnTop, btnHelp });
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] { txtNickname, lblGiveInYour });
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL,
				new Component[] { btnNewButton, btnPersonableGame, btnSelectSkin, btnTop, btnHelp });
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] { txtNickname, lblGiveInYour });
		contentPane.setLayout(gl_contentPane);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { btnNewButton, lblSnake }));
	}
}
