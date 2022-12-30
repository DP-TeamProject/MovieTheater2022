package model.facade;


public class Temp{
  public int temp=30;
  public boolean state=false;
  public void on() {
      this.state=true;
      System.out.println("tmpon");
  }

  public void off() {
      this.state=false;
      System.out.println("tmpoff");
  }
  public void SetTemp(int temp) {
      this.temp=temp;
  }
}
