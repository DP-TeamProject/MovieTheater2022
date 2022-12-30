package model.facade;


public class Beam_Projector{
    public boolean state=false;
    public void on() {
      this.state=true;
        System.out.println("beamon");
    }

    public void off() {
      this.state=false;
      System.out.println("beamoff");
    }
}
