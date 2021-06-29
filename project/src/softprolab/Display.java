package softprolab;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Color;

public class Display extends JFrame {

	private JPanel contentPane;
	public JFrame frame;
	//private final Action action = new SwingAction();
	public static final String ID = "Asteroid Mining";
	/**
	 * Launch the application.
	 */
	
	public Display(Settler s) {		
		intialize(s);
	}

	/**
	 * Create the frame.
	 */
	public void intialize(Settler s) {
		
		frame = new JFrame(ID);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		MainMenu mainMenu = new MainMenu();
		frame.setContentPane(mainMenu);
		mainMenu.setLayout(null);
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.setBackground(Color.GRAY);
		btnPlay.setForeground(Color.BLACK);
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnPlay.setBounds(319, 193, 179, 55);
		mainMenu.add(btnPlay);
		btnPlay.addActionListener(new ActionListener(){
			

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GameScreen g = new GameScreen(s);
				frame.dispose();
			}
			});
			
		
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnNewButton.setBounds(319, 388, 179, 63);
		mainMenu.add(btnNewButton);
	}
	
		
	}

