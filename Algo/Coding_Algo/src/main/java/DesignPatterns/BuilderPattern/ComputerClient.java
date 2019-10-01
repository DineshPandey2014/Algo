package DesignPatterns.BuilderPattern;

public class ComputerClient {
  public static void main(String args[]) {
    Computer comp = new Computer.Builder("2GB", "2TB", "Intel i7").build();

    //Enabling graphics card.
    Computer comp1 = new Computer.Builder("2GB", "2TB", "Intel i7").setBlueToothEnabled(true).build();
  }
}
