package leetcode.medium;

import leetcode.element.Interval;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author youyinnn
 * Date 3/30/2019
 */
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        return merge(intervals);
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new LinkedList<>();
        int[] ss = new int[intervals.size()];
        int[] ee = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            ss[i] = intervals.get(i).start;
            ee[i] = intervals.get(i).end;
        }
        Arrays.sort(ss);
        Arrays.sort(ee);
        int si = 0;
        int ei = 0;
        int nowStart;
        while (ei < intervals.size()) {
            nowStart = ss[si];
            while (si + 1 < intervals.size() && ee[ei] >= ss[si + 1]) {
                si++;
                ei++;
            }
            ans.add(new Interval(nowStart, ee[ei]));
            si++;
            ei++;
        }
        return ans;
    }

}
