package leetcode.leetcode921_940;

/*Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points,
        with sides parallel to the x and y axes.

        If there isn't any rectangle, return 0.*/

// using hashmap O(n^2) time complexity

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MinimumAreaRectangle_939 {
    public static int minAreaRect(int[][] points) {
        if(points.length < 4){
            return 0;
        }
        // for every x coordinate in points we're going to save all the corresponding y-coordinates
        // O(n)
        HashMap<Integer, Set<Integer>> yCoord = new HashMap<>();
        for(int[] point : points){
            if(! yCoord.containsKey(point[0])){
                yCoord.put(point[0], new HashSet<>());
            }
            yCoord.get(point[0]).add(point[1]);
        }

        int minArea = Integer.MAX_VALUE;
        // find diagonal
        // O(n^2)
        for(int[] point1 : points){
            for(int[] point2: points){
                // x and y coordinate have to be different
                if(point1[0] == point2[0] || point1[1] == point2[1]){
                    continue;
                }

                // possible diagonal
                // yCoord.get(point1[0]) -> all ycoord with same xcoord as point1
                // is there one that has same ycoord as point2? : then we have a third point for the rectangle
                // does yCoord.get(point1[0]) contain point2[1]
                // and vice versa does yCoord.get(point2[0]) contain point1[1]
                if(yCoord.get(point1[0]).contains(point2[1]) &&  yCoord.get(point2[0]).contains(point1[1])){
                    // we have found a rectangle with diagonal point1-point2
                    // base: point1[0] - point2[0]
                    // height: point1[1] - point2[1]
                    minArea = Math.min(minArea,
                            Math.abs(point1[0] - point2[0]) * Math.abs(point1[1] - point2[1]));
                }



            }
        }

        if(minArea == Integer.MAX_VALUE){
            return 0;
        }


        return minArea;

    }
}
