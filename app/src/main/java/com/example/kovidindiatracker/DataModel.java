package com.example.kovidindiatracker;

public class DataModel {
    String state;
    String active;
    String confirmed;
    String recovered;
    String decesaed;

    public DataModel(String state, String confirmed, String active, String recovered, String decesaed) {
        this.state = state;
        this.confirmed = confirmed;
        this.active = active;
        this.recovered = recovered;
        this.decesaed = decesaed;
    }

    public String getState() {
        return state;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public String getActive() {
        return active;
    }

    public String getRecovered() {
        return recovered;
    }

    public String getDecesaed() {
        return decesaed;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public void setDecesaed(String decesaed) {
        this.decesaed = decesaed;
    }
}
