import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Scanner;

public class NaiveGoldTrader {
    static int RanreadGoldPrices(int goldPrices[], int n) {
        for (int i = 0; i < n; i++) {
            goldPrices[i] = (int) Math.round(Math.random() * 20000 + 20000);
        }
        return n;
    }

    public static void main(String args[]) {
        int goldPrices[] = new int[1000000];
	Scanner a = new Scanner(System.in);
	int n = a.nextInt();
	a.close();
        RanreadGoldPrices(goldPrices, n);
        int bestBuyDate = 0;
        int bestSellDate = 0;
        int maxProfit = Integer.MIN_VALUE;
        long count = 0;
        for (int buyDate = 0; buyDate < n - 1; buyDate++) {
            for (int sellDate = buyDate + 1; sellDate < n; sellDate++) {
                count++;
                int profit = goldPrices[sellDate] - goldPrices[buyDate];
                if (profit > maxProfit) {
                    maxProfit = profit;
                    bestBuyDate = buyDate;
                    bestSellDate = sellDate;
                }
            }
        }
        System.out.println("Number of days: " + n);
        System.out.println("Max profit is: " + maxProfit);
        System.out.println("Buy date: " + (bestBuyDate + 1));
        System.out.println("Sell date: " + (bestSellDate + 1));
        System.out.println("count: " + count);
    }
}
