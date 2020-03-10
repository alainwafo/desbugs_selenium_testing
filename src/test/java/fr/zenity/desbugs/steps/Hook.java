package fr.zenity.desbugs.steps;


import fr.zenity.desbugs.context.ScenarioContext;


public class Hook {

    protected ScenarioContext scenarioContext;

    public Hook(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
    }

}
