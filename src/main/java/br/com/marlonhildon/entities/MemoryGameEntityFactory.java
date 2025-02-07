package br.com.marlonhildon.entities;

import br.com.marlonhildon.constants.MemoryGameType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;

public class MemoryGameEntityFactory implements EntityFactory {

    @Spawns("player")
    public Entity buildPlayer(SpawnData spawnData) {
        return FXGL.entityBuilder(spawnData)
                .type(MemoryGameType.CARD)
                .view("rabbit.png")
                .onClick(e -> System.out.println("Clicked!"))
                .build();
    }

}
