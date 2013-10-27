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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> list = new ArrayList<Interval>();
        if (intervals.size() <= 1)
            return intervals;

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                int result = (i1.start > i2.start) ? 1 : -1;
                return result;
            }
        });
        Interval newInterval = intervals.get(0);
        for (Interval interval : intervals) {
            if (interval.start > newInterval.end) {
                list.add(newInterval);
                newInterval = interval;
            }
            if (intersect(newInterval, interval))
                newInterval = merge(newInterval, interval);
        }
        list.add(newInterval);
        return list;
    }

    public boolean intersect(Interval i1, Interval i2) {
        if (i1.start > i2.end || i1.end < i2.start)
            return false;
        return true;
    }

    public Interval merge(Interval i1, Interval i2) {
        return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
    }
}