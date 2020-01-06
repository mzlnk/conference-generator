package pl.mzlnk.conferencegenerator.repository.data;

import pl.mzlnk.conferencegenerator.model.data.DataType;
import pl.mzlnk.conferencegenerator.model.data.Person;
import pl.mzlnk.conferencegenerator.service.FileService;

import java.util.ArrayList;
import java.util.List;

import static pl.mzlnk.conferencegenerator.utils.RandomUtil.r;

class PersonRepository extends BaseDataRepository<Person> {

    private List<String> firstNames = new ArrayList<>();
    private List<String> lastNames = new ArrayList<>();

    private int firstNamesSize = 0;
    private int lastNamesSize = 0;

    PersonRepository(FileService fileService) {
        super(DataType.PERSON, fileService);
    }

    @Override
    protected Person randomEntry() {
        String firstName = firstNames.get(r.nextInt(firstNamesSize));
        String lastName = lastNames.get(r.nextInt(lastNamesSize));

        return new Person(firstName, lastName);
    }

    @Override
    protected void loadData(FileService fileService) {

    }

}
