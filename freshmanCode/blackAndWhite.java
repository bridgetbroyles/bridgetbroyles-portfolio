import java.awt.Color;
import java.awt.Graphics;

public static void main(String[] args) throws InterruptedException {

	DrawingPanel dp = new DrawingPanel(300, 200);
	Graphics gr = dp.getGraphics();
	gr.setColor(Color.CYAN);
	gr.drawString("Hello world!", 20, 50);
	gr.setColor(Color.YELLOW);
	gr.fillOval(10, 100, 20, 70);
	gr.setColor(Color.GREEN);
	gr.fillRect(100, 80, 44, 90);
	Thread.sleep(2000);
	blackAndWhite(dp);
}

public static void blackAndWhite(DrawingPanel dp) {
	Color[][] pixels=dp.getPixels();
			
	for(int r=0; r<pixels.length; r++) {
		for(int c=0; c<pixels[r].length; c++) {
			int red= pixels[r][c].getRed();
			int blue=pixels[r][c].getBlue();
			int green=pixels[r][c].getGreen();
			int average=(red+green+blue)/3;
			Color grayscale=new Color(average,average,average);
			pixels[r][c]=grayscale;
			
	
		}
		dp.setPixels(pixels);
	}
	
}