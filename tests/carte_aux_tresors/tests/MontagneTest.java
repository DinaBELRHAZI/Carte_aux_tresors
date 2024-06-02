package carte_aux_tresors.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import carte.Montagne;


class MontagneTest {
	
	private Montagne montagne;
	
	@BeforeEach
    void setUp() {
    	
    	// Given: La montagne a pour coordonée (1, 4)
        montagne = new Montagne(1, 4);
    }

	@Test
    public void testGetX() {
     
        // When: On obtient la coordonnée x
        int x = montagne.getX();
        
        // Then: La coordonée x devrait être 1
        assertEquals(1, x, "La coordonnée X de la montagne devrait être 1");
    }
	
	@Test
    void testSetX() {
        // When : Nous modifions la coordonnée X de la montagne
        montagne.setX(1);

        // Then : Nous vérifions que la coordonnée X a bien été modifiée
        assertEquals(1, montagne.getX(), "La coordonnée X de du tresor doit être 1");
    }

    @Test
    public void testGetY() {
        
        // When: On obtient la coordonnée y
        int y = montagne.getY();
        
        // Then: La coordonée y devrait être 4
        assertEquals(4, y, "La coordonnée Y de la montagne devrait être 4");
    }
    
    @Test
    void testSetY() {
        // When : Nous modifions la coordonnée Y de la montagne
        montagne.setY(4);

        // Then : Nous vérifions que la coordonnée X a bien été modifiée
        assertEquals(4, montagne.getY(), "La coordonnée Y de la montagne doit être 4");
    }

    @Test
    public void testMontagneNonNull() {
      
        // Then: L'objet montagne ne devrait pas être null
        assertNotNull(montagne, "L'objet montagne ne devrait pas être null");
    }
}
