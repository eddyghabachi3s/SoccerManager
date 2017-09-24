package match;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetMatches")
public class GetMatches extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetMatches() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MatchBean matBean = new MatchBean();
		List<Match> matches = matBean.getMatches();
		request.setAttribute("matches", matches);
		request.getRequestDispatcher("match/matches.jsp").forward(request, response);
	}

}
