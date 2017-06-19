package main.java.datamodel;

import main.java.applicationlogic.ApplicationLayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 212027982 on 6/13/2017.
 */
public class CheckListContainer {
    List<CheckList> checkListItems= new ArrayList<>();
    ApplicationLayer applicationLayer = new ApplicationLayer();
    /**
     *
     * @param checkListItems
     */
    public void setCheckListItems(List<CheckList> checkListItems) {
        this.checkListItems = checkListItems;
    }
    /*

     */
    public List<CheckList> getCheckListItems() {
        return checkListItems;
    }

    /**
     *
     * @param checkList
     */
    public void addChecklist (CheckList checkList){

        checkListItems.add(checkList);
    };

    /**
     *
     * @param checkList
     */
    public void deleteChecklist (CheckList checkList){

        checkListItems.remove(checkList);
    };


}
