package carte_aux_tresors.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import carte.Main;
import carte.Carte;
import carte.Aventurier;



class MainTest {

	private static final String INPUT_FILE = "tests/ressources.tests/fichier_entree_test.txt";
    private static final String OUTPUT_FILE = "tests/ressources.tests/fichier_sortie_test.txt";

    private Carte carte;
    
    @BeforeEach
    void setUp() throws IOException {
    	// Given : Initialisation d'une carte de dimensions 3 x 4
    	carte = Main.lireFichierEntree(INPUT_FILE);
    }

    @Test
    void testLireFichierEntree() throws IOException {

    	// Then : Vérification des données du fichier
        assertNotNull(carte);
        assertEquals(3, carte.getLargeur());
        assertEquals(4, carte.getHauteur());
        assertEquals(1, carte.getAventuriers().size());
    }

    @Test
    void testSimulerMouvements() throws IOException {

        // When : Simulation des mouvements
        Main.simulerMouvements(carte);

        // Then : Vérification de la position finale de l'aventurier
        Aventurier aventurier = carte.getAventuriers().get(0);
        assertEquals(0, aventurier.getX());  
        assertEquals(3, aventurier.getY());
    }

    @Test
    void testEcrireFichierSortie() throws IOException {
    	// When : On simule les mouvements de l'aventurier
    	Main.simulerMouvements(carte);
    	
        // When : Écriture du résultat dans le fichier de sortie
        Main.ecrireFichierSortie(carte, OUTPUT_FILE);

        // When : Lecture du fichier de sortie pour vérifier le contenu
        String fichierSortie = Files.readString(Paths.get(OUTPUT_FILE));

        // Then : Vérification des données dans le fichier de sortie
        assertNotNull(fichierSortie);
        assertTrue(fichierSortie.contains("C - 3 - 4"));
        assertTrue(fichierSortie.contains("M - 1 - 0"));
        assertTrue(fichierSortie.contains("M - 2 - 1"));
        assertTrue(fichierSortie.contains("T - 1 - 3 - 2"));
        assertTrue(fichierSortie.contains("A - Lara - 0 - 3 - S - 3"));
    }

}
