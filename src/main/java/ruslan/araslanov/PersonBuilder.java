package ruslan.araslanov;

public class PersonBuilder {
    private String name;
    private String surname;
    private Integer age;
    private String address;

    public PersonBuilder setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым или null");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Фамилия не может быть пустой или равана null");
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(Integer age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным или больше 120 лет");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Поля фамилия и имя обязательны для заполнения!");
        }
        Person person;
        if (age != null) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }
        person.setAddress(address);
        return person;
    }
}
