package net.larbig;

import java.io.IOException;
import java.util.logging.Logger;

import org.vaadin.teemu.switchui.Switch;

import com.pi4j.device.piface.PiFace;
import com.pi4j.device.piface.PiFaceLed;
import com.pi4j.device.piface.PiFaceRelay;
import com.pi4j.device.piface.impl.PiFaceDevice;
import com.pi4j.wiringpi.Spi;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class PiFaceView extends VerticalLayout {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(RaspiXPView.class.getName());

	public PiFaceView() {
		setSpacing(true);
		setMargin(true);
		
		Switch switchK0 = new Switch("Relais K0");
		switchK0.addListener(new Property.ValueChangeListener() {

			private static final long serialVersionUID = 1L;

			public void valueChange(ValueChangeEvent event) {

				try {

					PiFace piface = new PiFaceDevice(PiFace.DEFAULT_ADDRESS, Spi.CHANNEL_0);

					boolean value = (Boolean) event.getProperty().getValue();
					if (value) {
						log.info("[SWITCH S1 PRESSED ] Turn RELAY-K0 <ON>");

						piface.getRelay(PiFaceRelay.K0).close();
					} else {
						log.info("[SWITCH S1 RELEASED] Turn RELAY-K0 <OFF>");
						piface.getRelay(PiFaceRelay.K0).open();

					}
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		});
		switchK0.setImmediate(true);

		Switch switchK1 = new Switch("Relais K1");
		switchK1.addListener(new Property.ValueChangeListener() {

			private static final long serialVersionUID = 1L;

			public void valueChange(ValueChangeEvent event) {

				try {
					PiFace piface = new PiFaceDevice(PiFace.DEFAULT_ADDRESS, Spi.CHANNEL_0);

					boolean value = (Boolean) event.getProperty().getValue();
					if (value) {
						log.info("[SWITCH S2 PRESSED ] Turn RELAY-K1 <ON>");

						piface.getRelay(PiFaceRelay.K1).close();
					} else {
						log.info("[SWITCH S2 RELEASED] Turn RELAY-K1 <OFF>");

						piface.getRelay(PiFaceRelay.K1).open();

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		switchK1.setImmediate(true);

		Switch switchLED0 = new Switch("LED0");
		switchLED0.addListener(new Property.ValueChangeListener() {

			private static final long serialVersionUID = 1L;

			public void valueChange(ValueChangeEvent event) {

				try {

					PiFace piface = new PiFaceDevice(PiFace.DEFAULT_ADDRESS, Spi.CHANNEL_0);

					boolean value = (Boolean) event.getProperty().getValue();
					if (value) {
						log.info("[SWITCH LED0 PRESSED ] Turn LED0 <ON>");

						piface.getLed(PiFaceLed.LED0).on();
					} else {
						log.info("[SWITCH LED0 RELEASED] Turn LED0 <OFF>");
						piface.getLed(PiFaceLed.LED0).off();

					}
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		});
		switchLED0.setImmediate(true);

		addComponent(switchK0);
		addComponent(switchK1);

		addComponent(switchLED0);

	}
}
