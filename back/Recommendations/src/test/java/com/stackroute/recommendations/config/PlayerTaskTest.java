package com.stackroute.recommendations.config;

import static org.mockito.Mockito.when;

import com.stackroute.recommendations.model.PlayerDto;
import com.stackroute.recommendations.model.PlayerResponse;
import com.stackroute.recommendations.service.PlayerService;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PlayerTask.class})
@ExtendWith(SpringExtension.class)
class PlayerTaskTest {
    @MockBean
    private PlayerService playerService;

    @Autowired
    private PlayerTask playerTask;

    /**
     * Method under test: {@link PlayerTask#execute()}
     */
    @Test
    void testExecute() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     PlayerTask.playerService

        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setApiKey("Api Key");
        playerResponse.setData(new ArrayList<>());
        when(playerService.getRemotePlayerResponse()).thenReturn(playerResponse);
        playerTask.execute();
    }

    /**
     * Method under test: {@link PlayerTask#execute()}
     */

    @Disabled("TODO: Complete this test")
    void testExecute2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.ReduceOps$ReduceTask.doLeaf(ReduceOps.java:960)
        //       at java.util.stream.ReduceOps$ReduceTask.doLeaf(ReduceOps.java:934)
        //       at java.util.stream.AbstractTask.compute(AbstractTask.java:327)
        //       at java.util.concurrent.CountedCompleter.exec(CountedCompleter.java:754)
        //       at java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:373)
        //       at java.util.concurrent.ForkJoinTask.invoke(ForkJoinTask.java:686)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateParallel(ReduceOps.java:927)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:233)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
        //       at com.stackroute.recommendations.config.PlayerTask.execute(PlayerTask.java:23)
        //   In order to prevent execute()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   execute().
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<PlayerDto> playerDtoList = new ArrayList<>();
        playerDtoList.add(null);

        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setApiKey("Api Key");
        playerResponse.setData(playerDtoList);
        when(playerService.getRemotePlayerResponse()).thenReturn(playerResponse);
        playerTask.execute();
    }
}

