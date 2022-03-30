package edu.cmu.optimisticStrivers.stack;
import java.util.*;

public class WYC_496_NextGreaterElementI_easy {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];
        Map<Integer, Integer> nextMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[0]);

        for (int j = 1; j < nums2.length; j++) {
            while (!stack.isEmpty() && nums2[j] > stack.peek()) {
                int n = stack.pop();
                nextMap.put(n, nums2[j]);
            }
            stack.push(nums2[j]);
        }
        while (!stack.isEmpty()) {
            nextMap.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = nextMap.get(nums1[i]); // getOrDefault(nums1[i], -1);
        }

        return res;
    }
}
