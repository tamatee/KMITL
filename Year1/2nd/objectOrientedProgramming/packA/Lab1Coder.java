package packA;
import java.util.ArrayList;
public class Lab1Coder {
    private String name;
    private ArrayList<String> lang = new ArrayList<>();
    ArrayList<String> ans = new ArrayList<>();
    int experience;
    String a = "";
    public Lab1Coder() {

    }

    public Lab1Coder(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public Lab1Coder(String name) {
        this.name = name;
        this.experience = 0;
    }

    public  void setName(String name) {
        this.name = name;
    }

    public  String getName() {
        return name;
    }

    public void setLanguage(String... lang) {
        for (String string : lang) {
            this.lang.add(string);
        }
    }

    public ArrayList<String> getLanguage() {
        return this.lang;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public ArrayList<String> findCommonLanguages(Lab1Coder other) {
        for (String i : this.getLanguage()) {
            for (String j : other.getLanguage()) {
                if (i.equals(j)) {
                    ans.add(i);
                }
            }
        }
        if (ans.size() == 0) {
            ans.add("None");
        }
        return ans;
    }

    public String atos() {
        for (int i = 0; i < getLanguage().size(); i++) {
            a += getLanguage().get(i);
            if (i != getLanguage().size() - 1) {
                a += " ";
            }
        }
        return a;
    }

    public String toString() {
        return String.format("%s(%d) know %s", name, experience, atos());

    }
}