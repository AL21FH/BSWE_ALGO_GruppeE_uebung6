package org.lecture.menu;

import org.lecture.helpers.ConsoleColor;

import java.util.Scanner;

/**
 * The Menu class provides a simple text-based menu for managing storage.
 * <p>
 * The menu includes options for simulating delivery and sales, displaying storage history, and exiting the program.
 *
 * @author Unger Daniel, Leicht Andreas, Alnahhas Khaled
 * @version 1.0
 */
public class Menu {

    /**
     * Prints the main menu and captures the user's choice.
     *
     * @return The user's choice as an integer.
     */
    public int printMenu() {
        String menu = """
                
                🛒💻💵🛒💻💵 Storage Managing 🛒💻💵🛒💻💵
                💻                                         💻
                💵             Delivery / Sales            💵
                🛒                                         🛒
                💻              Please choose:             💻
                💵                                         💵
                🛒 (1) 📥📤Start 60 seconds Simulation     🛒
                💻 (2) 📦Show Storage History              💻
                💵                                         💵
                🛒 (9) Exit                                🛒
                💻                                         💻
                🛒💻💵🛒💻💵🛒  -HAVE FUN-  🛒💻💵🛒💻💵🛒              
                """;
        System.out.println(menu);
        System.out.println(ConsoleColor.ANSI_YELLOW + "Please choose an option: " + ConsoleColor.ANSI_RESET);
        int choiceService = chooseOption();
        return choiceService;
    }

    /**
     * Captures the user's choice from the console input.
     *
     * @return The user's choice as an integer.
     */
    private int chooseOption() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        } else {
            System.err.println("Invalid input! Please enter a number!");
        }
        return choice;
    }
}
