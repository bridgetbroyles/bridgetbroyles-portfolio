import java.awt.Graphics;
import java.awt.Color;
import java.io.IOException;


public class ParametricArt {

	public static final int WIDTH = 400; // you can change this value
	public static final int HEIGHT = 400; // you can change this value

	public static void main(String[] args) {
		
		DrawingPanel dp = new DrawingPanel(WIDTH, HEIGHT);
		Graphics gr = dp.getGraphics();
		dp.setBackground(Color.PINK);

		drawParametricCurve(gr);
		
		try {
			dp.save("picture.png");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Draws a parametric Curve pattern based on an equation from my multivariable
	 * professor. The original math equations, given to me by Professor Ansari, are:
	 * x=sin(t+cos(100t)) y=cos(t+sin(100t))
	 * 
	 * @param Graphics g, allows for graphics 
	 * # void method
	 */

	public static void drawParametricCurve(Graphics g) {
		int centerX = WIDTH / 2;
		int centerY = HEIGHT / 2;
		int prevX = 0;
		int prevY = 0;
		double period = 10 * Math.PI; // graphical component of a parametric curve

		for (double t = 0; t < period; t += 0.01) {

			int x = (int) (Math.sin(t + Math.cos(100 * t)) * 200);
			int y = (int) (Math.cos(t + Math.sin(100 * t)) * 200);

			int nextX = centerX + x;
			int nextY = centerY + y;

			// Changes components of the color by a factor of current "t" position in
			// the curve
			int r = (int) (Math.abs(Math.sin(t * 0.1) * 255));
			int gr = (int) (Math.abs(Math.cos(t * 0.1) * 255));
			int b = 255;

			Color color = new Color(r, gr, b);
			g.setColor(color);
			g.drawLine(prevX, prevY, nextX, nextY);

			prevX = nextX;
			prevY = nextY;

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
