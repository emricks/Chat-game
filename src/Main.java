import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame implements KeyListener {
    static int w = 8;
    static int h = 8;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main frame = new Main();
            frame.setVisible(true);
        });

    }

    public Main() {
        setTitle("Arrow Key Input Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this); // Add key listener to the frame
        setFocusable(true); // Make sure the frame can receive focus
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (!Grid.shop) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (Player.yPos > 0) {
                        Player.yPos--;
                    } else {
                        Player.yPos = Grid.height - 1;
                    }
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
            }

            if (Player.xPos == Coin.xPos && Player.yPos == Coin.yPos) {
                Coin.changePositon();
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