package com.switchfully.springdi.codelab01.v4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringSongWithLyrics {
    public static void main(String... args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        // --> Make changes here so the song lyrics are correct
        // --> + Make changes in the ApplicationConfiguration class
        String newLine = applicationContext.getBean("NewLine", String.class);
        String whoTo = applicationContext.getBean("WhoAmITalkingTo", String.class);
        String whoAbout = applicationContext.getBean(String.class);
        String whoAboutWhat = applicationContext.getBean(String.class);
        String whatAbout = applicationContext.getBean(String.class);
        // <-- End of changes

        System.out.print("Oh " + whoTo + ", won't you buy me a " + whatAbout + "?" + newLine +
                "My " + whoAbout + " all drive " + whoAboutWhat + ", I must make amends." + newLine +
                "Worked hard all my lifetime, no help from my " + whoAbout + "," + newLine +
                "So Lord, won't you buy me a " + whatAbout + "?"
        );
    }
}
