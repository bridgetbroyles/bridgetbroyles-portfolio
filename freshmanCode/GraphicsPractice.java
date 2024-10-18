import java.awt.Graphics;

public class GraphicsPractice {

	public static final int BOARD_SIZE = 300;
	public static final int CIRCLE_SIZE = 30;

	public static void main(String[] args) {

		DrawingPanel dp = new DrawingPanel(BOARD_SIZE, BOARD_SIZE);
		Graphics gr = dp.getGraphics();
		drawBoard(dp, gr);

	}
//creates a checkerboard pattern with ovals 
	public static void drawBoard(DrawingPanel dp, Graphics gr) {
		int numRows=BOARD_SIZE/CIRCLE_SIZE;
		for(int r=0; r<numRows; r++) {
			for(int c=0; c<numRows; c++) {
        //even and odd, or odd and even row/column indexs
				if((r%2==0)&&(c%2!=0)||(r%2!=0&&c%2==0))
				gr.fillOval(r*CIRCLE_SIZE, c*CIRCLE_SIZE, CIRCLE_SIZE, CIRCLE_SIZE);
			  }
	  	}
	}
  
}
