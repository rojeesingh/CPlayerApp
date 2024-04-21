package com.stackroute.recommendations.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.stackroute.recommendations.model.Player;
import com.stackroute.recommendations.model.PlayerResponse;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@ContextConfiguration(classes = {PlayerServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PlayerServiceImplTest {
    @MockBean
    private MongoTemplate mongoTemplate;

    @Autowired
    private PlayerServiceImpl playerServiceImpl;

    @MockBean
    private RestTemplate restTemplate;

    /**
     * Method under test: {@link PlayerServiceImpl#addOrUpdate(Player)}
     */

    void testAddOrUpdate() {
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

        Player player2 = new Player();
        player2.setCountry("GB");
        player2.setId(ObjectId.get());
        player2.setName("Name");
        player2.setPlayerId("42");
        when(mongoTemplate.insert((Object) any())).thenReturn("Insert");
        when(mongoTemplate.save((Player) any())).thenReturn(player2);
        when(mongoTemplate.findOne((Query) any(), (Class<Player>) any())).thenReturn(player);
        when(mongoTemplate.insert((Player) any())).thenReturn(player1);

        Player player3 = new Player();
        player3.setCountry("GB");
        player3.setId(ObjectId.get());
        player3.setName("Name");
        player3.setPlayerId("42");
        assertSame(player2, playerServiceImpl.addOrUpdate(player3));
        verify(mongoTemplate).findOne((Query) any(), (Class<Player>) any());
        verify(mongoTemplate).insert((Object) any());
        verify(mongoTemplate).save((Player) any());
    }

    /**
     * Method under test: {@link PlayerServiceImpl#addOrUpdate(Player)}
     */

    void testAddOrUpdate2() {
        Player player = mock(Player.class);
        doNothing().when(player).modify((Player) any());
        doNothing().when(player).setCountry((String) any());
        doNothing().when(player).setId((ObjectId) any());
        doNothing().when(player).setName((String) any());
        doNothing().when(player).setPlayerId((String) any());
        player.setCountry("GB");
        player.setId(ObjectId.get());
        player.setName("Name");
        player.setPlayerId("42");

        Player player1 = new Player();
        player1.setCountry("GB");
        player1.setId(ObjectId.get());
        player1.setName("Name");
        player1.setPlayerId("42");

        Player player2 = new Player();
        player2.setCountry("GB");
        player2.setId(ObjectId.get());
        player2.setName("Name");
        player2.setPlayerId("42");
        when(mongoTemplate.insert((Object) any())).thenReturn("Insert");
        when(mongoTemplate.save((Player) any())).thenReturn(player2);
        when(mongoTemplate.findOne((Query) any(), (Class<Player>) any())).thenReturn(player);
        when(mongoTemplate.insert((Player) any())).thenReturn(player1);

        Player player3 = new Player();
        player3.setCountry("GB");
        player3.setId(ObjectId.get());
        player3.setName("Name");
        player3.setPlayerId("42");
        assertSame(player2, playerServiceImpl.addOrUpdate(player3));
        verify(mongoTemplate).findOne((Query) any(), (Class<Player>) any());
        verify(mongoTemplate).insert((Object) any());
        verify(mongoTemplate).save((Object) any());
        verify(player).modify((Player) any());
        verify(player).setCountry((String) any());
        verify(player).setId((ObjectId) any());
        verify(player).setName((String) any());
        verify(player).setPlayerId((String) any());
    }

    /**
     * Method under test: {@link PlayerServiceImpl#addOrUpdate(Player)}
     */

    void testAddOrUpdate3() {
        Player player = mock(Player.class);
        doNothing().when(player).modify((Player) any());
        doNothing().when(player).setCountry((String) any());
        doNothing().when(player).setId((ObjectId) any());
        doNothing().when(player).setName((String) any());
        doNothing().when(player).setPlayerId((String) any());
        player.setCountry("GB");
        player.setId(ObjectId.get());
        player.setName("Name");
        player.setPlayerId("42");

        Player player1 = new Player();
        player1.setCountry("GB");
        player1.setId(ObjectId.get());
        player1.setName("Name");
        player1.setPlayerId("42");

        Player player2 = new Player();
        player2.setCountry("GB");
        player2.setId(ObjectId.get());
        player2.setName("Name");
        player2.setPlayerId("42");
        when(mongoTemplate.insert((Object) any())).thenReturn("Insert");
        when(mongoTemplate.save((Player) any())).thenReturn(player2);
        when(mongoTemplate.findOne((Query) any(), (Class<Player>) any())).thenReturn(player);
        when(mongoTemplate.insert((Player) any())).thenReturn(player1);
        Player player3 = mock(Player.class);
        when(player3.getPlayerId()).thenReturn("42");
        doNothing().when(player3).setCountry((String) any());
        doNothing().when(player3).setId((ObjectId) any());
        doNothing().when(player3).setName((String) any());
        doNothing().when(player3).setPlayerId((String) any());
        player3.setCountry("GB");
        player3.setId(ObjectId.get());
        player3.setName("Name");
        player3.setPlayerId("42");
        assertSame(player2, playerServiceImpl.addOrUpdate(player3));
        verify(mongoTemplate).findOne((Query) any(), (Class<Player>) any());
        verify(mongoTemplate).insert((Object) any());
        verify(mongoTemplate).save((Object) any());
        verify(player).modify((Player) any());
        verify(player).setCountry((String) any());
        verify(player).setId((ObjectId) any());
        verify(player).setName((String) any());
        verify(player).setPlayerId((String) any());
        verify(player3).getPlayerId();
        verify(player3).setCountry((String) any());
        verify(player3).setId((ObjectId) any());
        verify(player3).setName((String) any());
        verify(player3).setPlayerId((String) any());
    }

    /**
     * Method under test: {@link PlayerServiceImpl#recommend(Integer)}
     */
    @Test
    void testRecommend() {
        ArrayList<Player> playerList = new ArrayList<>();
        when(mongoTemplate.findAll((Class<Player>) any())).thenReturn(playerList);
        List<Player> actualRecommendResult = playerServiceImpl.recommend(3);
        assertSame(playerList, actualRecommendResult);
        assertTrue(actualRecommendResult.isEmpty());
        verify(mongoTemplate).findAll((Class<Player>) any());
    }

    /**
     * Method under test: {@link PlayerServiceImpl#recommend(Integer)}
     */
    @Test
    void testRecommend2() {
        ArrayList<Player> playerList = new ArrayList<>();
        when(mongoTemplate.findAll((Class<Player>) any())).thenReturn(playerList);
        List<Player> actualRecommendResult = playerServiceImpl.recommend(0);
        assertSame(playerList, actualRecommendResult);
        assertTrue(actualRecommendResult.isEmpty());
        verify(mongoTemplate).findAll((Class<Player>) any());
    }

    /**
     * Method under test: {@link PlayerServiceImpl#getRemotePlayerResponse()}
     */
    @Test
    void testGetRemotePlayerResponse() throws RestClientException {
        when(restTemplate.getForEntity((String) any(), (Class<PlayerResponse>) any(), (Object[]) any()))
                .thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        assertNull(playerServiceImpl.getRemotePlayerResponse());
        verify(restTemplate).getForEntity((String) any(), (Class<PlayerResponse>) any(), (Object[]) any());
    }

    /**
     * Method under test: {@link PlayerServiceImpl#getRemotePlayerResponse()}
     */

    @Disabled("TODO: Complete this test")
    void testGetRemotePlayerResponse2() throws RestClientException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.http.ResponseEntity.getBody()" because "forEntity" is null
        //       at com.stackroute.recommendations.service.PlayerServiceImpl.getRemotePlayerResponse(PlayerServiceImpl.java:53)
        //   In order to prevent getRemotePlayerResponse()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getRemotePlayerResponse().
        //   See https://diff.blue/R013 to resolve this issue.

        when(restTemplate.getForEntity((String) any(), (Class<PlayerResponse>) any(), (Object[]) any())).thenReturn(null);
        playerServiceImpl.getRemotePlayerResponse();
    }
}

