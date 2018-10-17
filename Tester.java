import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;

public class Tester {
	  public static void main(String[] args) {
		  
		//    JFrame.setDefaultLookAndFeelDecorated(true);
		    JFrame frame = new JFrame();
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(500, 500);
		    JPanel fieldPanel = new JPanel();	

		    

		    double[] values = new double[]{1,2,3,4,5};
		    Color[] colors = new Color[]{
		        Color.red,
		        Color.orange,
		        Color.yellow,
		        Color.green,
		        Color.blue
		    };
		    BarGraph graph = new BarGraph(values, colors);
		    JTextField[] fields = new JTextField[5];
		    for (int i = 0; i < 5; i++) {
		    	int j = i;
		    	fields[i] = new JTextField(7);
		    	fields[i].setText(String.valueOf(i + 1));
		    	fields[i].addActionListener(event ->
		         {
		          	  String input = fields[j].getText();
		          	  graph.changeNumbers(Integer.parseInt(input), j);
		          	  graph.repaint();
		            });
		    	fieldPanel.add(fields[i]);
		    }
		 
		    frame.add(graph, BorderLayout.CENTER);
		    frame.add(fieldPanel, BorderLayout.SOUTH);
		    frame.setVisible(true);

		  }
		}

