package FunctionalProgramming.Model;

import java.util.UUID;

/**
 * Created by brahim on 5/8/17.
 */

public class Person {

    private UUID id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String adresse;
    private String phoneNumber;
    private String email;

    public Person(){
        this.id =  UUID.randomUUID();
    }

    public Person(String firstName, String lastName, Integer age, String adresse, String phoneNumber, String email) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.adresse = adresse;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Person(String firstName) {
        this() ;
        this.firstName = firstName;

    }

    public Person(String firstName, String lastName, String adresse) {
        this.firstName  = firstName;
        this.lastName = lastName;
        this.adresse = adresse;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
      return firstName+", "+lastName+", "+age+" "+phoneNumber+", "+email;
    }
}
