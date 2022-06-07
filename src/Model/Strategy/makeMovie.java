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
public class makeMovie {
    public static void main(String[] args){
        movie m = new SF_movie();
        System.out.println(m.getcategory());
        System.out.println(m.getAge_Limit());
        m.setAge_Limit(new Adult());
        System.out.println(m.getAge_Limit());
        
        
        
        
        /*movie a = new Action_movie();
        movie b = new Romance_movie();
        movie c = new Comedy_movie();
        movie d = new Scary_movie();*/
        
    }   
}
