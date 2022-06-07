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
public class Romance implements Category {
    public String category;
    public Romance(){
       this.category="로맨스";
    }
    public String getcategory(){
        return this.category;
    }
    
    
}
