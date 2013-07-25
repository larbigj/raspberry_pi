package net.larbig;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.vaadin.terminal.FileResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class WebCamView extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	public WebCamView() {
		
		setSpacing(true);
		setMargin(true);
		// ############ camera
				// http://webcam-capture.sarxos.pl/#examples

				final VerticalLayout imgLayout = new VerticalLayout();

				Button buttonCamera = new Button("Photo");
				buttonCamera.addListener(new Button.ClickListener() {

					private static final long serialVersionUID = 1L;

					public void buttonClick(ClickEvent event) {
						Webcam webcam = Webcam.getDefault();
						webcam.setViewSize(WebcamResolution.VGA.getSize());
				
						webcam.open();
						
						BufferedImage image = webcam.getImage();
						try {

							String imgPath = "/opt/"+System.currentTimeMillis()+".png";
				
							ImageIO.write(image, "PNG", new File(imgPath));
							FileResource resource =  new FileResource(new File(imgPath), getApplication());
							Embedded imagePic = new Embedded("RasPiCam " + imgPath , resource);
							imagePic.setType(Embedded.TYPE_IMAGE);
							imagePic.setWidth("90%");
							imgLayout.removeAllComponents();
							imgLayout.addComponent(imagePic);
					
						} catch (IOException e) {
							e.printStackTrace();
						}
						webcam.close();
					}
				});
				addComponent(buttonCamera);
				addComponent(imgLayout);
				
	}

}
