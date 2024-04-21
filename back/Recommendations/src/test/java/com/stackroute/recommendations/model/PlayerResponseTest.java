package com.stackroute.recommendations.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class PlayerResponseTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link PlayerResponse}
     *   <li>{@link PlayerResponse#setApiKey(String)}
     *   <li>{@link PlayerResponse#setData(List)}
     *   <li>{@link PlayerResponse#getApiKey()}
     *   <li>{@link PlayerResponse#getData()}
     * </ul>
     */
    @Test
    void testConstructor() {
        PlayerResponse actualPlayerResponse = new PlayerResponse();
        actualPlayerResponse.setApiKey("Api Key");
        ArrayList<PlayerDto> playerDtoList = new ArrayList<>();
        actualPlayerResponse.setData(playerDtoList);
        assertEquals("Api Key", actualPlayerResponse.getApiKey());
        assertSame(playerDtoList, actualPlayerResponse.getData());
    }
}

