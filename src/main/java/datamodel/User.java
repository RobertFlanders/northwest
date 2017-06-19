package main.java.datamodel;

/**
 * Created by 212027982 on 6/13/2017.
 */
public class User {
    public String getName() {
        return name;
    }

    private   String name;

    public void setName(String name) {
        this.name = name;
    }

    public CheckListContainer getCheckListContainer() {
        return checkListContainer;
    }

    /**
     *
     */
    public CheckListContainer checkListContainer;

    public User(String userName , CheckListContainer container ){
            checkListContainer=container;
            name = userName;
            }

    /**
     *
      * @param container
     */
    public void addContainer(CheckListContainer container){
         if (checkListContainer==null) {
             checkListContainer = container;
         } else {
             System.out.println("Tried to Replace Existing Container");
         }
     };

    /**
     *
     * @param container
     */
    public void deleteContainer(CheckListContainer container){
        if (checkListContainer==null) {
            System.out.println("Tried to delete null Container");
        } else {
            checkListContainer=null;
        }
    };
}
