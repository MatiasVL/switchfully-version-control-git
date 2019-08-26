package switchtothesun.commandreader.handler;

import org.springframework.stereotype.Service;
import switchtothesun.attraction.AttractionRepository;

@Service
public class FindAttractionsInCountryHandler implements Handler {

    private AttractionRepository attractionRepository;

    public FindAttractionsInCountryHandler(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }
    @Override
    public boolean canHandle(String prefix) {
        return prefix.startsWith("find attractions in");
    }

    @Override
    public void handle(String parameter) {
        System.out.println("Finding attractions in country " + parameter);
        attractionRepository.findAttractionsInCountry(parameter).forEach(System.out::println);
    }
}
