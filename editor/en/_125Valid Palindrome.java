//A phrase is a palindrome if, after converting all uppercase letters into 
//lowercase letters and removing all non-alphanumeric characters, it reads the same 
//forward and backward. Alphanumeric characters include letters and numbers. 
//
// Given a string s, return true if it is a palindrome, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
// 
//
// Example 2: 
//
// 
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric 
//characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s consists only of printable ASCII characters. 
// 
// Related Topics Two Pointers String 👍 3798 👎 5297


//leetcode submit region begin(Prohibit modification and deletion)
class _125Solution {
    public boolean isPalindrome(String s) {
        /**
         * 版本 1 2022-06-04 03
         */
//        String sf = s;
//        List list = new LinkedList<String>();
//        char[] ca = new char[sf.length()];
//        for(int i=0; i<sf.length(); i++){
//            if(Character.isLetterOrDigit(sf.charAt(i))){
//                list.add(String.valueOf(sf.charAt(i)));
//            }
//        }
//        System.out.println(list.toString());
//        int count = 0;
//        for(int i=0; i<list.size()/2; i++){
//            String c = (String) list.get(i);
//            if(c.equalsIgnoreCase((String) list.get(list.size()-1-i))){
//                System.out.println(c);
//                System.out.println(">"+(String) list.get(list.size()-1-i));
//                count++;
//            }
//        }
//        //System.out.println(count);
//        return count == list.size()/2;

        /**
         * 版本 1 2022-06-05 抄的答案
         * https://leetcode.cn/problems/valid-palindrome/solution/125-yan-zheng-hui-wen-chuan-by-chen-wei-apinv/
         * https://leetcode.cn/problems/valid-palindrome/solution/by-daxige-052o/
         *
         * 2022-06-18 第二次练习
         */
        if(s.isEmpty()){
            return true;
        }
        int left=0, right=s.length()-1;
        while (left < right){
            //这里要不停查找符合要求的下标的字符，所以用while和左右边界判断
//            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
//                left++;
//            }
            if(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
                continue;
            }
            //这里要不停查找符合要求的下标的字符，所以用while和左右边界判断
//            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
//                right--;
//            }
            if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
                continue;
            }
            //只要有一个不相等，就说明不是回文，返回false
            if(Character.toLowerCase(s.charAt(left))
                != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        //循环结束了都没找到，说明是回文，返回true
        return true;
    }

    public  boolean  is(String s){
        int n = s.length();
        for(int i=0;i<s.length()/2;i++)
        {
            if(s.charAt(i)!=s.charAt(n-i))
                return false;
        }
        return true;
    }
    /*
     */
}
//leetcode submit region end(Prohibit modification and deletion)
