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
public class Scary implements Category {
    public String category;
    public Scary(){
       this.category="공포";
    }
    public String getcategory(){
        return this.category;
    }
    
    
}
