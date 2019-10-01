package Tree;

/*
 * Constructor chaining
 */
public class JavaInterview {
  JavaInterview() {
    this(0);
    System.out.println("1111");
  }

  JavaInterview(int x) {
    this(0,0);
    System.out.println("2222");
  }

  JavaInterview(int x, int y) {
    System.out.println("333");
  }

  public static void main(String args[]) {
    JavaInterview test = new JavaInterview();
  }
}
