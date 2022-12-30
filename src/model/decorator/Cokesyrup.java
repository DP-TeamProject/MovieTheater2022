
package model.decorator;

public class Cokesyrup implements SodaTaste{
     public String taste;
    public Cokesyrup(){
        this.taste="콜라";
    }
    public String gettaste(){
        return this.taste;
    };
}
