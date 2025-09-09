public class Select {
    public static void displayMenu(String character1, String character2) {
        String menu;
        if (!Main.multiplayer) {
            menu = "+-----+\n" +
                   "+--" + character1 + "-+\n" +
                   "+-----+\n" +
                   "Press ENTER to continue.";
        } else {
            menu = "+--1--+--2--+\n" +
                   "+--" + character1 + "-+--" + character2 + "-+\n" +
                   "+-----+-----+\n" +
                   "Press ENTER to continue";
        }
        Main.printSwing(menu);
    }
}

