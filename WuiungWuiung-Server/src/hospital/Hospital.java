package hospital;

import location.Location;

public class Hospital {
	private String hospitalName;	// �̸�
	private String hospitalPhone;	// ��ȭ��ȣ
	private Location hospitalLocationInfo;	// ��ġ����
	
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getHospitalPhone() {
		return hospitalPhone;
	}
	public void setHospitalPhone(String hospitalPhone) {
		this.hospitalPhone = hospitalPhone;
	}
	public Location getHospitalLocationInfo() {
		return hospitalLocationInfo;
	}
	public void setHospitalLocationInfo(Location hospitalLocationInfo) {
		this.hospitalLocationInfo = hospitalLocationInfo;
	}	
	
};


// ȯ���� ��ġ�� �����ϴ� �ӽ� ����

// �װŶ� ���޴� ArrayList�� ����� ���޴�� �� ���� ����� ���޴� ������ �˾Ƴ��� �޽��� ���뿡 �߰�

// ��� ���޴뿡�� �޽��� �߻�