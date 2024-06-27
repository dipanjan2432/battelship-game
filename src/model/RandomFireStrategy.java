package model;

import view.BattelFieldView;
import view.FireView;

import java.util.Random;

public class RandomFireStrategy implements FireStrategy {

    Random rn = new Random();

    @Override
    public int[] getFireCoordinates(Player player, Player opponent) {
        int fireX = rn.nextInt(opponent.endX - opponent.startX + 1) + opponent.startX;
        int fireY = rn.nextInt(opponent.endY - opponent.startY + 1) + opponent.startY;
        return new int[] { fireX, fireY};
    }
}
