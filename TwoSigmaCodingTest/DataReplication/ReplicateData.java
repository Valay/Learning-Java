package DataReplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ReplicateData {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		try {
			int numDataCenters = Integer.parseInt(br.readLine());
			int data;
			
			
			// Fill up the data Structures 
			List<HashSet<Integer>> dataCenter = new ArrayList<HashSet<Integer>>(); 
			Map<Integer,Integer> dataSet = new HashMap<Integer,Integer>();
			HashSet<Integer> allDataSets = new HashSet<Integer>();
			
			for(int i=0;i<numDataCenters;i++){
				HashSet<Integer> dataset = new HashSet<Integer>();
				String[] s = (br.readLine()).split(" ");
				
				for(int j=1;j<s.length;j++){
					data = Integer.parseInt(s[j]);
					if(dataSet.get(data) == null){
						dataSet.put(data, i);
						allDataSets.add(data);
					}
					dataset.add(data);
				}			
				dataCenter.add(dataset);
			}
			
			//Replicate the data
			for(int k=0;k<dataCenter.size();k++){
				HashSet<Integer> temp = new HashSet<Integer>(allDataSets);
				temp.removeAll(dataCenter.get(k));
				for(Integer i:temp){
					System.out.println(i+" "+(dataSet.get(i)+1)+" "+(k+1));
				}
			}
			System.out.println("done");
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
