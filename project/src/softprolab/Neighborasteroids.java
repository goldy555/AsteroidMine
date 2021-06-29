package softprolab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Neighborasteroids {

	public JFrame frame;

	private JPanel contentPane;
	
	public static final String ID = "Neighboring Asteroids";
	private JTable table;

	/**
	 * Create the application.
	 */
	public Neighborasteroids(Settler s) {
		initialize(s);
	}
   
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Settler s) {
		frame = new JFrame(ID);
		String[] columnnames= {"Asteroid id","Type", "Travel code"};
		JPanel panel= new JPanel();

		
		
String [][]data=new String[100][3];
for(int i=0; i<s.GetCurrentPlace().getNeighbor().size(); i++) 
{
	data[i][0]=Integer.toString(s.GetCurrentPlace().getNeighbor().get(i).ID);
	if(s.GetCurrentPlace().getNeighbor().get(i) instanceof Asteroid)
	data[i][1]="Asteroid";
	else
		data[i][1]="Gate";
	data[i][2]=Integer.toString(i);
}

		table = new JTable(data,columnnames);
		table.setShowHorizontalLines(true);
		table.setRowMargin(1);
		panel.add(table);
		
		
		
		frame.getContentPane().add(panel);
		
		
		table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,16));
		table.setFont(new Font("Serif", Font.PLAIN,16));
		table.getTableHeader().setForeground(Color.WHITE);
		table.setOpaque(false);
		table.getTableHeader().setBackground(new Color(32,136,203));
		table.setRowHeight(25);
	

		table.setShowHorizontalLines(true);
	      table.setGridColor(Color.black);
	      table.setRowSelectionAllowed(true);
	      panel.add(new JScrollPane(table));
	      frame.getContentPane().add(panel);
	      DefaultTableModel tableModel = new DefaultTableModel(data,columnnames) {

	    	    @Override
	    	    public boolean isCellEditable(int row, int column) {
	    	       //all cells false
	    	       return false;
	    	    }
	    	};
	    	table.setModel(tableModel);
	      
	      JButton b= new JButton("Go to");
	  
	      frame.setSize(800, 600);
	      frame.setVisible(true);
	      JPanel panel2 = new JPanel();
	      panel2.setLayout(null);
	      b.setBounds(530,450,100,60);
	      panel2.add(b);
		frame.getContentPane().add(panel2);		
	}
	
	

}
