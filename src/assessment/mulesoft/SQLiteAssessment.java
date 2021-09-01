package assessment.mulesoft;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteAssessment {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:sqlite:/F:\\sqlite3\\usersdb.db";
		try {
			Connection  connection = DriverManager.getConnection(jdbcUrl);
			String sql = "SELECT rowid,* FROM Movies ";
			
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql); 
			System.out.println("Fetching the Total  Details : \n");
			
			while(result.next()) {
				Integer id = result.getInt("rowid");
				String movieName = result.getString("MovieName");
				String actor = result.getString("Actor");
				String actress = result.getString("Actress");
				String releaseYear = result.getString("ReleaseYear");
				String directorName = result.getString("DirectorName");
				
				System.out.println(id+" | "+ movieName+" | "+actor+" | "+actress+" | "+releaseYear+" | "+directorName);
				
			}
			System.out.println();
			
			String fetch = "SELECT MovieName,Actor FROM Movies NATURAL JOIN Movies";
			Statement state = connection.createStatement();
			ResultSet res = statement.executeQuery(fetch);
			System.out.println("Fetching the Details of Movie Corresponding to its Actors : \n");
			
			while(res.next()) {
				String movieName = result.getString("MovieName");
				String actor = result.getString("Actor");
				
				System.out.println( movieName+" | "+actor);
			}
			
		} catch (SQLException e) {
			System.out.println("Error connecting to sqlite databse");
			e.printStackTrace();
		}
	}

}
