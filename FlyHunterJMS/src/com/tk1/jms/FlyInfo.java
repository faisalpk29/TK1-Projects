package com.tk1.jms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class FlyInfo implements Serializable {


	private static final long serialVersionUID = -2915218509756779957L;
	private String flyId;
	private int xPosition;
	private int yPostiion;
	private String operation;
	private Integer score;
	private int round = 0;
	private ArrayList<FlyInfo> flyList;
	public String getPlayerName() {
		return flyId;
	}
	public void setPlayerName(String playerName) {
		this.flyId = playerName;
	}
	public int getxPosition() {
		return xPosition;
	}
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	public int getyPostiion() {
		return yPostiion;
	}
	public void setyPostiion(int yPostiion) {
		this.yPostiion = yPostiion;
	}
	public String getFlyId() {
		return flyId;
	}
	public void setFlyId(String flyId) {
		this.flyId = flyId;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public ArrayList<FlyInfo> getFlyList() {
		return flyList;
	}
	public void setFlyList(ArrayList<FlyInfo> flyList) {
		this.flyList = flyList;
	}
	
	
	
	
}
