package seedu.whatsnext.commons.events.model;

import seedu.whatsnext.commons.events.BaseEvent;
import seedu.whatsnext.model.ReadOnlyTaskManager;

/** Indicates the AddressBook in the model has changed*/
public class AddressBookChangedEvent extends BaseEvent {

    public final ReadOnlyTaskManager data;

    public AddressBookChangedEvent(ReadOnlyTaskManager data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "number of persons " + data.getPersonList().size() + ", number of tags " + data.getTagList().size();
    }
}
