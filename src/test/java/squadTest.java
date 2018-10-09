import org.junit.*;
import static org.junit.Assert.*;

public class squadTest {

  @Test
    public void squad_instantiatesCorrectly_true() {
      Squad testSquad = new Squad("Marvel","Fighting Evil");
      assertEquals(true, testSquad instanceof Squad);
  }
  @Test
   public void getSquadName_squadInstantiatesWithSquadName_Marvel() {
     Squad testSquad = new Squad("Marvel","Fighting Evil");
     assertEquals("Marvel", testSquad.getSquadName());
   }
   @Test
    public void getDescription_squadInstantiatesWithDescription_FightingEvil() {
      Squad testSquad = new Squad("Marvel","Fighting Evil");
      assertEquals("Fighting Evil", testSquad.getDescription());
  }
  @Test
    public void all_returnsAllInstancesOfSquad_true() {
      Squad firstSquad = new Squad("Marvel","Fighting Evil");
      Squad secondSquad = new Squad("Lego","Bringing Fun");
      assertEquals(true, Squad.all().contains(firstSquad));
      assertEquals(true, Squad.all().contains(secondSquad));
    }
@Test
  public void clear_emptiesAllCategoriesFromList_0() {
    Squad testSquad = new Squad("Marvel","Fighting Evil");
    Squad.clear();
    assertEquals(Squad.all().size(), 0);
}
// @Test
//   public void getId_categoriesInstantiateWithAnId_1() {
//     Squad testSquad = new Squad("Marvel","Fighting Evil");
//     assertEquals(1, testSquad.getId());
//   }
  @Test
    public void getHeros_initiallyReturnsEmptyList_ArrayList() {
      Squad.clear();
      Squad testSquad = new Squad("Marvel","Fighting Evil");
      assertEquals(0, testSquad.getHeroes().size());
    }
    @Test
      public void addHero_addsHero_true() {
        Squad testSquad = new Squad("Marvel","Fighting Evil");
        Hero testHero = new Hero("Mr Robot","23","Laser Eyes","Pepper Spray");
        testSquad.addHero(testHero);
        assertTrue(testSquad.getHeroes().contains(testHero));
      }

}
