package net.larbig;


import java.util.logging.Logger;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import com.vaadin.ui.Button;

import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class GpioView extends VerticalLayout {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(RaspiXPView.class.getName());

	public GpioView() {
		setSpacing(true);
		setMargin(true);
		
		Button buttonGpio01 = new Button("Gpio on/off/pulse");
		buttonGpio01.addListener(new Button.ClickListener() {

			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				 try {
					final GpioController gpio = GpioFactory.getInstance();
					final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);
					log.info("--> GPIO state should be: ON");	
					Thread.sleep(10000);
					pin.low();
					pin.pulse(1000, true);
					log.info("--> GPIO state should be: OFF");
					gpio.shutdown();
				} catch (InterruptedException e) {
					log.severe(e.toString());
					e.printStackTrace();
				}
			}
		});
		addComponent(buttonGpio01);
		
		
		
	
		

	}
}
