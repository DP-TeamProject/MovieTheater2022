
package model.decorator;

public class Soda extends Drink {
    public String getDescription(String Description){
        return this.Description+=Description;
    }
}
