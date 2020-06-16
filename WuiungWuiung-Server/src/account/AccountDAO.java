package account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import log.Log;
import setting.Setting;

public class AccountDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public AccountDAO() {
		try {
			String dbURL = Setting.dbURL;
			String dbID = Setting.dbID;
			String dbPassword = Setting.dbPassword;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int login(String accountID, String accountPassword) {
		String SQL = "SELECT accountPassword FROM ACCOUNT WHERE accountID = ?";

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, accountID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(accountPassword)) {
					return 1; // �α��� ����
				} else
					return 0; // ��й�ȣ ����ġ
			}
			return -1; // ���̵� ����
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // �����ͺ��̽� ����
	}

	public int join(Account account) {
		String SQL = "INSERT INTO ACCOUNT VALUES (?, ?, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, account.getAccountID()); // ���� ID
			pstmt.setString(2, account.getAccountPassword()); // ���� ��й�ȣ
			pstmt.setString(3, account.getAccountName()); // �̸�
			pstmt.setString(4, account.getAccountResidentID()); // �ֹε�Ϲ�ȣ
			pstmt.setString(5, account.getAccountAuthority()); // �Ƿ���, ȯ��, ������
			pstmt.setString(6, account.getAccountPhone()); // ��ȭ��ȣ
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // �����ͺ��̽� ����
	}

	public Account getInfo(String id) {
		String SQL = "SELECT * FROM ACCOUNT WHERE accountID = ?";
		Account account = new Account();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				account.setAccountID(rs.getString(1));
				account.setAccountPassword(rs.getString(2));
				account.setAccountName(rs.getString(3));
				account.setAccountResidentID(rs.getString(4));
				account.setAccountAuthority(rs.getString(5));
				account.setAccountPhone(rs.getString(6));
				return account;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

	public ArrayList<Account> getList(int pageNumber) {
		String SQL = "SELECT * FROM ACCOUNT WHERE ACCOUNTAUTHORITY = 'PATIENT' ORDER BY accountID ASC LIMIT ?, 10;";
		/* SQL������ LIMIT�� 10�� �Խñ� ����� 10���� ����Ѵٴ� �ǹ� */
		ArrayList<Account> list = new ArrayList<Account>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			int startNum = (pageNumber - 1) * 10;
			pstmt.setInt(1, startNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Account account = new Account();
				account.setAccountID(rs.getString(1));
				account.setAccountPassword(rs.getString(2));
				account.setAccountName(rs.getString(3));
				account.setAccountResidentID(rs.getString(4));
				account.setAccountAuthority(rs.getString(5));
				account.setAccountPhone(rs.getString(6));
				list.add(account);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getNext() {
		String SQL = "SELECT accountID FROM ACCOUNT ORDER BY accountID ASC";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; 	// ù ��° �Խù��� ���
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1; // �����ͺ��̽� ����
	}
	/* getNext()�������ǰڴµ�..? */
	

	public boolean nextPage(int pageNumber) {
		String SQL = "SELECT * FROM ACCOUNT ORDER BY accountID DESC LIMIT ?, 10";
		ArrayList<Account> list = new ArrayList<Account>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, (pageNumber - 1) * 10);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
