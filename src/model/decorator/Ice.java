
package model.decorator;

public class Ice extends CondimentCoffee {
     public Drink drink;
    public Ice(Drink c){
        this.drink=c;
        System.out.println("최종가격 : "+drink.cost());
    }
    public String getDescription(){
       return drink.getDescription()+" 얼음 추가";
    }
    public int cost(){
        return 200 + drink.cost(); 
    }
}
