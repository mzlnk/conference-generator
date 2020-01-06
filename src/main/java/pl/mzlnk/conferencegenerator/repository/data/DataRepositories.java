package pl.mzlnk.conferencegenerator.repository.data;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.mzlnk.conferencegenerator.model.data.DataType;
import pl.mzlnk.conferencegenerator.properties.ConferenceGeneratorProperties;
import pl.mzlnk.conferencegenerator.service.FileService;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DataRepositories {

    public static DataRepositories init(FileService fileService, ConferenceGeneratorProperties properties) {
        DataRepositories repositories = new DataRepositories();

        repositories.registerRepository(new PersonRepository(fileService));
        repositories.registerRepository(new AddressRepository(fileService));
        repositories.registerRepository(new ConferenceDetailsRepository(fileService));
        repositories.registerRepository(new WorkshopDetailsRepository(fileService, properties));

        return repositories;
    }

    private Map<DataType, DataRepository<?>> repositories = new HashMap<>();

    public DataRepository<?> getRepository(DataType dataType) {
        return repositories.get(dataType);
    }

    private void registerRepository(DataRepository<?> repository) {
        repositories.put(repository.getDataType(), repository);
    }

}
