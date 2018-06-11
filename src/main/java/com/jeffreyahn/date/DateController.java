package com.jeffreyahn.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/{word}")
	public String dateOrTime(@PathVariable("word") String word, Model model) {
		if(word.equals("date")) {
			DateFormat df = new SimpleDateFormat("E', the 'dd' of 'MMMM', 'yyyy");
			Date currDate = new Date();
			String fDate = df.format(currDate);
			model.addAttribute("date", fDate);
			return "date.jsp";
		} else if(word.equals("time")) {
			DateFormat df = new SimpleDateFormat("hh:mm a zzz");
			Date currDate = new Date();
			String fTime= df.format(currDate);
			
			model.addAttribute("time", fTime);
			return "time.jsp";
		} else {
			model.addAttribute("wat", "wat");
			return "index.jsp";
		}
	}
}
