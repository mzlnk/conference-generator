package pl.mzlnk.conferencegenerator;

import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.entity.attendee.Attendee;
import pl.mzlnk.conferencegenerator.repository.EntityRepository;
import pl.mzlnk.conferencegenerator.repository.impl.EntitiesRepository;

import static pl.mzlnk.conferencegenerator.utils.TerminalUtil.WELCOME_TITLE;

public class ConferenceGenerator {

    public static ConferenceGenerator app;

    public EntitiesRepository entitiesRepository;

    public ConferenceGenerator() {
        app = this;

        entitiesRepository = EntitiesRepository.init();
    }

    public static void main(String[] args) {
        ConferenceGenerator generator = new ConferenceGenerator();
        generator.run();

        EntityRepository<Attendee> repository = generator.entitiesRepository.getRepository(EntityType.ATTENDEE);
    }

    public void run() {
        System.out.println(WELCOME_TITLE);
    }

}
