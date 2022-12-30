
package test;

import model.observer.*;

public class SalesDataobserver {

    public static void main(String[] args) {
        // TODO code application logic here
        SalesData sdata = new SalesData();
        ManagerDisplay f= new ManagerDisplay(sdata);
        MovieSalesDisplay m= new MovieSalesDisplay(sdata);
        FoodSalesDisplay fs= new FoodSalesDisplay(sdata);
        sdata.settotalChanged(80, 30,"매점");//실행이 되어면 1대다의 의존성에 의하여 연결된 것들이 작동을 하여 출력을 한다.
        sdata.settotalChanged(80, 3,"영화");//실행이 되어면 1대다의 의존성에 의하여 연결된 것들이 작동을 하여 출력을 한다.
        sdata.settotalChanged(80, 3,"총합");
    }
    
}
