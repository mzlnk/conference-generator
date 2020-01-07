package pl.mzlnk.conferencegenerator.repository.data;

import com.google.gson.Gson;
import pl.mzlnk.conferencegenerator.model.data.Address;
import pl.mzlnk.conferencegenerator.model.data.DataType;
import pl.mzlnk.conferencegenerator.service.FileService;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static pl.mzlnk.conferencegenerator.utils.RandomUtil.r;

class AddressRepository extends BaseDataRepository<Address> {

    private static final String COUNTRIES_FILE = "address-countries.json";
    private static final String CITIES_FILE = "address-cities.json";
    private static final String STREETS_FILE = "address-streets.json";

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
        Gson gson = new Gson();

        fileService.findFile(FileService.Directory.DATA, COUNTRIES_FILE)
                .ifPresent(file -> {
                    try (FileReader fr = new FileReader(file)) {
                        this.countries = Arrays.asList(gson.fromJson(fr, String[].class));
                    } catch (IOException e) {
                        e.printStackTrace(); // todo: add log support here
                    }
                });

        fileService.findFile(FileService.Directory.DATA, CITIES_FILE)
                .ifPresent(file -> {
                    try (FileReader fr = new FileReader(file)) {
                        this.cities = Arrays.asList(gson.fromJson(fr, String[].class));
                    } catch (IOException e) {
                        e.printStackTrace(); // todo: add log support here
                    }
                });

        fileService.findFile(FileService.Directory.DATA, STREETS_FILE)
                .ifPresent(file -> {
                    try (FileReader fr = new FileReader(file)) {
                        this.streets = Arrays.asList(gson.fromJson(fr, String[].class));
                    } catch (IOException e) {
                        e.printStackTrace(); // todo: add log support here
                    }
                });
    }

}
