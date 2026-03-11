import java.util.*;

class UsernameChecker {

    HashMap<String, Integer> users = new HashMap<>();
    HashMap<String, Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    public void register(String username, int userId) {
        users.put(username, userId);
    }

    public List<String> suggestAlternatives(String username) {
        List<String> list = new ArrayList<>();
        list.add(username + "1");
        list.add(username + "2");
        list.add(username.replace("_", "."));
        return list;
    }

    public String getMostAttempted() {
        return Collections.max(attempts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        UsernameChecker u = new UsernameChecker();
        u.register("john_doe",1);

        System.out.println(u.checkAvailability("john_doe"));
        System.out.println(u.checkAvailability("jane_smith"));
        System.out.println(u.suggestAlternatives("john_doe"));
    }
}