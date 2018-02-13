package com.art2cat.dev.soundsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CDPlayerConfig.class, CDConfig.class})
//@ImportResource("classpath:/Volumes/Navis.A&C/SpingDemo/src/main/resources/spring.xml")
public class SoundSystemConfig {

}
