import java.util.Arrays;

/**
Given an integer array nums, move all 0's to the end of it while maintaining 
the relative order of the non-zero elements. 

 Note that you must do this in-place without making a copy of the array. 

 
 Example 1: 
 Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
 
 Example 2: 
 Input: nums = [0]
Output: [0]
 
 
 Constraints: 

 
 1 <= nums.length <= 10⁴ 
 -2³¹ <= nums[i] <= 2³¹ - 1 
 

 
Follow up: Could you minimize the total number of operations done?

 Related Topics Array Two Pointers 👍 10381 👎 261

*/

//leetcode submit region begin(Prohibit modification and deletion)
class _283Solution {
    public void moveZeroes(int[] nums) {
        int length = 0;
        if (nums == null || (length = nums.length) == 0) {
            return;
        }

        /**
         * solution1 solution2 题解
         * https://leetcode.cn/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
         */
        solution2(nums);
    }

    public static void main(String[] args) {
        _283Solution solution = new _283Solution();
        solution.moveZeroes(new int[]{0,1,0,3,12});
    }

    public void solution1(int[] nums){
        int j=0;
        int tempNum;
        for(int i=0; i< nums.length; i++){
            if(nums[i] != 0 ){
                tempNum = nums[i];
                nums[i] = nums[j];
                nums[j] = tempNum;
                j++;
                System.out.print("j->"+nums[j]);
            }
            System.out.println(Arrays.toString(nums));
        }
    }

    public void solution2(int[] nums){
        int j=0;
        for(int i=0; i< nums.length; i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                /*
                 i != j 这个表达式比较难理解
                 当循环完成后，j表示不等于0的数字个数，如果碰到有i开始不等于j的，意思是下标应该是为0的数字
                 在循环过程中，如果j与i相等时，说明遇到的数字都是不等于0的
                 如果循环中碰到有j不等于i的时候，说明i遇到数字为0的元素下标了，i累加遇到不为0的数字，继续复制给j，然后因为这个时候i != j，所以标记这个i为0
                 在后续对比中，j始终代表不为0的数，所以走完流程，只需要下标不相同的时候改为0就好

                 没啥说的，背下来这种思路吧
                 */
                if(i != j){
                    nums[i] = 0;
                }
                System.out.print("i->"+i+" j->"+j);
                j++;
            }
            System.out.println(Arrays.toString(nums));
        }
    }

    public void solution3(int[] nums){
        int j=0;
        for(int i=0;i<nums.length;i++){
            //不是0 i和j一起后移 同时交换i和j
            //如果nums[i]=0 此时j指向的就是0
            if(nums[i]!=0){
                if(nums[j]==0){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j++;
            }
        }
    }

    public void solution4(int[] nums){
        int j=0;
        for(int i=0;i<nums.length;i++){
            //不是0 i和j一起后移 同时交换i和j
            //如果nums[i]=0 此时j指向的就是0
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
