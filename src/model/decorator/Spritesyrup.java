
package model.decorator;

public class Spritesyrup implements SodaTaste {
     public String taste;
    public Spritesyrup(){
        this.taste="사이다";
    }
    public String gettaste(){
        return this.taste;
    };
}
