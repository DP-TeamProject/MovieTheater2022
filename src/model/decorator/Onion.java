
package model.decorator;

public class Onion extends CondimentHotdog {
    public food food;
      public Onion(food h){
        this.food=h;
        System.out.println("최종가격 : "+food.cost());
    }
      public String getDescription(){
       return food.getDescription()+" 양파 추가";
    }
    public int cost(){
        return 400 + food.cost(); 
    }
}
