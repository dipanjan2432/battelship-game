package model;

public class BattleShip implements BattleFieldCells {

    private String id;
    private Boolean isDestroyed;
    BattleShip(String id){
        this.id = id;
        this.isDestroyed = false;
    }

    @Override
    public String getId() {
        return id;
    }

    Boolean isDestroyed() {
        return isDestroyed;
    }

    void destroyShip(){
       isDestroyed = true;
    }
}
