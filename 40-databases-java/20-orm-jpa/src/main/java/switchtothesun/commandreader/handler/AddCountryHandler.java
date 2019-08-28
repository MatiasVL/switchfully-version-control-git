package switchtothesun.commandreader.handler;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import switchtothesun.country.CountryRepository;

import static java.lang.String.format;

@Service
public class AddCountryHandler implements Handler {

    private CountryRepository countryRepository;

    public AddCountryHandler(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public boolean canHandle(String prefix) {
        return prefix.startsWith("add country");
    }

    @Override
    public void handle(String parameter) {
        try{
            countryRepository.addCountry(parameter);
            System.out.println(format("Country %s added", parameter));
        } catch (DuplicateKeyException exception) {
            System.out.println(format("Could not add country: Country %s already exists", parameter));
        }
    }
}
