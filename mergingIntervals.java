import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergingIntervals {
    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int intervalStart = intervals[0][0];
        int intervalEnd = intervals[0][1];
        
        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals){
            if (interval[0] <= intervalEnd){
                intervalEnd = Math.max(intervalEnd, interval[1]);
            }
            else{
                res.add(new int[]{intervalStart, intervalEnd});
                intervalStart = interval[0];
                intervalEnd = interval[1];
            }
        }
        res.add(new int[]{intervalStart, intervalEnd});
        return res.toArray(new int[res.size()][]);
        
    }

    public static void main(String[] args) {
        int[][] intervals1 = new int[][]{
            {91111,94133},
            {91111,91111},
            {94200,94299},
            {94230,94699}
        };
        System.out.println(Arrays.deepToString(
            mergeIntervals(intervals1)
        ));
        
        int[][] intervals2 = new int[][]{
            {1,3},
            {1,4},
            {4,9}
        };
        System.out.println(Arrays.deepToString(
            mergeIntervals(intervals2)
        ));

        int[][] intervals3 = new int[][]{
            {1,3},
            {1,2},
            {3,3}
        };
        System.out.println(Arrays.deepToString(
            mergeIntervals(intervals3)
        ));


    }
}
