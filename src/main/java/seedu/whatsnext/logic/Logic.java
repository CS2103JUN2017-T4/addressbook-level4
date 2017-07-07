package seedu.whatsnext.logic;

import javafx.collections.ObservableList;
import seedu.whatsnext.logic.commands.CommandResult;
import seedu.whatsnext.logic.commands.exceptions.CommandException;
import seedu.whatsnext.logic.parser.exceptions.ParseException;
import seedu.whatsnext.model.task.BasicTaskFeatures;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /** Returns the filtered list of persons */
    ObservableList<BasicTaskFeatures> getFilteredPersonList();

}
