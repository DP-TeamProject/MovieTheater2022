
package model.decorator;

public class Suger_Content extends CondimentBubbleTea {
    public Drink drink;
    public Suger_Content(Drink d){
        System.out.println("실행");
        this.drink=d;
    }
    public String getDescription(){
       return drink.getDescription()+" 슈가 시럽 추가";
    }
    public int cost(){
        return 700 + drink.cost(); // 코코넛 시럽 추가 1번 추가가격은 700원
    }
}
