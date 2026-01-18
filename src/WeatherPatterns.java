import java.util.Arrays;

/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author Zoe Sun
 */

public class WeatherPatterns {
    // Declare array to store lis at each index for memoization
    public static int[] lis;

    // DFS to find max LIS in entire temperature array
    public static int dfs(int i, int[] temperatures) {
        if (lis[i] != -1) return lis[i]; // return if already computed

        int max_len = 1; // lis always begins with length 1
        // DFS to find future days with higher temperatures like edges in graph
        for (int j = i + 1; j < temperatures.length; j++) {
            if (temperatures[j] > temperatures[i])
                // update max length of LIS found
                max_len = Math.max(max_len, 1 + dfs(j, temperatures));
        }
        // store results for memoization and return
        lis[i] = max_len;
        return lis[i];
    }

    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures) {
        // initialize lis array and ints to use to find LIS
        int n = temperatures.length, max_lis = 1;
        lis = new int[n];
        Arrays.fill(lis, -1); // LIS for index with value -1 has not been computed
        // DFS from each day (node) to find LIS that begins there and return max found
        for (int i = 0; i < n; i++) {
            max_lis = Math.max(max_lis, dfs(i, temperatures));
        }
        return max_lis;
    }

    // nonrecursive lis
    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    /*public static int longestWarmingTrend(int[] temperatures) {
        // Initialize lis array and ints to use to find LIS
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
    }*/
}
