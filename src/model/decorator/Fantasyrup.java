
package model.decorator;

public class Fantasyrup implements SodaTaste {
    public String taste;
    public Fantasyrup(){
        this.taste="환타";
    }
    public String gettaste(){
        return this.taste;
    };
}
