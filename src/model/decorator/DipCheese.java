
package model.decorator;

public class DipCheese extends CondimentNacho{
     public food food;
      public DipCheese(food n){
        this.food=n;
        System.out.println("최종가격 : "+food.cost());
    }
     public String getDescription(){
       return food.getDescription()+" 딥치즈 추가";
    }
    public int cost(){
        return 500 + food.cost(); 
    }
}
