public class Coin2 {
    static char rarity = 'c';
    static int value = 1;
    static int xPos = -1;
    static int yPos = -1;

    static void changePosition() {
        if (Player.xPos == xPos && Player.yPos == yPos) {
            Player.cash += value;
        }
        if (Player2.xPos == xPos && Player2.yPos == yPos) {
            Player2.cash += value;
        }
        while (Player.xPos == xPos && Player.yPos == yPos || Player2.xPos == xPos && Player2.yPos == yPos || Coin1.xPos == xPos && Coin1.yPos == yPos || Coin.xPos == xPos && Coin.xPos == yPos) {
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
