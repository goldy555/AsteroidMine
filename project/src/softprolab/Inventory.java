package softprolab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Inventory extends JFrame {
	public static final String ID = "Asteroid Mining";
	private JPanel contentPane;
JFrame secondframe;
	/**
	 * Launch the application.
	 */
	public void BindInventorytable(Settler s)
	{
		ArrayList<Mineral> min_list = s.GetMinerals();
		// Column Names
        String[] columnNames = { "Mineral", "Amount" };
		if(min_list == null) // if no data found 
		{
			
			 String[][] data = {
			            { "Iron", "Mineral", "" },
			            { "Carbon", "Mineral", "" },
			            { "Uranium", "Mineral", "" },
			            { "Water Ice", "Mineral", "" }
			        };
			  
			        
			     JTable   j = new JTable(data, columnNames);
			     secondframe.getContentPane().add(j,BorderLayout.EAST);
		}
		else
		
		{
			//assigning content of inventory to the array
			String [][]data=new String[4][2];
				data[0][0]="Uranium";
				int count=0;
				for(int j=0; j<min_list.size();j++) 
				{
					if(min_list.get(j) instanceof Uranium)
						count++;
				}
				data[0][1]=Integer.toString(count);
				
				count=0;
				data[1][0]="Water Ice";
				for(int j=0; j<min_list.size();j++) 
				{
					if(min_list.get(j) instanceof WaterIce)
						count++;
				}
				data[1][1]=Integer.toString(count);
				
				count=0;
				data[2][0]="Iron";
				for(int j=0; j<min_list.size();j++) 
				{
					if(min_list.get(j) instanceof Iron)
						count++;
				}
				data[2][1]=Integer.toString(count);
				
				count=0;
				data[3][0]="Carbon";
				for(int j=0; j<min_list.size();j++) 
				{
					if(min_list.get(j) instanceof Carbon)
						count++;
				}
				data[3][1]=Integer.toString(count);
				
				
			  JTable  j1 = new JTable(data, columnNames);
			     secondframe.getContentPane().add(j1,BorderLayout.EAST);

		}
		
		
		
	}
	/**
	 * Create the application.
	 */
	public Inventory(Settler s) {
		
		initialize(s);
	}
	/**
	 * Create the frame.
	 */
	public void initialize(Settler s) {
		secondframe = new JFrame(ID);
		secondframe.setBounds(100, 100, 800, 500);
		ImageIcon ic = new ImageIcon("aster.png");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 735, 414);
		label.setIcon(ic);
		label.setOpaque(true);
		
		JPanel panel = new JPanel();
		secondframe.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.add(label);
		Color c = new Color(194, 143, 78);
		
		BindInventorytable(s);
	}

}
