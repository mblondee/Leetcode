package leetcode.leetcode921_940;

/*Given a set of points in the xy-plane, determine the minimum area of any rectangle formed from these points,
        with sides not necessarily parallel to the x and y axes.

        If there isn't any rectangle, return 0.*/

import java.util.*;

public class MinimumAreaRectangleII_940 {
    public static double minAreaFreeRect(int[][] points) {
        if(points.length < 4){
            return 0;
        }
        double minArea = Double.MAX_VALUE;


        // diagonals of a rectangle intersect in mid point of both lines
        // and they are of equal length

        // for every length that we find we save the corresponding diagonals in a list


        HashMap<Double , List<int[][]>> diagonals = new HashMap<>();

        for(int i = 0; i < points.length; i++){
            for(int j = i+1; j < points.length; j++){
                double length = length(points[i], points[j]);
                if(!diagonals.containsKey(length)){
                    diagonals.put(length, new ArrayList<>());
                }
                diagonals.get(length).add(new int[][]{points[i], points[j]});

            }
        }

        // we now look for keys (length) that have more than 1 and see we can find pairs with the same length
        for(double length : diagonals.keySet()){
            List<int[][]> currentLength = diagonals.get(length);
            if(currentLength.size() <= 1){
                continue;
            }
            for(int i = 0; i < currentLength.size(); i++){
                int[][] points1 = currentLength.get(i);
                for(int k = i+1; k < currentLength.size(); k++){
                    int[][] points2 = currentLength.get(k);
                    if(points1[0] == points2[0] || points1[0] == points2[1]
                    || points1[1] == points2[0] || points1[1] == points2[1]){
                        continue;
                    }
                    double[] midPoint1 = midPoint(points1[0], points1[1]);
                    double[] midPoint2 = midPoint(points2[0], points2[1]);
                    if(midPoint1[0] == midPoint2[0] && midPoint1[1] == midPoint2[1]){
                        // we have found a rectangle!
                        // base: length(points1[0],points2[0])
                        // height: length(points1[1],points2[0]
                        minArea = Math.min(minArea,
                                length(points1[0],points2[0]) * length(points1[1],points2[0])
                                );
                    }
                }
            }

        }




        if(minArea == Double.MAX_VALUE){
            return 0;
        }
        return minArea;

    }

    private static double length(int[] point1, int[] point2){
        return Math.sqrt((point2[1]-point1[1])*(point2[1]-point1[1]) + (point2[0]-point1[0])*(point2[0]-point1[0]));
    }

    private static double[] midPoint(int[] point1, int[] point2){
        return new double[]{point1[0] + (point2[0] - point1[0])/2.0, point1[1] + (point2[1] - point1[1])/2.0};
    }
}
