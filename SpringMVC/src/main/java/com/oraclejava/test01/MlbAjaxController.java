package com.oraclejava.test01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MlbAjaxController {

	@RequestMapping("/ajax/xmlTeam")
	@ResponseBody
	public TeamJaxb showTeamXml() {
		TeamJaxb team = new TeamJaxb();
		team.setName("기아");
		team.setLogo("https://tv.pstatic.net/thm?size=150x112&quality=9&q=http://sstatic.naver.net/keypage/image/dss/146/48/40/78/146_2484078_team_image_url_1428310006072.jpg");
		return team;
	}
	
	@RequestMapping("/ajax/xmlMlb")
	@ResponseBody
	public MlbJaxb showMlbXml() {
		TeamJaxb team = new TeamJaxb();
		team.setName("기아");
		team.setLogo("https://tv.pstatic.net/thm?size=150x112&quality=9&q=http://sstatic.naver.net/keypage/image/dss/146/48/40/78/146_2484078_team_image_url_1428310006072.jpg");
		
		TeamJaxb team2 = new TeamJaxb();
		team2.setName("두산");
		team2.setLogo("https://tv.pstatic.net/thm?size=150x112&quality=9&q=http://sstatic.naver.net/keypage/image/dss/146/48/41/02/146_2484102_team_image_url_1428311072978.jpg");
		
		TeamJaxb team3 = new TeamJaxb();
		team3.setName("한화");
		team3.setLogo("https://tv.pstatic.net/thm?size=150x112&quality=9&q=http://sstatic.naver.net/keypage/image/dss/146/48/40/93/146_2484093_team_image_url_1428384557192.jpg");
		
		List<TeamJaxb> teamList = new ArrayList<TeamJaxb>();
		teamList.add(team);
		teamList.add(team2);
		teamList.add(team3);
		MlbJaxb mlb = new MlbJaxb();
		mlb.setTeamList(teamList);
		
		return mlb;
	}
}
