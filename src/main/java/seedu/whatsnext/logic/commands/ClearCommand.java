package seedu.whatsnext.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.whatsnext.model.TaskManager;

/**
 * Clears the address book.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Task List has been cleared!";


    @Override
    public CommandResult execute() {
        requireNonNull(model);
        model.resetData(new TaskManager());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
