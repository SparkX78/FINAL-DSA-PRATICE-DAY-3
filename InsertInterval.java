import java.util.Arrays;
public class InsertInterval {
    


    public static int[][] insert(int[][] intervals, int[] newInterval) {
        // Create a result array with one extra slot for the new interval
        int[][] result = new int[intervals.length + 1][2];
        int i = 0, j = 0;

        // Add all intervals that end before the new interval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result[j++] = intervals[i++];
        }

        // Merge overlapping intervals with the new interval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Add the merged interval
        result[j++] = newInterval;

        // Add remaining intervals
        while (i < intervals.length) {
            result[j++] = intervals[i++];
        }

        // Return the result trimmed to actual size
        return Arrays.copyOf(result, j);
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        
        int[][] intervals = { {1, 3}, {6, 9} };
        int[] newInterval = {2, 5};

        int[][] merged = insert(intervals, newInterval);

        System.out.println("Merged Intervals:");
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

