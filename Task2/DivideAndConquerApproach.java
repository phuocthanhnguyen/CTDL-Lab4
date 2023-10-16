package Task2;

import java.util.Arrays;
import java.util.Random;

public class DivideAndConquerApproach {
	private static void mergeSort(int[] array, int low, int high) {
		if (high <= low)
			return;
		int mid = (low + high) / 2;
		mergeSort(array, low, mid);
		mergeSort(array, mid + 1, high);
		merge(array, low, mid, high);
	}

	private static void merge(int[] array, int low, int mid, int high) {
		int leftArray[] = new int[mid - low + 1];
		int rightArray[] = new int[high - mid];
		for (int i = 0; i < leftArray.length; i++)
			leftArray[i] = array[low + i];
		for (int i = 0; i < rightArray.length; i++)
			rightArray[i] = array[mid + i + 1];
		int leftIndex = 0;
		int rightIndex = 0;
		for (int i = low; i < high + 1; i++) {
			if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
				if (leftArray[leftIndex] >= rightArray[rightIndex]) {
					array[i] = leftArray[leftIndex];
					leftIndex++;
				} else {
					array[i] = rightArray[rightIndex];
					rightIndex++;
				}
			} else if (leftIndex < leftArray.length) {
				array[i] = leftArray[leftIndex];
				leftIndex++;
			} else if (rightIndex < rightArray.length) {
				array[i] = rightArray[rightIndex];
				rightIndex++;
			}
		}
	}

	public static void quickSort(int[] array) {
		int low = 0, high = array.length - 1;
		quickSortHelp(array, low, high);
	}

	public static void quickSortHelp(int[] array, int low, int high) {
		if (low < high) {
			int idx = partitionFirst(array, low, high);

			quickSortHelp(array, low, idx - 1);
			quickSortHelp(array, idx + 1, high);
		}
	}

	private static int getPivotMedianOfThree(int[] array) {
		int mid = array.length / 2;
		int first = array[0];
		int last = array[array.length - 1];
		int median = array[mid];

		if (first > last) {
			return first;
		} else if (first > median) {
			return first;
		} else if (last < first) {
			return last;
		} else if (last < median) {
			return last;
		} else {
			return median;
		}
	}

	static int partitionFirst(int arr[], int low, int high) {
		int pivot = arr[low];
		int st = low;
		int end = high;
		int k = high;
		for (int i = high; i > low; i--) {
			if (arr[i] > pivot)
				swap(arr, i, k--);
		}
		swap(arr, low, k);
		return k;
	}

	static int partitionLast(int arr[], int low, int high) {
		int pivot = arr[high];
		int st = low;
		int end = high;
		int k = high;
		for (int i = low; i < high; i++) {
			if (arr[i] < pivot)
				swap(arr, i, k++);
		}
		swap(arr, low, k);

		return k;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static int getPivotRandom(int[] array) {
		Random random = new Random();
        int randomIndex = random.nextInt(array.length);
        return array[randomIndex];
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 8, 9 };
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		int[] arr2 = { 1, 3, 5, 7, 8, 9 };
		quickSort(arr2);
		System.out.println(Arrays.toString(arr2));
	}
}
