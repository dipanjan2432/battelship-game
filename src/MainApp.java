import controller.BattelFieldRepository;
import controller.InMemoryBattelFieldRepository;
import model.FireStrategy;
import model.RandomFireStrategy;
import view.BattelFieldView;
import view.FireView;

public class MainApp {
    public static void main(String[] args) {
        FireStrategy fireStrategy = new RandomFireStrategy();
        BattelFieldView battelFieldView = new BattelFieldView();
        FireView fireView = new FireView();
        BattelFieldRepository battelFieldRepository = new InMemoryBattelFieldRepository(fireStrategy,battelFieldView, fireView);
        battelFieldRepository.initGame(10, "A","B");
        battelFieldRepository.addShip(0,0,2);
        battelFieldRepository.addShip(3,2,2);
        battelFieldRepository.viewBattleField();
        battelFieldRepository.startGame();
    }
}