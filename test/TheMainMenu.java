import org.junit.jupiter.api.Test;
public class TheMainMenu {
    @Test 
    void shouldDisplayMenuOptions(){
        MainMenu mm = new MainMenu();
        mm.display();
    }
}
