package leetcode.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author youyinnn
 * Date 2/1/2019
 */
public class TwoSum {

    /**
     * can't handle with same value sequence like [3, 2, 3] target 6
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int max = nums[0];
        int min = max;
        // get rank
        for (int e : nums) {
            if (e > max) {
                max = e;
            }
            if (e < min) {
                min = e;
            }
        }
        // show up table
        Integer[] showUpMap = new Integer[max - min + 1];
        Integer[] indicesMap = new Integer[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            showUpMap[nums[i] - min] = 1;
            indicesMap[nums[i] - min] = i;
        }
        for (int i = 0; i < showUpMap.length; i++) {
            boolean show = showUpMap[i] == 1;
            if (show) {
                int a = i + min;
                int need = target - a;
                if (showUpMap[need - min] == 1) {
                    return new int[] {indicesMap[i], indicesMap[need - min]};
                }
            }
        }
        return null;
    }

    @Test
    public void testTwoSum1(){
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

    /**
     * too much memory needed in case like [50000000,3,2,4,50000000] target 100000000
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int max = nums[0];
        int min = max;
        // get rank
        for (int e : nums) {
            if (e > max) {
                max = e;
            }
            if (e < min) {
                min = e;
            }
        }
        // show up table
        Integer[] showUpMap = new Integer[max - min + 1];
        LinkedList[] indicesMap = new LinkedList[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            showUpMap[nums[i] - min] = 1;
            if (indicesMap[nums[i] - min] == null) {
                indicesMap[nums[i] - min] = new LinkedList<Integer>();
            }
            indicesMap[nums[i] - min].add(i);
        }
        System.out.println(Arrays.toString(showUpMap));
        System.out.println(Arrays.toString(indicesMap));
        for (int i = 0; i < showUpMap.length; i++) {
            boolean show = showUpMap[i] != null;
            if (show) {
                int a = i + min;
                int need = target - a;
                if (need - min < showUpMap.length &&
                        showUpMap[need - min] != null) {
                    int ai = (int) indicesMap[i].get(0);
                    int bi = (int) indicesMap[need - min].get(0);
                    if (ai == bi) {
                        bi = (int) indicesMap[need - min].get(1);
                    }
                    return new int[]{ai, bi};
                }
            }
        }
        return null;
    }

    @Test
    public void testTwoSum2(){
        int[] nums = {3, 2, 3};
        System.out.println(Arrays.toString(twoSum2(nums, 6)));
    }

    class Pair {
        int val;
        int index;

        @Override
        public String toString() {
            return "Pair{" +
                    "val=" + val +
                    ", index=" + index +
                    '}';
        }
    }

    private Pair[] table;

    private int hash(int key) {
        return Math.abs(key) % table.length;
    }

    private void setTable(int[] origin) {
        int rank = origin.length << 1;
        table = new Pair[rank];
        for (int i = 0; i < origin.length; i++) {
            int place = detection(origin[i], false);
            Pair pair = new Pair();
            pair.val = origin[i];
            pair.index = i;
            table[place] = pair;
        }
    }

    private int seek(int key) {
        return detection(key, true);
    }

    private int detection(int key, boolean seek) {
        int hash = hash(key);
        if (!seek && table[hash] == null) {
            return hash;
        } else if (seek && table[hash] == null) {
            return -1;
        } else if (seek && table[hash].val == key) {
            return hash;
        } else {
            int offset = 1;
            boolean after = false;
            while (hash + offset < table.length) {
                if (!seek && table[hash + offset] == null) {
                    break;
                } else if (seek && table[hash + offset] == null) {
                    return -1;
                } else if (seek && table[hash + offset].val == key) {
                    return hash + offset;
                }
                offset++;
            }
            if (hash + offset == table.length) {
                offset = 1;
                while (hash - offset >= 0) {
                    if (!seek && table[hash - offset] == null) {
                        break;
                    } else if (seek && table[hash - offset] == null) {
                        return -1;
                    } else if (seek && table[hash - offset].val == key) {
                        return hash + offset;
                    }
                    offset++;
                }
            } else {
                after = true;
            }
            return after ? hash + offset : hash - offset;
        }
    }

    public int[] twoSum3(int[] nums, int target) {
        setTable(nums);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            int seek = seek(complement);
            if (seek != -1) {
                int index = table[seek].index;
                if (index == i) {
                    if (seek + 1 < table.length) {
                        index = table[seek + 1].index;
                    } else {
                        index = table[seek - 1].index;
                    }
                }
                if (nums[index] + nums[i] == target) {
                    return new int[]{i, index};
                }
            }
        }
        return nums;
    }

    @Test
    public void testTwoSumWithHashing(){
        //int[] nums = {50000000,3,2,4,50000000};
        //System.out.println(Arrays.toString(twoSum3(nums, 100000000)));

        //int[] nums = {3, 3};
        //System.out.println(Arrays.toString(twoSum3(nums, 6)));

        //int[] nums = {2, 5, 5, 11};
        //System.out.println(Arrays.toString(twoSum3(nums, 10)));

        int[] nums = {3, 2 ,4};
        System.out.println(Arrays.toString(twoSum3(nums, 6)));
    }

    public int[] twoSum4(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length ; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        return nums;
    }

}
