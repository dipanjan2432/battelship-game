package controller;

import model.Battelfield;
import model.BattleShip;
import model.FireStrategy;
import model.Player;
import view.BattelFieldView;
import view.FireView;

public class InMemoryBattelFieldRepository implements BattelFieldRepository {
    private int numShip = 0;
    private FireStrategy fireStrategy;
    private Player player1;
    private Player player2;
    private Battelfield battelfield;
    private BattelFieldView battelFieldView;
    private FireView fireView;

    public InMemoryBattelFieldRepository(FireStrategy fireStrategy, BattelFieldView battelFieldView, FireView fireView) {
        this.fireStrategy = fireStrategy;
        this.battelFieldView = battelFieldView;
        this.fireView = fireView;
    }

    @Override
    public void initGame(int N, String playerId1, String playerId2) {
        player1 = new Player(playerId1, 0, N - 1, 0, N / 2 - 1);
        player2 = new Player(playerId2, 0, N - 1, N / 2, N - 1);
        this.battelfield = new Battelfield(N);
    }

    @Override
    public void addShip(int x, int y, int capacity) throws RuntimeException {
        checkGameInitialised();
        numShip++;
        int n = battelfield.getBoardSize();

        if (x >= n) {
            throw new RuntimeException("row should be smaller than Field size");
        }

        if (y >= (n / 2)) {
            throw new RuntimeException("Column should be smaller than half of the Field size");
        }

        if (capacity >= n / 2) {
            throw new RuntimeException("Capacity should be smaller than half of the Field size");
        }

        battelfield.addShip(x, y, capacity, player1.getId() + "-SH" + numShip);
        battelfield.addShip(x, y + n / 2, capacity, player2.getId() + "-SH" + numShip);
    }

    @Override
    public void startGame() throws RuntimeException {
        checkGameInitialised();
        Player turn = player1;
        Player opponent = player2;
        while(true){
            int[] fireCoordinates = fireStrategy.getFireCoordinates(turn, opponent);
            BattleShip ship = battelfield.fire(fireCoordinates[0], fireCoordinates[1]);
            fireView.fireStep(turn, opponent, fireCoordinates[0], fireCoordinates[1], ship);
            if (battelfield.isPlayerDestroyed(opponent)){
                break;
            }
            Player temp = opponent;
            opponent = turn;
            turn = temp;
        }
        battelFieldView.printWinner(turn);
    }

    @Override
    public void viewBattleField() throws RuntimeException {
       checkGameInitialised();
       battelFieldView.viewBattleField(battelfield);

    }

    private void checkGameInitialised() throws RuntimeException {
        if (battelfield == null) {
            throw new RuntimeException("Game is not initialized.");
        }
    }
}
