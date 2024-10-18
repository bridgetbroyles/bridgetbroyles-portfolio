import java.awt.Graphics;
import java.awt.Color;
import java.io.IOException;

public class StairsGraphics {
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(350, 350);
		Graphics g = panel.getGraphics();
		panel.setBackground(Color.PINK);

		leftDecreasing(20, 20, g);
		leftIncreasing(20, 220, g);
		g.drawString("Stairs Practice!", 130, 180);
		rightDecreasing(220, 20, g);
		rightIncreasing(220, 220, g);

		saveDrawingPanel(panel, "panel.png");
	}

	public static void leftDecreasing(int x, int y, Graphics g) {
		for (int i = 0; i < 10; i++) {
			g.drawRect(x, y + 10 * i, 10 + 10 * i, 10);
		}
	}

	public static void leftIncreasing(int x, int y, Graphics g) {
		for (int i = 0; i < 10; i++) {
			g.drawRect(x, y + 10 * i, 100 - 10 * i, 10);
		}
	}

	public static void rightDecreasing(int x, int y, Graphics g) {
		for (int i = 0; i < 10; i++) {
			g.drawRect(x + 10 * i, y + 10 * i, 100 - 10 * i, 10);
		}
	}

	public static void rightIncreasing(int x, int y, Graphics g) {
		for (int i = 0; i < 10; i++) {
			g.drawRect(x, y + 10 * i, 10 + 10 * i, 10);
		}
	}

	public static void saveDrawingPanel(DrawingPanel panel, String fileName) {
		try {
			panel.save(fileName);
		} catch (IOException e) {
			System.out.println("Unable to save DrawingPanel");
		}
	}
}
