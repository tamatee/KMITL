package packA;

public class Client implements CanPay{
    private String name;
    private MemberTypeWithDiscount memberType;
    public Client() {
        
    }
    public Client(String n) {
        this.name = n;
        memberType = MemberTypeWithDiscount.NONE;
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
                memberType = MemberTypeWithDiscount.SILVER;
                break;
            case SILVER :
                memberType = MemberTypeWithDiscount.GOLD;
                break;
            case GOLD :
                memberType = MemberTypeWithDiscount.PREMIUM;
                break;
            case PREMIUM:
                break;
        }
        showMembershipStatus();

    }
    public void demoteMemberType() {
        switch (memberType) {
            case PREMIUM :
                memberType = MemberTypeWithDiscount.GOLD;
                break;
            case GOLD:
                memberType = MemberTypeWithDiscount.SILVER;
                break;
            case SILVER :
                memberType = MemberTypeWithDiscount.NONE;
                break;
            case NONE:
                break;
        }
        showMembershipStatus();
    }
    public void showMembershipStatus() {
        System.out.println("You are NOW " + memberType + " "+ memberType.print());
    }
}
