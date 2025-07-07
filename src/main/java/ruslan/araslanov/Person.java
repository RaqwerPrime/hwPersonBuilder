package ruslan.araslanov;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OptionalInt getAge() {
        return age == null ? OptionalInt.empty() : OptionalInt.of(age);
    }


    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    public boolean hasAge() {
        return age != null;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname).setAddress(this.address);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(surname, person.surname)
                && Objects.equals(age, person.age) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ").append(surname);
        if (age != null) {
            sb.append(", возраст: ").append(age);
        }
        if (address != null) {
            sb.append(", адрес: ").append(address);
        }
        return sb.toString();
    }
}