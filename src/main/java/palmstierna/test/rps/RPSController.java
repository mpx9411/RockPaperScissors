package palmstierna.test.rps;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

/**
 * The type RPS controller.
 */
@RestController
public class RPSController {

    private HashMap<UUID, Game> gameRep = new HashMap<>();

    /**
     * Get summary of game by fetching the correct game with the UUID and
     * returning the toString() of the Game object. id is validated and incorrect input
     * gives custom error message instead.
     *
     * @param id the id
     * @return the string
     */
    @GetMapping("/games/{id}")
    public String getGame(@PathVariable String id) {
        Game game = gameRep.get(UUID.fromString(id));
        return (game == null ? "Game does not exist" : game.toString());
    }

    /**
     * Create game containing a new player with the name parameter as constructor argument,
     * and then inserts it into the map of active games. Returns the UUID as a string.
     *
     * @param name the name
     * @return the string
     */
    @PostMapping("/games/")
    public String createGame(@RequestParam(name = "name") String name) {
        Game newGame = new Game(name);
        gameRep.put(newGame.getId(), newGame);
        return newGame.getId().toString();
    }

    /**
     * Join a game by fetching the game from the map with the id converted to a UUID and
     * running the join method with the given name as argument. id is validated and incorrect input gives
     * custom error message.
     *
     * @param id   the id
     * @param name the name
     */
    @PostMapping("/games/{id}/join")
    public String join(@PathVariable String id, @RequestParam(name = "name") String name) {
        UUID uuid = UUID.fromString(id);
        if(gameRep.get(uuid) == null){
            return "Game does not exist";
        }
        return gameRep.get(uuid).join(name);
    }

    /**
     * Make a move by fetching the game from the map with the id converted to a UUID and running the move method
     * with the name-string and the move-string. Every parameter is validated and incorrect input gives specific
     * error messages.
     *
     * @param id   the id
     * @param name the name
     * @param move the move
     * @return the string
     */
    @PostMapping("/games/{id}/move")
    public String move(@PathVariable String id, @RequestParam(name = "name") String name, @RequestParam(name = "move") String move) throws InterruptedException {
        UUID uuid = UUID.fromString(id);
        Game game = gameRep.get(uuid);
        if(game == null){
            return "Game does not exist!";
        }
        if(!game.hasPlayer(name)){
            return "Player does not exist!";
        }
        try{
            Hand enumMove = Hand.valueOf(move);
        }catch (IllegalArgumentException e){
            return "Invalid move!";
        }

        gameRep.get(uuid).move(name, move);
        Outcome result = gameRep.get(uuid).getResult();
        while (result == Outcome.UNFINISHED) {
            Thread.sleep(1000);
            result = gameRep.get(uuid).getResult();
        }
        Game finishedGame = gameRep.get(uuid);
        switch (result) {
            case ONE:
                return finishedGame.getFirstPlayer().getName() + " is the winner";
            case TWO:
                return finishedGame.getSecondPlayer().getName() + " is the winner";
            default:
                return "It's a tie!";
        }
    }
}
