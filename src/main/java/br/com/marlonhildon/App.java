package br.com.marlonhildon;

import br.com.marlonhildon.behaviours.CardBehaviour;
import br.com.marlonhildon.constants.MemoryGameType;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.text.Text;

import java.util.*;

public class App extends GameApplication {

    private final int SCREEN_WIDTH = 800;
    private final int SCREEN_HEIGHT = 600;
    private final CardBehaviour CARD_BEHAVIOUR = new CardBehaviour();
    private final int MAX_UNIQUE_CARDS = 6;
    private final int CARD_SIZE_PIXELS = 173;
    private Entity firstCardClicked;
    private Entity secondCardClicked;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(SCREEN_WIDTH);
        settings.setHeight(SCREEN_HEIGHT);
        settings.setTitle("Memory Game");
        settings.setVersion("0.1-ALPHA");
    }

    @Override
    protected void initInput() {

    }

    @Override
    protected void onUpdate(double tpf) {
        CARD_BEHAVIOUR.destroyCards();
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("pixelsMoved", 0);
    }

    @Override
    protected void initGame() {
        List<MemoryGameType> cardTypes = new ArrayList<>(Arrays.asList(MemoryGameType.values()));
        List<Entity> cardsToRender = new ArrayList<>();
        Random rand = new Random();

        //Picks 6 unique cards
        for(int i = 0; i< MAX_UNIQUE_CARDS; i++) {
            MemoryGameType cardType = cardTypes.get(rand.nextInt(cardTypes.size()));
            cardsToRender.add(CARD_BEHAVIOUR.buildEntityByType(cardType));
            cardsToRender.add(CARD_BEHAVIOUR.buildEntityByType(cardType));
            cardTypes.remove(cardType);
        }

        //Sorts the card list and spawns it
        int xRenderCoordinate = 0, yRenderCoordinate = 0;
        Collections.shuffle(cardsToRender, rand);
        Collections.shuffle(cardsToRender, rand);

        for(Entity cardEntity : cardsToRender) {
            cardEntity.setAnchoredPosition(xRenderCoordinate,yRenderCoordinate);
            xRenderCoordinate += CARD_SIZE_PIXELS;

            if((xRenderCoordinate + CARD_SIZE_PIXELS) > SCREEN_WIDTH) {
                xRenderCoordinate = 0;
                yRenderCoordinate += CARD_SIZE_PIXELS;
            }

            FXGL.getGameWorld().addEntities(cardEntity);
        }

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
