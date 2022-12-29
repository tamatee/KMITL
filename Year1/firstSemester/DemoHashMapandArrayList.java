import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DemoHashMapandArrayList {
    public static void main(String... args) {
        // and Demo HashMap
        CSMovie m1 = new CSMovie("a", 2019);
        CSMovie m2 = new CSMovie("b", 2020);

        HashMap<String, CSMovie> voteTable = new HashMap<>();
        voteTable.putIfAbsent("a", m1);
        voteTable.putIfAbsent("b", m2);

        String[] votes = { "b", "b", "a", "b", "a" };
        for (String s : votes) {
            CSMovie getVote = voteTable.get(s);
            getVote.voteCnt += 1;
            voteTable.put(s, getVote);
        }

        for (Map.Entry<String, CSMovie> entry : voteTable.entrySet()) {
            // CSMovie tmp = entry.getValue(); //i.e. entry.getValue() is a movie ref
            System.out.println(entry.getKey() + " " + entry.getValue().voteCnt);
        }
        ArrayList<CSMovie> movies = new ArrayList<>();
        movies.add(m1);
        movies.add(m2);
        System.out.println("******* showing votes greater than 2************");
        for (CSMovie m : movies) {
            if (m.voteCnt > 2)
                System.out.println(m);
        }
        System.out.println("bye");
    }
}

class CSMovie {
    String title;
    int year;
    int voteCnt;

    CSMovie(String t, int y) {
        title = t;
        year = y;
    }

    public String toString() {
        return "" + title + " " + voteCnt;
    }
}
