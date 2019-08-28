package switchtothesun.commandreader.handler;

import org.springframework.stereotype.Service;
import switchtothesun.attraction.AttractionRepository;
import switchtothesun.country.CountryRepository;
import switchtothesun.metadata.MetadataRepository;

@Service
public class ReportHandler implements Handler {

    private AttractionRepository attractionRepository;
    private CountryRepository countryRepository;
    private MetadataRepository metadataRepository;

    public ReportHandler(AttractionRepository attractionRepository, CountryRepository countryRepository, MetadataRepository metadataRepository) {
        this.attractionRepository = attractionRepository;
        this.countryRepository = countryRepository;
        this.metadataRepository = metadataRepository;
    }

    @Override
    public boolean canHandle(String prefix) {
        return prefix.startsWith("report");
    }

    public void handle(String parameter) {
        System.out.println("Printing out report");
        System.out.println("*******************");

        System.out.println("Attractions: ");
        System.out.println("-------------");
        attractionRepository.getAllAttractions().forEach(System.out::println);
        System.out.println("-------------");

        System.out.println("Countries: ");
        System.out.println("-------------");
        countryRepository.getAllCountries().forEach(System.out::println);
        System.out.println("-------------");

        metadataRepository.increaseNumberOfVisitsByOne();
        System.out.println("Times report has been created (including this one): " + metadataRepository.getNumberOfVisits());

    }

}
