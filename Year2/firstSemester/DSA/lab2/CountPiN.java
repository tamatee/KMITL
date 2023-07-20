public class CountPiN {
    static boolean isPrime0(int n) {
        if (n == 1)
            return false;
        if (n <= 3)
            return true;
	if ((n%2==0) || (n%3==0)) {
		return false;
	}
        int m = (int)Math.sqrt(n);
        for (int i = 2; i <= m; i+=6) {
            if (m % i == 0)
                return false;
	    if (m%(i+2)==0) {
		    return false;
	    }
        }
        return true;
    }

    public static void main(String[] args) {
	    System.out.println("isPrime0");
        for (int N = 100000; N <= 1000000; N += 100000) {
            long start = System.currentTimeMillis();
            int count = 0;
            for (int n = 1; n < N; n++) {
                if (isPrime0(n))
                    count++;
            }
            long time = (System.currentTimeMillis() - start);
            System.out.println(N + " \t" + count + " \t" + time);
        }
    }
}
