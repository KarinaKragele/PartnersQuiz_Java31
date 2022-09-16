import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Db {
    private final String dbURL = "jdbc:mysql://localhost:3306/java31";
    private final String user = "root";
    private final String password = "MySQL2022";


    public  ArrayList<String> readData(int person,int[] randomNumbers2){
        ArrayList<String> questions = new ArrayList<>();
/*        Random rand = new Random();
        HashSet <Integer> randomNumbers = new HashSet<>();
        int[] randomNumbers2 = new int[5];
        randomNumbers.add(rand.nextInt(19)+1);
        while(randomNumbers.size() < 5){
            randomNumbers.add(rand.nextInt(19)+1);
        }
        int j =0;
        for (int i: randomNumbers){
            randomNumbers2[j++] = i;
            System.out.println(i);
        }*/

        //System.out.println(Arrays.toString(randomNumbers2));
        try(Connection conn =DriverManager.getConnection(dbURL,user,password)){

            String sql = "SELECT * FROM questions WHERE ID = "+ randomNumbers2[0] +" OR ID = "+ randomNumbers2[1] +" " +
                    " OR ID = "+ randomNumbers2[2] +"  OR ID = "+ randomNumbers2[3] +"  OR ID = "+ randomNumbers2[4]+";";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                //System.out.println(resultSet.getString(2));
                if(person == 1){
                    questions.add(resultSet.getString(2));
                } else {
                    questions.add(resultSet.getString(3));
                }

            }

        }catch (SQLException e){
            System.out.println(e);
        }
        //System.out.println(questions);
        return questions;


    }



}
