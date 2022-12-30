
package model.observer;

public class ManagerDisplay implements observer {
    public int Currentprice=0;
    private SalesData SalesData;
    public ManagerDisplay(SalesData SalesData){
        this.SalesData=SalesData;
        SalesData.registerObserver(this);
    }
    public void update(int price, int the_number,String type){
        if (type=="총합") {
        Currentprice+=price;
        display();
        }
        else {
            display();
        }
        display();
    }
    public void display(){
        System.out.print("현재 총 매출 : ");       
        System.out.println(Currentprice);
    }
}
