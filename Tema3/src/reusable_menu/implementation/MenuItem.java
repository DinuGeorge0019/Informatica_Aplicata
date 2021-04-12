package reusable_menu.implementation;

import reusable_menu.abstractions.IMenuItem;
import reusable_menu.abstractions.*;


public class MenuItem implements IMenuItem{
    private final String text ;
    private final int shortCut ;
    private final IExecutableAction actionToExecute ;
    
    
	public MenuItem(String text, int shortCut, IExecutableAction actionToAction) {
		this.text = text;
		this.shortCut = shortCut;
		this.actionToExecute = actionToAction;
	}
	
	
	public IExecutableAction getActionToExecute() {
		return actionToExecute;
	}
	
	@Override
	public String getText()
    {
		return this.text;
    }
	
	@Override
    public int getShortCut()
    {
    	return this.shortCut;
    }
	
	@Override
    public void render()
    {
        System.out.println(shortCut + ". " + text);
    }
	
	@Override
    public void execute()
    {
        if(actionToExecute != null)
        {
            actionToExecute.execute(new Object[]{this});
        }
    }
	
	
}
