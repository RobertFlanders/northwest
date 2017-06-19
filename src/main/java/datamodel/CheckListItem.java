package main.java.datamodel;

/**
 * Created by 212027982 on 6/9/2017.
 */
public class CheckListItem {
    private String taskText = "";
    private boolean completeFlag= false;

    public String getTaskText() {
        return taskText;
    }

    public boolean isComplettionFlag() {
        return completeFlag;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public void setCompleteFlag(boolean completeFlag) {
        this.completeFlag = completeFlag;
    }


}

