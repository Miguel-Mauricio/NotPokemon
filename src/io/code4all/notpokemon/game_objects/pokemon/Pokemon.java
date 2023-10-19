package io.code4all.notpokemon.game_objects.pokemon;

import io.code4all.notpokemon.Game;
import io.code4all.notpokemon.game_objects.GameObject;

import java.util.LinkedList;

public abstract class Pokemon extends GameObject {
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
        for(Pokemon p: pokemons)
            if (p.level == level)
                pokemonsToRandom.add(p);
        return pokemonsToRandom.get((int) (Math.random()*(pokemonsToRandom.size()-1)));
    }

    public void hit(int damage){
       health -= damage - defence;
       if(health <= 0)
           dead = true;
    }

    public int getAttackDamage(){
        return (int)(Math.random() * Game.DAMAGE_BOOST) + this.attackDamage;
    }

    public boolean isDead(){
        return dead;
    }

    public String getMessage(){
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

}
