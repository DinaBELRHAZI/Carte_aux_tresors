package carte;
import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.*;

public class Main {

	
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            Carte carte = lireFichierEntree("src/ressources/fichier_entree.txt");
            simulerMouvements(carte);
            ecrireFichierSortie(carte, "src/ressources/fichier_sortie.txt");
            System.out.println("Voici le résultat finale");
            carte.afficherCarte();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lecture du ficher d'entrée
     * @param fichier
     * @return
     * @throws IOException
     */
    public static Carte lireFichierEntree(String fichier) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fichier));
        String ligne;
        Carte carte = null;

        while ((ligne = reader.readLine()) != null) {
            if (ligne.startsWith("#")) continue; // Ignore les lignes de commentaire
            String[] parts = ligne.split(" - ");
            switch (parts[0]) {
                case "C":
                    carte = new Carte(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                    break;
                case "M":
                    carte.ajouterMontagne(new Montagne(Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
                    break;
                case "T":
                    carte.ajouterTresor(new Tresor(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
                    break;
                case "A":
                    carte.ajouterAventurier(new Aventurier(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4].charAt(0), parts[5]));
                    break;
            }
            
        }

        reader.close();
        return carte;
    }

    
    /**
     * Exécution d'un mouvement
     * @param carte
     */
    public static void simulerMouvements(Carte carte) {
        for (Aventurier aventurier : carte.getAventuriers()) {
            aventurier.executerMouvement(carte);
        }
    }
    
    

    /**
     * Ecriture du résultat sur le ficher de sortie
     * @param carte
     * @param fichier
     * @throws IOException
     */
    public static void ecrireFichierSortie(Carte carte, String fichier) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fichier));

        // Dimension de la carte
        writer.write(String.format("C - %d - %d\n", carte.largeur, carte.hauteur));
        
        
        // Positions des montagnes
        for (Montagne montagne : carte.montagnes) {
            writer.write(String.format("M - %d - %d\n", montagne.getX(), montagne.getY()));
        }

        // Positions des trésors
        for (Tresor tresor : carte.tresors) {
            if (tresor.getQuantite() > 0) {
                writer.write(String.format("T - %d - %d - %d\n", tresor.getX(), tresor.getY(), tresor.getQuantite()));
            }
        }

        // Positions des aventuriers
        for (Aventurier aventurier : carte.getAventuriers()) {
            writer.write(String.format("A - %s - %d - %d - %c - %d\n", aventurier.getNom(), aventurier.getX(), aventurier.getY(), aventurier.getOrientation(), aventurier.getTresorsCollectes()));
        }

        writer.close();
    }

}
