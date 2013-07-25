package net.larbig;


import java.io.File;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


public class SystemInfoView extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	public SystemInfoView() {
		setSpacing(true);
		setMargin(true);
		
		String nameOS = "os.name";  
		  String versionOS = "os.version";  
		  String architectureOS = "os.arch";
		addComponent(new Label("Name of the OS: " + System.getProperty(nameOS)));
		addComponent(new Label("Version of the OS: " + System.getProperty(versionOS)));
		addComponent(new Label("Architecture of THe OS: " + System.getProperty(architectureOS)));
		addComponent(new Label(""));


		addComponent(new Label("Free memory (bytes): " +  Runtime.getRuntime().freeMemory()));
		
		long maxMemory = Runtime.getRuntime().maxMemory();
		addComponent(new Label("Maximum memory (bytes): " +  (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory)));
		
		addComponent(new Label("Total memory (bytes): " +   Runtime.getRuntime().totalMemory()));
		
		
		/* Get a list of all filesystem roots on this system */
	    File[] roots = File.listRoots();

	    /* For each filesystem root, print some info */
	    for (File root : roots) {
	    	addComponent(new Label("File system root: " + root.getAbsolutePath()));
	    	addComponent(new Label("Total space (bytes): " + root.getTotalSpace()));
	    	addComponent(new Label("Free space (bytes): " + root.getFreeSpace()));
	    	addComponent(new Label("Usable space (bytes): " + root.getUsableSpace()));
	    }
		
		
		
		
		
		
		
		
		
		
	}

}
