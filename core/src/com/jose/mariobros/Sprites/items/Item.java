package com.jose.mariobros.Sprites.items;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.jose.mariobros.MarioBros;
import com.jose.mariobros.Screens.PlayScreen;
import com.jose.mariobros.Sprites.Mario;

/**
 * Created by jose on 29/10/15.
 */
public abstract class Item extends Sprite {
    protected PlayScreen screen;
    protected World world;
    protected Vector2 velocity;
    protected boolean setToDestroy;
    protected boolean destroyed;
    protected Body body;

    public Item(PlayScreen screen, float x, float y){
        this.screen = screen;
        this.world = screen.getWorld();
        setPosition(x, y);
        setBounds(getX(), getY(), 16 / MarioBros.PPM, 16 / MarioBros.PPM);
        defineItem();
        setToDestroy = false;
        destroyed = false;
    }
    public void update(float dt){
        if(setToDestroy && !destroyed){
            world.destroyBody(body);
            destroyed = true;
        }
    };

    public void draw(Batch batch){
        if(!destroyed)
            super.draw(batch);
    }
    public abstract void use(Mario mario);


    public abstract void defineItem();

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public void destroy(){
        setToDestroy = true;
    }
}