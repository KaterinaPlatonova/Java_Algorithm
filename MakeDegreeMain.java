package geekBrains;

public class MakeDegreeMain {

    public static void main(String[] args) {
        System.out.println("The result is " + makeDegree(5, 4));
    }

    public static int makeDegree(int a, int b) {
        if (b == 1) {
            return a;
        }
        return a * makeDegree(a, b - 1);
    }
}
