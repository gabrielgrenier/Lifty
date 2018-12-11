/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

/**
 *
 * @author gabri
 */
public class Avertissement {
    private final String message;
    private final String type;
    
    public Avertissement(String message, String type){
        this.message = message;
        this.type = type;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    public String getType(){
        return this.type;
    }
}
