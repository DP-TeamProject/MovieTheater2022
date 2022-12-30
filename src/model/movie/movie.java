
package model.movie;

import java.time.*;

public class movie {
    public Category category;
    public Age_Limit age_limit;
    public String Title="";
    public String Director="";
    public String Time="";
    public String Actor="";
    public String Release_date;

    public String getTitle() {
        return Title;
    }

    public String getDirector() {
        return Director;
    }

    public String getTime() {
        return Time;
    }

    public String getActor() {
        return Actor;
    }
    public void setTitle(String Title){
        this.Title=Title;
    }
    public void setDirector(String Director){
        this.Director=Director;
    }
    public void setTime(String Time){
        this.Time=Time;
    }
    public void setRelease_date(String Release_date){
        this.Release_date=Release_date;
    }
    public String getRelease_date() {
        return Release_date;
    }
    public void setcategory(Category category){
        this.category=category;
    }
    public void setActor(String Actor){
        this.Actor=Actor;
    }
    public void setAge_Limit(Age_Limit age_limit){
        this.age_limit=age_limit;
    }
    public String getcategory(){
        return category.getcategory();
    }
    public String getAge_Limit(){
        return age_limit.getAge_Limit();
    }
    
}
