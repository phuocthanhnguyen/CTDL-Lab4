package Task1;

import java.util.Arrays;

public class BasicSortingAlgorithms {
	public static void selectionSort(int[] array) {
		int temp;
		for (int i = 0; i <= array.length - 2; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					minIndex = j;
				}
			}
			temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
		System.out.println(Arrays.toString(array));
	}

	
	public static void bubbleSort(int[] array) {
		int temp;
		for (int i = array.length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (array[j] < array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}

	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i;
			int temp = array[i];
			while ((j > 0) && (array[j - 1] < temp)) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = temp;
		}
		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) {
		int[] a1 = {1,3,5,7,8,9};
		
		System.out.println("Task1.1");
		selectionSort(a1);
		System.out.println("Task1.2");
		bubbleSort(a1);
		System.out.println("Task1.3");
		insertionSort(a1);
	}
}









