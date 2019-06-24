package com.company;

public abstract class Character {
    protected String name;
    protected int level;
    protected int vitality;
    protected int strength;
    protected int agility;
    protected int intelligence;

    public Character(String name, int level, int strength, int agility, int intelligence) throws BadCharacteristicsSetted {
        this.name = name;
        this.level = level;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.vitality = level * 5;

        if (strength + agility + intelligence > level)
            throw new BadCharacteristicsSetted();
    }

    public String getName() {
        return name;
    }

    public String getNameAndVitality() {
        return name + " (" + vitality + " Vitalité)";
    }

    public int getLevel() {
        return level;
    }

    public int getVitality() {
        return vitality;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Inflict Damages to the Character. The damages value is substract to the vitality.
     * The method print in System.out the damages inflicted and the death of the Character (if vitality <= 0)
     * @param damage Damages value
     */
    public void inflictDamages(int damage) {
        this.vitality -= damage;
        System.out.println(this.getName() + " perd " + damage + " points de vie") ;
        if (this.vitality <= 0)
            System.out.println(this.getName() + " est mort");
    }

    /**
     * The basic attack of a Character
     * @param enemy the Character targeted
     */
    public abstract void basicAttack(Character enemy);

    /**
     * The special attack of a Character
     * @param enemy the Character targeted
     */
    public abstract void specialAttack(Character enemy);

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", vitality=" + vitality +
                ", strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                '}';
    }
}
