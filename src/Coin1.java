public class Coin1 {
    static char rarity = 'c';
    static int value = 1;
    static int xPos = -1;
    static int yPos = -1;

    static void changePosition() {
        Player.cash += value;
        while (Player.xPos == xPos && Player.yPos == yPos || Coin.xPos == xPos && Coin.yPos == yPos || Coin2.xPos == xPos && Coin2.yPos == yPos) {
            xPos = (int) (Math.random() * Grid.width);
            yPos = (int) (Math.random() * Grid.height);
        }
        double random = Math.random();
        if (random >= 0.06*Shop.rarityMultiplier) {
            rarity = 'c';
            value = 1;
        }
        if (random < 0.06*Shop.rarityMultiplier) {
            rarity = 'r';
            value = 5;
        }
        if (random < 0.01*Shop.rarityMultiplier) {
            rarity = 'l';
            value = 25;
        }
    }
}
