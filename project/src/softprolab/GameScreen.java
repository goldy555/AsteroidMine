package softprolab;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GameScreen {
	GameScreen(Settler s)
	{
		//main frame and panels
		JFrame frame=new JFrame();
		JPanel npanel=new JPanel();
		JPanel spanel=new JPanel();
		
		//actions and buttons
		JTextField destination=new JTextField("",20);
		JButton move=new JButton("Move");
		JButton mine=new JButton("Mine");
		JButton drill=new JButton("Drill");
		JButton hide=new JButton("Hide");
		JButton openInventory=new JButton("Open Inventory");
		JButton openNeighbor=new JButton("Open Neighbor List");
		JButton buildStation=new JButton("Build Station");
		JButton buildGate=new JButton("Build Gate");
		
		//information about asteroid 
		JTextArea id=new JTextArea("ID");
		id.setEditable(false);
		JTextField idfield=new JTextField(Integer.toString(s.GetCurrentPlace().ID));
		JTextArea depth=new JTextArea("depth");
		depth.setEditable(false);
		JTextField depthfield=new JTextField(Integer.toString(s.GetCurrentPlace().getDepth()));
		depthfield.setEditable(false);
		JTextArea state=new JTextArea("state");
		state.setEditable(false);
		JTextField statefield=new JTextField(s.GetCurrentPlace().getState());
		statefield.setEditable(false);
		JTextArea core=new JTextArea("core");
		core.setEditable(false);
		JTextField corefield;
		
		

		if(s.GetCurrentPlace().hollow) {
			corefield=new JTextField("hollow core");
			corefield.setEditable(false);}
		
		else if(s.GetCurrentPlace().getCore().getType()==1){
		corefield=new JTextField("Uranium");
		corefield.setEditable(false);}
		
		else if(s.GetCurrentPlace().getCore().getType()==4){
		corefield=new JTextField("Carbon");
		corefield.setEditable(false);}
		
		else if(s.GetCurrentPlace().getCore().getType()==3){
		corefield=new JTextField("Iron");
		corefield.setEditable(false);}
		
		else if(s.GetCurrentPlace().getCore().getType()==2){
		corefield=new JTextField("Water Ice");
		corefield.setEditable(false);}
		
		else {
		corefield=new JTextField("hollow core");
		corefield.setEditable(false);}
		
		
		//Button click events
		move.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){
				  int i=Integer.parseInt(destination.getText());
				  s.Travel(s.GetCurrentPlace().getNeighbor().get(i));
				  GameScreen newscreen=new GameScreen(s);
				  frame.dispose();
			  }});
		
		drill.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){
				  s.Drill(s.GetCurrentPlace());
				  GameScreen newscreen=new GameScreen(s);
				  frame.dispose();
			  }});
		
		mine.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){
				  try {
					s.Mine(s.GetCurrentPlace());
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  frame.dispose();
			  }});
		
		hide.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){
				  s.Hide();
				  GameScreen newscreen=new GameScreen(s);
				  frame.dispose();
			  }});
		
		openInventory.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){
				  Inventory inv = new Inventory(s);
					inv.secondframe.setVisible(true);
			  }});
		
		openNeighbor.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){
				  Neighborasteroids n = new Neighborasteroids(s);
					n.frame.setVisible(true);
			  }});
		
		buildGate.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){
				  Random rand=new Random();
				  int r=rand.nextInt(100);
				  s.BuildGate(r);
			  }});
		
		buildStation.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){
				 int counti=0, countu = 0, countw=0, countc=0;
				 for(int i=0;i<s.minerals.size();i++) 
				 {
					if( s.minerals.get(i) instanceof Uranium) countu++;
					if( s.minerals.get(i) instanceof WaterIce) countw++;
					if( s.minerals.get(i) instanceof Iron) counti++;
					if( s.minerals.get(i) instanceof Carbon) countc++;
				 }
				 if(countu>=2 && counti>=2 && countw>=2 && countc>=2) { s.MakeStation();
				 frame.dispose();}
			  }});
		
		//image
		ImageIcon ic = new ImageIcon("aster.png");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 735, 414);
		label.setIcon(ic);
		label.setOpaque(true);
		
		//north panel components
		npanel.add(label);
		npanel.add(id);
		npanel.add(idfield);
		npanel.add(depth);
		npanel.add(depthfield);
		npanel.add(state);
		npanel.add(statefield);
		npanel.add(core);
		try {
		npanel.add(corefield);}
		catch(Exception e) {}
		
		
		//south panel components
		spanel.add(destination);
		spanel.add(move);
		spanel.add(drill);
		spanel.add(mine);
		spanel.add(hide);
		spanel.add(openInventory);
		spanel.add(openNeighbor);
		spanel.add(buildStation);
		spanel.add(buildGate);
		
		//layout
		frame.add(npanel, BorderLayout.NORTH);
		frame.add(spanel, BorderLayout.SOUTH);
		
		//finalizing
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
