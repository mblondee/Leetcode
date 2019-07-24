package leetcode.leetcode81_100;

/*The gray code is a binary numeral system where two successive values differ in only one bit.

        Given a non-negative integer n representing the total number of bits in the code,
        print the sequence of gray code.A gray code sequence must begin with 0.*/

import java.util.ArrayList;
import java.util.List;

public class GrayCode_89 {
    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        // given that n != 0

        result.add(0);

        // total number of elements result should have is 2^n = 1<< n
        helper(result, n, 1<<n, 0);

        return result;

    }

    private static void helper(List<Integer> result, int n, int total, int current){
        if(result.size() == total){
            return;
        }

        // try to change every element of current element (is of length n)
        for(int i = 0; i < n; i++){
            // 1 << i is 10..0 length i
            // if in spot != i there is a 0, then 0 xor 0 = 0
            // if in spot != i there is a 1, then 1 xor 0 = 1
            // hence spots != i are not changed
            // if in spot = i there is a 0, then 0 xor 1 = 1
            // if in spot = i there is a 1, then 1 xor 1 = 0
            // hence spot = i are changed
            int tryNext = current^(1 << i);
            if(result.contains(tryNext)){
                continue;
            }
            result.add(tryNext);
            helper(result, n, total, tryNext);

            // if function helper returns we need to check if we need to remove and keep looking or stop
            if(result.size() == total){
                return;
            }
            result.remove(tryNext);

        }



    }
}
