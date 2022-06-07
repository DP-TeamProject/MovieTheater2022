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
public class Action implements Category {
    public String category;
    public Action(){
       this.category="액션";
    }
    public String getcategory(){
        return this.category;
    }
    
    
}
