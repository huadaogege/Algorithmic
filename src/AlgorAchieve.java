
public class AlgorAchieve {

	private AlgorAchieve (){
	}
	
	private static final AlgorAchieve instance = new AlgorAchieve();
	
	public static AlgorAchieve getInstance() {
		return instance;
	}
	
    
	
	/* 算法一:选择排序
	 * 
	 * 实现原理:首先遍历一遍数组,找到最小的一个元素和第一个元素换位，
	 *        然后依次在剩余的元素中和第2，3...个元素换位，
	 *        每一遍都只能确定一个元素的位置
	 *        
	 * 交换次数:(N-1)+(N-2)+...+2+1=N*(N-1)/2次比较
	 *
	 * 基本特点:1.运行时间和输入顺序无关
	 *        2.数据移动是最少的       
	 * */
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
	
	/* 算法二:插入排序
	 * 
	 * 实现原理:类似给扑克牌洗牌的方式，为了要给插入的元素腾出空间，
	 *        插入点右侧所有的元素都要向右移动，所以如果输入的顺序
	 *        一本有序要比无需需要的时间少很多
	 *        
	 * 交换次数:最好的情况:N-1和0次交换，最坏的情况是(N*N)/2
	 * 
	 * 基本特点:需要交换的次数和输入的顺序有直接关系       
	 *        
	 * */
	public static void insertSort(Comparable<Integer>[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			show(a);
			System.out.println("*******");
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				show(a);
				exch(a, j, j - 1);
			}
		}
	}
	/***********************************公共算法使用方法*****************************************/
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
