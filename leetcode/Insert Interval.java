/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> list = new ArrayList<Interval>();

        boolean ADD = false;
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start)
                list.add(interval);
            if (interval.start > newInterval.end) {
                if (!ADD) {
                    list.add(newInterval);
                    ADD = true;
                }
                list.add(interval);
            }
            if (intersect(newInterval, interval))
                newInterval = merge(newInterval, interval);
        }
        if (!ADD)
            list.add(newInterval);
        return list;
    }

    public boolean intersect(Interval interval_1, Interval interval_2) {
        if (interval_1.end < interval_2.start || interval_1.start > interval_2.end)
            return false;
        return true;
    }

    public Interval merge(Interval interval_1, Interval interval_2) {
        return new Interval(Math.min(interval_1.start, interval_2.start), Math.max(interval_1.end, interval_2.end));
    }
}