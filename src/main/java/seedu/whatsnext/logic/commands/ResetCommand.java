package seedu.whatsnext.logic.commands;

import seedu.whatsnext.commons.core.Messages;
import seedu.whatsnext.commons.core.UnmodifiableObservableList;
import seedu.whatsnext.commons.core.index.Index;
import seedu.whatsnext.commons.exceptions.IllegalValueException;
import seedu.whatsnext.logic.commands.exceptions.CommandException;
import seedu.whatsnext.model.task.BasicTaskFeatures;
import seedu.whatsnext.model.task.DateTime;
import seedu.whatsnext.model.task.exceptions.TaskNotFoundException;

//@@author A0142675B
public class ResetCommand extends Command {

    public static final String COMMAND_WORD = "reset";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Reset the task identified by the index number used in the last task listing to floating task, \n"
            + "i.e. remove the start and end date and time"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_RESET_TASK_SUCCESS = "Reseted Task: %1$s";

    public final Index targetIndex;

    public ResetCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute() throws CommandException, IllegalValueException {
        UnmodifiableObservableList<BasicTaskFeatures> lastShownList = model.getFilteredTaskList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }

        BasicTaskFeatures taskToReset = lastShownList.get(targetIndex.getZeroBased());

        BasicTaskFeatures resetedTask = EditCommand.createNonOverlapTask(taskToReset);

        DateTime initDateTime = new DateTime();

        resetedTask.setStartDateTime(initDateTime);
        resetedTask.setEndDateTime(initDateTime);

        try {
            model.updateTask(taskToReset, resetedTask);
        } catch (TaskNotFoundException pnfe) {
            assert false : "The target task cannot be missing";
        }
        return new CommandResult(String.format(MESSAGE_RESET_TASK_SUCCESS, taskToReset));
    }

}
