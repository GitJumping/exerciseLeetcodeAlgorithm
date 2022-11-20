import java.util.HashMap;

/**
Given an array of integers nums and an integer target, return indices of the 
two numbers such that they add up to target. 

 You may assume that each input would have exactly one solution, and you may 
not use the same element twice. 

 You can return the answer in any order. 

 
 Example 1: 

 
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 

 Example 2: 

 
Input: nums = [3,2,4], target = 6
Output: [1,2]
 

 Example 3: 

 
Input: nums = [3,3], target = 6
Output: [0,1]
 

 
 Constraints: 

 
 2 <= nums.length <= 10⁴ 
 -10⁹ <= nums[i] <= 10⁹ 
 -10⁹ <= target <= 10⁹ 
 Only one valid answer exists. 
 

 
Follow-up: Can you come up with an algorithm that is less than 
O(n²) time complexity?

 Related Topics Array Hash Table 👍 36858 👎 1173

*/

//leetcode submit region begin(Prohibit modification and deletion)
class _1Solution {
    public int[] twoSum(int[] nums, int target) {
//        return solution1(nums, target);
        return solution2(nums, target);
    }

    public int[] solution1(int[] nums, int target){
        int[] a = new int[2];
        int length = nums.length;
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(target-nums[i] == nums[j]){
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        return new int[0];
    }

    public int[] solution2(int[] nums, int target){
        int[] a = new int[2];
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            if(hash.containsKey(nums[i])){
                a[0] = hash.get(nums[i]);
                a[1] = i;
                return a;
            }
            hash.put(target-nums[i], i);
        }
        return a;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
