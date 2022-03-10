package xp.workshop.order.rps;

import java.util.function.Function;

public enum Hand {

    ROCK("ROCK", (hand) -> {
        if (hand.value.equals("SCISORSE")) {
            return 1;
        } else if (hand.value.equals("PAPER")) {
            return -1;
        }
        return 0;
    }),
    SCISORSE("SCISORSE", (hand) -> {
        if (hand.value.equals("PAPER")) {
            return 1;
        } else if (hand.value.equals("ROCK")) {
            return -1;
        }
        return 0;
    }),
    PAPER("PAPER", (hand) -> {
        if (hand.value.equals("ROCK")) {
            return 1;
        } else if (hand.value.equals("SCISORSE")) {
            return -1;
        }
        return 0;
    });

    private final String value;
    private final Function<Hand, Integer> play;

    Hand(String value, Function<Hand, Integer> play) {
        this.value = value;
        this.play = play;
    }

    public int versus(Hand hand) {
        return this.play.apply(hand);
    }
}
