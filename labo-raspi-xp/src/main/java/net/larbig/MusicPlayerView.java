package net.larbig;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import java.io.File;
import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.PlugInManager;
import javax.media.format.AudioFormat;

public class MusicPlayerView extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	public MusicPlayerView() {
		setSpacing(true);
		setMargin(true);

		addComponent(new Label("Music Tab"));
		
		
		Button buttonMusic = new Button("Play Test mp3");
		buttonMusic.addListener(new Button.ClickListener() {

			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
//				Format input1 = new AudioFormat(AudioFormat.MPEGLAYER3);
//				Format input2 = new AudioFormat(AudioFormat.MPEG);
//				Format output = new AudioFormat(AudioFormat.LINEAR);
//				PlugInManager.addPlugIn(
//					"com.sun.media.codec.audio.mp3.JavaDecoder",
//					new Format[]{input1, input2},
//					new Format[]{output},
//					PlugInManager.CODEC
//				);
				try{
					Player player = Manager.createPlayer(new MediaLocator(new File("C:/Temp/beeptest.mp3").toURI().toURL()));
					player.start();
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		addComponent(buttonMusic);
		
		
		
		
	}

}
