
package model.movie;

public class Adult implements Age_Limit {
    public String Age_Limit;
    public Adult(){
       this.Age_Limit="19세 이상 관람가";
    }
    public String getAge_Limit(){
        return this.Age_Limit;
    }
    
    
}
