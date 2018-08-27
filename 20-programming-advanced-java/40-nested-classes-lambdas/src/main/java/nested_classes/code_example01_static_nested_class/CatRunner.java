package nested_classes.code_example01_static_nested_class;

import java.time.LocalDate;

public class CatRunner {

    public static void main(String[] args) {
        Cat.CatBuilder unusedCatBuilder = Cat.CatBuilder.cat()
                .withName("Frodo")
                .withBreed(Breed.PERSIAN);

        Cat aCatInstance = Cat.CatBuilder.cat()
                .withName("Mister Mynx")
                .withBirthday(LocalDate.of(1991, 12, 31))
                .withBreed(Breed.MANX)
                .build();

        System.out.println(aCatInstance.getName());
        System.out.println(aCatInstance.getBirthday());
        System.out.println(aCatInstance.getBreed());
    }

}
