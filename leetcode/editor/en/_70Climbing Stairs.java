/**
You are climbing a staircase. It takes n steps to reach the top. 

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you 
climb to the top? 

 
 Example 1: 

 
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
 

 Example 2: 

 
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

 
 Constraints: 

 
 1 <= n <= 45 
 

 Related Topics Math Dynamic Programming Memoization 👍 13644 👎 403

*/

//leetcode submit region begin(Prohibit modification and deletion)

/**
 *  f1=1
 *  f2=2
 *  f3=f2+f1
 *  fn=f(n-1)+f(n-2)
 */
class _70Solution {
    public int climbStairs(int n) {
        //12 17
        return solution1(n);
//        return solution2(n);
    }

    /**
     * 用规律累加
     * @param n
     * @return
     */
    public int solution1(int n){
        //1，2阶，直接返回
        if(n == 1 || n == 2){
            return n;
        }
        //基数
        int i=1,j=2,k=3;
        //从第三阶开始，累加
        for(int z=3; z<=n; z++){
            k=i+j;
            i=j;
            j=k;
        }
        return k;
    }

    /**
     * 递归调用
     * @param n
     * @return
     */
    public int solution2(int n){
        //1，2阶，直接返回
        if(n < 3){
            return n;
        }
        //基数
        //int i=1,j=2,k=3;
        return solution2(n-2) + solution2(n-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
