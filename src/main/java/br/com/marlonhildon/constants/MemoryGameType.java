package br.com.marlonhildon.constants;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum MemoryGameType {

    APPLE("apple.png"),
    BANANA("banana.png"),
    BEAR("bear.png"),
    CAT("cat.png"),
    ELEPHANT("elephant.png"),
    FROG("frog.png"),
    LEMON("lemon.png"),
    PEAR("pear.png"),
    PIG("pig.png"),
    RABBIT("rabbit.png"),
    STRAWBERRY("strawberry.png"),
    WATERMELON("watermelon.png");

    private final String fileName;

}
