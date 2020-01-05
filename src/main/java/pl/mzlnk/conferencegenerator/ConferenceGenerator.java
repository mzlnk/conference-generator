package pl.mzlnk.conferencegenerator;

import static pl.mzlnk.conferencegenerator.utils.TerminalUtil.WELCOME_TITLE;

public class ConferenceGenerator {

    public static ConferenceGenerator app;

    public ConferenceGenerator() {
        app = this;
    }

    public static void main(String[] args) {
        ConferenceGenerator generator = new ConferenceGenerator();
        generator.run();
    }

    public void run() {
        System.out.println(WELCOME_TITLE);
    }

}
