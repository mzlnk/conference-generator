package pl.mzlnk.conferencegenerator.repository.data;

import pl.mzlnk.conferencegenerator.model.data.Address;
import pl.mzlnk.conferencegenerator.model.data.DataType;
import pl.mzlnk.conferencegenerator.service.FileService;

import java.util.ArrayList;
import java.util.List;

import static pl.mzlnk.conferencegenerator.utils.RandomUtil.r;

class AddressRepository extends BaseDataRepository<Address> {

    private static final int MIN_STREET_NUMBER = 1;
    private static final int MAX_STREET_NUMBER = 1000;

    private List<String> countries = new ArrayList<>();
    private List<String> cities = new ArrayList<>();
    private List<String> streets = new ArrayList<>();

    private int countriesSize = 0;
    private int citiesSize = 0;
    private int streetsSize = 0;

    AddressRepository(FileService fileService) {
        super(DataType.ADDRESS, fileService);
    }

    @Override
    protected Address randomEntry() {
        String country = countries.get(r.nextInt(countriesSize));
        String city = cities.get(r.nextInt(citiesSize));
        String street = streets.get(r.nextInt(streetsSize));
        int streetNumber = r.nextInt(MAX_STREET_NUMBER - MIN_STREET_NUMBER) + MIN_STREET_NUMBER;

        return new Address(country, city, street, streetNumber);
    }

    @Override
    protected void loadData(FileService fileService) {

    }

}
