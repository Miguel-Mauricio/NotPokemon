package io.code4all.notpokemon.game_objects.pokemon;

import io.code4all.notpokemon.Game;
import io.code4all.notpokemon.game_objects.GameObject;

import java.util.LinkedList;

public abstract class Pokemon extends GameObject {
    private static final int BOOST = 50;
    private String name;
    private int level;
    private int health;
    private int initialHealth;
    private boolean dead;
    private int attackDamage;
    private int defence;
    private boolean isGoingRight;
    private boolean isGoingLeft;

    private String type;

    private boolean specialAttack;
    private String nextTypeOfAttack;

    public Pokemon(String name, int level, int health, int attackDamage, int defence, String type) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.initialHealth = health;
        this.attackDamage = attackDamage;
        this.defence = defence;
        this.type = type;
    }

    public static Pokemon getPokemon(int level, LinkedList<Pokemon> pokemons) {
        LinkedList<Pokemon> pokemonsToRandom = new LinkedList<>();
        for (Pokemon p : pokemons)
            if (p.level == level)
                pokemonsToRandom.add(p);
        return pokemonsToRandom.get((int) (Math.random() * (pokemonsToRandom.size() -1)));
    }

    public void hit(int damage, String type) {
        switch (type) {
            case "FIRE":
                if (this.type.equals("GRASS"))
                    damage += BOOST;
                break;
            case "WATER":
                if (this.type.equals("FIRE"))
                    damage += BOOST;
                break;
            case "GRASS":
                if (this.type.equals("WATER"))
                    damage += BOOST;
                break;
            default:

                break;
        }
        if(damage - defence > 0)
            health -= damage - defence;
        if (health <= 0)
            dead = true;
    }

    public int getAttackDamage() {
        return (int) (Math.random() * Game.DAMAGE_BOOST) + this.attackDamage;
    }

    public boolean isDead() {
        return dead;
    }

    public String getMessage() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name=" + name +
                "health=" + health +
                ", attackDamage=" + attackDamage +
                ", defence=" + defence +
                '}';
    }

    public void reanimate() {
        this.dead = false;
        health = initialHealth;
        this.setSpecial(true);
        this.setNextTypeOfAttack("normal");

    }

    public boolean isGoingRight() {
        return this.isGoingRight;
    }

    public void setGoingRight(boolean b) {
        this.isGoingRight = b;
    }

    public boolean isGoingLeft() {
        return this.isGoingLeft;
    }

    public void setGoingLeft(boolean b) {
        this.isGoingLeft = b;
    }

    public int getHealth() {
        return this.health;
    }


    public boolean hasSpecial(){
        return specialAttack;
    }

    public void setSpecial(boolean b){
        this.specialAttack = b;
    }

    public String nextTypeOfAttack() {
        return this.nextTypeOfAttack;
    }

    public void setNextTypeOfAttack(String s){
        this.nextTypeOfAttack = s;
    }

    public String getType() {
        return this.type;
    }

    public void gainXP(int i) {
        this.attackDamage += i;
        this.defence += i;
        this.health += i;
        this.initialHealth += i;
    }

    public int getLevel() {
        return level;
    }
}
