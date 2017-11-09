package app.controller;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;

public class Osoba {	
	
	@JsonView(Pogled.Public.class)
	private String ime;
	
	@JsonView(Pogled.Public.class)
	private String prezime;
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	
}
