import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class BarGraph extends JPanel {

	private double[] values;
	private Color[] colors;

	public BarGraph(double[] values, Color[] colors) {
		this.values = values;
		this.colors = colors;
	}
	
	public void changeNumbers(double number, int position) {
		values[position] = number;
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (values == null || values.length == 0) {
			return; 
		}
		
		double minValue = 0;
		double maxValue = 0;
		for (int i = 0; i < values.length; i++) {
			if (minValue > values[i]) {
				minValue = values[i];
			}
			if (maxValue < values[i]) {
				maxValue = values[i];
			}
		}

		Dimension dim = getSize();
		int panelWidth = dim.width;
		int panelHeight = dim.height;
		int barWidth = panelWidth / values.length;



		int top = 5;
		if (maxValue == minValue) {
			return;
		}
		double scale = (panelHeight - top) / (maxValue - minValue);
		for (int j = 0; j < values.length; j++) {
			int valueP = j * barWidth + 1;
			int valueQ = top;
			int height = (int) (values[j] * scale);
			if (values[j] >= 0) {
				valueQ += (int) ((maxValue - values[j]) * scale);
			} else {
				valueQ += (int) (maxValue * scale);
				height = -height;
			}

			g.setColor(colors[j]);
			g.fillRect(valueP, valueQ, barWidth - 2, height);
			g.setColor(Color.black);
			g.drawRect(valueP, valueQ, barWidth - 2, height);

			
		}
	}
}
