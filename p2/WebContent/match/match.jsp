<!DOCTYPE html>
<html>
<head>
<title>JOGO</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<h1 id="header">Match</h1>
	<form class="editor" action="SaveMatch" method="post">
		<input type="hidden" name="id" value="<%=request.getAttribute("id")%>">
		<table>
			<tr>
				<td><label>Home Team</label></td>
				<td><input type="text" id="homeTeam" name="homeTeam"
					maxlength="100" required placeholder="name"
					<%if (request.getAttribute("id") != null) {%>
					value="<%=request.getAttribute("homeTeam")%>" <%}%>></td>
				<td><input type="text" name="homeScore" placeholder="score"
					required maxlength="2" pattern="\d*" title="Score must be integer."
					size=3 <%if (request.getAttribute("id") != null) {%>
					value="<%=request.getAttribute("homeScore")%>" <%}%>
					onkeydown="return checkit(event)"></td>
			</tr>
			<tr>
				<td><label>Away Team</label></td>
				<td><input type="text" name="awayTeam" maxlength="100" required
					placeholder="name" <%if (request.getAttribute("id") != null) {%>
					value="<%=request.getAttribute("awayTeam")%>" <%}%>></td>
				<td><input type="text" name="awayScore" placeholder="score"
					required maxlength="2" pattern="\d*" title="Score must be integer."
					size=3 <%if (request.getAttribute("id") != null) {%>
					value="<%=request.getAttribute("awayScore")%>" <%}%>
					onkeydown="return checkit(event)"></td>
			</tr>
		</table>
		<br> <input type="submit" value="Save">
	</form>
	<br>
	<a href="GetMatches">Matches</a>
	<script src="script.js"></script>
</body>
</html>