
package model.decorator;

public class Popcorn extends food {
    private int cost =0;
    public String getDescription(String Description){
        return this.Description+=Description;
    }   
}
