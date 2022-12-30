
package model.decorator;

public class Shot extends CondimentCoffee {
     public Drink drink;
    public Shot(Drink c){
        this.drink=c;
        System.out.println("최종가격 : "+drink.cost());
    }
    public String getDescription(){
       return drink.getDescription()+" 샷 추가";
    }
    public int cost(){
        return 300 + drink.cost(); 
    }
}
