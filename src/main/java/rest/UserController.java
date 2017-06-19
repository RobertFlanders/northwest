package main.java.rest;

/**
 * Created by 212027982 on 6/13/2017.
 */


import main.java.applicationlogic.ApplicationLayer;
import main.java.datamodel.CheckList;
import main.java.datamodel.CheckListContainer;
import main.java.datamodel.CheckListItem;
import main.java.datamodel.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.Object;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    ApplicationLayer applicationLayer = new ApplicationLayer();

    @RequestMapping("/user")
    public User user(@RequestParam(value="username", defaultValue="doe") String name) {
        return applicationLayer.lookupUser(name);
    }
    @RequestMapping("/createtasklist")
    @ModelAttribute
    public CheckList createTaskList(@RequestParam(value="tasklistname", defaultValue="List") String name,
                                    @RequestParam(value="task", defaultValue="none") String task,
                                    @ModelAttribute("submitTask") CheckListItem model ) {
        model.setTaskText(task);
        return applicationLayer.createTaskList(name,model);
    }
    @RequestMapping("/addtasklistitem")

    public CheckList addTaskListItem(@RequestParam(value="checklistname", defaultValue="List") String name,
                                    @RequestParam(value="task", defaultValue="none") String task,
                                   @ModelAttribute("submitTask") CheckListItem model )  {

        model.setTaskText(task);
        CheckList checklist = applicationLayer.addCheckList(name,model);
        applicationLayer.updatePersistence( checklist);
        return checklist;
    }
    @RequestMapping("/deletetasklistitem")
    public void deleteTaskListItem(@RequestParam(value="checklistname", defaultValue="List") String name,
                                       @RequestParam(value="task", defaultValue="none") String task,
                                       @ModelAttribute("submitTask") CheckListItem model ) {
        CheckList checklist=applicationLayer.getCheckList(name);
        checklist.deleteItem(model);
        applicationLayer.updatePersistence( checklist);

    }
    @RequestMapping("/deletetasklist")
    public void deleteTaskList(@RequestParam(value="username", defaultValue="Doe") String name,
                                   @ModelAttribute("submitTask") CheckListItem model) {
        User user = applicationLayer.lookupUser(name);
        CheckListContainer checkListContainer  = user.getCheckListContainer();
        CheckList checkList = applicationLayer.getCheckList(name);
        checkListContainer.deleteChecklist(checkList);
        applicationLayer.deletePersistence(checkList);

    }

    @RequestMapping("/setcompletionflag")
    public void associateUserToTaskList(@RequestParam(value="checklistname", defaultValue="List") String name,
                                        @RequestParam(value="task", defaultValue="none") String task) {

        CheckList checkList = applicationLayer.getCheckList(name);
        CheckListItem checkListItem = checkList.getCheckListItem(task);
        checkListItem.setCompleteFlag(true);
        applicationLayer.updatePersistence(checkList);

    }
}