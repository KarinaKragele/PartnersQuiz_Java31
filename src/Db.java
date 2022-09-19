import java.sql.*;
import java.util.ArrayList;

public class Db {
    private final String dbURL = "jdbc:mysql://localhost:3306/java31";
    private final String user = "root";
    private final String password = "MySQL2022";

    public  ArrayList<String> readData(int person,int[] randomNumbers2){
        ArrayList<String> questions = new ArrayList<>();

        try(Connection conn =DriverManager.getConnection(dbURL,user,password)){

            String sql = "SELECT * FROM questions WHERE ID = "+ randomNumbers2[0] +" OR ID = "+ randomNumbers2[1] +" " +
                    " OR ID = "+ randomNumbers2[2] +"  OR ID = "+ randomNumbers2[3] +"  OR ID = "+ randomNumbers2[4]+";";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                if(person == 1){
                    questions.add(resultSet.getString(2));
                } else {
                    questions.add(resultSet.getString(3));
                }
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return questions;
    }
}
