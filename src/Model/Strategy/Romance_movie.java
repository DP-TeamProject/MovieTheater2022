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
public class Romance_movie extends movie{
        public Romance_movie(){
            category = new Romance();
            age_limit = new All();
        }
}
