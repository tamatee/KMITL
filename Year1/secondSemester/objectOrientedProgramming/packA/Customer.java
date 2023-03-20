package packA;

public class Customer implements CanPay{
    private String name;
    private MemberType memberType;
    public Customer() {
        
    }
    public Customer(String n) {
        this.name = n;
        memberType = MemberType.NONE;
    }
    public void spend(int a) {
        switch(a) {
            case 1:
                promoteMemberType();
                
                break;
            case -1:
                demoteMemberType();
                break;
        }
    }
    public void promoteMemberType() {
        switch (memberType) {
            case NONE :
                memberType = MemberType.SILVER;
                break;
            case SILVER :
                memberType = MemberType.GOLD;
                break;
            case GOLD :
                memberType = MemberType.PREMIUM;
                break;
            case PREMIUM:
                break;
        }
        showMembershipStatus();

    }
    public void demoteMemberType() {
        switch (memberType) {
            case PREMIUM :
                memberType = MemberType.GOLD;
                break;
            case GOLD:
                memberType = MemberType.SILVER;
                break;
            case SILVER :
                memberType = MemberType.NONE;
                break;
            case NONE:
                break;
        }
        showMembershipStatus();
    }
    public void showMembershipStatus() {
        System.out.println("You are NOW " + memberType);
    }
}
