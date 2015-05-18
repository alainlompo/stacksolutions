package stack.commons.algorithms;

import java.util.ArrayList;

public class Mode {

   public static <T> Pair<T, Integer> mode(T items[])
   {
       ArrayList <Pair<T, Integer>> temp = new ArrayList<Pair<T,Integer>>();
       //ArrayList <T> temp = new ArrayList<>();

       for(T values: items)
       {
           temp.add((Pair<T, Integer>) values);
       }

       for(int i = 0; i < temp.size(); i++)
           for(int j = 0; j < temp.size(); j++)
       {
           if(temp.get(i) == temp.get(j)) {
        	   
           }
       }
       
       return temp.get(0);
   }
}


    class Pair<X,Y>{
     private X first;
     private Y second;

     public Pair(X x, Y y){
       this.first = x;
       this.second = y;
     }

     public X getFirst(){
       return this.first;
     }
     public Y getSecond(){
       return this.second;
     }

     public boolean equals(Object o){
       if(!(o instanceof Pair)){
         return false;
       }
       Pair p = (Pair) o;
       return
         this.first.equals(p.first) &&
         this.second.equals(p.second);
     }

     public String toString(){
       return String.format("(%s,%s)",first,second);
     }

   }