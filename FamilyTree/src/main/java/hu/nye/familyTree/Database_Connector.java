package hu.nye.familyTree;

import java.sql.*;



public class Database_Connector {

    private static int SEX;
    private static int PERSONAL_ID;
    private static int FATHER_ID;
    private static int MOTHER_ID;
    private static int GEN;
    private static String FIRST_NAME;
    private static String MIDDLE_NAME;
    private static String LAST_NAME;
    private static String EXTRA_NAME;
    private static String BIRTH_DATE;
    private static String DEATH_DATE;
    private static boolean ISMARRIED;
    private static String SEX_STRING;

    public static void DatabaseGetInfo(String First_Name,String Last_Name, String Birth_Date){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/algorithm", "Algorithm", "D3)qTNmp@y*_SHr2");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM people");

            while(resultSet.next()){



                PERSONAL_ID = resultSet.getInt("Personal_ID");
                FATHER_ID = resultSet.getInt("Father_ID");
                MOTHER_ID = resultSet.getInt("Mother_ID");
                FIRST_NAME = resultSet.getString("First_name");
                MIDDLE_NAME = resultSet.getString("Middle_name");
                LAST_NAME = resultSet.getString("Last_name");
                EXTRA_NAME = resultSet.getString("Extra_name");
                SEX = resultSet.getInt("Sex");
                GEN = resultSet.getInt("Gen");
                BIRTH_DATE = resultSet.getString("Birth_date");
                DEATH_DATE = resultSet.getString("Death_date");
                ISMARRIED = resultSet.getBoolean("Married");

                if(SEX == 1) SEX_STRING = "Male";
                else if (SEX == 0) SEX_STRING = "Female";

                /*
                System.out.println(First_Name + " " + FIRST_NAME);
                if(First_Name.equals(FIRST_NAME)) System.out.println("true");
                System.out.println(Last_Name + " " + LAST_NAME);
                if(Last_Name.equals(LAST_NAME)) System.out.println("true");
                System.out.println(Birth_Date + " " + BIRTH_DATE);
                if(Birth_Date.equals(BIRTH_DATE)) System.out.println("true");
                 */

                if(First_Name.equals(FIRST_NAME) && Last_Name.equals(LAST_NAME) && Birth_Date.equals(BIRTH_DATE)) {
                    System.out.println("Personal ID: " + PERSONAL_ID +
                            "\nFather ID: " + FATHER_ID +
                            "\nMother ID: " + MOTHER_ID +
                            "\nFirst Name: " + FIRST_NAME +
                            "\nMiddle Name: " + MIDDLE_NAME +
                            "\nLast Name: " + LAST_NAME +
                            "\nExtra Name: " + EXTRA_NAME +
                            "\nSex: " + SEX_STRING +
                            "\nGen: " + GEN +
                            "\nBirth Date: " + BIRTH_DATE +
                            "\nDeath Date: " + DEATH_DATE +
                            "\nIs Married: " + ISMARRIED);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void DatabaseAddData(String Father_First_Name, String Father_Last_Name, String Father_Birth_Date, String Mother_First_Name, String Mother_Last_Name, String Mother_Birth_Date, String First_Name, String Middle_Name, String Last_Name, String Extra_Name, String Birth_Date, String Sex, int Gen){

        int Father_ID = 0;
        int Mother_ID = 0;
        int Sex_Int;

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/algorithm", "Algorithm", "D3)qTNmp@y*_SHr2");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM people");

            while (resultSet.next()){
                if(Father_First_Name.equals(resultSet.getString("First_name")) && Father_Last_Name.equals(resultSet.getString("Last_name")) && Father_Birth_Date.equals(resultSet.getString("Birth_date"))){
                    Father_ID = resultSet.getInt("Personal_ID");
                    //System.out.println("Father found");
                } else if(Mother_First_Name.equals(resultSet.getString("First_name")) && Mother_Last_Name.equals(resultSet.getString("Last_name")) && Mother_Birth_Date.equals(resultSet.getString("Birth_date"))){
                    Mother_ID = resultSet.getInt("Personal_ID");
                    //System.out.println("Mother found");
                }
            }
            //System.out.printf(Father_ID + " " + Mother_ID);

            if(Sex == "m" || Sex == "M") Sex_Int = 1;
            else Sex_Int = 0;

            System.out.println(Sex_Int);


            statement.execute("INSERT INTO people (Father_ID, Mother_ID, First_name, Middle_name, Last_name, Extra_name, Sex, Gen, Birth_date)\n" +
                    "VALUES ('" + Father_ID +"','"+Mother_ID+"','"+First_Name+"','"+Middle_Name+"','"+Last_Name+"','"+Extra_Name+"','"+Sex_Int+"','"+Gen+"','"+Birth_Date+"')");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



}
