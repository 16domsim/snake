package A_Snake_GUI;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

/**
 * Benutzer kann seinen Skin hier ausw�hlen.
 */
public class Skinfenster extends JDialog {
	
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static Skinfenster frame;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Startet das Skinfenster.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					frame = new Skinfenster();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Instanzieert das Skinfenster.
	 */
	public Skinfenster() {
		setType(Type.UTILITY);
		setTitle("Skin");
		setBounds(100, 100, 449, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblSelectYourSkin = new JLabel("Select your Skin");
		lblSelectYourSkin
				.setIcon(new ImageIcon("/Users/domsim/Developing/Java/Games/Snake_Projekt/src/Bilder/Schlange/schlange.png"));
		lblSelectYourSkin.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectYourSkin.setFont(new Font("Consolas", Font.PLAIN, 26));

		JRadioButton rdbtnGreen = new JRadioButton("green");
		buttonGroup.add(rdbtnGreen);
		rdbtnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startfenster.skinnr = 0;
			}
		});
		rdbtnGreen.setSelected(true);
		rdbtnGreen.setFont(new Font("Consolas", Font.PLAIN, 20));

		JRadioButton rdbtnBlack = new JRadioButton("black");
		buttonGroup.add(rdbtnBlack);
		rdbtnBlack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startfenster.skinnr = 1;
			}
		});
		rdbtnBlack.setFont(new Font("Consolas", Font.PLAIN, 20));

		JLabel label = new JLabel("");

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon("/Users/domsim/Developing/Java/Games/Snake_Projekt/src/Bilder/Schlange/gruen/kopflinks.png"));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(
				new ImageIcon("/Users/domsim/Developing/Java/Games/Snake_Projekt/src/Bilder/Schlange/schwarz/kopflinks.png"));

		JLabel label_1 = new JLabel("");

		JRadioButton rdbtnBlue = new JRadioButton("blue");
		rdbtnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startfenster.skinnr = 2;
			}
		});
		buttonGroup.add(rdbtnBlue);
		rdbtnBlue.setFont(new Font("Consolas", Font.PLAIN, 20));

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("/Users/domsim/Developing/Java/Games/Snake_Projekt/src/Bilder/Schlange/blau/kopflinks.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(68).addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(label).addGap(10))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(rdbtnGreen, GroupLayout.PREFERRED_SIZE, 110,
														GroupLayout.PREFERRED_SIZE)
												.addGap(4).addComponent(lblNewLabel).addGap(4)))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(rdbtnBlue, GroupLayout.PREFERRED_SIZE, 110,
																GroupLayout.PREFERRED_SIZE)
														.addGap(4).addComponent(label_2, GroupLayout.PREFERRED_SIZE, 30,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(rdbtnBlack, GroupLayout.PREFERRED_SIZE, 110,
																GroupLayout.PREFERRED_SIZE)
														.addGap(4).addComponent(lblNewLabel_1))))))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(77).addComponent(label_1,
								GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblSelectYourSkin, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(lblSelectYourSkin, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGap(31)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(label).addGap(24)
										.addComponent(lblNewLabel).addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(rdbtnGreen, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnBlack, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
								.createSequentialGroup().addGap(18)
								.addComponent(rdbtnBlue, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGap(29))
								.addGroup(gl_contentPane
										.createSequentialGroup().addGap(18).addComponent(label_2,
												GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()))));
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] { lblNewLabel_1, rdbtnBlack });
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] { lblNewLabel, rdbtnGreen });
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] { rdbtnGreen, rdbtnBlack });
		contentPane.setLayout(gl_contentPane);
	}
}
