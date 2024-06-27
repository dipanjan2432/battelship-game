package view;

import model.Battelfield;
import model.BattleFieldCells;
import model.Player;

public class BattelFieldView {

    public void viewBattleField(Battelfield battelfield) {
        BattleFieldCells[][] battleFieldBoard = battelfield.getBoard();
        for (BattleFieldCells[] battleFieldCells : battleFieldBoard) {
            for (int j = 0; j < battleFieldCells.length; j++) {
                System.out.print(battleFieldCells[j].getId());
                System.out.print("  ");
            }
            System.out.println("");
        }
    }

    public void printWinner(Player player){
        System.out.println(player.getId() + " Is the winner");
    }
}
