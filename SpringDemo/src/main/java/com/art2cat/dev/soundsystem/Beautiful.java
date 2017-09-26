package com.art2cat.dev.soundsystem;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("sheIsBeautiful")
@Profile("test")
public class Beautiful implements CompactDisc {

    private String title = "She is beautiful";
    private String artist = "Badhoven";

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

    public void playTrack(int trackNumber) {

    }
}
