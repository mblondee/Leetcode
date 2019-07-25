package leetcode.leetcode201_220;

/*Given an array of integers, find out whether there are two distinct indices i and j
        in the array such that the absolute difference between nums[i] and nums[j]
        is at most t and the absolute difference between i and j is at most k.*/


import java.util.TreeSet;

public class ContainsDuplicateIII_220 {

    // subset method in TreeSet O(log n)

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if( nums.length <= 1 || k < 0 || t < 0){
            return false;
        }

        // we are only keeping the last k indices in the set (difference cannot be more)
        TreeSet<Long> set  = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            // we are looking for values in range [min, max]
            long min = (long) nums[i] - t;
            long max = (long) nums[i] + t;

            if(!set.subSet(min, true, max, true).isEmpty()){
                return true;
            }
            set.add((long) nums[i]);

            if(i >= k){
                set.remove( (long) nums[i-k]);
            }

        }
        return false;
    }





/*    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if( k < 0 || t < 0){
            return false;
        }

        // x = 0,1,2 -> bucket 0 (x/3)
        // x = 3,4,5 -> bucket 1 (x/3)


        // update: will remap everything to positive numbers!
        // for negative numbers we need to make some adjustments
        // eg x = -1 x/3 = 0 and we have already used this bucket
        // x = -1, -2 -> bucket -1 (x-3)/3   (-1-3)/3 = -4/3 = -1, (-2-3)/3 = -5/3 = -1
        // x = -3,-4,-5 -> bucket -2  (-3-3)/3 = -6/3 = -2, (-4-3)/3 = -7/3 = -2, (-5-3)/3 = -8/3 = -2;

        // if|x-y| < t, then either they are in the same bucket, or at most one apart


        // for every bucket we keep the last index seen so far
        HashMap<Long, Long> bucketToIndex = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            // remap number
            long remap = (long) nums[i] + Integer.MAX_VALUE;
            long currentBucket =  getBucket(nums[i], t);
            // we have already seen this bucket -> we know values are at most t apart -> still have to check indices
            if(bucketToIndex.containsKey(currentBucket) && i - bucketToIndex.get(currentBucket) <= k){
                return true;
            }
            //we have already seen bucket -1 -> have to check indices and values
            if(bucketToIndex.containsKey(currentBucket-1) && i - bucketToIndex.get(currentBucket-1) <= k
                    && Math.abs((long) nums[i] - nums[bucketToIndex.get(currentBucket-1)]) <= t) {
                return true;
            }
            //we have already seen bucket +1 -> have to check indices and values
            if(bucketToIndex.containsKey(currentBucket+1) && i - bucketToIndex.get(currentBucket+1) <= k
                    && Math.abs((long) nums[i] - nums[bucketToIndex.get(currentBucket+1)]) <= t) {
                return true;
            }
            else{
                bucketToIndex.put(currentBucket, i);
            }

        }
        return false;

    }

    private static long getBucket(long value, int t){
        if(t == 0){
            return value;
        }
        else{
            return value/t;
        }
*//*        if(value >= 0){
            return value/t;
        }
        else{
            return (value-t)/t;
        }*//*
    }*/
}
