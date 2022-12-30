
package test;

import model.movie.*;

public class strategy {
    public static void main(String[] args){
        movie m = new Action_movie();
        System.out.println(m.getcategory());
        System.out.println(m.getAge_Limit());
        m.setAge_Limit(new Adult());
        System.out.println(m.getAge_Limit());

    }   
}
