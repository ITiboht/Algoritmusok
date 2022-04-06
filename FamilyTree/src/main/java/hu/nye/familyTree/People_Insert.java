package hu.nye.familyTree;

import java.sql.SQLOutput;
import java.util.Scanner;

import static hu.nye.familyTree.Database_Connector.DatabaseAddData;

public class People_Insert {

    private static int GEN;
    private static String FIRST_NAME = "";
    private static String MIDDLE_NAME= "";
    private static String LAST_NAME = "";
    private static String EXTRA_NAME = "";
    private static String BIRTH_DATE = "";
    private static String SEX_STRING = "";
    private static String FATHERS_FIRST_NAME = "";
    private static String FATHERS_LAST_NAME = "";
    private static String FATHERS_BIRTH_DATE = "";
    private static String MOTHERS_FIRST_NAME = "";
    private static String MOTHERS_LAST_NAME = "";
    private static String MOTHERS_BIRTH_DATE = "";

    public static void addData(){
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter the following information:\n");
        System.out.printf("Father's first name: ");
        FATHERS_FIRST_NAME = input.nextLine();
        System.out.printf("\nFather's last name: ");
        FATHERS_LAST_NAME = input.nextLine();
        System.out.printf("\nFather's birth date: ");
        FATHERS_BIRTH_DATE = input.nextLine();
        System.out.printf("\nMother's first name: ");
        MOTHERS_FIRST_NAME = input.nextLine();
        System.out.printf("\nMother's last name: ");
        MOTHERS_LAST_NAME = input.nextLine();
        System.out.printf("\nMother's birth date: ");
        MOTHERS_BIRTH_DATE = input.nextLine();
        System.out.printf("\nFirst name: ");
        FIRST_NAME = input.nextLine();
        System.out.printf("\nMiddle name: ");
        MIDDLE_NAME = input.nextLine();
        System.out.printf("\nLast name: ");
        LAST_NAME = input.nextLine();
        System.out.printf("\nExtra name (E.g.: jr.): ");
        EXTRA_NAME = input.nextLine();
        System.out.printf("\nBirth date (0000-00-00): ");
        BIRTH_DATE = input.nextLine();
        System.out.printf("\nSex (M/F): ");
        SEX_STRING = input.nextLine();
        System.out.printf("\nWhich family generation is he/she from: ");
        GEN = input.nextInt();

        DatabaseAddData(FATHERS_FIRST_NAME, FATHERS_LAST_NAME, FATHERS_BIRTH_DATE, MOTHERS_FIRST_NAME, MOTHERS_LAST_NAME, MOTHERS_BIRTH_DATE, FIRST_NAME, MIDDLE_NAME, LAST_NAME, EXTRA_NAME, BIRTH_DATE, SEX_STRING, GEN);

    }
}
