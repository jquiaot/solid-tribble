import java.util.*;
import java.util.stream.*;

// START: 12:05AM
// END:   
public class Spiral {

    /**
     * Generates a two-dimensional array of ints corresponding to a n x n square
     * of integers that contain the numbers 1 ... n^2 in a spiral pattern,
     * starting across the top and spiraling towards the center.
     */
    public static int[][] spiral(int n) {
        int[][] res = new int[n][n];


        // 0,0 1,0 2,0 .. n-1,0
        // n-1,1 n-1,2 n-1,3 .. n-1,n-1
        // n-2,n-1 n-3,n-1 .. 1,n-1 0,n-1
        // 0,n-2 0,n-3 .. 0,1 0,0

        int start = 0, end = n - 1;
        int cur = 1;
        int x = 0, y = 0;

        while (start <= end) {
            for (x = start; x <= end; ++x) {
                System.out.println(String.format("res[%d][%d] = %d]", y, x, cur));
                res[y][x] = cur++;
            }
            x--;
            for (y = start + 1; y <= end; ++y) {
                System.out.println(String.format("res[%d][%d] = %d]", y, x, cur));
                res[y][x] = cur++;
            }
            y--;
            for (x = end - 1; x >= start; --x) {
                System.out.println(String.format("res[%d][%d] = %d]", y, x, cur));
                res[y][x] = cur++;
            }
            x++;
            for (y = end - 1; y >= start + 1; --y) {
                System.out.println(String.format("res[%d][%d] = %d]", y, x, cur));
                res[y][x] = cur++;
            }
            y++;
            start++;
            end--;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        }
        printSpiral(spiral(n));
    }


    private static void printSpiral(int[][] s) {
        int padding = (int) Math.floor(Math.log10(Math.pow(s.length, 2))) + 1;
        for (int y = 0; y < s.length; ++y) {
            for (int x = 0; x < s[y].length; ++x) {
                System.out.print(String.format("%0" + padding + "d ", s[y][x]));
            }
            System.out.println("");
        }
    }
}