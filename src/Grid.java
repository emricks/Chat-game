import java.util.ArrayList;
import java.util.List;

public class Grid {
    static int width = 0;
    static int height = 0;
    static boolean shop = false;
    static List<List<Character>> board = new ArrayList<>();
    public static void updatePosition(int w, int h) {
        Main.printSwing(Coin.xPos + " " + Coin.yPos);
        Main.printSwing(Coin1.xPos + " " + Coin1.yPos);
        Main.printSwing(Coin2.xPos + " " + Coin2.yPos);
        board.clear();
        Main.printSwing("\033[H\033[2J");
        width = w;
        height = h;
        for (int i = 0; i < Grid.height; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < Grid.width; j++) {
                list.add('n');
            }
            board.add(list);
        }
        List<Character> innerlist;
        if (Main.multiplayer) {
            innerlist = board.get(Player.yPos);
            innerlist.set(Player.xPos, '1');
            innerlist = board.get(Player2.yPos);
            innerlist.set(Player2.xPos, '2');
        } else {
            innerlist = board.get(Player.yPos);
            innerlist.set(Player.xPos, 'p');
        }
        innerlist = board.get(Coin.yPos);
        if (Coin.rarity == 'c') {
            innerlist.set(Coin.xPos, 'c');
        } else if (Coin.rarity == 'r') {
            innerlist.set(Coin.xPos, 'r');
        } else if (Coin.rarity == 'l') {
            innerlist.set(Coin.xPos, 'l');
        }
        if (Coin1.yPos != -1) {
            innerlist = board.get(Coin1.yPos);
            if (Coin1.rarity == 'c') {
                innerlist.set(Coin1.xPos, 'c');
            } else if (Coin1.rarity == 'r') {
                innerlist.set(Coin1.xPos, 'r');
            } else if (Coin1.rarity == 'l') {
                innerlist.set(Coin1.xPos, 'l');
            }
        }
        if (Coin2.yPos != -1) {
            innerlist = board.get(Coin2.yPos);
            if (Coin2.rarity == 'c') {
                innerlist.set(Coin2.xPos, 'c');
            } else if (Coin2.rarity == 'r') {
                innerlist.set(Coin2.xPos, 'r');
            } else if (Coin2.rarity == 'l') {
                innerlist.set(Coin2.xPos, 'l');
            }
        }

        StringBuilder print = new StringBuilder();
        int digits = (int) Math.ceil(Math.log(Player.cash+0.1)/Math.log(10));
        if (Player.cash == 1 || Player.cash == 0) {digits = 1;}
        print.append("+");
        if (digits == 1) {
             for (int i = 0; i < Math.floor(width-0.5); i++) {
                 print.append("-");
             }
             print.append("$").append(Player.cash);
             for (int i = 0; i < Math.ceil(width-0.5); i++) {
                 print.append("-");
             }
        } else if (digits == 2) {
            for (int i = 0; i < width-1; i++) {
                print.append("-");
            }
            print.append("$").append(Player.cash);
            for (int i = 0; i < width-1; i++) {
                print.append("-");
            }
        } else {
            for (int i = 0; i < Math.floor(width-1.5); i++) {
                print.append("-");
            }
            print.append("$").append(Player.cash);
            for (int i = 0; i < Math.ceil(width-1.5); i++) {
                print.append("-");
            }
        }
        print.append("+\n");

        board.forEach(inner -> {
            print.append("+ ");
            inner.forEach(e -> {
                switch (e) {
                    case 'p':
                        print.append(Player.character);
                        break;
                    case '1':
                        print.append(Player.character);
                        break;
                    case '2':
                        print.append(Player2.character);
                        break;
                    case 'c':
                        print.append("\uD83D\uDCB5");
                        break;
                    case 'r':
                        print.append("\uD83D\uDCB0");
                        break;
                    case 'l':
                        print.append("\uD83D\uDC8E");
                        break;
                    case 'n':
                        print.append(". ");
                }
            });
            print.append("+\n");
        });

        if (Main.multiplayer) {
            digits = (int) Math.ceil(Math.log(Player2.cash+0.1)/Math.log(10));
            if (Player2.cash == 1 || Player2.cash == 0) {digits = 1;}
            print.append("+");
            if (digits == 1) {
                for (int i = 0; i < Math.floor(width-0.5); i++) {
                    print.append("-");
                }
                print.append("$").append(Player2.cash);
                for (int i = 0; i < Math.ceil(width-0.5); i++) {
                    print.append("-");
                }
            } else if (digits == 2) {
                for (int i = 0; i < width-1; i++) {
                    print.append("-");
                }
                print.append("$").append(Player2.cash);
                for (int i = 0; i < width-1; i++) {
                    print.append("-");
                }
            } else {
                for (int i = 0; i < Math.floor(width-1.5); i++) {
                    print.append("-");
                }
                print.append("$").append(Player2.cash);
                for (int i = 0; i < Math.ceil(width-1.5); i++) {
                    print.append("-");
                }
            }
            print.append("+\n");
        } else {
            print.append("+");
            for (int i = 0; i < 2*width+1; i++) {
                print.append("-");
            }
            print.append("+");
        }
        Main.printSwing(print.toString());
    }
}
