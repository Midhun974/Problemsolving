class Solution {
    public String clearDigits(String s) {
        Stack<Character>stk=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int ch=c-'0';
            if(ch>=0 && ch<=9){
                stk.pop();
            }
            else{
                stk.push(c);
            }
        }
        StringBuilder sb=new StringBuilder("");
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}