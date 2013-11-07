package MergeSort;

import java.util.Arrays;

public class MergeSort {
	
	public static int[] mergesort(int[] data, int start, int end){
		//divide the array
		int low = start;
		int high = end;
		
		if(low >= high){
			return Arrays.copyOfRange(data, low, high+1);
		}
		
		int mid = low + (high - low)/2;
		int[] left;
		int[] right;
		left = mergesort(data, low, mid);
		right = mergesort(data, mid+1, high);
		
		data = merge(left, right);
		return data;
	}
	
	private static int[] merge(int[] a, int[] b){
		int aux[] = new int[a.length + b.length];
		int aptr=0;
		int bptr=0;
		for(int i=0; i < a.length + b.length ; i++){
			// if any of the arrays is exhausted
			if(aptr>=a.length){
				aux[i] = b[bptr];
				bptr++;
				continue;
			}
			if(bptr>=b.length){
				aux[i] = a[aptr];
				aptr++;
				continue;
			}
			
			// if both array have elements
			if(a[aptr] > b[bptr]){
				aux[i] = b[bptr];
				bptr++;
			}else{
				aux[i] = a[aptr];
				aptr++;
			}
		}
		
		return aux;
	}
}
