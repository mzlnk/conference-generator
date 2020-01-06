package pl.mzlnk.conferencegenerator.repository.data;

import pl.mzlnk.conferencegenerator.model.data.DataType;
import pl.mzlnk.conferencegenerator.model.data.WorkshopDetails;
import pl.mzlnk.conferencegenerator.properties.ConferenceGeneratorProperties;
import pl.mzlnk.conferencegenerator.service.FileService;

import java.util.ArrayList;
import java.util.List;

import static pl.mzlnk.conferencegenerator.utils.RandomUtil.r;

class WorkshopDetailsRepository extends BaseDataRepository<WorkshopDetails> {

    private ConferenceGeneratorProperties properties;

    private List<String> names = new ArrayList<>();
    private List<String> descriptions = new ArrayList<>();

    private int namesSize = 0;
    private int descriptionsSize = 0;

    WorkshopDetailsRepository(FileService fileService, ConferenceGeneratorProperties properties) {
        super(DataType.WORKSHOP_DETAILS, fileService);

        this.properties = properties;
    }

    @Override
    protected WorkshopDetails randomEntry() {
        String name = names.get(r.nextInt(namesSize));
        String description = descriptions.get(r.nextInt(descriptionsSize));
        double price = r.nextDouble() * (properties.getWorkshopPriceMax() - properties.getWorkshopPriceMin()) + properties.getWorkshopPriceMin();
        int attendeesLimit = r.nextInt(properties.getWorkshopAttendeesLimitMax() - properties.getWorkshopAttendeesLimitMin()) + properties.getWorkshopAttendeesLimitMin();

        return new WorkshopDetails(name, description, price, attendeesLimit);
    }

    @Override
    protected void loadData(FileService fileService) {

    }

}
