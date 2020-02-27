import java.util.LinkedList;

class Solution {
    public String reverseWords(String s) {
        if(s==null||s.length()<=1)
            return s;
        String[] strs=s.split(" ");
        for(String string:strs)
            System.out.println(string);
        LinkedList<String> list=new LinkedList<>();
        for(String string:strs)
            list.push(string);
        StringBuilder sb=new StringBuilder();
        while(!list.isEmpty())
            sb.append(list.pop()+" ");
        
        return sb.toString().substring(0,sb.length()-1);
        
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.reverseWords("hello  "));
    }
}