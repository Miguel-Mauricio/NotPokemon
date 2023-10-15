package io.code4all.notpokemon.game_objects.pokemon;

import io.code4all.notpokemon.game_objects.GameObject;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Pokemon extends GameObject {
    private String name;
    private int health;
    private boolean dead;
    private Picture picture;
    private int attackDamage;
    private int defence;

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

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public void setName(String name) {
        this.name = name;
    }
}
