
package model.movie;

public class Youth implements Age_Limit {
    public String Age_Limit;
    public Youth(){
       this.Age_Limit="12세 이상 관람가";
    }
    public String getAge_Limit(){
        return this.Age_Limit;
    }
    
    
}
