
package controller;

import util.InputUtils;

/**
 *
 * @author nhsssss
 */
public class Menu {
    public static int chooseInputOption(){
            System.out.println("-------------------------------------------");
            System.out.println("1. Add planet.");
            System.out.println("2. Search.");
            System.out.println("3. Delete.");
            System.out.println("4. View all solar system.");
            System.out.println("5. Exit");
            System.out.println("--------------------------------------------");
        int option = InputUtils.inputOption(1, 5);
        return option;
    }
}
