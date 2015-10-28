package com.jose.mariobros.Sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.jose.mariobros.MarioBros;
import com.jose.mariobros.Scenes.Hud;

import java.awt.Polygon;

/**
 * Created by jose on 27/10/15.
 */
public class Coin extends InteractiveTileObject {
    private static TiledMapTileSet tileSet;
    private final int BLANK_COIN = 28;
    public Coin(World world, TiledMap map, Rectangle bounds){
        super(world, map, bounds);
        tileSet = map.getTileSets().getTileSet("tileset_gutter");
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.COIN_BIT);

    }

    @Override
    public void onHeadHit() {
        getCell().setTile(tileSet.getTile(BLANK_COIN));
        Hud.addScore(100);

    }
}
