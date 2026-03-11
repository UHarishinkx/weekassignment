import java.util.*;

class Autocomplete {

    HashMap<String,Integer> freq = new HashMap<>();

    void addQuery(String query){
        freq.put(query,freq.getOrDefault(query,0)+1);
    }

    void search(String prefix){

        for(String q:freq.keySet()){

            if(q.startsWith(prefix))
                System.out.println(q+" -> "+freq.get(q));
        }
    }

    public static void main(String[] args){

        Autocomplete a = new Autocomplete();

        a.addQuery("java tutorial");
        a.addQuery("javascript guide");
        a.addQuery("java download");

        a.search("jav");
    }
}