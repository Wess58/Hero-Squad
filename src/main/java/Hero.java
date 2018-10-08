import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Hero {
    private String mAlias;
    private String mAge;
    private String mSpecialPower;
    private String mWeakness;
    private LocalDateTime mCreatedAt;
    private static List<Hero> instances = new ArrayList<Hero>();
    private int mId;

    public Hero(String alias,String age, String specialPower, String weakness ){
        mAlias = alias;
        mAge = age;
        mSpecialPower = specialPower;
        mWeakness = weakness;
        mCreatedAt = LocalDateTime.now();
        instances.add(this);
        mId = instances.size();
    }

    public String getAlias(){
        return mAlias;
    }

    public String getAge(){
      return mAge;
    }

    public String getSpecialPower(){
      return mSpecialPower;
    }

    public String getWeakness(){
      return mWeakness;
    }

    public LocalDateTime getCreatedAt(){
      return mCreatedAt;
    }

    public static List<Hero> all(){
      return instances;
    }

    public static void clear(){
      instances.clear();
    }

    public int getId(){
      return mId;
    }

    public static Hero find(int id){
      return instances.get(id -1);
    }
}
