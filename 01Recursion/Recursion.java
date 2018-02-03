public class Recursion{
  public int fact(int n){
    return 0;
  }
  public int fib(int n){
    return 0;
  }
  public double sqrt(double n){
    return 0;
  }
  public static void main(String[] arg){
    Recursion recur=new Recursion();
    //tests for factorial
    System.out.println(recur.fact(0));//expecting 1
    System.out.println(recur.fact(-1));//expecting exception
    System.out.println(recur.fact(2));//expecting 2
    System.out.println(recur.fact(6));//expecting 720
    System.out.println(recur.fact(10));//expecting 3628800

    //tests for fib
    System.out.println(recur.fib(0));// expecting 0
    System.out.println(recur.fib(-4));// expecting exception
    System.out.println(recur.fib(4));// expecting 3
    System.out.println(recur.fib(30));//expecting 832040

    //tests for sqrt
    System.out.println(recur.sqrt(0));//expecting 0.0
    System.out.println(recur.sqrt(-4));//expecting exception
    System.out.println(recur.sqrt(1));//expecting 1.0
    System.out.println(recur.sqrt(2));//expecting 1.4
    System.out.println(recur.sqrt(196));//expecting 14.0
    System.out.println(recur.sqrt(236));//expecting 15.3
  }
}
