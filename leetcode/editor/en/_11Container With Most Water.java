////You are given an integer array height of length n. There are n vertical 
//lines 
////drawn such that the two endpoints of the iáµÊ° line are (i, 0) and (i, height[
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
//// 2 <= n <= 10âµ 
//// 0 <= height[i] <= 10â´ 
//// 
//// Related Topics Array Two Pointers Greedy ð 17647 ð 969
//


//leetcode submit region begin(Prohibit modification and deletion)
class _11Solution {
    public int maxArea(int[] height) {

        return solution1(height);

    }

    public int solution1(int[] height){
        int max=0;
        //içå¾ªç¯ [1,8,6,2,5,4,8,3,_7]
        //jçå¾ªç¯ [_1,8,6,2,5,4,8,3,7]
//        for(int i=0; i<height.length; i++){
        for(int i=0; i<height.length-1; i++){
//                for(int j=i+1; j< height.length-1; j++){
            //è¿ä¹åï¼ä¿è¯è¾¹çä¸éå¤
            //ä¿è¯i jä¸éå¤ï¼ä¸ä¼æéå¤çå¼
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
     * å¢å¤§äºç©ºé´å¤æåº¦
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
