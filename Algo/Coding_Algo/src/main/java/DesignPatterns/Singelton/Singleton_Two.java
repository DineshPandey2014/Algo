package DesignPatterns.Singelton;

public class Singleton_Two {
  private static Singleton_Two singleInstance = null;

  private Singleton_Two() {
    if(singleInstance != null) {
      throw new RuntimeException("Cannot create, Please use get instance");
    }
  }


  public static  Singleton_Two getInstance() {
    if(singleInstance == null) {
      synchronized (Singleton_Two.class) {
        if(singleInstance == null) {
          singleInstance = new Singleton_Two();
        }
      }
    }
    return singleInstance;
  }
}
