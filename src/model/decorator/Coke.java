
package model.decorator;

public class Coke extends Soda{
    public Coke(){
        select = new Cokesyrup();
    }
}
