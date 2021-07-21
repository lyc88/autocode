package com.letcode;

import cn.hutool.json.JSONUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lyc
 * @date 2021/7/14 16:07
 */
public class Test01 {

    public static void main(String[] args) {
        int[] s = {2,7,11,15 };
        int target = 9;
        int[] twoSum = twoSum(s, target);
        int[] twoSum02 = twoSum02(s, target);
        int[] twoSum03 = twoSum03(s, target);
        //System.out.println(JSONUtil.toJsonStr(twoSum));
        //System.out.println(JSONUtil.toJsonStr(twoSum02));
        System.out.println(JSONUtil.toJsonStr(twoSum03));
    }

    /**
     * 简单两层循环
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                int num2 = nums[j];
                if(target == num2+num){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }


    /**
     * 利用 map 降低 时间复杂度  空间换时间
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum02(int[] nums, int target) {
        int[] result = new int[2];
        Map map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int s = target-num;
            if(map.get(s) != null){
                result[0] = i;
                result[1] = (int) map.get(s);
                return result;
            }
            map.put(num,i);

        }
        return result;
    }


    public static int[] twoSum03(int[] nums, int target) {
        int[] result = new int[2];
        Map map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        //先有序
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];

        int r = target - mid;

        if(r == 0){
            if(map.get(0) != null)
            result[0] = (int) map.get(mid);
            result[1] = (int) map.get(0);
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int s = target-num;
                if(map.get(s) != null){
                    result[0] = (int) map.get(num);
                    result[1] = (int) map.get(s);
                    return result;
                }
        }
        return result;
    }
}
