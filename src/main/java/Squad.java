import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Squad {
    private String mSquadName;
    private LocalDateTime mCreatedAt;
    private static List<Squad> instances = new ArrayList<Squad>();
    // private int mId;

    public Squad(String squadName){
        mSquadName = squadName;
        mCreatedAt = LocalDateTime.now();
        instances.add(this);
        // mId = instances.size();
    }

    public String getSquadName(){
        return mSquadName;
    }

    public LocalDateTime getCreatedAt(){
      return mCreatedAt;
    }

    public static List<Squad> all(){
      return instances;
    }

    public static void clear(){
      instances.clear();
    }

    // public int getId(){
    //   return mId;
    // }
}
