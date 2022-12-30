
package model.observer;
import java.util.*;

public class SalesData extends subject{
    private int price;
    private int the_number;
    private String type;
    private ArrayList obserbers;
    public SalesData(){
        obserbers = new ArrayList();
    }
    public void registerObserver(observer o){
       obserbers.add(o);
    }
    public void removeObserver(observer o){
       int i=  obserbers.indexOf(o);
       if (i>=0) obserbers.remove(o);
    }
    public void notifyobserver(){
        for (int i = 0; i < obserbers.size(); i++) {
            observer observer = (observer) obserbers.get(i);
            observer.update(price,the_number,type);
        }
    }
    public void totalChanged(){
        notifyobserver();
    }
    public void settotalChanged(int price, int the_number,String type){
        this.price=price;
        this.the_number=the_number;
        this.type=type;
        totalChanged();
    }
    public int getprice(){
        return price;
    }
}
