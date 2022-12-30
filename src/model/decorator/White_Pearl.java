
package model.decorator;

public class White_Pearl extends CondimentBubbleTea {
    public Drink drink;
    public White_Pearl(Drink d){
        this.drink=d;
    }
    public String getDescription(){
       return drink.getDescription()+" 흰 색 펄 추가";
    }
    public int cost(){
        return 500 + drink.cost(); // 코코넛 시럽 추가 1번 추가가격은 700원
    }
}
