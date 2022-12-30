
package model.decorator;

public class Coconut extends CondimentBubbleTea {
    public Drink drink;
    public Coconut(Drink d){
        this.drink=d;
    }
    public String getDescription(){
       return drink.getDescription()+" 코코넛 시럽 추가";
    }
    public int cost(){
        return 700 + drink.cost(); // 코코넛 시럽 추가 1번 추가가격은 700원
    }
}
