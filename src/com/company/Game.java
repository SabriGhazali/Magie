package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Character player1;
    Character player2;

    private Scanner sc = new Scanner(System.in);

    /**
     * Run the game
     * Started by characters creation then turn to turn fight.
     */
    public void run() {
        System.out.println("Création du personnage du Joueur 1");
        player1 = createCharacter("Joueur 1");
        System.out.println(player1);
        System.out.println("Création du personnage du Joueur 2");
        player2 = createCharacter("Joueur 2");
        System.out.println(player2);
        while (player1.getVitality() > 0 && player2.getVitality() > 0) {
            playerTurn(player1, player2);
            if (player2.getVitality() > 0)
                playerTurn(player2, player1);
        }
        if (player1.getVitality() <= 0)
            System.out.println(player1.getName() + " a perdu !");
        if (player2.getVitality() <= 0)
            System.out.println(player2.getName() + " a perdu !");
    }

    void playerTurn(Character currentPlayer, Character otherPlayer) {
        int attackType = askForIntValue(currentPlayer.getNameAndVitality() + " veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)", 1, 2);
        if (attackType == 1)
            currentPlayer.basicAttack(otherPlayer);
        else
            currentPlayer.specialAttack(otherPlayer);
    }

    Character createCharacter(String name) {
        Character character = null;
        do {
            int characterClass = askForIntValue("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)", 1, 3);
            int level = askForIntValue("Niveau du personnage ?", 1, 100);
            int strength = askForIntValue("Force du personnage ?", 0, 100);
            int agility = askForIntValue("Agilité du personnage ?", 0, 100);
            int intelligence = askForIntValue("Intelligence du personnage ?", 0, 100);
            try {
                switch (characterClass) {
                    case 1 :
                        character = new Warrior(name, level, strength, agility, intelligence);
                        break;
                    case 2 :
                        character = new Rogue(name, level, strength, agility, intelligence);
                        break;
                    case 3 :
                        character = new Magus(name, level, strength, agility, intelligence);
                        break;
                }
            } catch (BadCharacteristicsSetted e) {
                System.err.println("Merci de saisir un total de points de caractéristiques égal au niveau de votre personnage.");
                character = null;
            }
        } while (character == null);
        return character;
    }

    int askForIntValue(String question, int minValue, int maxValue) {
        System.out.println(question);
        int value = -1;
        boolean valueIsGood;
        do {
            try {
                value = sc.nextInt();
                valueIsGood = true;
            } catch (InputMismatchException e) {
                sc.next();
                System.err.println("Merci de saisir une valeur valide");
                valueIsGood = false;
            }
            if (value < minValue) {
                System.err.println("Merci de saisir une valeur supérieure ou égale à " + minValue);
                valueIsGood = false;
            }
            if (value > maxValue) {
                System.err.println("Merci de saisir une valeur inférieure ou égale à " + maxValue);
                valueIsGood = false;
            }
        } while (!valueIsGood);
        return value;
    }
}
