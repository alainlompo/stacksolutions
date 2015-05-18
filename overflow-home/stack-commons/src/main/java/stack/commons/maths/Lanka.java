package stack.commons.maths;

public class Lanka {
    public Lanka(Object o)
    {
        System.out.println("Obj");
    }
     public Lanka(Number o)
    {
        System.out.println("Num");
    }
      public Lanka(Integer o)
    {
        System.out.println("Int");
    }
      public static void main(String[] args) {
        new Lanka(null);
    }
}
