package nye.hu.progTech.Start;

import nye.hu.progTech.Map.Load;
import nye.hu.progTech.Map.Board;

import java.util.Scanner;

public class Menu_Interation {
    private Board world;
    private Load load;




    public Menu_Interation(Board world) {
        this.world = world;
        this.load =new Load(0);
    }

    public void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("****************************");
            System.out.println("********* Main Menu ********");
            System.out.println("* 1. Edit World            *");
            System.out.println("* 2. The Ranking           *");
            System.out.println("* 3. Load from Database    *");
            System.out.println("* 4. Saved Maps            *");
            System.out.println("* 5. Exit                  *");
            System.out.println("****************************");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Set world size to a random value for Easy difficulty
                    editWorldMenu();
                    break;
                case 2:
                    System.out.println("\n");
                    world.reviwe();
                    System.out.println("\n");
                    showMainMenu();
                    break;
                case 3:
                    int a =load.getSize();
                    load = new Load(a);

                    load.play();
                    break;
                case 4:
                    System.out.println("\n");
                    load.reviwe();
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("Exiting the game.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }

    private void editWorldMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("*************************");
            System.out.println("*****Edit World Menu:****");
            System.out.println("*  1. Easy              *");
            System.out.println("*  2. Normal            *");
            System.out.println("*  3. Hard              *");
            System.out.println("*  4. Back to Main Menu *");
            System.out.println("*************************");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:

                    int easySize = world.getRandomNumberEasy();
                    world = new Board(easySize);
                    System.out.println("World difficulty set to Easy.");
                    world.play();
                    break;

                case 2:

                    int normalSize = world.getRandomNumberNormal();
                    world = new Board(normalSize);
                    System.out.println("World difficulty set to Normal.");
                    world.play();
                    break;
                case 3:

                    int hardSize = world.getRandomNumberHard();
                    world = new Board(hardSize);
                    System.out.println("World difficulty set to Hard.");
                    world.play();
                    break;
                case 4:
                    //Voltar para o menu principal
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }


}


