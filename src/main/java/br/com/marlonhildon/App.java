package br.com.marlonhildon;

import br.com.marlonhildon.entities.MemoryGameEntityFactory;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

import java.util.Map;

public class App extends GameApplication {

    private Entity appleCard;
    private Entity bananaCard;
    private Entity bearCard;
    private Entity catCard;
    private Entity elephantCard;
    private Entity frogCard;
    private Entity lemonCard;
    private Entity pearCard;
    private Entity pigCard;
    private Entity rabbitCard;
    private Entity strawberryCard;
    private Entity watermelonCard;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setTitle("Memory Game");
        settings.setVersion("0.1-ALPHA");
    }

    @Override
    protected void initInput() {
        FXGL.onKey(KeyCode.D, () -> {
            rabbitCard.translateX(5); // move right 5 pixels
            FXGL.inc("pixelsMoved", +5);
        });

        FXGL.onKey(KeyCode.A, () -> {
            rabbitCard.translateX(-5); // move left 5 pixels
            FXGL.inc("pixelsMoved", -5);
        });

        FXGL.onKey(KeyCode.W, () -> {
            rabbitCard.translateY(-5); // move up 5 pixels
            FXGL.inc("pixelsMoved", +5);
        });

        FXGL.onKey(KeyCode.S, () -> {
            rabbitCard.translateY(5); // move down 5 pixels
            FXGL.inc("pixelsMoved", +5);
        });
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("pixelsMoved", 0);
    }

    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new MemoryGameEntityFactory());
        appleCard = FXGL.spawn("apple", 0, 0);
        bananaCard = FXGL.spawn("banana", 173, 0);
        bearCard = FXGL.spawn("bear", 346, 0);
        catCard = FXGL.spawn("cat", 519, 0);
        elephantCard = FXGL.spawn("elephant", 0, 173);
        frogCard = FXGL.spawn("frog", 173, 173);
        lemonCard = FXGL.spawn("lemon", 346, 173);
        pearCard = FXGL.spawn("pear", 519, 173);
        pigCard = FXGL.spawn("pig", 0, 346);
        rabbitCard = FXGL.spawn("rabbit", 173, 346);
        strawberryCard = FXGL.spawn("strawberry", 346, 346);
        watermelonCard = FXGL.spawn("watermelon", 519, 346);
    }

    @Override
    protected void initUI() {
        Text textPixels = new Text();
        textPixels.setTranslateX(50);
        textPixels.setTranslateY(100);

        textPixels.textProperty().bind(FXGL.getWorldProperties().intProperty("pixelsMoved").asString());

        FXGL.getGameScene().addUINode(textPixels);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
