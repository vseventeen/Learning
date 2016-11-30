package com.sortingalgorithm;

import java.util.Arrays;

/**
 * ������ϣ��������ð������Ľ��
 * ���Խ�λ�ں��ŵĽ�С��ֵ�Ͽ����������ǰ��
 * ʱ�临�Ӷȣ�O(n^2)
 * �ռ临�Ӷȣ�O(1)
 * ���ȶ�����
 */

public class CombSort {
	
	public static void main(String[] args) {
//		int[] a = {3, 7, 1, 10, 5, 2, 4, 9, 6};
		int[] a = {3, 5, 0, 7, 6,1,10,7,2};

		System.out.println("��ʼ���У�" + Arrays.toString(a));
		combSort(a);
		System.out.println("�������У�" + Arrays.toString(a));
		System.out.println((int)(4/1.3));
		System.out.println(1&7);
		System.out.println(1^7);
	}

	public static void combSort(int[] src) {
		
		boolean isSwapped = true;
		int len = src.length;
		int gap = len;
		
		// gap���뵽��Сֵ1��ȷ�������Ƚ�
		while (isSwapped || gap > 1) {
			// ��gapʹ�ù̶��ĵݼ���1.3
			if (gap > 1) {
				gap = (int) (gap / 1.3); 
			}
			
			System.out.println(gap);
			
			isSwapped = false;
			
			// combSort11
			/*if (gap == 9 || gap == 10) {
				gap = 11;
			}*/
			
			// ÿ���gap�Ƚ�
			for (int i = gap; i < len; i++) {
				if (src[i] < src[i - gap]) {
					int tmp = src[i];
					src[i] = src[i - gap];
					src[i - gap] = tmp;
					isSwapped = true;
				}
			}
			
			System.out.println(Arrays.toString(src));
		}
	}
}
