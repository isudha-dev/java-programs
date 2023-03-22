package dsa.arrays;

import java.util.ArrayList;

// https://www.scaler.com/academy/mentee-dashboard/class/29819/assignment/problems/58?navref=cl_tt_nv
public class MergeIntervals {
    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();

        // for empty intervals
        if (intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }

        Interval mergedInteval = new Interval();
        boolean firstOL = false, lastOL = false;

        // find first overlapping interval
        Interval firstOverlap = new Interval();
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).end >= newInterval.start && newInterval.end >= intervals.get(i).start) {
                firstOverlap = intervals.get(i);
                firstOL = true;
                break;
            }
        }

        // find last overlapping interval
        Interval lastOverlap = new Interval();
        for (int i = intervals.size() - 1; i >= 0; i--) {
            if (intervals.get(i).end >= newInterval.start && newInterval.end >= intervals.get(i).start) {
                lastOverlap = intervals.get(i);
                lastOL = true;
                break;
            }
        }

        // creating merged interval
        if (firstOL && lastOL) {
            mergedInteval.start = Math.min(firstOverlap.start, newInterval.start);
            mergedInteval.end = Math.max(lastOverlap.end, newInterval.end);
        }

        // if we have merged interval
        if (firstOL && lastOL) {
            boolean addedMergeInteval = false;
            for (Interval i : intervals) {
                if (i.end >= mergedInteval.start && mergedInteval.end >= i.start) {
                    if (!addedMergeInteval) {
                        result.add(mergedInteval);
                        addedMergeInteval = true;
                    }
                } else {
                    result.add(i);
                }
            }
            return result;
        }

        // if newInterval is before all intervals
        if (newInterval.end < intervals.get(0).start) {
            result.add(newInterval);
            result.addAll(intervals);
            return result;
        }

        // if newInterval is after all intervals
        if (newInterval.start > intervals.get(intervals.size() - 1).end) {
            result.addAll(intervals);
            result.add(newInterval);
            return result;
        }

        // if newInterval is inbetween all intervals
        for (int i = 0; i < intervals.size(); i++) {
            if (newInterval.start > intervals.get(i).end && newInterval.end < intervals.get(i + 1).start) {
                result.add(intervals.get(i));
                result.add(newInterval);
            } else {
                result.add(intervals.get(i));
            }

        }

        return result;
    }

    public static void main(String[] args) {
        // Interval i1 = new Interval(1, 2);
        Interval i2 = new Interval(1, 2);
        Interval i3 = new Interval(3, 6);
        Interval newInterval = new Interval(8, 10);
        ArrayList<Interval> intervals = new ArrayList<>();
        // intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);

        System.out.println(insert(intervals, newInterval));

    }

}
