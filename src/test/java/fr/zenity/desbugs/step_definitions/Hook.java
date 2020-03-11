package fr.zenity.desbugs.step_definitions;


import fr.zenity.desbugs.context.ScenarioContext;


public class Hook {

    protected ScenarioContext scenarioContext;

    public Hook(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
    }

}
