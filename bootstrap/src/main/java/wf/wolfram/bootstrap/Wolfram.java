package wf.wolfram.bootstrap;

import akka.actor.ActorSystem;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Wolfram {

    public static void main(String[] args) {

        log.info("Preparing environment");

        ActorSystem system = ActorSystem.create();

    }

}
