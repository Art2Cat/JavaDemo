package com.art2cat.dev.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.LinkedList;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {
    @Bean
    public CompactDisc rain() {
        BlankDisc cd = new BlankDisc();
        cd.setTitle("Rain");
        cd.setArtist("All star");
        List<String> tracks = new LinkedList<String>();
        tracks.add("Promises Under The Rain");
        tracks.add("Rhythm Of The Rain");
        tracks.add("Autumn rain");
        tracks.add("Rainight");
        tracks.add("November Rain");
        tracks.add("Through the Rain");
        tracks.add("I Can't Stop the Rain");
        tracks.add("Endless Rain");
        tracks.add("The Rain");
        cd.setTracks(tracks);
        return cd;
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }
}
