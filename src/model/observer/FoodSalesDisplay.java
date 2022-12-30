
package model.observer;

public class FoodSalesDisplay implements observer {
    public int Foodprice=0;
    private int Foodcount=0;
    private SalesData SalesData;
    public FoodSalesDisplay(SalesData SalesData){
        this.SalesData=SalesData;
        SalesData.registerObserver(this);
    }
    public void update(int price, int the_number,String type){
        if (type=="매점") {
        Foodprice+=price;
        Foodcount+=the_number;
        display();
        }
        else {
            display();
        }
    }
    public void display(){
        System.out.print("총 매점 매출 : ");
        System.out.println(Foodprice);
        System.out.print("총 매점 판매량 : ");
        System.out.println(Foodcount);
       
    }
}
