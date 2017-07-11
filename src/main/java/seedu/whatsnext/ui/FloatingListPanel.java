package seedu.whatsnext.ui;

import java.util.HashMap;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import javafx.util.Pair;
import seedu.whatsnext.commons.core.LogsCenter;
import seedu.whatsnext.commons.events.ui.TaskPanelSelectionChangedEvent;
import seedu.whatsnext.model.task.BasicTaskFeatures;

/**
 * Panel containing the list of Tasks.
 */
public class FloatingListPanel extends UiPart<Region> {
    private static final String FXML = "FloatingListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(FloatingListPanel.class);

    @FXML
    private ListView<Pair<BasicTaskFeatures, Integer>> floatingListView;
    
    private HashMap<Integer, Integer> floatingMap = new HashMap<Integer, Integer>();
    private int scrollIndex = 0;

    public FloatingListPanel(ObservableList<BasicTaskFeatures> taskList) {
        super(FXML);
        setConnections(taskList);
    }

    public void setConnections(ObservableList<BasicTaskFeatures> taskList) {
        ObservableList<Pair<BasicTaskFeatures, Integer>> floatingTaskList = extractFloatingTasks(taskList);
        floatingListView.setItems(floatingTaskList);
        System.out.println("alright");
        floatingListView.setCellFactory(listView -> new TaskListViewCell());
        setEventHandlerForSelectionChangeEvent();
    }

    private ObservableList<Pair<BasicTaskFeatures, Integer>> extractFloatingTasks(ObservableList<BasicTaskFeatures> taskList) {
        ObservableList<Pair<BasicTaskFeatures, Integer>> floatingTaskList = FXCollections.observableArrayList();
        for (int index = 0; taskList.size() != index; index++) {
            BasicTaskFeatures taskToFloat = taskList.get(index);
            if (taskToFloat.getTaskType().equals("floating")) {
                Pair<BasicTaskFeatures, Integer> floatTask = new Pair<BasicTaskFeatures, Integer>(taskToFloat, index);
                floatingTaskList.add(floatTask);
                floatingMap.put(index, scrollIndex);
                scrollIndex++;
            }
        }
        return floatingTaskList;
    }
    
    public ListView<Pair<BasicTaskFeatures, Integer>> getFloatingListView() {
        return this.floatingListView;
    }

    private void setEventHandlerForSelectionChangeEvent() {
        floatingListView.getSelectionModel().selectedItemProperty()
                .addListener((observablse, oldValue, newValue) -> {
                    if (newValue != null) {
                        logger.fine("Selection in task list panel changed to : '" + newValue + "'");
                        raise(new TaskPanelSelectionChangedEvent(newValue.getKey()));
                    }
                });
    }

    //@@author A0154987J
    public void scrollTo(int index) {
        Platform.runLater(() -> {
            //scrolls to task with index and selects it
        	//floatingListView.getSelectionModel().clearSelection();
            floatingListView.scrollTo(index);
            floatingListView.getSelectionModel().clearAndSelect(index);
        });
    }

    class TaskListViewCell extends ListCell<Pair<BasicTaskFeatures, Integer>> {

    	@Override
        protected void updateItem(Pair<BasicTaskFeatures, Integer> task, boolean empty) {
            super.updateItem(task, empty);

            if (empty || task == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new FloatingTaskCard(task.getKey(), task.getValue() + 1).getRoot());
            }
        }
    }
    
    public HashMap<Integer, Integer> getMap() {
    	return floatingMap;
    }
}
