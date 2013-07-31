package net.larbig;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.vaadin.terminal.FileResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;


import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;


public class RaspiXPView extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(RaspiXPView.class.getName());

	public RaspiXPView() {
		log.info("init labo-raspi-xp main view");
		setSpacing(true);
		setMargin(true);
		
		addComponent(new Label("Raspberry Pi eXPerimental"));
		
		final VerticalLayout vl = new VerticalLayout();
		
		final VerticalLayout vLogin = new VerticalLayout();
		final TextField user = new TextField("User :");
		final PasswordField password = new PasswordField("Passwort : ");
		final TabSheet tabs = new TabSheet();
		
		Button btLogin = new Button("Login");
		btLogin.addListener(new Button.ClickListener() {

			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				if(user.getValue().equals("hans") && password.getValue().equals("wurst")){
					vl.removeAllComponents();
					vl.addComponent(tabs);
				}
			}
		});
		
		vLogin.addComponent(user);
		vLogin.addComponent(password);
		vLogin.addComponent(btLogin);
		
		
		
		tabs.setHeight(100.0f, UNITS_PERCENTAGE);
		tabs.setWidth(100.0f, UNITS_PERCENTAGE);
//		tabs.addTab(new GpioView(), "Gpio");
		tabs.addTab(new PiFaceView(), "PiFace");
		tabs.addTab(new WebCamView(), "Webcam");
//		tabs.addTab(new MusicPlayerView(), "Music");
		tabs.addTab(new VideoPlayerView(), "Video");
		tabs.addTab(new SystemInfoView(), "System Info");

		
		
		
		vl.addComponent(vLogin);
		
		addComponent(vl);

	}

}
