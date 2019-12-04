package pyramidci.TrainTicketProject;

import java.sql.*;

public class TrainDAO {
	//Variables
	private String DRIVER_NAME;
	private String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String USERNAME = "hr";
	private String PASSWORD = "password";
	DBConnection dbc = new DBConnection();
	Connection con = dbc.getConnection(DB_URL, USERNAME, PASSWORD);


	// METHOD TO FIND TRAIN
	public Train findTrain(int trainNo)
	{
		PreparedStatement stmt;
		ResultSet rs;
		String query;
		try {
			query = "select * from trains where train_no = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1,trainNo);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return new Train(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}