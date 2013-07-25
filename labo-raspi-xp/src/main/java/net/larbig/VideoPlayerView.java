package net.larbig;

import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Video;

public class VideoPlayerView extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	public VideoPlayerView() {
		setSpacing(true);
		setMargin(true);
		addComponent(new Label("VIdeo Tab"));
		
		

		Embedded e = new Embedded(null, new ExternalResource("http://www.youtube.com/v/meXvxkn1Y_8&hl=en_US&fs=1&"));
		e.setMimeType("application/x-shockwave-flash");
		e.setParameter("allowFullScreen", "true");
		e.setWidth("320px");
		e.setHeight("265px");
		addComponent(e);
			
		Video v = new Video( "video" ); // Instantiate video player widget.
		// Specify a list of your video in one or more formats.
		// Different browsers support various different video formats.
		v.setSources( 
		    new ExternalResource( "http://www.fca.at/storage/users/2/2/video/3680/flick.mp4" )
		); 
		v.setWidth( "640px" ); // Set size of the video player's display area on-screen.
		v.setHeight( "360px" );
		addComponent( v ); // Add the component to the window or layout.
		
		
		
	}

}
