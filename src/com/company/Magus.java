package com.company;

public class Magus extends Character {

    public Magus(String name, int level, int strength, int agility, int intelligence) throws BadCharacteristicsSetted {
        super(name, level, strength, agility, intelligence);
    }

    @Override
    public void basicAttack(Character enemy) {
        int damage = intelligence;
        System.out.println(name +  " utilise  Boule de Feu et inflige " + intelligence + " dommages.");
        enemy.inflictDamages(damage);
    }

    @Override
    public void specialAttack(Character enemy) {
        int vitalityEarned = intelligence * 2;
        int newVitality = vitality + vitalityEarned;
        if (newVitality > level * 5)
            newVitality = level * 5;
        System.out.println(name +  " utilise Soin et gagne " + (newVitality - vitality) + " en vitalité.");
        vitality = newVitality;
    }

    @Override
    public String toString() {
        return "Abracadabra je suis le Mage " + name +
                " niveau " + level +
                " je possède " + vitality + " de vitalité, " +
                strength + " de force, " +
                agility + " d'agilité et " +
                intelligence + " d'intelligence !";
    }
}
