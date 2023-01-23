package packA;

/**
 * Accountant
 */
public class Accountant extends Programmer {
    private static String companyName = "berk barn jamkad";
    private int experience;
    private String specialty;

    public Accountant() {
    }

    public Accountant(String name, int superExp, int experience, int sal, String talent) {
        super(name, superExp, experience);
        this.experience = experience;
        this.specialty = talent;
    }

    public void setSpecialty(String newSpecialty) {
        this.specialty = newSpecialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setAccountExperience() {
        this.experience = super.getExperience();
    }

    @Override
    public int getExperience() {
        return super.getExperience();
    }

    public String tellProfit() {
        return String.format("%s's profit is %.0f. My salary is %d", companyName, Math.random() * 10000,
                super.getSalary());
    }

    @Override
    public String toString() {
        return "Account [experience=" + experience +", specialty=" + specialty +"]";
    }

    @Override
    public void sayHi() {
        System.out.println(super.getName() + " says hello");
    }

    public static String tellMyRole() {
        System.out.println("I am an accountant at " + companyName);
        return "";
    }
}