
package model.decorator;

public class Pearl extends CondimentBubbleTea {
    public Drink drink;
    public Pearl(Drink d){
        this.drink=d;
        System.out.println("최종가격 : "+drink.cost());
    }
    public String getDescription(){
       return drink.getDescription()+" 펄 추가";
    }
    public int cost(){
        return 500 + drink.cost(); // 코코넛 시럽 추가 1번 추가가격은 700원
    }
    
}
