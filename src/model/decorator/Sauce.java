
package model.decorator;

public class Sauce extends CondimentHotdog {
    public food food;
      public Sauce(food h){
        this.food=h;
        System.out.println("최종가격 : "+food.cost());
    }
      public String getDescription(){
       return food.getDescription()+" 소스 추가";
    }
    public int cost(){
        return 500 + food.cost(); 
    }
}
