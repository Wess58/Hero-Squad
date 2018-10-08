import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class test{

    @Test
    public void Hero_instantiatesCorrectly_true() {
        Hero myHero = new Hero("Mr Robot","23","Laser Eyes","Pepper Spray"  );
        assertEquals(true, myHero instanceof Hero);
    }

    @Test
    public void Hero_instantiatesWithName_String() {
        Hero myHero = new Hero("Mr Robot","23","Laser Eyes","Pepper Spray");
        assertEquals("Mr Robot", myHero.getAlias());
      }

    @Test
    public void Hero_instantiatesWithAge_String() {
        Hero myHero = new Hero("Mr Robot","23","Laser Eyes","Pepper Spray");
        assertEquals("23", myHero.getAge());
    }
    @Test
    public void Hero_instantiatesWithPower_String() {
        Hero myHero = new Hero("Mr Robot","23","Laser Eyes","Pepper Spray");
        assertEquals("Laser Eyes", myHero.getSpecialPower());
      }

    @Test
    public void Hero_instantiatesWithWeakness_String() {
        Hero myHero = new Hero("Mr Robot","23","Laser Eyes","Pepper Spray");
        assertEquals("Pepper Spray", myHero.getWeakness());
      }


    @Test
    public void all_displaysAllCreateHeroes_true(){
      Hero firstHero = new Hero("Mr Robot","23","Laser Eyes","Pepper Spray");
      Hero secondHero = new Hero("2Pac","43","Mind Reading","Electrical shock");
      assertEquals(true, Hero.all().contains(firstHero));
      assertEquals(true, Hero.all().contains(secondHero));
    }

    @Test
    public void clear_emptiesHeroesFromArrayList_0(){
      Hero myHero = new Hero("Mr Robot","23","Laser Eyes","Pepper Spray");
      Hero.clear();
      assertEquals(Hero.all().size(), 0);
    }

    @Test
    public void getID_heroInstantiateWithAnID_1(){
      Hero.clear(); // Remember, the test will fail without this line! We need to empty leftover Tasks from previous tests!
      Hero myHero = new Hero("Mr Robot","23","Laser Eyes","Pepper Spray");
      assertEquals(1, myHero.getId());
    }

}
