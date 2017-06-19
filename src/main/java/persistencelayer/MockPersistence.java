package main.java.persistencelayer;

import main.java.datamodel.*;

import javax.management.Query;
import java.util.*;

/**
 * Created by 212027982 on 6/9/2017.
 */
public class MockPersistence {
    DataBase dataBase = new DataBase();

    // Save obj to the data store.
    public void persist(Object obj){};

    // Read obj with a given primary key.
    public Object load(Class c, Object pK){
        return null;
    };

    // Update the modified object obj.
    public void update(Object obj){};

    //  Delete obj from the database.
    public void delete(Object obj){};

    // Find objects that satisfy conditions of our query.
    public User find(User user){

        UserListTable table = findUserListTable(user.getName());
        CheckListContainer checkListContainer =new CheckListContainer();
        CheckList checkList;

        for (String s : table.getList()){
          checkList=findCheckList(s);
          checkListContainer.addChecklist(checkList);
        }

        user.addContainer(checkListContainer);
        return user;
    };
    // Find objects that satisfy conditions of our query.
    public UserListTable findUserListTable(String name){
       return dataBase.find(name);
    };
    public CheckList findCheckList (String name )
    {
        return dataBase.findCheckList(name);
    }
}
