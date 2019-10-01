package DesignPatterns.Singelton;

/**
 * Ensure that a class
 * 
 */
public class Singleton_One {

  private Singleton_One() {

  }

  private static class SingleTon {
    private static Singleton_One singleObject = new Singleton_One();
  }

  public static Singleton_One getSingletonObject() {
    return SingleTon.singleObject;
  }
}
