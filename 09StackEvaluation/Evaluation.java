import java.util.*;
public class Evaluation{
    private static int isOperator(String s){
        String[] operators={"+","-","*","/","%"};
		for(int i=0;i<operators.length;i++){
            if(s.equals(operators[i])){
                return i;
            }
        }
        return -1;
    }
    public static double eval(String str){
        Stack<Double> S= new Stack<>();
        int lastSpace=0;
        for(int j=0;j<str.length();j++){
            if(j==str.length()-1||str.substring(j,j+1).equals(" ")){
                int i=0;
                if(lastSpace==str.length()-1){
                    i=isOperator(str.substring(lastSpace,j+1));       
                }  
                else{
                    i=isOperator(str.substring(lastSpace,j));
                }    
                if(i>=0){
                    double arg0=S.pop();
                    double arg1=S.pop();
                    double result=0;
                    if(i==0){
                        result=arg0+arg1;
                    }
                    if(i==1){
                        result=arg1-arg0;
                    }
                    if(i==2){
                        result=arg0*arg1;
                    }
                    if(i==3){
                        result=arg1/arg0;
                    }
                    if(i==4){
                        result=arg1%arg0;
                    }
                    S.push(result);
                    lastSpace=j+1;
                }
                else{
                    S.push(Double.parseDouble(str.substring(lastSpace,j)));
                    lastSpace=j+1;
                }
            }
        }
		return S.pop();
    }
    public static void main(String[] arg){
        System.out.println(Evaluation.eval("10 2.0 +"));
        System.out.println(Evaluation.eval("11 3 - 4 + 2.5 *"));
        System.out.println(Evaluation.eval("8 2 + 99 9 - * 2 + 9 -"));
    }
    
}
