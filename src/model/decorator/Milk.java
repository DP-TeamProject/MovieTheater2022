
package model.decorator;

public class Milk extends CondimentCoffee {
     public Drink drink;
    public Milk(Drink c){
        this.drink=c;
        System.out.println("최종가격 : "+drink.cost());
    }
    public String getDescription(){
       return drink.getDescription()+" 우유 추가";
    }
    public int cost(){
        return 300 + drink.cost(); 
    }
}
