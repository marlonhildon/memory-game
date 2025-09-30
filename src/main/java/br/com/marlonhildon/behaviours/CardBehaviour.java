package br.com.marlonhildon.behaviours;

import br.com.marlonhildon.constants.MemoryGameType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

public class CardBehaviour {

    private Entity firstCardClicked = null;
    private Entity secondCardClicked = null;

    public void destroyCards() {
        if((firstCardClicked != null && secondCardClicked != null) && isCardsClickedAreSameType()) {
            FXGL.getGameWorld().removeEntities(firstCardClicked,secondCardClicked);
            firstCardClicked = null;
            secondCardClicked = null;
        }
    }

    public Entity buildEntityByType(MemoryGameType cardType) {
        return FXGL.entityBuilder()
                .type(cardType)
                .view(cardType.getFileName())
                .onClick(entity -> {
                    System.out.println(cardType);
                    this.setClickedCardsValues(entity);
                    System.out.println("First card: " + firstCardClicked);
                    System.out.println("Second card: " + secondCardClicked);
                    System.out.println("Are they the same type, but with different coordinates? " + isCardsClickedAreSameType());
                })
                .build();
    }

    private void setClickedCardsValues(Entity cardEntity) {
        if(firstCardClicked != null && secondCardClicked != null) {
            firstCardClicked = null;
            secondCardClicked = null;
        }

        if(firstCardClicked != null) {
            secondCardClicked = cardEntity;
        }

        if (secondCardClicked == null) {
            firstCardClicked = cardEntity;
        }

    }

    private boolean isCardsClickedAreSameType() {
        return  (firstCardClicked != null && secondCardClicked != null) &&
                (firstCardClicked.getType().equals(secondCardClicked.getType())) &&
                !(firstCardClicked.getAnchoredPosition().equals(secondCardClicked.getAnchoredPosition()));
    }

}
