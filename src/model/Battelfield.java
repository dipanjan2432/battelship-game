package model;

import java.util.Arrays;

public class Battelfield {
    BattleFieldCells[][] board;
    public Battelfield(int size) {
        board = new BattleFieldCells[size][size];
        for (BattleFieldCells[] row : board) {
            Arrays.fill(row, new EmptyCells());
        }
    }

   public void addShip(int row, int col, int size, String id) throws RuntimeException {
        BattleShip ship = new BattleShip(id);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int r = row + i;
                int c = col + j;
                if (board[r][c] instanceof BattleShip) {
                    throw new RuntimeException("Ship is already present in the given coordinates");
                }
                board[r][c] = ship;
            }
        }
    }

    public Boolean isPlayerDestroyed(Player player){
        boolean isDestroyed = true;
        for(int i = player.startX ;i<=player.endX;i++){
            for(int j = player.startY; j<= player.endY;j++){
                BattleFieldCells cell = board[i][j];
                if (cell instanceof BattleShip){
                    if (!((BattleShip) cell).isDestroyed()){
                        isDestroyed = false;
                        break;
                    }
                }
            }
        }
        return  isDestroyed;
    }

    public BattleShip fire(int x , int y) {
        BattleFieldCells cell = board[x][y];
        if (cell instanceof BattleShip && !((BattleShip) cell).isDestroyed()){
            ((BattleShip) cell).destroyShip();
            return   (BattleShip) cell;
        }
        return null;
    }

    public int getBoardSize() throws RuntimeException {
        return board.length;
    }

    public BattleFieldCells[][] getBoard() {
        return board;
    }




}
