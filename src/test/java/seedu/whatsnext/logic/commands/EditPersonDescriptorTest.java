package seedu.whatsnext.logic.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.whatsnext.testutil.EditCommandTestUtil.DESC_AMY;
import static seedu.whatsnext.testutil.EditCommandTestUtil.DESC_BOB;
import static seedu.whatsnext.testutil.EditCommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.whatsnext.testutil.EditCommandTestUtil.VALID_EMAIL_BOB;
import static seedu.whatsnext.testutil.EditCommandTestUtil.VALID_NAME_BOB;
import static seedu.whatsnext.testutil.EditCommandTestUtil.VALID_DATE_BOB;
import static seedu.whatsnext.testutil.EditCommandTestUtil.VALID_TAG_HUSBAND;

import org.junit.Test;

import seedu.whatsnext.logic.commands.EditCommand.EditTaskDescriptor;
import seedu.whatsnext.testutil.EditTaskDescriptorBuilder;

public class EditPersonDescriptorTest {

    @Test
    public void equals() throws Exception {
        // same values -> returns true
        EditTaskDescriptor descriptorWithSameValues = new EditTaskDescriptor(DESC_AMY);
        assertTrue(DESC_AMY.equals(descriptorWithSameValues));

        // same object -> returns true
        assertTrue(DESC_AMY.equals(DESC_AMY));

        // null -> returns false
        assertFalse(DESC_AMY.equals(null));

        // different types -> returns false
        assertFalse(DESC_AMY.equals(5));

        // different values -> returns false
        assertFalse(DESC_AMY.equals(DESC_BOB));

        // different name -> returns false
        EditTaskDescriptor editedAmy = new EditTaskDescriptorBuilder(DESC_AMY).withName(VALID_NAME_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different phone -> returns false
        editedAmy = new EditTaskDescriptorBuilder(DESC_AMY).withPhone(VALID_DATE_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different email -> returns false
        editedAmy = new EditTaskDescriptorBuilder(DESC_AMY).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different address -> returns false
        editedAmy = new EditTaskDescriptorBuilder(DESC_AMY).withAddress(VALID_ADDRESS_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different tags -> returns false
        editedAmy = new EditTaskDescriptorBuilder(DESC_AMY).withTags(VALID_TAG_HUSBAND).build();
        assertFalse(DESC_AMY.equals(editedAmy));
    }
}
