package code_example01_static_nested_class;

import java.time.LocalDate;

public class Cat {

    private String name;
    private LocalDate birthday;
    private Breed breed;

    private Cat(String name, LocalDate birthday, Breed breed){
        this.name = name;
        this.birthday = birthday;
        this.breed = breed;
    }

    protected String getName() {
        return name;
    }

    protected LocalDate getBirthday() {
        return birthday;
    }

    protected Breed getBreed() {
        return breed;
    }

    protected static class CatBuilder {

        private String name;
        private LocalDate birthday;
        private Breed breed;

        protected static CatBuilder cat(){
            return new CatBuilder();
        }

        protected Cat build() {
            return new Cat(name, birthday, breed);
        }

        protected CatBuilder withName(String name) {
            this.name = name;
            return this;
        }

        protected CatBuilder withBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        protected CatBuilder withBreed(Breed breed) {
            this.breed = breed;
            return this;
        }
    }

}
