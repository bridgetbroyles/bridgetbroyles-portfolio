import java.awt.*;

public class matrixpractice {

	public static void main(String[] args) {
		DrawingPanel dp = new DrawingPanel();
		Graphics g = dp.getGraphics();
		drawImage(g);
		darkenImage(dp);
		runTests();

	}

	private static boolean isUpperTriangle(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr.length != arr[i].length)
				return false;
		}
		// Below top left to bottom right diagonal
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i][j] != 0)
					return false;
			}
		}
		return true;
	}

	private static void drawImage(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(90, 90, 500, 500);
		g.setColor(Color.YELLOW);
		g.fillOval(0, 0, 300, 300);

	}

	private static void darkenImage(DrawingPanel dp) {
		Color[][] pixels = dp.getPixels();
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[i].length; j++) {
				int red = pixels[i][j].getRed();
				int green = pixels[i][j].getGreen();
				int blue = pixels[i][j].getBlue();
				Color darken = new Color(red / 2, green / 2, blue / 2);
				pixels[i][j] = darken;
			}
		}
		dp.setPixels(pixels);
	}

	private static void runTests() {
		int[][] testCase1 = {
	            {1, 2, 3},
	            {0, 5, 6},
	            {0, 0, 9}
	        };
	        int[][] testCase2 = {
	            {1, 2, 3},
	            {4, 5, 6}, // Non-zero element here
	            {0, 0, 9}
	        };
	        int[][] testCase3 = {
	            {0, 0, 0},
	            {0, 0, 0},
	            {0, 0, 0}
	        };
	        int[][] testCase4 = {
	            {1, 1, 1},
	            {1, 1, 1},
	            {1, 1, 1}
	        };
	        int[][] testCase5 = {
	            {1}
	        };
	        int[][] testCase6 = {
	            {1},
	            {0}
	        };

		System.out.println("IsUpperTriangle: " + isUpperTriangle(testCase1));
		System.out.println("IsUpperTriangle: " + isUpperTriangle(testCase2));
		System.out.println("IsUpperTriangle: " + isUpperTriangle(testCase3));
		System.out.println("IsUpperTriangle: " + isUpperTriangle(testCase4));
		System.out.println("IsUpperTriangle: " + isUpperTriangle(testCase5));
		System.out.println("IsUpperTriangle: " + isUpperTriangle(testCase6));
	}

}
