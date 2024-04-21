package com.stackroute.recommendations.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PlayerTest {
    /**
     * Method under test: {@link Player#modify(Player)}
     */
    @Test
    void testModify() {
        Player player = new Player();

        Player player1 = new Player();
        player1.setCountry("GB");
        player1.setId(ObjectId.get());
        player1.setName("Name");
        player1.setPlayerId("42");
        player.modify(player1);
        assertEquals("GB", player.getCountry());
        assertEquals("42", player.getPlayerId());
        assertEquals("Name", player.getName());
    }

    /**
     * Method under test: {@link Player#modify(Player)}
     */
    @Test
    void testModify2() {
        Player player = new Player();

        Player player1 = new Player();
        player1.setCountry(null);
        player1.setId(ObjectId.get());
        player1.setName("Name");
        player1.setPlayerId("42");
        player.modify(player1);
        assertEquals("42", player.getPlayerId());
        assertEquals("Name", player.getName());
    }

    /**
     * Method under test: {@link Player#modify(Player)}
     */
    @Test
    void testModify3() {
        Player player = new Player();

        Player player1 = new Player();
        player1.setCountry("GB");
        player1.setId(ObjectId.get());
        player1.setName(null);
        player1.setPlayerId("42");
        player.modify(player1);
        assertEquals("GB", player.getCountry());
        assertEquals("42", player.getPlayerId());
    }

    /**
     * Method under test: {@link Player#modify(Player)}
     */
    @Test
    void testModify4() {
        Player player = new Player();

        Player player1 = new Player();
        player1.setCountry("GB");
        player1.setId(ObjectId.get());
        player1.setName("Name");
        player1.setPlayerId(null);
        player.modify(player1);
        assertEquals("GB", player.getCountry());
        assertEquals("Name", player.getName());
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */

    @Disabled("TODO: Complete this test")
    void testEquals6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "str" is null
        //       at com.stackroute.recommendations.model.Player.equals(Player.java:68)
        //   In order to prevent equals(Object)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   equals(Object).
        //   See https://diff.blue/R013 to resolve this issue.

        Player player = new Player();
        player.setCountry(null);
        player.setId(ObjectId.get());
        player.setName("Name");
        player.setPlayerId("42");

        Player player1 = new Player();
        player1.setCountry("GB");
        player1.setId(ObjectId.get());
        player1.setName("Name");
        player1.setPlayerId("42");
        assertThrows(NullPointerException.class, () -> player.equals(player1));
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */

    @Disabled("TODO: Complete this test")
    void testEquals8() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "str" is null
        //       at com.stackroute.recommendations.model.Player.equals(Player.java:68)
        //   In order to prevent equals(Object)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   equals(Object).
        //   See https://diff.blue/R013 to resolve this issue.

        Player player = new Player();
        player.setCountry("GB");
        player.setId(ObjectId.get());
        player.setName(null);
        player.setPlayerId("42");

        Player player1 = new Player();
        player1.setCountry("GB");
        player1.setId(ObjectId.get());
        player1.setName("Name");
        player1.setPlayerId("42");
        assertThrows(NullPointerException.class, () -> player.equals(player1));
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */

    @Disabled("TODO: Complete this test")
    void testEquals10() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "str" is null
        //       at com.stackroute.recommendations.model.Player.equals(Player.java:68)
        //   In order to prevent equals(Object)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   equals(Object).
        //   See https://diff.blue/R013 to resolve this issue.

        Player player = new Player();
        player.setCountry("GB");
        player.setId(ObjectId.get());
        player.setName("Name");
        player.setPlayerId(null);

        Player player1 = new Player();
        player1.setCountry("GB");
        player1.setId(ObjectId.get());
        player1.setName("Name");
        player1.setPlayerId("42");
        assertThrows(NullPointerException.class, () -> player.equals(player1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Player}
     *   <li>{@link Player#setCountry(String)}
     *   <li>{@link Player#setId(ObjectId)}
     *   <li>{@link Player#setName(String)}
     *   <li>{@link Player#setPlayerId(String)}
     *   <li>{@link Player#getCountry()}
     *   <li>{@link Player#getId()}
     *   <li>{@link Player#getName()}
     *   <li>{@link Player#getPlayerId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Player actualPlayer = new Player();
        actualPlayer.setCountry("GB");
        ObjectId getResult = ObjectId.get();
        actualPlayer.setId(getResult);
        actualPlayer.setName("Name");
        actualPlayer.setPlayerId("42");
        assertEquals("GB", actualPlayer.getCountry());
        assertSame(getResult, actualPlayer.getId());
        assertEquals("Name", actualPlayer.getName());
        assertEquals("42", actualPlayer.getPlayerId());
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals() {
        Player player = new Player();
        player.setCountry("GB");
        player.setId(ObjectId.get());
        player.setName("Name");
        player.setPlayerId("42");
        assertNotEquals(player, null);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals2() {
        Player player = new Player();
        player.setCountry("GB");
        player.setId(ObjectId.get());
        player.setName("Name");
        player.setPlayerId("42");
        assertNotEquals(player, "Different type to Player");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Player#equals(Object)}
     *   <li>{@link Player#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Player player = new Player();
        player.setCountry("GB");
        player.setId(ObjectId.get());
        player.setName("Name");
        player.setPlayerId("42");
        assertEquals(player, player);
        int expectedHashCodeResult = player.hashCode();
        assertEquals(expectedHashCodeResult, player.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Player#equals(Object)}
     *   <li>{@link Player#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        Player player = new Player();
        player.setCountry("GB");
        player.setId(ObjectId.get());
        player.setName("Name");
        player.setPlayerId("42");

        Player player1 = new Player();
        player1.setCountry("GB");
        player1.setId(ObjectId.get());
        player1.setName("Name");
        player1.setPlayerId("42");
        assertEquals(player, player1);
        int expectedHashCodeResult = player.hashCode();
        assertEquals(expectedHashCodeResult, player1.hashCode());
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals5() {
        Player player = new Player();
        player.setCountry("GBR");
        player.setId(ObjectId.get());
        player.setName("Name");
        player.setPlayerId("42");

        Player player1 = new Player();
        player1.setCountry("GB");
        player1.setId(ObjectId.get());
        player1.setName("Name");
        player1.setPlayerId("42");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals7() {
        Player player = new Player();
        player.setCountry("GB");
        player.setId(ObjectId.get());
        player.setName("42");
        player.setPlayerId("42");

        Player player1 = new Player();
        player1.setCountry("GB");
        player1.setId(ObjectId.get());
        player1.setName("Name");
        player1.setPlayerId("42");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals9() {
        Player player = new Player();
        player.setCountry("GB");
        player.setId(ObjectId.get());
        player.setName("Name");
        player.setPlayerId("Name");

        Player player1 = new Player();
        player1.setCountry("GB");
        player1.setId(ObjectId.get());
        player1.setName("Name");
        player1.setPlayerId("42");
        assertNotEquals(player, player1);
    }
}

