package packA;

public enum MemberTypeWithDiscount {
    NONE(0, 0), SILVER(0.5, 0.5),GOLD(1.0, 2.0), PREMIUM(3.0, 4.5);
    private double productDiscountRate;
    private double serviceDiscountRate;

    private MemberTypeWithDiscount(double pdr, double sdr) {
        this.productDiscountRate = pdr;
        this.serviceDiscountRate = sdr;
    }

    public String print() {
        return String.format("%.0f%%discount on Product %.0f%% discount on service ",productDiscountRate * 10, serviceDiscountRate * 10);
    }
}

