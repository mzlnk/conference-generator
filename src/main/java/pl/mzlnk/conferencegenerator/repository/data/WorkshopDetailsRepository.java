package pl.mzlnk.conferencegenerator.repository.data;

import com.google.gson.Gson;
import pl.mzlnk.conferencegenerator.model.data.DataType;
import pl.mzlnk.conferencegenerator.model.data.WorkshopDetails;
import pl.mzlnk.conferencegenerator.properties.ConferenceGeneratorProperties;
import pl.mzlnk.conferencegenerator.service.FileService;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pl.mzlnk.conferencegenerator.utils.RandomUtil.r;

class WorkshopDetailsRepository extends BaseDataRepository<WorkshopDetails> {

    private static final String NAMES_FILE = "workshop-details-names.json";

    private ConferenceGeneratorProperties properties;

    private List<WorkshopDetails> details = new ArrayList<>();

    private int detailsSize = 0;

    WorkshopDetailsRepository(FileService fileService, ConferenceGeneratorProperties properties) {
        super(DataType.WORKSHOP_DETAILS, fileService);

        this.properties = properties;
    }

    @Override
    protected WorkshopDetails randomEntry() {
        WorkshopDetails workshop = details.get(r.nextInt(detailsSize));

        double price = r.nextDouble() * (properties.getWorkshopPriceMax() - properties.getWorkshopPriceMin()) + properties.getWorkshopPriceMin();
        int attendeesLimit = r.nextInt(properties.getWorkshopAttendeesLimitMax() - properties.getWorkshopAttendeesLimitMin()) + properties.getWorkshopAttendeesLimitMin();

        workshop.setAttendeesLimit(attendeesLimit);
        workshop.setPrice(price);

        return workshop;
    }

    @Override
    protected void loadData(FileService fileService) {
        Gson gson = new Gson();

        fileService.findFile(FileService.Directory.DATA, NAMES_FILE)
                .ifPresent(file -> {
                    try (FileReader fr = new FileReader(file)) {
                        this.details = Arrays.asList(gson.fromJson(fr, WorkshopDetails[].class));
                    } catch (IOException e) {
                        e.printStackTrace(); // todo: add log support here
                    }
                });

    }

}
