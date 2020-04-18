package com.example.kovidindiatracker;

import java.util.List;

public class Pojo{
	private List<StatewiseItem> statewise;


	public Pojo(List<StatewiseItem> statewise) {
		this.statewise = statewise;
	}

	public List<StatewiseItem> getStatewise() {
		return statewise;
	}

	@Override
	public String toString() {
		return "Pojo{" +
				"statewise=" + statewise +
				'}';
	}


}