public class Shop {
    static int numCoins = 1;
    static double rarityMultiplier = 1.0;
    static int numCoinsPrice = 20;
    static int rarityPrice = 10;
    public static void openShop() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        String print;
        if (Player.selected == 'c') {
            if (Player.cash < 10) {
                print = "+----------SHOP----------+\n" +
                        "+-----------$" + Player.cash + "-----------+\n" +
                        "+-X-Num of coins--" + numCoins + "--" + "$" + numCoinsPrice + "-+\n" +
                        "+---Coins rarity-" + rarityMultiplier + "-" + "$" + rarityPrice + "-+\n" +
                        "+------------------------+\n";
            } else if (Player.cash < 100) {
                print = "+----------SHOP----------+\n" +
                        "+----------$" + Player.cash + "-----------+\n" +
                        "+-X-Num of coins--" + numCoins + "--" + "$" + numCoinsPrice + "-+\n" +
                        "+---Coins rarity-" + rarityMultiplier + "-" + "$" + rarityPrice + "-+\n" +
                        "+------------------------+\n";
            } else {
                print = "+----------SHOP----------+\n" +
                        "+----------$" + Player.cash + "----------+\n" +
                        "+-X-Num of coins--" + numCoins + "--" + "$" + numCoinsPrice + "-+\n" +
                        "+---Coins rarity-" + rarityMultiplier + "-" + "$" + rarityPrice + "-+\n" +
                        "+------------------------+\n";
            }
        } else {
            if (Player.cash < 10) {
                print = "+----------SHOP----------+\n" +
                        "+-----------$" + Player.cash + "-----------+\n" +
                        "+---Num of coins--" + numCoins + "--" + "$" + numCoinsPrice + "-+\n" +
                        "+-X-Coins rarity-" + rarityMultiplier + "-" + "$" + rarityPrice + "-+\n" +
                        "+------------------------+\n";
            } else if (Player.cash < 100) {
                print = "+----------SHOP----------+\n" +
                        "+----------$" + Player.cash + "-----------+\n" +
                        "+---Num of coins--" + numCoins + "--" + "$" + numCoinsPrice + "-+\n" +
                        "+-X-Coins rarity-" + rarityMultiplier + "-" + "$" + rarityPrice + "-+\n" +
                        "+------------------------+\n";
            } else {
                print = "+----------SHOP----------+\n" +
                        "+----------$" + Player.cash + "----------+\n" +
                        "+---Num of coins--" + numCoins + "--" + "$" + numCoinsPrice + "-+\n" +
                        "+-X-Coins rarity-" + rarityMultiplier + "-" + "$" + rarityPrice + "-+\n" +
                        "+------------------------+\n";
            }
        }
        System.out.println(print);
    }
}
