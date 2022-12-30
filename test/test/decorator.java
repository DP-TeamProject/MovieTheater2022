
package test;

import model.decorator.*;

public class decorator {

    public static void main(String[] args) {
        food Nacho = new Nacho();
        Nacho = new Pickle(Nacho); 
        Nacho = new Pickle(Nacho);        
        System.out.println(Nacho.getDescription());
        food Hotdog = new HotDog();
        Hotdog = new Onion(Hotdog);
        Hotdog = new Pickle(Hotdog);
        Hotdog = new Salsa(Hotdog);
        System.out.println(Hotdog.getDescription());
        Drink b = new Coffee();
        b = new Ice(b);
        b = new Shot(b);
        b = new Milk(b);
        System.out.println(b.getDescription());

    }
}
