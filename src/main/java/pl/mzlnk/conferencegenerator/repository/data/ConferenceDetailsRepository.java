package pl.mzlnk.conferencegenerator.repository.data;

import pl.mzlnk.conferencegenerator.model.data.ConferenceDetails;
import pl.mzlnk.conferencegenerator.model.data.DataType;
import pl.mzlnk.conferencegenerator.service.FileService;

import java.util.ArrayList;
import java.util.List;

import static pl.mzlnk.conferencegenerator.utils.RandomUtil.r;

class ConferenceDetailsRepository extends BaseDataRepository<ConferenceDetails> {

    private List<String> names = new ArrayList<>();
    private List<String> descriptions = new ArrayList<>();

    private int namesSize = 0;
    private int descriptionsSize = 0;

    ConferenceDetailsRepository(FileService fileService) {
        super(DataType.CONFERENCE_DETAILS, fileService);
    }

    @Override
    protected ConferenceDetails randomEntry() {
        String name = names.get(r.nextInt(namesSize));
        String description = descriptions.get(r.nextInt(descriptionsSize));

        return new ConferenceDetails(name, description);
    }

    @Override
    protected void loadData(FileService fileService) {

    }

}
