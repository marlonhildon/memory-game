package br.com.marlonhildon.entities;

import br.com.marlonhildon.constants.MemoryGameType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;

public class MemoryGameEntityFactory implements EntityFactory {

    @Spawns("apple")
    public Entity buildApple(SpawnData spawnData) {
        return FXGL.entityBuilder(spawnData)
                .type(MemoryGameType.APPLE)
                .view(MemoryGameType.APPLE.getFileName())
                .build();
    }

    @Spawns("banana")
    public Entity buildBanana(SpawnData spawnData) {
        return FXGL.entityBuilder(spawnData)
                .type(MemoryGameType.BANANA)
                .view(MemoryGameType.BANANA.getFileName())
                .build();
    }

    @Spawns("bear")
    public Entity buildBear(SpawnData spawnData) {
        return FXGL.entityBuilder(spawnData)
                .type(MemoryGameType.BEAR)
                .view(MemoryGameType.BEAR.getFileName())
                .build();
    }

    @Spawns("cat")
    public Entity buildCat(SpawnData spawnData) {
        return FXGL.entityBuilder(spawnData)
                .type(MemoryGameType.CAT)
                .view(MemoryGameType.CAT.getFileName())
                .build();
    }

    @Spawns("elephant")
    public Entity buildElephant(SpawnData spawnData) {
        return FXGL.entityBuilder(spawnData)
                .type(MemoryGameType.ELEPHANT)
                .view(MemoryGameType.ELEPHANT.getFileName())
                .build();
    }

    @Spawns("frog")
    public Entity buildFrog(SpawnData spawnData) {
        return FXGL.entityBuilder(spawnData)
                .type(MemoryGameType.FROG)
                .view(MemoryGameType.FROG.getFileName())
                .build();
    }

    @Spawns("lemon")
    public Entity buildLemon(SpawnData spawnData) {
        return FXGL.entityBuilder(spawnData)
                .type(MemoryGameType.LEMON)
                .view(MemoryGameType.LEMON.getFileName())
                .build();
    }

    @Spawns("pear")
    public Entity buildPear(SpawnData spawnData) {
        return FXGL.entityBuilder(spawnData)
                .type(MemoryGameType.PEAR)
                .view(MemoryGameType.PEAR.getFileName())
                .build();
    }
    @Spawns("pig")
    public Entity buildPig(SpawnData spawnData) {
        return FXGL.entityBuilder(spawnData)
                .type(MemoryGameType.PIG)
                .view(MemoryGameType.PIG.getFileName())
                .build();
    }

    @Spawns("rabbit")
    public Entity buildRabbit(SpawnData spawnData) {
        return FXGL.entityBuilder(spawnData)
                .type(MemoryGameType.RABBIT)
                .view(MemoryGameType.RABBIT.getFileName())
                .onClick(e -> System.out.println("Clicked!"))
                .build();
    }

    @Spawns("strawberry")
    public Entity buildStrawberry(SpawnData spawnData) {
        return FXGL.entityBuilder(spawnData)
                .type(MemoryGameType.STRAWBERRY)
                .view(MemoryGameType.STRAWBERRY.getFileName())
                .build();
    }

    @Spawns("watermelon")
    public Entity buildWatermelon(SpawnData spawnData) {
        return FXGL.entityBuilder(spawnData)
                .type(MemoryGameType.WATERMELON)
                .view(MemoryGameType.WATERMELON.getFileName())
                .build();
    }

}
