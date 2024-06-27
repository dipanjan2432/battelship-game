package controller;

public interface BattelFieldRepository {

    void initGame(int N, String playerId1, String playerId2);

    void addShip(int x, int y,int capacity) throws RuntimeException;

    void startGame() throws RuntimeException;

    void viewBattleField() throws RuntimeException;

}
