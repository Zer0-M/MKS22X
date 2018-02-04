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
    return 0;
  }
  public int fibHelp(int k){
    if(k<2){
      return k;
    }
    return fibHelp(k-2)+fibHelp(k-1);
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
  public static void main(String[] arg){
    Recursion recur=new Recursion();/*
    //tests for factorial
    System.out.println(recur.fact(0));//expecting 1
    //System.out.println(recur.fact(-1));//expecting exception
    System.out.println(recur.fact(2));//expecting 2
    System.out.println(recur.fact(6));//expecting 720
    System.out.println(recur.fact(10));//expecting 3628800

    //tests for fib
    System.out.println(recur.fib(0));// expecting 0
    //System.out.println(recur.fib(-4));// expecting exception
    for(int n=0;n<50;n++){
      long startTime   = System.currentTimeMillis();
      System.out.println(recur.fibHelp(n));// expecting 3
      long endTime   = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);
    }

    System.out.println(recur.fib(5));//expecting 832040
    */
    //tests for sqrt
    for(double d=0.0;d<10000;d+=1.0){
      if(Math.sqrt(d)!=recur.sqrt(d)){
        System.out.println(recur.closeEnough(Math.sqrt(d),recur.sqrt(d)));
        System.out.println(Math.sqrt(d)+" vs. "+recur.sqrt(d));
      }
    }
    System.out.println("\nPerfect Squares");
    for(double n=0.0;n<100;n+=1.0){
      double d=n*n;
      if(Math.sqrt(d)!=recur.sqrt(d)){
        System.out.println(recur.closeEnough(Math.sqrt(d),recur.sqrt(d)));
        System.out.println(Math.sqrt(d)+" vs. "+recur.sqrt(d));
      }
    }
  }
}
