package pl.mzlnk.conferencegenerator.repository.data;

import com.google.gson.Gson;
import pl.mzlnk.conferencegenerator.model.data.ConferenceDetails;
import pl.mzlnk.conferencegenerator.model.data.DataType;
import pl.mzlnk.conferencegenerator.service.FileService;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pl.mzlnk.conferencegenerator.utils.RandomUtil.r;

class ConferenceDetailsRepository extends BaseDataRepository<ConferenceDetails> {

    private static final String NAMES_FILE = "conference-details-names.json";
    private static final String DESCRIPTIONS_FILE = "conference-details-descriptions.json";

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
        Gson gson = new Gson();

        fileService.findFile(FileService.Directory.DATA, NAMES_FILE)
                .ifPresent(file -> {
                    try (FileReader fr = new FileReader(file)) {
                        this.names = Arrays.asList(gson.fromJson(fr, String[].class));
                    } catch (IOException e) {
                        e.printStackTrace(); // todo: add log support here
                    }
                });

        fileService.findFile(FileService.Directory.DATA, DESCRIPTIONS_FILE)
                .ifPresent(file -> {
                    try (FileReader fr = new FileReader(file)) {
                        this.descriptions = Arrays.asList(gson.fromJson(fr, String[].class));
                    } catch (IOException e) {
                        e.printStackTrace(); // todo: add log support here
                    }
                });
    }

}
