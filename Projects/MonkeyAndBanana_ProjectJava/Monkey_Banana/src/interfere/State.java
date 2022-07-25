/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfere;

/**
 *
 * @author ADMIN
 */
public class State {
    public boolean hasStick, hasChair, hasBanana;
    private boolean pick, climb, push;

    public State() {
        this.climb = this.pick = this.push =false;
        this.hasBanana = this.hasChair = this.hasStick = false;
    }
    
    public boolean isHasStick() {
        return hasStick;
    }

    public void setHasStick(boolean hasStick) {
        this.hasStick = hasStick;
    }

    public boolean isHasChair() {
        return hasChair;
    }

    public void setHasChair(boolean hasChair) {
        this.hasChair = hasChair;
    }

    public boolean isHasBanana() {
        return hasBanana;
    }

    public void setHasBanana(boolean hasBanana) {
        this.hasBanana = hasBanana;
    }

    public boolean isPick() {
        return pick;
    }

    public void setPick(boolean pick) {
        this.pick = pick;
    }

    public boolean isClimb() {
        return climb;
    }

    public void setClimb(boolean climb) {
        this.climb = climb;
    }

    public boolean isPush() {
        return push;
    }

    public void setPush(boolean push) {
        this.push = push;
    }
    
    public void move(){
        
    }
    
    public boolean pushChair(){
        if(!this.hasChair){
            System.out.println("The monkey doesn't have the chair");
            return false;
        }else if(isClimb()){
            System.out.println("Monkey is on the chair");
            boolean getOff = Utils.askQuiz("Do you want to get off the chair?\n"
                                         + "Press \"s\" to Get Off\n"
                                         + "Press \"c\" to Cancel", "p", "c");
            getOff = true;
            //if(!getOff)return false;
            setClimb(getOff);
            System.out.println("Monkey gets off the chair");
        }
        if(!isPush()){
            return this.push = Utils.askQuiz("Do you want to push the chair?\n"
                                            + "Press \"p\" to Push\n"
                                            + "Press \"c\" to Cancel", "p", "c");
        }
        System.out.println("Monkey has already push that chair");
        return true;
    }
    
    public boolean pushChair(boolean tmp){
        if(!this.hasChair){
            System.out.println("The monkey doesn't have the chair");
            return false;
        }else if(isClimb()){
            System.out.println("Monkey is on the chair");
            boolean getOff = true;
            if(!getOff)return false;
            setClimb(getOff);
            System.out.println("Monkey gets off the chair");
        }
        if(!isPush()){
            return this.push = tmp;
        }
        System.out.println("Monkey has already push that chair");
        return true;
    }
    
    public boolean useStick(){
        if(!this.hasStick){
            System.out.println("The monkey doesn't have Stick");
            return false;
        }
        boolean wave = Utils.askQuiz("Do you want to wave the Stick?\n"
                                   + "Press \"p\" to Wave\n"
                                   + "Press \"c\" to Cancel", "p", "c");
        if(wave){
            System.out.println("The monkey waves the Stick");
            return true;
        }
        return false;
    }
    
    public boolean useStick(boolean tmp){
        if(!this.hasStick){
            System.out.println("The monkey doesn't have Stick");
            return false;
        }
        boolean wave = tmp;
        if(wave){
            System.out.println("The monkey waves the Stick");
            return true;
        }
        return false;
    }
    
    public boolean pickup(){
        if(!hasStick){
            return this.pick = Utils.askQuiz("Do you want to pick the Stick?\n"
                                    + "Press \"p\" to Pick\n"
                                    + "Press \"c\" to Cancel", "p", "c");
        }
        System.out.println("Monkey has already had the Stick");
        return true;
    }
    
    public boolean pickup(boolean tmp){
        if(!hasStick){
            return this.pick = tmp;
        }
        System.out.println("Monkey has already had the Stick");
        return true;
    }
    
    public boolean climbChair(){
        if(!this.hasChair){
            System.out.println("Monkey doesn't have the chair");
            return false;
        }
        this.setClimb(Utils.askQuiz("Do you want to climb the Chair?\n"
                                    + "Press \"p\" to Climb\n"
                                    + "Press \"c\" to Cancel", "p", "c"));
        return this.isClimb();
    }
    
    public boolean climbChair(boolean tmp){
        if(!this.hasChair){
            System.out.println("Monkey doesn't have the chair");
            return false;
        }
        this.setClimb(tmp);
        return this.isClimb();
    }
}
