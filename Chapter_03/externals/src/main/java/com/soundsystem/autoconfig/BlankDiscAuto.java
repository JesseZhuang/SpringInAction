package com.soundsystem.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class BlankDiscAuto {

    private String title;

    private String artist;

    // Spring cannot instantiate your TestController because its only constructor requires a parameter.
    // You can add a no-arg constructor or you add @Autowired annotation to the constructor:
    @Autowired
    public BlankDiscAuto (@Value("${disc.title}") String title, @Value("${disc.artist}")String artist) {
        this.title = title;
        this.artist = artist;
    }

//    public BlankDiscAuto(
//            @Value("#{systemProperties['disc.title']}") String title,
//            @Value("#{systemProperties['disc.artist']}") String artist) {
//        this.title = title;
//        this.artist = artist;
//    }

//    #{artistSelector.selectArtist()?.toUpperCase()}
//    ? ensures not null

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

}
