package algorithm;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author youyinnn
 * Date 2/26/2019
 */
public class ShortestDistanceOfTwoPointInSet {

    class Point {
        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private double distanceOfTwoPoint(Point a, Point b) {
        if (a == null || b == null) {
            return Double.MAX_VALUE;
        }
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    @Test
    public void testDistanceOfTwoPoint(){
        Point a = new Point(0, 0);
        Point b = new Point(3, 4);
        assertEquals(distanceOfTwoPoint(a, b), 5.0f, 0f);
    }

    public Point[] shortestDistance(Point[] set) {
        Point[] ans = new Point[2];
        double get = Double.MAX_VALUE;
        for (Point a : set) {
            for (Point b : set) {
                double tmp = distanceOfTwoPoint(a, b);
                if (tmp < get && a != b) {
                    get = tmp;
                    ans[0] = a;
                    ans[1] = b;
                }
            }
        }
        return ans;
    }

    private Point[] set = {
            new Point(0, 0),
            new Point(0.5, 2),
            new Point(1, 1),
            //new Point(1, 3),
            //new Point(1, 5),
            //new Point(1, 7),
            new Point(-0.5, 2),
            new Point(-1, 1),
            //new Point(-1, 3),
            //new Point(-1, 5),
            //new Point(-1, 7),
    };

    @Test
    public void testSolution1(){
        System.out.println(Arrays.toString(shortestDistance(set)));
    }

    public Point[] sortByX(Point[] set) {
        for (int i = 0; i < set.length - 1; i++) {
            int heapLength = set.length - i;
            int lastParentIndex = (heapLength - 2) / 2;
            for (int j = lastParentIndex; j >= 0; j--) {
                int leftChildIndex = j * 2 + 1;
                int rightChildIndex = leftChildIndex + 1;
                int bigIndex = leftChildIndex;
                if (rightChildIndex < heapLength
                        && set[rightChildIndex].x > set[leftChildIndex].x) {
                    bigIndex = rightChildIndex;
                }
                if (set[bigIndex].x > set[j].x) {
                    swap(set, bigIndex, j);
                }
            }
            swap(set, 0, heapLength - 1);
        }
        return set;
    }

    private void swap(Point[] set, int a, int b) {
        Point tmp = set[a];
        set[a] = set[b];
        set[b] = tmp;
    }

    @Test
    public void testSortByX(){
        for (Point point : sortByX(set)) {
            System.out.println(point);
        }
    }

    public Point[] shortestInThree(Point[] set) {
        Point[] ans = new Point[2];
        double da = distanceOfTwoPoint(set[0], set[1]);
        double db = distanceOfTwoPoint(set[0], set[2]);
        double dc = distanceOfTwoPoint(set[1], set[2]);
        if (da <= db && da <= dc) {
            ans[0] = set[0];
            ans[1] = set[1];
        } else if (db <= da && db <= dc) {
            ans[0] = set[0];
            ans[1] = set[2];
        } else {
            ans[0] = set[0];
            ans[1] = set[2];
        }
        return ans;
    }

    public Point[] shortestDistance2(Point[] set, int start, int end) {
        Point[] ans = new Point[2];
        int length = end - start + 1;
        if (length == 1) {
            ans[0] = set[start];
        } else if (length == 2) {
            ans[0] = set[start];
            ans[1] = set[end];
        } else if (length == 3) {
            return shortestInThree(set);
        } else {
            int mid = (length / 2) + start;
            Point[] leftAns = shortestDistance2(set, start, mid);
            Point[] rightAns = shortestDistance2(set, mid + 1, end);
            double ld = Double.MAX_VALUE, rd = Double.MAX_VALUE;
            if (leftAns.length == 2) {
                ld = distanceOfTwoPoint(leftAns[0], leftAns[1]);
            }
            if (rightAns.length == 2) {
                rd = distanceOfTwoPoint(rightAns[0], rightAns[1]);
            }
            double dis = Math.min(ld, rd);
            Point midP = set[mid];
            double midAnsD = Double.MAX_VALUE;
            for (int i = start; i <= end && set[i].x <= midP.x; i++) {
                Point pl = set[i];
                if (pl.x >= midP.x - dis) {
                    for (int j = mid, count = 0;
                         j <= end && count < 6 && set[j].x <= midP.x + dis;
                         j++, count++) {
                        Point pr = set[j];
                        double tmp = distanceOfTwoPoint(pl, pr);
                        if (tmp < dis && tmp != 0) {
                            ans[0] = pl;
                            ans[1] = pr;
                            midAnsD = tmp;
                        }
                    }
                }
            }
            if (midAnsD <= dis) {
                return ans;
            } else if (ld <= rd) {
                return leftAns;
            } else {
                return rightAns;
            }
        }
        return ans;
    }

    @Test
    public void testSolution2(){
        Point[] points = sortByX(set);
        System.out.println(Arrays.toString(points));
        System.out.println(Arrays.toString(shortestDistance2(points, 0, set.length - 1)));
    }

}
