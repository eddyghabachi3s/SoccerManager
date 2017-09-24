package match;

import global.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MatchBean {

	public List<Match> getMatches() {

		List<Match> list = new ArrayList<>();
		Statement stmt = null;
		Connection con = null;
		try {
			con = new DbConnection().getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * From tbl_match order by mat_id");
			while (rs.next()) {
				Match mat = new Match(rs.getLong("mat_id"), rs.getString("mat_homeTeam"), rs.getString("mat_awayTeam"),
						rs.getInt("mat_homeScore"), rs.getInt("mat_awayScore"));
				list.add(mat);
			}
		} catch (SQLException ex) {
			System.err.println("Caught Exception: " + ex.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				System.err.println("Caught Exception: " + ex.getMessage());
			}
		}
		return list;
	}

	public void addMatch(Match mat) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = new DbConnection().getConnection();

			pstmt = con.prepareStatement(
					"Insert Into tbl_match " + "(mat_homeTeam, mat_awayTeam, mat_homeScore, mat_awayScore) " + "Values("
							+ "'" + mat.getHomeTeam() + "'," + "'" + mat.getAwayTeam() + "'," + mat.getHomeScore() + ","
							+ mat.getAwayScore() + ")");

			pstmt.execute();

		} catch (SQLException ex) {
			System.err.println("Caught Exception: " + ex.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				System.err.println("Caught Exception: " + ex.getMessage());
			}
		}
	}

}
