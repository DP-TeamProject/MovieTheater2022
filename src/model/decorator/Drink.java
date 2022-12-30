
package model.decorator;

public class Drink {
    public SodaTaste select;
    public Drink(){
    }
    public String Description="";
    public String getDescription(){
        return this.Description;
    }
    public int cost(){
        System.out.println("코스트 실행");
        return 0; // 초기 값은 0으로 설정
    }
    public String gettaste(){
        return this.select.gettaste();
    }
    
}
