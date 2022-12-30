
package model.decorator;

public class Sausage extends CondimentHotdog {
    public food food;
      public Sausage(food h){
        this.food=h;
        System.out.println("최종가격 : "+food.cost());
    }
      public String getDescription(){
       return food.getDescription()+" 소시지 추가";
    }
    public int cost(){
        return 1000 + food.cost(); 
    }
}
