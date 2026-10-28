import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnOceanGrid {
    @test
    void shouldBeAbleToBeMAde(){
        OceanGrid og = new OceanGrid();
        assertNotNull(og);
        assertInstanceOf(OceanGrid.class, og);
    }

    @Test
    void shouldBeDisplayableEmpty(){
        // Arrange
        OceanGrid og = new OceanGrid();

        // Act
    
        // no assertion, will alwasy pass
        // used to visulize gird

        System.out.println(og.toString());
    }

    @Test
    void ShouldBeaAbleToPlaceShips
    OceanGrid og = New OceanGrid();
    
}
