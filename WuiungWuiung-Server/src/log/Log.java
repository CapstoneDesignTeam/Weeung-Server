package log;

import account.Account;
import location.Location;

public class Log {
	
	private int logID;
	private Account accountInfo;	// SQL�κ��� �޾ƿ� ȯ�� ����
	private String latitude;	// ����
	private String longtitude; // �浵
	private String pulse;	// �ƹ�
	private String temp;	// ü��
	private String date;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public int getLogID() {
		return logID;
	}


	public void setLogID(int logID) {
		this.logID = logID;
	}


	public Account getAccountInfo() {
		return accountInfo;
	}


	public void setAccountInfo(Account accountInfo) {
		this.accountInfo = accountInfo;
	}

	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongtitude() {
		return longtitude;
	}


	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}


	public String getPulse() {
		return pulse;
	}


	public void setPulse(String pulse) {
		this.pulse = pulse;
	}


	public String getTemp() {
		return temp;
	}


	public void setTemp(String temp) {
		this.temp = temp;
	}
}
