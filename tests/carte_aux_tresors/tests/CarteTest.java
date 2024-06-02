package carte_aux_tresors.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import carte.Aventurier;
import carte.Carte;
import carte.Montagne;
import carte.Tresor;

class CarteTest {

	private Carte carte;
	private Aventurier aventurier1;
    private Aventurier aventurier2;
    private Montagne montagne;
    private Tresor tresor;

    @BeforeEach
    public void setUp() {
        // Given: Initialisation d'une carte de dimensions 3 x 4
        carte = new Carte(3, 4);
        // Given: Deux aventuriers nommés Dina (aventurier1) et Lara (aventurier2)
        aventurier1 = new Aventurier("Dina", 2, 0, 'N', "AAGDADAG");
        aventurier2 = new Aventurier("Lara", 1, 1, 's', "AADADAGGA");
        // Given: Une montagne a pour coordonnées (1, 1)
        montagne = new Montagne(1, 1);
        // Given: Un trésor a pour coordonnées (0, 3) avec une quantité de 2
        tresor = new Tresor(0, 3, 2);
    }
    
    @Test
    public void testGetLargeur() {
        
        // When: On obtient la largeur de la carte
        int l = carte.getLargeur();

        // Then: La largeur de la carte devrait être 3
        assertEquals(3, l, "La largeur de la carte devrait être 3");
    }
	
	@Test
    void testSetLargeur() {
        // When : Nous modifions la largeur de la carte
		carte.setLargeur(3);

        // Then : Nous vérifions que la largeur a bien été modifiée
        assertEquals(3, carte.getLargeur(), "La largeur de la carte doit être 3");
    }
	
	@Test
    public void testGetHauteur() {
        
        // When: On obtient la hauteur de la carte
        int h = carte.getHauteur();

        // Then: La hauteur de la carte devrait être 4
        assertEquals(4, h, "La largeur de la carte devrait être 4");
    }
	
	@Test
    void testSetHauteur() {
        // When : Nous modifions la hauteur de la carte
		carte.setHauteur(4);

        // Then : Nous vérifions que la hauteur a bien été modifiée
        assertEquals(4, carte.getHauteur(), "La largeur de la carte doit être 4");
    }
	
	
	@Test
    public void testGetTresor() {
        
        carte.ajouterTresor(tresor);

        // When: On récupère le trésor aux coordonnées (0, 3)
        Tresor recupereTresor = carte.getTresor(0, 3);

        // Then: Le trésor récupéré devrait être le même que celui ajouté
        assertEquals(tresor, recupereTresor, "Le trésor récupéré devrait être le même que celui ajouté");
    }
	
	
	@Test
    public void testGetAventuriers() {
        // When : Ajouter les deux aventuriers à la carte
        carte.ajouterAventurier(aventurier1);
        carte.ajouterAventurier(aventurier2);

        // Then : On récupère la liste des aventuriers et on vérifie qu'elle contient bien les deux aventuriers
        List<Aventurier> aventuriers = carte.getAventuriers();
        assertNotNull("La liste d'aventuriers ne doit pas être null", aventuriers);
        assertEquals("La liste d'aventuriers doit contenir 2 aventuriers", 2, aventuriers.size());
        assertTrue("La liste d'aventuriers doit contenir l'aventurier Dina", aventuriers.contains(aventurier1));
        assertTrue("La liste d'aventuriers doit contenir l'aventurier Lara", aventuriers.contains(aventurier2));
    }
	
	

    @Test
    public void testAjouterMontagne() {

        // When: Nous ajoutons la montagne à la carte
        carte.ajouterMontagne(montagne);

        // Then: La position (1, 1) devrait être marquée comme une montagne
        assertTrue(carte.estMontagne(1, 1), "La case (1, 1) devrait être une montagne");
    }
    
   

    @Test
    public void testAjouterTresor() {
       
        // When: Nous ajoutons le trésor à la carte
        carte.ajouterTresor(tresor);

        // Then: La position (0, 3) devrait contenir le trésor
        assertEquals(tresor, carte.getTresor(0, 3), "La case (0, 3) devrait contenir le trésor");
    }
    
    
    @Test
    public void testAjouterAventurier() {
    	
    	// When: Nous ajoutons l'aventurier à la carte
    	carte.ajouterAventurier(aventurier1);
    	
    	// Then: La position (2, 0) devrait contenir l'aventurier
    	assertTrue(carte.aventurierPresent(2, 0), "La case (2, 0) devrait contenir un aventurier");
    }

    
    @Test
    public void testEstMontagne() {
        // Given: Une montagne aux coordonnées (1, 1)
        carte.ajouterMontagne(new Montagne(1, 1));

        // When: On vérifie si la case (1, 1) est une montagne
        boolean estMontagne = carte.estMontagne(1, 1);

        // Then: La vérification devrait être vraie
        assertTrue(estMontagne, "La case (1, 1) devrait être une montagne");
        
        // And when: Nous vérifions une position sans montagne
        boolean nonMontagne = carte.estMontagne(0, 0);

        // Then: La vérification devrait être fausse
        assertFalse(nonMontagne, "La case (0, 0) ne devrait pas être une montagne");
    }
    
    

    
    @Test
    public void testAventurierPresent() {
    	
        // When: Nous ajoutons l'aventurier à la carte
        carte.ajouterAventurier(aventurier1);

        // Then: La case (2, 0) devrait contenir l'aventurier Dina
        assertTrue(carte.aventurierPresent(2, 0), "La case (2, 0) devrait contenir l'aventurier Dina");

        // Then: Nous vérifions une position sans aventurier
        assertFalse(carte.aventurierPresent(2, 2), "La case (2, 2) ne devrait pas contenir d'aventurier");
    }
    



}
