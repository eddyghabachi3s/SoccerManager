package match;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetMatch")
public class GetMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetMatch() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("match/match.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MatchBean matBean = new MatchBean();
		Match mat = matBean.getMatch(Long.valueOf(request.getParameter("id")));
		request.setAttribute("id", mat.getId());
		request.setAttribute("homeTeam", mat.getHomeTeam());
		request.setAttribute("awayTeam", mat.getAwayTeam());
		request.setAttribute("homeScore", mat.getHomeScore());
		request.setAttribute("awayScore", mat.getAwayScore());
		request.getRequestDispatcher("match/match.jsp").forward(request, response);
	}

}