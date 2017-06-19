package main.java.applicationlogic;

import main.java.datamodel.CheckList;
import main.java.datamodel.CheckListContainer;
import main.java.datamodel.CheckListItem;
import main.java.datamodel.User;
import main.java.persistencelayer.MockPersistence;

import java.util.Objects;

/**
 * Created by 212027982 on 6/14/2017.
 */
public class ApplicationLayer {

    MockPersistence mockPersistence = new MockPersistence();
    public CheckList createTaskList(String name, CheckListItem task){
        CheckList checkList = new CheckList(name,task);
        mockPersistence.persist(checkList);
        return checkList;

    }
    public User lookupUser(String user){
        User user1 = new User(user,null);
        mockPersistence.find(user1);
        return user1;
    }

    public CheckList getCheckList(String name){
     return mockPersistence.findCheckList(name);
    }
    public CheckList addCheckList(String name, CheckListItem item ){
        CheckList checkList = getCheckList(name );
        checkList.addItem(item );
        return checkList;

    }
    public void updatePersistence(Object object){
        mockPersistence.update(object);
    }
    public void deletePersistence(Object object){
        mockPersistence.delete(object);
    }
}
