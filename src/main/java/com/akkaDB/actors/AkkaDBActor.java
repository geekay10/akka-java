package com.akkaDB.actors;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import com.akkaDB.messages.SetRequest;

import java.util.HashMap;
import java.util.Map;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

public class AkkaDBActor extends AbstractActor {
    protected final Map<String, Object> map = new HashMap<>();

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(
                SetRequest.class, message -> map.put(message.getKey(), message.getValue()))
                .matchAny(o -> println("Received Unknown Message"))
                .build();
    }

    public AkkaDBActor() {
        createReceive().onMessage();
    }
}
