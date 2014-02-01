import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import MergeSort.MergeSort;
import QuickSort.Quicksort;

public class Driver {

	public static void main(String[] args){
		
		// read file for numbers to sort
		Scanner s = null;
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new LinkedHashSet<Integer>();
		//System.out.println(list.size());
			try {
				s = new Scanner(new BufferedReader(new FileReader("data/data.txt")));
				while(s.hasNext()){
					list.add(Integer.parseInt(s.next()));
				}
				set.addAll(list);
				list.clear();
				list.addAll(set);
				//System.out.println(list);
				int[] data = new int[list.size()];
				for(int i=0;i<list.size();i++){
					data[i] = list.get(i);
					//System.out.print(data[i]+" ");
				}
				System.out.println(data.length);
				
				//data = MergeSort.mergesort(data, 0 , data.length);				
				Quicksort qs = new Quicksort();
				data = qs.quicksort(data);
				System.out.println("");
				for(int i=0;i<data.length;i++){
					System.out.print(data[i]+" ");
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
