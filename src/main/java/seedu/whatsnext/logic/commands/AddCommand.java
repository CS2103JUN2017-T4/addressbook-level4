package seedu.whatsnext.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.whatsnext.logic.parser.CliSyntax.PREFIX_END_DATETIME;
import static seedu.whatsnext.logic.parser.CliSyntax.PREFIX_START_DATETIME;
import static seedu.whatsnext.logic.parser.CliSyntax.PREFIX_TAG_CLI;

<<<<<<< HEAD
import seedu.whatsnext.commons.core.EventsCenter;
import seedu.whatsnext.commons.core.index.Index;
import seedu.whatsnext.commons.events.ui.JumpToListRequestEvent;
=======
import seedu.whatsnext.commons.core.UnmodifiableObservableList;
>>>>>>> 35f1e675ef2b668aa82ad56fcded82ac28b939ce
import seedu.whatsnext.commons.exceptions.IllegalValueException;
import seedu.whatsnext.logic.commands.exceptions.CommandException;
import seedu.whatsnext.model.task.BasicTask;
import seedu.whatsnext.model.task.BasicTaskFeatures;
import seedu.whatsnext.model.task.exceptions.DuplicateTaskException;


/**
 * Adds a task to the task manager.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a task to the task manager. "
            + "Parameters: "
            + "Submit assignment "
            + PREFIX_START_DATETIME + "Monday 10AM "
            + PREFIX_END_DATETIME + "Friday 10AM "
            + PREFIX_TAG_CLI + " high";

    public static final String MESSAGE_SUCCESS = "New task added: %1$s";
    public static final String MESSAGE_DUPLICATE_TASK = "This task already exists in the task manager";
    public static final String INVALID_TASK_CREATED = "Invalid Task Format";
    public static final String MESSAGE_OVERLAP_TASK = "This Task causes an overlapping Event Task.";
    private BasicTask toAdd;

    /**
     * Creates an AddCommand to add the specified {@code ReadOnlyPerson}
     */
    public AddCommand(BasicTaskFeatures task) {
        toAdd = new BasicTask(task);
    }

    //@@author A0156106M
    @Override
    public CommandResult execute() throws CommandException, IllegalValueException {
        requireNonNull(model);
        UnmodifiableObservableList<BasicTaskFeatures> taskList = model.getFilteredTaskList();
        if (toAdd.isOverlapTask(taskList)) {
            toAdd = EditCommand.createOverlapTask(toAdd);
        }
        try {
<<<<<<< HEAD
 //           int overlapTaskIndex = BasicTask.getOverlapTaskIndex(toAdd, taskList);
//            if (BasicTask.eventTaskOverlap(overlapTaskIndex)) {
                //BasicTaskFeatures taskToEdit = taskList.get(overlapTaskIndex);
                //model.updateTask(taskToEdit, EditCommand.createOverlappingTask(taskToEdit));
//                model.addTask(EditCommand.createOverlapTask(toAdd));
//            } else {
            model.addTask(toAdd);
//            }
            int i;
            for (i = 0; i < model.getFilteredTaskList().size(); i++) {
                if (toAdd.equals(model.getFilteredTaskList().get(i))) {
                    break;
                }
            }
            Index newTaskIndex = new Index(i);
            EventsCenter.getInstance().post(new JumpToListRequestEvent(newTaskIndex));
//            if (toAdd.containsOverlapTag()) {
//
//                String displayString = String.format(MESSAGE_SUCCESS, toAdd) + MESSAGE_OVERLAP_TASK;
//                return new CommandResult(displayString);
//            }

=======
            model.addTask(toAdd);
>>>>>>> 35f1e675ef2b668aa82ad56fcded82ac28b939ce
            return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
        } catch (DuplicateTaskException e) {
            throw new CommandException(MESSAGE_DUPLICATE_TASK);
        }
    }
}
