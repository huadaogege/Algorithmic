
public class AlgorithmicTest {

	public static void main(String[] args) {
		Integer[] array = {5,4,3,2,1};
		selectSort(array);
	}
	
	/*插入排序*/
	
	public static void insertSort(Comparable<Integer>[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}
	
	/*选择排序*/
	public static void selectSort(Comparable<Integer>[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			show(a);
			System.out.println("************");
			for (int j = i+1; j < N; j++) {
				show(a);
				if (less(a[j], a[min])) {
					min = j;
					exch(a, i, min);
				}
			}
		}
	}
	
	/* 比较大小*/	
	public static boolean less (Comparable<Integer> v, Comparable<Integer> w) {
		return v.compareTo((Integer) w) < 0;
	}
	
	/*数组元素交换位置 */
	private static void exch(Comparable<Integer>[] a, Integer i, Integer j) {
		Comparable<Integer> t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	/*列举数组里面所有元素*/
	private static void show(Comparable<Integer>[] a) {
		String arrayString = "";
		for (int i = 0; i < a.length; i++) {
			arrayString += a[i];
		}
		System.out.println(arrayString);
	}
	
	/*判断数组是否是有序的*/
	public static boolean isSorted(Comparable<Integer>[] a ) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		return true;
	}	

}
