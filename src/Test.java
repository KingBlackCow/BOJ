

public class Test {
    private static int modify(int k){
        k+=10;
        return k;
    }
    public static void main(String[] args) {
       int j=89;
       switch (j/10){
           case 10:
           case 9:
               System.out.print("A");
           case 8:
               System.out.print("B");
           case 7:
               System.out.print("C");
           default:
               System.out.print("F");
       }
//        modify(k);
//        System.out.println(k);

    }
}
