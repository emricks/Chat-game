import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends JFrame implements KeyListener {
    static int w = 8;
    static int h = 8;
    static boolean inGame = false;
    static boolean multiplayer = false;
    static List<String> choose = new ArrayList<>();
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main frame = new Main();
            frame.setVisible(true);
        });
        Scanner input = new Scanner(System.in);
        System.out.println("1 for singleplayer, 2 for multiplayer");
        if (input.nextInt() == 2) {
            multiplayer = true;
            System.out.println();
            input.nextLine();
            System.out.println("Player 1 uses arrow keys to move, Player 2 uses WASD.");
            System.out.println("Move around to collect money, first to $50 wins.");
            System.out.println("\uD83D\uDCB5 = $1, \uD83D\uDCB0 = $5, \uD83D\uDC8E = $25");
            System.out.println("Press SHIFT to choose characters.");
            Player.xPos = 2;
            Player.yPos = 7;
            Player2.xPos = 7;
            Player2.yPos = 7;
            Coin.changePosition();
            Coin1.changePosition();
            Coin2.changePosition();
            Coin2.xPos = 5;
            Coin2.yPos = 5;
            Shop.rarityMultiplier = 3;
        } else {
            System.out.println();
            input.nextLine();
            System.out.println("Use arrow keys to move.");
            System.out.println("Move around to collect money, press E to enter and exit the shop.");
            System.out.println("\uD83D\uDCB5 = $1, \uD83D\uDCB0 = $5, \uD83D\uDC8E = $25");
            System.out.println("Press SHIFT to choose character.");
            Coin.changePosition();
        }
    }
    static int index1 = 0;
    static int index2 = 0;
    public Main() {
        setTitle("Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this); // Add key listener to the frame
        setFocusable(true); // Make sure the frame can receive focus
        choose.add("\uD83E\uDD99");
        choose.add("\uD83E\uDD91");
        choose.add("\uD83E\uDD98");
        choose.add("\uD83D\uDC19");
        choose.add("\uD83E\uDEBF");
        choose.add("\uD83E\uDD85");
        choose.add("\uD83D\uDC12");
        choose.add("\uD83D\uDC01");
        choose.add("\uD83D\uDC25");
        choose.add("\uD83D\uDC20");
        choose.add("\uD83D\uDC22");
        choose.add("\uD83D\uDC09");
        choose.add("\uD83D\uDC2B");
        choose.add("\uD83D\uDC1D");
        choose.add("\uD83D\uDC0C");
        choose.add("\uD83E\uDD82");
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (multiplayer && !inGame) {
            if (e.getKeyCode() == KeyEvent.VK_UP && index1 < 15) {
                index1++;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN && index1 > 0) {
                index1--;
            } else if (e.getKeyCode() == KeyEvent.VK_W && index2 < 15) {
                index2++;
            } else if (e.getKeyCode() == KeyEvent.VK_S && index2 > 0) {
                index2--;
            } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                Player.character = choose.get(index1);
                Player2.character = choose.get(index2);
                inGame = true;
                Grid.updatePosition(10,10);
            }
            Select.displayMenu(choose.get(index1), choose.get(index2));
        }
        if (!multiplayer && !inGame) {
            if (e.getKeyCode() == KeyEvent.VK_UP && index1 < 15) {
                index1++;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN && index1 > 0) {
                index1--;
            } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                Player.character = choose.get(index1);
                inGame = true;
                Grid.updatePosition(w, h);
            }
            Select.displayMenu(choose.get(index1), choose.get(index2));
        }
        if (!multiplayer && inGame) {
            System.out.println("Not multiplayer is running");
            if (!Grid.shop) {
                Grid.updatePosition(w, h);
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (Player.yPos > 0) {
                            Player.yPos--;
                        } else {
                            Player.yPos = Grid.height - 1;
                        }
                        System.out.println("Up");
                        break;
                    case KeyEvent.VK_DOWN:
                        if (Player.yPos < h-1) {
                            Player.yPos++;
                        } else {
                            Player.yPos = 0;
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (Player.xPos > 0) {
                            Player.xPos--;
                        } else {
                            Player.xPos = Grid.width - 1;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (Player.xPos < w-1) {
                            Player.xPos++;
                        } else {
                            Player.xPos = 0;
                        }
                        break;
                    case KeyEvent.VK_E:
                        Grid.shop = true;
                        Shop.openShop();
                        return;
                    case KeyEvent.VK_C:
                        Player2.xPos = Coin.xPos;
                        Player2.yPos = Coin.yPos;
                }

                if (Player.xPos == Coin.xPos && Player.yPos == Coin.yPos) {
                    Coin.changePosition();
                }
                if (Player.xPos == Coin1.xPos && Player.yPos == Coin1.yPos) {
                    Coin1.changePosition();
                }
                if (Player.xPos == Coin2.xPos && Player.yPos == Coin2.yPos) {
                    Coin2.changePosition();
                }
                Grid.updatePosition(w, h);

            } else {
                Shop.openShop();
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (Player.selected == 'c') {
                            return;
                        } else {
                            Player.selected = 'c';
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (Player.selected == 'r') {
                            return;
                        } else  {
                            Player.selected = 'r';
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (Player.selected == 'c') {
                            if (Player.cash >= Shop.numCoinsPrice) {
                                Player.cash -= Shop.numCoinsPrice;
                                Shop.numCoins++;
                                if (Shop.numCoins == 2) {
                                    Coin1.changePosition();
                                }
                                if (Shop.numCoins == 3) {
                                    Coin2.changePosition();
                                }
                                Shop.numCoinsPrice *= 3;
                            }
                        } else {
                            if (Player.cash >= Shop.rarityPrice) {
                                Player.cash -= Shop.rarityPrice;
                                Shop.rarityMultiplier += 0.5;
                                Shop.rarityPrice *= 2;
                            }
                        }
                        break;
                    case KeyEvent.VK_E:
                        Grid.shop = false;
                        Grid.updatePosition(w, h);
                        return;
                }
                Shop.openShop();
            }
        } else if (inGame) {
            w = 10;
            h = 10;
            Grid.updatePosition(w, h);
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (Player.yPos > 0) {
                        Player.yPos--;
                    } else {
                        Player.yPos = Grid.height - 1;
                    }
                    System.out.println("Up");
                    break;
                case KeyEvent.VK_DOWN:
                    if (Player.yPos < h-1) {
                        Player.yPos++;
                    } else {
                        Player.yPos = 0;
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (Player.xPos > 0) {
                        Player.xPos--;
                    } else {
                        Player.xPos = Grid.width - 1;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (Player.xPos < w-1) {
                        Player.xPos++;
                    } else {
                        Player.xPos = 0;
                    }
                    break;
                case KeyEvent.VK_SHIFT:
                    Player.xPos = Coin1.xPos;
                    Player.yPos = Coin1.yPos;
                    break;
                case KeyEvent.VK_W:
                    if (Player2.yPos > 0) {
                        Player2.yPos--;
                    } else {
                        Player2.yPos = Grid.height - 1;
                    }
                    System.out.println("Up");
                    break;
                case KeyEvent.VK_S:
                    if (Player2.yPos < h-1) {
                        Player2.yPos++;
                    } else {
                        Player2.yPos = 0;
                    }
                    break;
                case KeyEvent.VK_A:
                    if (Player2.xPos > 0) {
                        Player2.xPos--;
                    } else {
                        Player2.xPos = Grid.width - 1;
                    }
                    break;
                case KeyEvent.VK_D:
                    if (Player2.xPos < w-1) {
                        Player2.xPos++;
                    } else {
                        Player2.xPos = 0;
                    }
                    break;
                case KeyEvent.VK_C:
                    Player2.xPos = Coin.xPos;
                    Player2.yPos = Coin.yPos;
                    break;
            }

            if (Coin.xPos == Player.xPos && Coin.yPos == Player.yPos || Coin.xPos == Player2.xPos && Coin.yPos == Player2.yPos) {
                Coin.changePosition();
            }
            if (Coin1.xPos == Player.xPos && Coin1.yPos == Player.yPos || Coin1.xPos == Player2.xPos && Coin1.yPos == Player2.yPos) {
                Coin1.changePosition();
            }
            if (Coin2.xPos == Player.xPos && Coin2.yPos == Player.yPos || Coin2.xPos == Player2.xPos && Coin2.yPos == Player2.yPos) {
                Coin2.changePosition();
            }
            if (Player.cash >= 50) {
                System.out.println("PLayer 1 wins!");
                System.exit(0);
            }
            if (Player2.cash >= 50) {
                System.out.println("PLayer 2 wins!");
                System.exit(0);
            }
            Grid.updatePosition(w, h);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Implement if needed
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Implement if needed
    }


}