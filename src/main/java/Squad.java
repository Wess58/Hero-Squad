import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Squad {
    private String mSquadName;
    private  String mDescription;
    private static List<Squad> instances = new ArrayList<Squad>();
    private int mId;
    private List<Hero> mHeroes;


    public Squad (String squadName, String description){
        mSquadName = squadName;
        mDescription= description;
        instances.add(this);
        mId = instances.size();
        mHeroes = new ArrayList<Hero>();

    }

    public String getSquadName(){
        return mSquadName;
    }

    public String getDescription(){
      return mDescription;
    }

    public static List<Squad> all(){
      return instances;
    }

    public static void clear(){
      instances.clear();
    }

    public int getId(){
        return mId;
    }
    public static Squad find(int id) {
        return instances.get(id - 1);
    }
    public List<Hero> getHeroes() {
        return mHeroes;
    }
    public void addHero(Hero hero) {
      mHeroes.add(hero);
    }
}
