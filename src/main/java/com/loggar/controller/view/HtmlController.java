package com.loggar.controller.view;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/html")
public class HtmlController {
	private static String readLineByLine(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append(System.lineSeparator()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contentBuilder.toString();
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String welcomeAsHTML() {
		return "<html>\n" + "<header><title>Welcome</title></header>\n" + "<body>\n" + "Hello world\n" + "</body>\n" + "</html>";
	}

	@RequestMapping(value = "/timetable-exam", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String timetable_exam() {
		return readLineByLine("./dist/html/plain-html-sample.html");
	}
}