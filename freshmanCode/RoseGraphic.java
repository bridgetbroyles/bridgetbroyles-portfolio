import java.awt.Graphics;
import java.awt.Color;
import java.io.IOException;

public class RoseGraphic {

	public static final int WIDTH = 700; // you can change this value
	public static final int HEIGHT = 700; // you can change this value

	public static void main(String[] args) {
		
		DrawingPanel dp = new DrawingPanel(WIDTH, HEIGHT);
		Graphics gr = dp.getGraphics();
		dp.setBackground(Color.PINK);

		drawRoseCurve(gr);


		try {
			dp.save("picture.png");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Draws a parametric Curve pattern based on an equation from my multivariable
	 * professor.
	 * 
	 * 
	 * @param Graphics g, allows for graphics # void method
	 */

	public static void drawRoseCurve(Graphics g) {
		int centerX = WIDTH / 2;
		int centerY = HEIGHT / 2;
		int prevX = centerX; // starting point
		int prevY = centerY;

		double period = 2 * Math.PI;
		double r;

		for (double t = 0; t < period; t += 0.01) {

			r = 300 * Math.cos(5 * t); // r is component of rose petal graph

			// Parametric equations for x and y
			int addedX = (int) (r * Math.cos(t));
			int addedY = (int) (r * Math.sin(t));
			int x = centerX + addedX;
			int y = centerY + addedY;

			// Color changing with "t"
			int red = (int) (Math.abs(Math.sin(t) * 255));
			int green = (int) (Math.abs(Math.cos(t) * 255));
			int blue = 255;

			Color color = new Color(red, green, blue);
			g.setColor(color);
			g.drawLine(prevX, prevY, x, y);

			prevX = x;
			prevY = y;
		}
	}

	
	public static void saveDrawingPanel(DrawingPanel dp, String fileName) {
		try {
			dp.save(fileName);
		} catch (IOException e) {
			System.out.println("Unable to save DrawingPanel");
		}
	}
}
