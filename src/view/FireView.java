package view;

import model.BattleShip;
import model.Player;

public class FireView {

    public void fireStep(Player player, Player opponent, int x, int y, BattleShip destroyed){
        if (destroyed!=null){
            System.out.println(player.getId() + "'s turn: Missile fired at (" + x +"," + y + "). Hit " + opponent.getId() + "'s ship with id " + destroyed.getId());
        } else {
            System.out.println(player.getId() + "'s turn: Missile fired at (" + x +"," + y + "). Miss");
        }
    }
}
