package carte_aux_tresors.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import carte.Aventurier;
import carte.Carte;

import static org.junit.jupiter.api.Assertions.*;

class AventurierTest {
	
	private Carte carte;
    private Aventurier aventurier;

    
    @BeforeEach
    void setUp() {
    	// Given : Initialisation d'une carte de dimensions 3 x 4
    	carte = new Carte(3,4);
    	// Given: Un aventurier nommé Dina (aventurier1) aux coordonnées (2, 0) face au Sud avec une séquence de mouvements "AAGDADAG"
        aventurier = new Aventurier("Dina", 2, 0, 'N', "AAGDADAG");
    }

    @Test
    void testGetNom() {
        // When : Récupérer le nom de l'aventurier
        String nom = aventurier.getNom();

        // Then : Nous vérifions que le nom est correct
        assertEquals("Dina", nom, "Le nom de l'aventurier doit être 'Dina'");
    }

    @Test
    void testGetX() {
        // When : Récupérer la coordonnée X de l'aventurier
        int x = aventurier.getX();

        // Then : La coordonée X devrait être 2
        assertEquals(2, x, "La coordonnée X de l'aventurier doit être 2");
    }

    @Test
    void testGetY() {
        // When : Récupérer la coordonnée Y de l'aventurier
        int y = aventurier.getY();

        // Then : La coordonée Y devrait être 0
        assertEquals(0, y, "La coordonnée Y de l'aventurier doit être 0");
    }

    @Test
    void testGetOrientation() {
        // When : Récupérer l'orientation de l'aventurier
        char orientation = aventurier.getOrientation();

        // Then : L'orientation devrait être N
        assertEquals('N', orientation, "L'orientation de l'aventurier doit être 'N'");
    }

    @Test
    void testGetSequenceMovement() {
        // When : Récupérer la séquence de mouvements de l'aventurier
        String sequence = aventurier.getSequence();

        // Then : La séquence devrait être AAGDADAG
        assertEquals("AAGDADAG", sequence, "La séquence de mouvements de l'aventurier doit être 'AAGDADAG'");
    }

    @Test
    void testSetX() {
        // When : Nous modifions la coordonnée X de l'aventurier
        aventurier.setX(2);

        // Then : Nous vérifions que la coordonnée X a bien été modifiée
        assertEquals(2, aventurier.getX(), "La coordonnée X de l'aventurier doit être 2");
    }

    @Test
    void testSetY() {
        // When : Nous modifions la coordonnée Y de l'aventurier
        aventurier.setY(0);

        // Then : Nous vérifions que la coordonnée Y a bien été modifiée
        assertEquals(0, aventurier.getY(), "La coordonnée Y de l'aventurier doit être 0");
    }

    @Test
    void testSetOrientation() {
        // When : Nous modifions l'orientation de l'aventurier
        aventurier.setOrientation('E');

        // Then : Nous vérifions que l'orientation a bien été modifiée
        assertEquals('E', aventurier.getOrientation(), "L'orientation de l'aventurier doit être 'E'");
    }

    @Test
    void testAvancer() {
    	
    	
        // When : Faire avancer l'aventurier
        aventurier.avancer(carte);

        // Then : Nous vérifions que les coordonnées ont été mises à jour correctement
        assertEquals(2, aventurier.getX(), "La coordonnée X de l'aventurier doit être 2");
        assertEquals(0, aventurier.getY(), "La coordonnée Y de l'aventurier doit être 0");
        		
    }
    
    @Test
    void testExecuterMouvement() {

        // When : On exécute la séquence de mouvements
        aventurier.executerMouvement(carte);

        // Then : Nous vérifions que les coordonnées et l'orientation de l'aventurier ont été mises à jour correctement
        assertEquals(2, aventurier.getX(), "La coordonnée X de l'aventurier doit être 2");
        assertEquals(0, aventurier.getY(), "La coordonnée Y de l'aventurier doit être 0");
        assertEquals('N', aventurier.getOrientation(), "L'orientation de l'aventurier doit être 'N'");
    }
    
}

