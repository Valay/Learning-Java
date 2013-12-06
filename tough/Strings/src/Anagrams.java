import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Arrays;

// To execute Java, please define "static void main" on a class named Solution

class Anagrams {
  
  
  public static void main(String[] args) {
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("hello", "world");
    System.out.println("hello " + map.get("hello"));
    Anagrams s = new Anagrams();
    s.testAnagrams();
  }
  
  public void printAnagrams(List<String> words){
       Map<String, List<String>> anagrams = new HashMap<String, List<String>>();
    
    
    for(int i=0;i<words.size();i++){
      char[] temp;
      temp = words.get(i).toCharArray();
      Arrays.sort(temp);
      String s = new String(temp);
      if(anagrams.containsKey(s)){
        anagrams.get(s).add(words.get(i));
        //anagrams.put(s,lstr);
      }else{
          List<String> ls = new ArrayList<String>();
          ls.add(words.get(i));
          anagrams.put(s,ls);
      }      
    }
    
    for(String key: anagrams.keySet()){
      System.out.println(anagrams.get(key));
    }
  }
                     
   public void testAnagrams(){
         List<String> strs = new ArrayList<String>();
       strs.add("foo");
       strs.add("bar");
       strs.add("oof");
       strs.add("rab");
       strs.add("abr");
       strs.add("cab");
       this.printAnagrams(strs);
   }                   
}

//
// < foo bar oof rab abr cab
// > foo oof
// > bar rab abr
// > cab