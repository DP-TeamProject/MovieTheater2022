package model.facade;


public class Light{
  public boolean state=false;
  public void on() {
      this.state=true;
      System.out.println("lighton");
  }

  public void off() {
      this.state=false;
      System.out.println("lightoff");
  }

}
