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
public class Action_movie extends movie{
        public Action_movie(){
            category = new Action();
            age_limit = new All();
        }
}
