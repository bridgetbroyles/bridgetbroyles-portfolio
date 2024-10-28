import java.util.Arrays;

public class arrayPractice {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 };
		int[] a1 = { 5, 6 };
		String[] str = { "monsters", "wind", "bozo", "cry" };
		int[] index = { 0, 1, 2, 3 };

		System.out.println(Arrays.toString(str));
		swapValues(str, index);
		System.out.println(Arrays.toString(str));

		System.out.println(Arrays.toString(combineArraysAlternating(a, a1)));
		System.out.println(Arrays.toString(combineArraysAlternating2(a, a1)));
		System.out.println(Arrays.toString(combineArraystoEnd(a, a1)));

	}

	public static int[] combineArraysAlternating(int[] a, int[] a2) {
		int[] a3 = new int[a.length + a2.length];
		int i = 0, j = 0, k = 0;

		// i is index in a
		// j is index in a2
		// k is index in a3

		while (i < a.length && j < a2.length) {
			a3[k++] = a[i++];
			a3[k++] = a2[j++];
		}

		// Remaining numbers from the array that is greater length

		while (i < a.length) {
			a3[k++] = a[i++];
		}

		while (j < a2.length) {
			a3[k++] = a2[j++];
		}

		return a3;
	}

	public static int[] combineArraysAlternating2(int[] arr1, int[] arr2) {
		int[] combined = new int[arr1.length + arr2.length];
		int maxLength = Math.max(arr1.length, arr2.length);
		int index = 0;
		for (int i = 0; i < maxLength; i++) {
			if (i < arr1.length) {
				combined[index] = arr1[i];
				index++;
			}
			if (i < arr2.length) {
				combined[index] = arr2[i];
				index++;
			}

		}
		return combined;
	}

	public static int[] combineArraystoEnd(int[] a, int[] a2) {
		int[] a3 = new int[a.length + a2.length];

		for (int i = 0; i < a.length; i++) {
			a3[i] = a[i];
		}

		for (int i = 0; i < a2.length; i++) {
			a3[a.length + i] = a2[i];
		}

		return a3;
	}

	public static void swapValues(String[] arr, int[] arr2) {

		Arrays.sort(arr2);
		for (int i = 0; i < arr2.length / 2; i++) {
			int index1 = arr2[2 * i];
			int index2 = arr2[2 * i + 1];

			// if (index1 < arr.length && index2 < arr.length)
			// checks bounds, but problem doesn't ask us to check
			String temp = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = temp;

		}

	}
}
