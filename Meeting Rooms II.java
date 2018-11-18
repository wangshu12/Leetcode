/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int len = intervals.length;
        if(len == 0) return 0;
        int[] start_array = new int[len];
        int[] end_array = new int[len];
        int count = 0;
        int max_count = 0;
        for(int i = 0; i < len; i++){
            start_array[i] = intervals[i].start;
            end_array[i] = intervals[i].end;
        }
        Arrays.sort(start_array);
        Arrays.sort(end_array);
        
        int j = 0;
        for(int i = 0; i < len; i ++){
            if(start_array[i] < end_array[j]){
                count++;
            }else{
                max_count = Math.max(count, max_count);
                while(j < len && start_array[i] >= end_array[j]){
                    count--;
                    j++;
                }
                count++;
            }
        }
        return Math.max(count, max_count);
    }
}