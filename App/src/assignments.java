import java.util.*;

class MultiLevelCache {

    HashMap<String,String> L1=new HashMap<>();
    HashMap<String,String> L2=new HashMap<>();
    HashMap<String,String> DB=new HashMap<>();

    String getVideo(String id){

        if(L1.containsKey(id))
            return "L1 HIT";

        if(L2.containsKey(id)){
            L1.put(id,L2.get(id));
            return "L2 HIT -> promoted to L1";
        }

        if(DB.containsKey(id)){
            L2.put(id,DB.get(id));
            return "DB HIT -> added to L2";
        }

        return "Video not found";
    }

    public static void main(String[] args){

        MultiLevelCache c=new MultiLevelCache();

        c.DB.put("video1","data");

        System.out.println(c.getVideo("video1"));
        System.out.println(c.getVideo("video1"));
    }
}