package net.larbig;


import java.util.logging.Logger;

import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;


import com.vaadin.ui.VerticalLayout;


public class RaspiXPView extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(RaspiXPView.class.getName());

	public RaspiXPView() {
		log.info("init labo-raspi-xp main view");
		setSpacing(true);
		setMargin(true);
		
		addComponent(new Label("Raspberry Pi eXPerimental"));
		
		TabSheet tabs = new TabSheet();
		tabs.setHeight(100.0f, UNITS_PERCENTAGE);
		tabs.setWidth(100.0f, UNITS_PERCENTAGE);
		
		tabs.addTab(new PiFaceView(), "PiFace");
		tabs.addTab(new WebCamView(), "Webcam");
//		tabs.addTab(new MusicPlayerView(), "Music");
		tabs.addTab(new VideoPlayerView(), "Video");
		tabs.addTab(new SystemInfoView(), "System Info");

		addComponent(tabs);

	}

}
