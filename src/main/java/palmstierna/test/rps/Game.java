package palmstierna.test.rps;

import java.util.UUID;

/**
 * The Game class provides constructor for creating a RockPaperScissor session
 * and methods to get and set Players and their chosen moves.
 *
 * @author Magnus P.
 */
public class Game {
    private UUID id;
    private Player firstPlayer;
    private Player secondPlayer;

    /**
     * Instantiates a new Game.
     *
     * @param name the name
     */
    public Game(String name) {
        firstPlayer = new Player(name);
        id = UUID.randomUUID();
    }

    /**
     * Get id uuid.
     *
     * @return the uuid
     */
    public UUID getId() {
        return id;
    }

    /**
     * Get first player object.
     *
     * @return the player
     */
    public Player getFirstPlayer() {
        return firstPlayer;
    }

    /**
     * Get second player object.
     *
     * @return the player
     */
    public Player getSecondPlayer() {
        return secondPlayer;
    }

    /**
     * Instantiates the second player.
     *
     * @param name name of the player
     */
    public void join(String name) {
        secondPlayer = new Player(name);
    }

    /**
     * Checks which player is calling to make a move by comparing with the name variable of
     * each player. For the object which the name matches, the hand of that player is set to
     * the matching value of the string parameter hand.
     *
     * @param name the name
     * @param hand the hand
     */
    public void move(String name, String hand) {
        if (firstPlayer.getName().equalsIgnoreCase(name)) {
            firstPlayer.setHand(Hand.valueOf(hand));
        } else if (secondPlayer.getName().equalsIgnoreCase(name)) {
            secondPlayer.setHand(Hand.valueOf(hand));
        }
    }

    /**
     * Get result outcome. Checks if both players have made their moves. If yes, the switch-statement returns
     * an Outcome based on which are the two moves. If not, return UNFINISHED.
     *
     * @return the outcome
     */
    public Outcome getResult() {

        switch (firstPlayer.getHand()) {
            case ROCK:
                switch (secondPlayer.getHand()) {
                    case ROCK:
                        return Outcome.TIE;
                    case SCISSORS:
                        return Outcome.ONE;
                    case PAPER:
                        return Outcome.TWO;
                    default:
                        return Outcome.UNFINISHED;
                }
            case SCISSORS:
                switch (secondPlayer.getHand()) {
                    case ROCK:
                        return Outcome.TWO;
                    case SCISSORS:
                        return Outcome.TIE;
                    case PAPER:
                        return Outcome.ONE;
                    default:
                        return Outcome.UNFINISHED;
                }
            case PAPER:
                switch (secondPlayer.getHand()) {
                    case ROCK:
                        return Outcome.ONE;
                    case SCISSORS:
                        return Outcome.TWO;
                    case PAPER:
                        return Outcome.TIE;
                    default:
                        return Outcome.UNFINISHED;
                }
            default:
                return Outcome.UNFINISHED;
        }
    }

    @Override
    public String toString() {
        String s = getId().toString();
        if (firstPlayer != null) {
            s += "\n" + firstPlayer.getName() + " is connected.";
            if (firstPlayer.getHand() != Hand.NONE) {
                s += "\n" + "They have made their move.";
            }
        }
        if (secondPlayer != null) {
            s += "\n" + secondPlayer.getName() + " is connected.";
            if (secondPlayer.getHand() != Hand.NONE) {
                s += "\n" + "They have made their move.";
            }
        }

        return s;
    }

    /**
     * The type Player. Contains a string for a name and an Hand-enum to represent their chosen move
     */
    class Player {
        private String name;
        private Hand hand;

        /**
         * Instantiates a new Player. When instantiated hand is None.
         *
         * @param name the name
         */
        public Player(String name) {
            this.name = name;
            hand = Hand.NONE;
        }

        /**
         * Get name string.
         *
         * @return the string
         */
        public String getName() {
            return name;
        }

        /**
         * Get hand hand.
         *
         * @return the hand
         */
        public Hand getHand() {
            return hand;
        }

        /**
         * Set hand.
         *
         * @param hand the hand
         */
        public void setHand(Hand hand) {
            this.hand = hand;
        }
    }

    /**
     * Enum representing the possible moves the player can make.
     */
    private enum Hand {
        ROCK,
        PAPER,
        SCISSORS,
        NONE,
    }

}
