package com.example.kovidindiatracker;

public class StatewiseItem{
	private String statenotes;
	private String recovered;
	private String deltadeaths;
	private String deltarecovered;
	private String active;
	private String deltaconfirmed;
	private String state;
	private String statecode;
	private String confirmed;
	private String deaths;
	private String lastupdatedtime;

	public StatewiseItem(String statenotes, String recovered, String deltadeaths, String deltarecovered, String active, String deltaconfirmed, String state, String statecode, String confirmed, String deaths, String lastupdatedtime) {
		this.statenotes = statenotes;
		this.recovered = recovered;
		this.deltadeaths = deltadeaths;
		this.deltarecovered = deltarecovered;
		this.active = active;
		this.deltaconfirmed = deltaconfirmed;
		this.state = state;
		this.statecode = statecode;
		this.confirmed = confirmed;
		this.deaths = deaths;
		this.lastupdatedtime = lastupdatedtime;
	}

	public String getStatenotes() {
		return statenotes;
	}

	public String getRecovered() {
		return recovered;
	}

	public String getDeltadeaths() {
		return deltadeaths;
	}

	public String getDeltarecovered() {
		return deltarecovered;
	}

	public String getActive() {
		return active;
	}

	public String getDeltaconfirmed() {
		return deltaconfirmed;
	}

	public String getState() {
		return state;
	}

	public String getStatecode() {
		return statecode;
	}

	public String getConfirmed() {
		return confirmed;
	}

	public String getDeaths() {
		return deaths;
	}

	public String getLastupdatedtime() {
		return lastupdatedtime;
	}

	@Override
	public String toString() {
		return "StatewiseItem{" +
				"statenotes='" + statenotes + '\'' +
				", recovered='" + recovered + '\'' +
				", deltadeaths='" + deltadeaths + '\'' +
				", deltarecovered='" + deltarecovered + '\'' +
				", active='" + active + '\'' +
				", deltaconfirmed='" + deltaconfirmed + '\'' +
				", state='" + state + '\'' +
				", statecode='" + statecode + '\'' +
				", confirmed='" + confirmed + '\'' +
				", deaths='" + deaths + '\'' +
				", lastupdatedtime='" + lastupdatedtime + '\'' +
				'}';
	}
}
