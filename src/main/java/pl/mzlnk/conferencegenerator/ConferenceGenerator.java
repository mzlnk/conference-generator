package pl.mzlnk.conferencegenerator;

import pl.mzlnk.conferencegenerator.repository.entity.EntitiesRepository;
import pl.mzlnk.conferencegenerator.service.FileService;
import pl.mzlnk.conferencegenerator.service.impl.FileServiceImpl;

import static pl.mzlnk.conferencegenerator.utils.TerminalUtil.WELCOME_TITLE;

public class ConferenceGenerator {

    public static ConferenceGenerator app;

    public final FileService fileService;
    public final EntitiesRepository entitiesRepository;

    public ConferenceGenerator() {
        app = this;

        fileService = FileServiceImpl.init();
        entitiesRepository = EntitiesRepository.init();
    }

    public static void main(String[] args) {
        ConferenceGenerator generator = new ConferenceGenerator();
        generator.run();
    }

    public void run() {
        System.out.println(WELCOME_TITLE);
    }

}
