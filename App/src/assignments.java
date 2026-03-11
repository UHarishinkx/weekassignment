import java.util.*;

class Analytics {

    HashMap<String,Integer> pageViews = new HashMap<>();
    HashMap<String,Set<String>> uniqueVisitors = new HashMap<>();

    void processEvent(String url,String user){

        pageViews.put(url,pageViews.getOrDefault(url,0)+1);

        uniqueVisitors.putIfAbsent(url,new HashSet<>());
        uniqueVisitors.get(url).add(user);
    }

    void dashboard(){

        System.out.println("Page Views: "+pageViews);
        System.out.println("Unique Visitors: "+uniqueVisitors);
    }

    public static void main(String[] args){

        Analytics a = new Analytics();

        a.processEvent("/news","user1");
        a.processEvent("/news","user2");
        a.processEvent("/sports","user3");

        a.dashboard();
    }
}