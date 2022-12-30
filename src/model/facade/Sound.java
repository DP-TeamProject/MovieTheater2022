package model.facade;


public class Sound {
    public boolean state=false;
  public void on() {
      this.state=true;
      System.out.println("soundon");
  }

  public void off() {
      this.state=false;
      System.out.println("soundoff");
  }
}
