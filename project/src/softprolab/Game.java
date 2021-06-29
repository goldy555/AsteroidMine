package softprolab;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

public SunStorm ss;
private static Settler s;
private Mineral mi;
public List<Asteroid> aster;
public static LinkedList<Robot>robots;
private Asteroid p;
public static Identity idn = Identity.MENU;

public static int WIDTH = 800;


public Game (){
	s=new Settler();
	aster=new ArrayList<>();
}

//game starts everything initializes
public void StartGame() {
for(int i=0;i<1000;i++) 
{
	Asteroid anew=new Asteroid(i);
	aster.add(anew);
}
Random rand=new Random();
for(int i=0;i<1000;i++) {
	for(int j=0;j<100;j++) {
	int randint=rand.nextInt(999);
	if(i==randint) randint++;
	aster.get(i).setNeighbor(aster.get(randint));}
}
s.SetCurrentPlace(aster.get(0));
EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			Display window = new Display(s);
			
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
});
}


//game finishes going to endgame screen
public static void EndGame() {
s.Die();
}

public static void winGame() 
{
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JTextArea text=new JTextArea("You Won! Congratulations, you may exit!");
	panel.add(text);
	frame.add(panel);
	frame.pack();
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	frame.setVisible(true);
}


//adding/removing sunstorm to the game
public void AddSunStrom() {


}
public static void AddRobot(Robot r) {
robots.add(r);
}
public static void RemoveRobot(Robot r) {
robots.remove(r);
}

}