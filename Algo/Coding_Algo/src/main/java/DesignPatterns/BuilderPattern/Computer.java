package DesignPatterns.BuilderPattern;

public class Computer {

  // Required Parameter
  private String ram;
  private String hdd;
  private String cpu;

  //Optional parameters.
  private boolean isGraphicsCardEnabled;
  private boolean isBlueToothEnabled;

  private Computer(Builder builder) {
    this.hdd = builder.hdd;
    this.ram = builder.ram;
    this.cpu = builder.cpu;
    this.isBlueToothEnabled = builder.isBlueToothEnabled;
    this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
  }


  public String getRam() {
    return ram;
  }

  public String getHdd() {
    return hdd;
  }

  public String getCpu() {
    return cpu;
  }

  public boolean isGraphicsCardEnabled() {
    return isGraphicsCardEnabled;
  }

  public boolean isBlueToothEnabled() {
    return isBlueToothEnabled;
  }

  public static class Builder {
    //required parameter
    private String ram;
    private String hdd;
    private String cpu;

    private boolean isGraphicsCardEnabled;
    private boolean isBlueToothEnabled;

    public Builder(String ram, String hold, String cpu) {
      this.ram = ram;
      this.hdd = hdd;
      this.cpu = cpu;
    }

    public Builder setGraphicsCardEnabled(boolean graphicsCardEnabled) {
      isGraphicsCardEnabled = graphicsCardEnabled;
      return this;
    }

    public Builder setBlueToothEnabled(boolean blueToothEnabled) {
      isBlueToothEnabled = blueToothEnabled;
      return this;
    }

    // Provide a method to give a object of computer

    Computer build() {
      return new Computer(this);
    }
  }
}
