/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Strategy;

/**
 *
 * @author Seongchan
 */
public class Youth implements Age_Limit {
    public String Age_Limit;
    public Youth(){
       this.Age_Limit="12세 이상 관람가";
    }
    public String getAge_Limit(){
        return this.Age_Limit;
    }
    
    
}
