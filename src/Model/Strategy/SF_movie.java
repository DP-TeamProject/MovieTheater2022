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
public class SF_movie extends movie{
        public SF_movie(){
            category = new SF();
            age_limit = new All();
        }
}
