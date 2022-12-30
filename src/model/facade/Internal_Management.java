package model.facade;


public class Internal_Management {
  public Sound sound;

  public Beam_Projector beam_Projector;

  public Light light;
  
  public Temp temp;

  public Internal_Management( Sound sound, Beam_Projector beam_Projector, Light light, Temp temp){
      this.sound=sound;
      this.temp=temp;
      this.light=light;
      this.beam_Projector=beam_Projector;
  }
  
  public void on() {
      sound.on();
      temp.on();
      light.on();
      beam_Projector.on();
  }
  public void off() {
      sound.off();
      temp.off();
      light.off();
      beam_Projector.off();
  }
}
