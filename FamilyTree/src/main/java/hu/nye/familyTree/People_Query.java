package hu.nye.familyTree;

import java.sql.*;
import java.util.Scanner;

import static hu.nye.familyTree.Database_Connector.DatabaseGetInfo;

public class People_Query {

    private static String FIRST_NAME;
    private static String LAST_NAME;
    private static String BIRTH_DATE;

    public static void getInfo(){
        Scanner input = new Scanner(System.in);
        System.out.println("Fist name: ");
        FIRST_NAME = input.nextLine();
        System.out.println("Last name: ");
        LAST_NAME = input.nextLine();
        System.out.println("Date of birth (0000-00-00): ");
        BIRTH_DATE = input.nextLine();
        DatabaseGetInfo(FIRST_NAME,LAST_NAME,BIRTH_DATE);
    }
}
