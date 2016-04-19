package com.oraclejava.test01;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Mlb")
public class MlbJaxb {

	private List<TeamJaxb> teamList;

	public List<TeamJaxb> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<TeamJaxb> teamList) {
		this.teamList = teamList;
	}
	
	
}
