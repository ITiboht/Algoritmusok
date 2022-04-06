package hu.nye.familyTree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static hu.nye.familyTree.People_Query.getInfo;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/algorithm", "Algorithm", "D3)qTNmp@y*_SHr2");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Scanner input = new Scanner(System.in);
        String menu;
        int repeated = 1;
        while(repeated == 1){
            System.out.println("What would you like to do?\n" +
                    "[1] Get People data\n" +
                    "[2] Add People to database\n" +
                    "[3] Change existing people\n" +
                    "[4] Check for kinship\n" +
                    "[5] Exit");
            menu = input.nextLine();
            switch (menu){
                case "1":{
                    getInfo();
                    break;
                }
                case "5":{
                    repeated = 0;
                    break;
                }
                default:{
                    System.out.println("This option does not exist.");
                    break;
                }
            }
        }
    }
}
