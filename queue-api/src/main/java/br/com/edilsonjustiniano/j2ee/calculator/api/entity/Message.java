package br.com.edilsonjustiniano.j2ee.calculator.api.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String description;

	public Message() {
	}

	public Message(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
