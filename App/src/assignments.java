import java.util.*;

class TokenBucket {
    int tokens;

    TokenBucket(int tokens) {
        this.tokens = tokens;
    }
}

class RateLimiter {

    HashMap<String,TokenBucket> clients = new HashMap<>();
    int limit = 5;

    boolean checkRateLimit(String client){

        clients.putIfAbsent(client,new TokenBucket(limit));

        TokenBucket bucket = clients.get(client);

        if(bucket.tokens>0){
            bucket.tokens--;
            return true;
        }

        return false;
    }

    public static void main(String[] args){

        RateLimiter r = new RateLimiter();

        for(int i=1;i<=7;i++)
            System.out.println("Request "+i+" : "+r.checkRateLimit("client1"));
    }
}