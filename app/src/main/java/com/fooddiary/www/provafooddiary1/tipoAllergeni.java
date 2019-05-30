package com.fooddiary.www.provafooddiary1;

import org.json.JSONObject;

public class tipoAllergeni extends JSONObject {
    boolean isGlutenFree;
    boolean isVegetariano;
    boolean isVegano;
    boolean isNichelFree;

    public tipoAllergeni(boolean glutenfree, boolean vegetariano, boolean vegano, boolean nichelfree){
        this.isGlutenFree = glutenfree;
        this.isVegetariano = vegetariano;
        this.isVegano = vegano;
        this.isNichelFree = nichelfree;
    }

    public boolean isGlutenFree(){
        return this.isGlutenFree;
    }

    public boolean isVegetariano(){
        return this.isVegetariano;
    }

    public boolean isVegano(){
        return this.isVegano;
    }

    public boolean isNichelFree(){
        return this.isNichelFree;
    }
}
