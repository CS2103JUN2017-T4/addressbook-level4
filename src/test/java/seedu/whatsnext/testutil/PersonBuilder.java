//package seedu.whatsnext.testutil;
//
//import java.util.Set;
//
//import seedu.whatsnext.commons.exceptions.IllegalValueException;
//import seedu.whatsnext.model.task.Address;
//import seedu.whatsnext.model.task.Email;
//import seedu.whatsnext.model.task.Name;
//import seedu.whatsnext.model.task.Person;
//import seedu.whatsnext.model.task.Phone;
//import seedu.whatsnext.model.task.ReadOnlyPerson;
//import seedu.whatsnext.model.tag.Tag;
//import seedu.whatsnext.model.util.SampleDataUtil;
//
///**
// * A utility class to help with building Person objects.
// */
//public class PersonBuilder {
//
//    public static final String DEFAULT_NAME = "Alice Pauline";
//    public static final String DEFAULT_DATE = "85355255";
//    public static final String DEFAULT_TIME = "alice@gmail.com";
//    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
//    public static final String DEFAULT_TAGS = "friends";
//
//    private Person person;
//
//    public PersonBuilder() throws IllegalValueException {
//        Name defaultName = new Name(DEFAULT_NAME);
//        Phone defaultPhone = new Phone(DEFAULT_PHONE);
//        Email defaultEmail = new Email(DEFAULT_EMAIL);
//        Address defaultAddress = new Address(DEFAULT_ADDRESS);
//        Set<Tag> defaultTags = SampleDataUtil.getTagSet(DEFAULT_TAGS);
//        this.person = new Person(defaultName, defaultPhone, defaultEmail, defaultAddress, defaultTags);
//    }
//
//    /**
//     * Initializes the PersonBuilder with the data of {@code personToCopy}.
//     */
//    public PersonBuilder(ReadOnlyPerson personToCopy) {
//        this.person = new Person(personToCopy);
//    }
//
//    public PersonBuilder withName(String name) throws IllegalValueException {
//        this.person.setName(new Name(name));
//        return this;
//    }
//
//    public PersonBuilder withTags(String ... tags) throws IllegalValueException {
//        this.person.setTags(SampleDataUtil.getTagSet(tags));
//        return this;
//    }
//
//    public PersonBuilder withAddress(String address) throws IllegalValueException {
//        this.person.setAddress(new Address(address));
//        return this;
//    }
//
//    public PersonBuilder withPhone(String phone) throws IllegalValueException {
//        this.person.setPhone(new Phone(phone));
//        return this;
//    }
//
//    public PersonBuilder withEmail(String email) throws IllegalValueException {
//        this.person.setEmail(new Email(email));
//        return this;
//    }
//
//    public Person build() {
//        return this.person;
//    }
//
//}