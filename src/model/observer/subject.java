
package model.observer;

public  class subject {
    observer observers;
    
    public void registerObserver(observer o){
        System.out.println("옵저버 추가");
    }
    public void removeObserver(observer o){
       System.out.println("옵저버 제거");
    }
    public void notifyobserver(){
            System.out.println("옵저버 알림");
    }
}
