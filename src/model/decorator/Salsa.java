
package model.decorator;

public class Salsa extends CondimentNacho {
    
    public food food;
      public Salsa(food n){
        this.food=n;
        System.out.println("최종가격 : "+food.cost());
    }
       public String getDescription(){
       return food.getDescription()+" 살사소스 추가";
    }
    public int cost(){
        return 500 + food.cost(); 
    }
}
