package match;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveMatch")
public class SaveMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveMatch() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Match mat = new Match();
		mat.setHomeTeam(request.getParameter("homeTeam"));
		mat.setAwayTeam(request.getParameter("awayTeam"));
		mat.setHomeScore(Integer.valueOf(request.getParameter("homeScore")));
		mat.setAwayScore(Integer.valueOf(request.getParameter("awayScore")));
		MatchBean matBean = new MatchBean();
		if (!request.getParameter("id").equals("null")) {
			mat.setId(Long.valueOf(request.getParameter("id")));
			matBean.modifyMatch(mat);
			response.sendRedirect("GetMatches");
		} else {
			matBean.addMatch(mat);
			request.getRequestDispatcher("match/match.jsp").forward(request, response);
		}
	}

}
