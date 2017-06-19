package main.java.persistencelayer;

import main.java.datamodel.CheckList;
import main.java.datamodel.CheckListItem;
import main.java.datamodel.UserListTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 212027982 on 6/14/2017.
 */
public class DataBase {
    List<String> list=new ArrayList<>();

    public UserListTable find (String name ){
        UserListTable userListTable = new UserListTable();
        list.add("List1");
        list.add("List2");
        userListTable.add(list);
        return userListTable;
    }
    public CheckList findCheckList (String name ){
        CheckList checkList = new CheckList("Data1", new CheckListItem());
        return checkList;
    }
}
