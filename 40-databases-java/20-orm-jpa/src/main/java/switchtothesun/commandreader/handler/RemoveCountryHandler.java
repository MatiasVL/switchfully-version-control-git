package switchtothesun.commandreader.handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import switchtothesun.country.CountryRepository;

import static java.lang.String.format;

@Service
public class RemoveCountryHandler implements Handler {

    private CountryRepository countryRepository;

    public RemoveCountryHandler(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public boolean canHandle(String prefix) {
        return prefix.startsWith("remove country");
    }

    @Override
    public void handle(String parameter) {
        try {
            countryRepository.delete(parameter);
            System.out.println(format("Country %s removed", parameter));
        } catch (DataIntegrityViolationException exception) {
            System.out.println(format("Could not remove country: Country %s still has connected attractions", parameter));
        }
    }
}
