
package model.decorator;

public class Pickle extends CondimentHotdog{
    public food food;
      public Pickle(food h){
        this.food=h;
        System.out.println("최종가격 : "+food.cost());
    }
      public String getDescription(){
       return food.getDescription()+" 피클 추가";
    }
    public int cost(){
        return 300 + food.cost(); 
    }
}
