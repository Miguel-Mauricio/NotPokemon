package io.code4all.notpokemon.game_objects.pokemon;

import io.code4all.notpokemon.game_objects.GameObject;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public abstract class Pokemon extends GameObject {
    private String name;
    private int level;
    private int health;
    private int initialHealth;
    private boolean dead;
    private int attackDamage;
    private int defence;

    public Pokemon(String name, int level, int health, int attackDamage, int defence) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.initialHealth = health;
        this.attackDamage = attackDamage;
        this.defence = defence;
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
                ", dead=" + dead +
                ", picture=" + picture +
                ", attackDamage=" + attackDamage +
                ", defence=" + defence +
                '}';
    }

    public void reanimate() {
        this.dead = false;
        health = initialHealth;
    }
}
