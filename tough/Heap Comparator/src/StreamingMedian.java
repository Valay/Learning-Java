import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class StreamingMedian{
	
    /* Head ends here*/
    static void median(String a[],int x[]) {
        int count = 0;
    	
    	Comparator<Integer> max = new Comparator<Integer>(){
    		public int compare(Integer o1, Integer o2){
    			
    			return o2-o1;
    		}
    	};
    	
    	Comparator<Integer> min = new Comparator<Integer>(){
    		public int compare(Integer o1, Integer o2){
    			
    			return o1-o2;
    		}
    	};
    	
    	PriorityQueue<Integer> minQ = new PriorityQueue<Integer>(10,min);
    	PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(10,max);

    	
       for(int i=0;i<a.length;i++){

    	   if(a[i].equals("a")){
    		   if(maxQ.isEmpty()){
    			   maxQ.add(x[i]);
    			   count++;
        	   }else{
	    		   if(x[i] > maxQ.peek()){
	    			   minQ.add(x[i]);
	    			   count++;
	    		   }else{
	    			   maxQ.add(x[i]);
	    			   count++;
	    		   }
        	   }
    	   }
    	   if(a[i].equals("r")){
    		   if(minQ.contains(x[i])){
    			   minQ.remove(x[i]);
    			   count--;
    		   }else if(maxQ.contains(x[i])){
    			   maxQ.remove(x[i]);
    			   count--;
    		   }else{
    			   System.out.println("Wrong!");
    			   continue;
    		   }
    		   if(count == 0){
    			   System.out.println("Wrong!");
    			   continue;
    		   }
    	   }
    	   
//    	   System.out.println(maxQ);
//    	   System.out.println(minQ);
//    	   System.out.println(count);
    	   
    	   // balance the queues!
    	   if( (maxQ.size() - minQ.size()) > 1){
    		   minQ.add(maxQ.remove());
    	   }
//    	   System.out.println(minQ.size());
//    	   System.out.println(maxQ.size());
    	   if( (minQ.size() - maxQ.size()) > 0){
    		   //System.out.println("Inside!");
    		   maxQ.add(minQ.remove());
    	   }
    	   
//    	   System.out.println(maxQ);
//    	   System.out.println(minQ);
    	   
    	   // print the median
    	   if(count % 2 == 0){
    		   if(maxQ.size() != 0 && minQ.size() != 0)
    			   System.out.println( ((double)maxQ.peek() + (double)minQ.peek()) / 2.0 );
    	   }else{
    		   System.out.println(maxQ.peek());
    	   }
       }
    }
    
    /* Tail starts here*/
    
   public static void main( String args[] ){
      

      Scanner in = new Scanner(System.in);
      
      int N;
      N = in.nextInt();
   
      String s[] = new String[N];
      int x[] = new int[N];
      
      for(int i=0; i<N; i++){
         s[i] = in.next();
         x[i] = in.nextInt();
      }
   
      median(s,x);
    }
}