package softprolab;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class MainMenu extends JPanel{
	///main menu HUD class with following drawing of tabs
	
	
	
	@Override
	public void paintComponent (Graphics gr) {
		//if (Game.flag == false) {
		Rectangle play = new Rectangle (Game.WIDTH/2-60, 170, 140,60 );

		
		Rectangle Quit = new Rectangle (Game.WIDTH/2-60, 390, 140,60 );
		Color c = new Color(135, 206, 235);
		gr.setColor(c);
		gr.fillRect(0, 0, 800, 600);
		
		Graphics2D g2d = (Graphics2D)gr;
		Font f = new Font (Font.MONOSPACED, Font.BOLD, 40 );
		
		gr.setFont(f);
		
		gr.setColor(Color.BLACK);
		
		gr.drawString(" Asteroid Mining", 220, 100);
		g2d.setColor(Color.GRAY);
		g2d.fillRect(Game.WIDTH/2-80, 190, 180,60);	
		
		g2d.fillRect(Game.WIDTH/2-80, 390, 180,60);
		g2d.setColor(Color.GREEN);
		gr.drawString("Play", Game.WIDTH/2-30, 240);
		gr.drawString("Quit", Game.WIDTH/2-40, 440);
		
		
	
		}
		
		
		
		
	}
