package com.stackroute.recommendations.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class PlayerDtoTest {
    /**
     * Method under test: {@link PlayerDto#of()}
     */
    @Test
    void testOf() {
        Player actualOfResult = (new PlayerDto()).of();
        assertNull(actualOfResult.getCountry());
        assertNull(actualOfResult.getPlayerId());
        assertNull(actualOfResult.getName());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link PlayerDto}
     *   <li>{@link PlayerDto#setCountry(String)}
     *   <li>{@link PlayerDto#setId(String)}
     *   <li>{@link PlayerDto#setName(String)}
     *   <li>{@link PlayerDto#getCountry()}
     *   <li>{@link PlayerDto#getId()}
     *   <li>{@link PlayerDto#getName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        PlayerDto actualPlayerDto = new PlayerDto();
        actualPlayerDto.setCountry("GB");
        actualPlayerDto.setId("42");
        actualPlayerDto.setName("Name");
        assertEquals("GB", actualPlayerDto.getCountry());
        assertEquals("42", actualPlayerDto.getId());
        assertEquals("Name", actualPlayerDto.getName());
    }
}

