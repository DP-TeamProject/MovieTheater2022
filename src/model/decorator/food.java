
package model.decorator;

public class food {
    public choiceTaste select;
    public String Description="";
    public String getDescription(String Description){
        return this.Description+=Description;
    }
    public String getDescription (){
        return Description;
    }
    public int cost(){
        return 0; // 초기 값은 0으로 설정
    }
    public String gettaste(){
        return this.select.gettaste(); // 초기 값은 0으로 설정
    }
}
