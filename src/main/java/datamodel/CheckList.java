package main.java.datamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 212027982 on 6/9/2017.
 */
public class CheckList {

    private String listName;
    List<CheckListItem> checkListItems= new ArrayList<>();
    public String getListName() {
        return listName;
    }

    public CheckList(String name, CheckListItem item){
        listName=name;
        checkListItems.add(item);
    }
    public void addItem (CheckListItem item ){
        checkListItems.add(item);
    }
    public void  deleteItem (CheckListItem item ){
        checkListItems.remove(item);
    };

    public CheckListItem getCheckListItem (String task ){
        for (CheckListItem item : checkListItems){
            if (item.getTaskText().contains(task)){
                return item;

            }
        }
     return null;
    }



}

