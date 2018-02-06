import java.util.*;
public class Recursion{
  public int fact(int n){
    if(n<0){
      throw new IllegalArgumentException();
    }
    if(n==0){
      return 1;
    }
    return n*fact(n-1);
  }
  public int fib(int n){
    return fibHelp(n,0,1);//by keeping track of the f(n-1) and f(n-2) terms as parameters we can reduce recursive calls
  }
  public int fibHelp(int k,int prev2,int prev1){
    // if
    if(k==0){
      return prev2;
    }
    if(k==1){
      return prev1;
    }
    return fibHelp(k-1,prev1,prev1+prev2);
  }

  public double sqrt(double n){
     if(n<0){
      throw new IllegalArgumentException();
    }
    double guess=2;
    return sqrtHelper(n,guess);
  }
  public boolean closeEnough(double n,double other){
    return Math.abs((((n-other)/other)*100))<=0.00000000000005;
  }
  public double sqrtHelper(double n, double  guess){
    if(n==0){
      return 0;
    }
    if(closeEnough(guess*guess,n)){
      return guess;
    }
    guess =  (n/guess+guess)/2.0;
    return sqrtHelper(n,guess);
  }
}
