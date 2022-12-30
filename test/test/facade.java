package test;

import model.facade.*;


public class facade {

        
    public static void main(String[] args) {
        // TODO code application logic here
        Sound sound =new Sound();

         Beam_Projector beam_Projector = new Beam_Projector();

         Light light = new Light();

         Temp temp = new Temp();
        Internal_Management facade = new Internal_Management(sound, beam_Projector,light,temp);
        facade.on();
        facade.off();
    }
}
