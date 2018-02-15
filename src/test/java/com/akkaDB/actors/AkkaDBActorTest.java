package com.akkaDB.actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import com.akkaDB.messages.SetRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AkkaDBActorTest {
    ActorSystem system = ActorSystem.create();

    @Test
    public void loadMapWithSetMessageData() {
        TestActorRef<AkkaDBActor> actorRef = TestActorRef.create(system, Props.create(AkkaDBActor.class));
        actorRef.tell(SetRequest.getInstance("Key", "Value"), ActorRef.noSender());

        assertEquals(actorRef.underlyingActor().map.get("Key"), "Value");
    }
}
