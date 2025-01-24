public class Practice {
	public static void main(String[] args) {

		ArrayIntList list1 = new ArrayIntList();

		list1.add(1);
		list1.add(3);
		list1.add(2);
		list1.add(7);
		list1.mirror();
		System.out.println("Mirrored list: " + list1); // [1, 3, 2, 7, 7, 2, 3, 1]

		ArrayIntList list2 = new ArrayIntList();
		list2.add(3);
		list2.add(4);
		list2.add(2);
		list2.add(5);
		ArrayIntList expandedList = list2.fromCounts();
		System.out.println("Expanded list: " + expandedList); // [4, 4, 4, 5, 5]
	}
}

class ArrayIntList {
	private int[] elementData;
	private int size;

	public ArrayIntList() {
		elementData = new int[10];
		size = 0;
	}

	public void add(int value) {
		ensureCapacity(size + 1);
		elementData[size] = value;
		size++;
	}

	public int get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index);
		}
		return elementData[index];
	}

	public int size() {
		return size;
	}

	private void ensureCapacity(int capacity) {
		if (capacity > elementData.length) {
			int[] newData = new int[Math.max(capacity, elementData.length * 2)];
			System.arraycopy(elementData, 0, newData, 0, size);
			elementData = newData;
		}
	}

	public void mirror() {
		int originalSize = size;
		for (int i = 0; i < originalSize; i++) {
			add(get(originalSize - i - 1));
		}
	}

	public ArrayIntList fromCounts() {
		ArrayIntList result = new ArrayIntList();
		for (int i = 0; i < size; i += 2) {
			int count = get(i);
			int value = get(i + 1);
			for (int j = 0; j < count; j++) {
				result.add(value);
			}
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(elementData[i]);
		}
		sb.append("]");
		return sb.toString();
	}
}
