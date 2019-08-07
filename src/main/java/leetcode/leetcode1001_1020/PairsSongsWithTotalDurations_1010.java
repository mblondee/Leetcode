package leetcode.leetcode1001_1020;

/*In a list of songs, the i-th song has a duration of time[i] seconds.

        Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
        Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.*/

public class PairsSongsWithTotalDurations_1010 {
    public int numPairsDivisibleBy60(int[] time) {

        // x % 60 = m, y % 60 = k => x = 60i + m, y = 60j + k
        // => x+y = 60(i+j) + m+k
        // if m+k = 60, then x + y % 60 = 0

        // #(pairs %60==0) = sum_i #(t, t%60 == i) * #(t, t%60 = 60-i)

        // special cases i = 0, i = 30: we need to find all pairs in these sets
        // this is combination of 2 out of n C(n,2) = n! /(2! (n-2)!) = n(n-1)/2

        // #(pairs %60==0) = sum_{i = 1}^29 #(t, t%60 == i) * #(t, t%60 = 60-i) +
        // #(t, t%60 == 0) * (#(t, t%60 == 0)-1)/2 + #(t, t%60 == 30) * (#(t, t%60 == 30)-1)/2

        int[] count = new int[60];

        for(int i = 0; i < time.length; i++){
            count[time[i] % 60]++;
        }

        int result = 0;

        result += count[0] * (count[0] -1)/2;
        result += count[30] * (count[30]-1)/2;

        for(int i = 1; i <= 29; i++){
            result += count[i] * count[60 - i];
        }


        return result;
    }
}
