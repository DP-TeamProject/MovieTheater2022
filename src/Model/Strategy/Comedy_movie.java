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
public class Comedy_movie extends movie{
        public Comedy_movie(){
            category = new Comedy();
            age_limit = new All();
        }
}
