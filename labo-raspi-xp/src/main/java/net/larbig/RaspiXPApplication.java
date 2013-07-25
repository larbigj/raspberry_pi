package net.larbig;


import com.vaadin.Application;

import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class RaspiXPApplication extends Application
{
    private Window window;
   
    @Override
    public void init()
    {
        window = new Window("Labo RasPi XP");
        setMainWindow(window);

		window.addComponent(new RaspiXPView());
        
    }
    
}
