package com.oraclejava.test01;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sawon")
public class SawonController {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		 this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model) {
		String sql = "SELECT last_name, first_name FROM contacts";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		model.addAttribute("model", list);
		return "/sawonView";
	}
}
