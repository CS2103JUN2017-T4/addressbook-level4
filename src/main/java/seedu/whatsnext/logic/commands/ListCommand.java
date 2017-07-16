package seedu.whatsnext.logic.commands;

import java.util.Set;

//@@author A0154986L
//@@author A0142675B
/**
 * Lists all uncompleted/ completed/ all tasks in the task manager to the user.
 * It can also list tasks by type only.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";
    public static final String LIST_INCOMPLETE = "incomplete";
    public static final String LIST_COMPLETED = "completed";
    public static final String LIST_ALL = "all";

    public static final String MESSAGE_USAGE = COMMAND_WORD + "list the tasks in the task manager.\n"
            + "To list incomplete tasks : list OR list incomplete\n"
            + "To list completed tasks : list completed\n"
            + "To list all tasks : list all";

    public static final String MESSAGE_SUCCESS_INCOMPLETE = "Listed all incomplete tasks";
    public static final String MESSAGE_SUCCESS_COMPLETED = "Listed all complete tasks";
    public static final String MESSAGE_SUCCESS_ALL = "Listed all tasks";

    private final Set<String> keywords;

    public ListCommand(Set<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public CommandResult execute() {
        if (keywords.isEmpty() || keywords.contains(LIST_INCOMPLETE)) {
            boolean isComplete = false;
            model.updateFilteredTaskListToShowByCompletion(isComplete);
            return new CommandResult(MESSAGE_SUCCESS_INCOMPLETE);
        } else if (keywords.contains(LIST_COMPLETED)) {
            boolean isComplete = true;
            model.updateFilteredTaskListToShowByCompletion(isComplete);
            return new CommandResult(MESSAGE_SUCCESS_COMPLETED);
        } else /*if (keywords.contains(LIST_ALL))*/ {
            model.updateFilteredListToShowAll();
            return new CommandResult(MESSAGE_SUCCESS_ALL);
        }
    }
}
