package fr.zenity.desbugs.context;

import fr.zenity.desbugs.Enum.Context;

import java.util.HashMap;

public class ScenarioContext {

    private HashMap<String,Object> context = new HashMap<>();

    public ScenarioContext( ){ }

    public boolean has(Context key){
        try{
            context.get(key.toString());
            return true;
        }catch (NullPointerException e){
            return false;
        }
    }

    public void set(Context key, Object value){
        context.put(key.toString(),value);
    }

    public <T>Object get(Context key) {
        return has(key) ? (T)context.get(key.toString()) : null;
    }

    public void clear( ){
        context.clear();
    }

}
