package calculusForComputerScience;

class Integrate {
    public interface FofX {
        double eval(double x);
    }

    static final int LEFT_POINT = 0;
    static final int MID_POINT = 1;
    static final int RIGHT_POINT = 2;

    static double integrate(FofX f, int interval, int point) {
        double dx=((double) 1 - (double) 0)/interval;
        double sum = 0;
        int i = 0;
        while (i<interval) {
            if (point == LEFT_POINT) {
                sum += f.eval((double) 0 + i * dx) * dx;
            } else if (point == MID_POINT) {
                sum += f.eval((double) 0 + i * dx + dx / 2) * dx;
            } else if (point == RIGHT_POINT) {
                sum += f.eval((double) 0 + i * dx + dx) * dx;
            }
            i++;
        }
        return sum;
    }

    static double [] integrate2(FofX f, int interval) {
        double sum;
        sum = 0;
        double sml;
        sml = 0;
        double d = (double) 1 - (double) 0;
        double xi=0;
        double factor= (double) (interval * (interval + 1)) /2;
        double sur = 0;
        int i = 0;
        while (i<interval) {
            var dxi = d*(interval-i)/factor;
            sml+=f.eval(xi)*dxi;          // left point
            sur+=f.eval(xi+dxi/2)*dxi;      // right point
            sum+=f.eval(xi+dxi)*dxi;      // mid point
            xi+=dxi;
            i++;
        }
        return new double [] {(sml), sum, sur};
    }

    public static void main(String[] args) {
        // FofX f = (x) ->  x*x;
        FofX f;
        f = Math::exp;
        var interval = args.length>0?Integer.parseInt(args[0]):100;
        var s = new double[]{integrate(f, interval, LEFT_POINT), integrate(f, interval, MID_POINT), integrate(f, interval, RIGHT_POINT)};
        System.out.printf("S >>> L: %f,M: %f,R: %f", s[0], s[1], s[2]);
        double [] s2 = integrate2(f, interval);
        // System.out.println("S2 : " + Arrays.toString(s2));
        System.out.println();
        System.out.printf("S2 >>> L: %f,M: %f,R: %f", s2[0], s2[1], s2[2]);
    }
}