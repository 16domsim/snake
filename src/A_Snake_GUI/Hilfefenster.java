package A_Snake_GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import java.awt.Component;

/**
 * Hifefenster f�r das Spiel.
 */
public class Hilfefenster extends JDialog {
	

	private JPanel contentPane;

	/**
	 * Startet das Hiffenster.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Hilfefenster frame = new Hilfefenster();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Instanziiert das Hilffenster.
	 */
	public Hilfefenster() {
		setTitle("Help");
		setType(Type.UTILITY);
		setBounds(100, 100, 450, 177);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblHelp = new JLabel("Help");
		lblHelp.setFont(new Font("Consolas", Font.PLAIN, 26));
		
		JLabel lblNewLabel = new JLabel("");

		
		JLabel lblPleasAskMe = new JLabel("Pleas ask me if there are any incerties.");
		lblPleasAskMe.setFont(new Font("Consolas", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(lblHelp)
							.addGap(65)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPleasAskMe)))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHelp)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addComponent(lblPleasAskMe)
					.addContainerGap(160, Short.MAX_VALUE))
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {lblHelp, lblNewLabel});
		contentPane.setLayout(gl_contentPane);
	}

}
