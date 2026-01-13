import java.util.Arrays;

/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author Zoe Sun
 */

public class WeatherPatterns {

    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures) {
        // Initialize dp array and ints to use to find LIS
        int n = temperatures.length;
        int cur_lis, max_lis = 1;
        int[] lis = new int[n];
        Arrays.fill(lis, 1); // Initialize LIS for each index to be 1 bc each int is subsequence of size 1

        // Iterate through temperatures
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Increase length of LIS at index i if value at temp[i] is greater than prev temp[j]
                if (temperatures[i] > temperatures[j]) lis[i] = Math.max(lis[i], lis[j] + 1);
            }
            // Update length of longest subsequence
            cur_lis = lis[i];
            max_lis = Math.max(max_lis, cur_lis);
        }
        return max_lis; // Return longest run
    }
}
