class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stck=new Stack<>();

        for(String token:tokens){
            if(isOperator(token)){
                int b=stck.pop();
                int a=stck.pop();
                int res=applyOperator(token,a,b);
                stck.push(res);
            }else {stck.push(Integer.parseInt(token));}
        }
        return stck.pop();
    }
    public boolean isOperator(String token){
        return token.equals("+") ||token.equals("-") ||token.equals("*") ||token.equals("/") ;
    }
    public int applyOperator(String operator, int a, int b){
        switch (operator){
            case ("+"): return a+b;
            case ("-"): return a-b;
            case ("*"): return a*b;
            case ("/"): return a/b;
            default : throw new  IllegalArgumentException("Invalid operator");
        }
    }
}