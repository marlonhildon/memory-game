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

    private Entity player;

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
            player.translateX(5); // move right 5 pixels
            FXGL.inc("pixelsMoved", +5);
        });

        FXGL.onKey(KeyCode.A, () -> {
            player.translateX(-5); // move left 5 pixels
            FXGL.inc("pixelsMoved", -5);
        });

        FXGL.onKey(KeyCode.W, () -> {
            player.translateY(-5); // move up 5 pixels
            FXGL.inc("pixelsMoved", +5);
        });

        FXGL.onKey(KeyCode.S, () -> {
            player.translateY(5); // move down 5 pixels
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
        player = FXGL.spawn("player", 300, 300);
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
