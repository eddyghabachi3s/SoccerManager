function checkit(e) {
	var key = e.keyCode;
	if ((key >= 48 && key <= 57) || (key >= 96 && key <= 105)
			|| (key == 8 || key == 9)) {
		return true;
	} else {
		return false;
	}
}