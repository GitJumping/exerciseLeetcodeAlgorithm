////You are given an integer array height of length n. There are n vertical 
//lines 
////drawn such that the two endpoints of the iᵗʰ line are (i, 0) and (i, height[
//i]).
//// 
////
//// Find two lines that together with the x-axis form a container, such that 
//the 
////container contains the most water. 
////
//// Return the maximum amount of water a container can store. 
////
//// Notice that you may not slant the container. 
////
//// 
//// Example 1: 
////
//// 
////Input: height = [1,8,6,2,5,4,8,3,7]
////Output: 49
////Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,
//8,
////3,7]. In this case, the max area of water (blue section) the container can 
////contain is 49.
//// 
////
//// Example 2: 
////
//// 
////Input: height = [1,1]
////Output: 1
//// 
////
//// 
//// Constraints: 
////
//// 
//// n == height.length 
//// 2 <= n <= 10⁵ 
//// 0 <= height[i] <= 10⁴ 
//// 
//// Related Topics Array Two Pointers Greedy 👍 17647 👎 969
//


//leetcode submit region begin(Prohibit modification and deletion)
class _11Solution {
    public int maxArea(int[] height) {

        return solution1(height);

    }

    public int solution1(int[] height){
        int max=0;
        //i的循环 [1,8,6,2,5,4,8,3,_7]
        //j的循环 [_1,8,6,2,5,4,8,3,7]
//        for(int i=0; i<height.length; i++){
        for(int i=0; i<height.length-1; i++){
//                for(int j=i+1; j< height.length-1; j++){
            //这么写，保证边界不重复
            //保证i j不重复，不会有重复的值
            for(int j=i+1; j< height.length; j++){
                    max = Math.max(max, (j-i)*Math.min(height[i], height[j]));
                }
            }
        return max;
    }

    /**
     * https://leetcode.cn/problems/container-with-most-water/solution/on-shuang-zhi-zhen-jie-fa-li-jie-zheng-que-xing-tu/
     * @param height
     * @return
     */
    public int solution2(int[] height){
        int max=0;
        for(int i=0, j=height.length-1; i < j; ){
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max, (j-i+1)*minHeight);
        }
        return max;
    }

    /**
     * 增大了空间复杂度
     * @param height
     * @return
     */
    public int solution3(int[] height){
        int max = 0;
        int minHeight = 0;
        for(int i=0,j= height.length-1; i<j; ){
            if(height[i]>height[j]){
                minHeight = height[j];
                j--;
            }else{
                minHeight = height[i];
                i++;
            }
            max = Math.max(max, minHeight * (j-i+1));
        }
        return max;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
