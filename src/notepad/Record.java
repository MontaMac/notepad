package notepad;

public abstract class Record {
    //abstract class specifics
    private static int count = 0;
    // for all persons count = 0 as it si private
    private int id;

    public Record() {
        // id = 10;
        count++;
        // increases with avery new peron
        id= count;
    }

    public abstract boolean hasSubstring(String str);
    // all note and person has such method.

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }
}
