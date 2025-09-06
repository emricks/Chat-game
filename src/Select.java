public class Select {
    public static void displayMenu(String character1, String character2) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if (!Main.multiplayer) {
            System.out.println("+-----+");
            System.out.println("+--"+character1+"-+");
            System.out.println("+-----+");
            System.out.println("Press ENTER to continue.");
        } else {
            System.out.println("+--1--+--2--+");
            System.out.println("+--"+character1+"-+--"+character2+"-+");
            System.out.println("+-----+-----+");
            System.out.println("Press ENTER to continue");
        }
    }
}

