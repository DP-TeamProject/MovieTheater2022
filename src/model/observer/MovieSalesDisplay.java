
package model.observer;

public class MovieSalesDisplay implements observer {
    public int Movieprice=0;
    private int Moviecount=0;
    private SalesData SalesData;
    public MovieSalesDisplay(SalesData SalesData){
        this.SalesData=SalesData;
        SalesData.registerObserver(this);
    }
    public void update(int price, int the_number,String type){
        if (type=="영화") {
        Movieprice+=price;
        Moviecount+=the_number;
        display();
        }
        else {
            display();
        }
    }
    public void display(){
        System.out.print("총 영화표 매출 : ");
        System.out.println(Movieprice);
         System.out.print("총 영화표 판매량 : ");
        System.out.println(Moviecount);
       
    }
}
