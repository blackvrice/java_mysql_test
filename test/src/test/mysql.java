package test;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;
public class mysql {
	Connection connection;
	
	public void connect() {
		String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
		String user = "root";
		String password = "blackholl1";
		String driverName = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void insert(String sql) {
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public ArrayList<Custom> Customselect(String sql) {
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<Custom> list = new ArrayList<>();
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while(rs.next()) {
				Custom custom = new Custom();
				custom.Busi_num = rs.getString("BUSI_NUM");
				custom.Custom = rs.getString("CUSTOM");
				list.add(custom);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	public Custom All_Custom_select(String sql) {
		Statement statement = null;
		ResultSet rs = null;
		Custom custom = new Custom();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			if(rs.next()) {
				custom.Busi_num = rs.getString("BUSI_NUM");
				custom.Custom = rs.getString("CUSTOM");
				custom.Short = rs.getString("SHORT");
				custom.Ceo = rs.getString("CEO");
				custom.Charge_person = rs.getString("CHARGE_PERSON");
				custom.Busi_condition = rs.getString("BUSI_CONDITION");
				custom.Item = rs.getString("ITEM");
				custom.Post_num = rs.getString("POST_NUM");
				custom.Addr1 = rs.getString("ADDR1");
				custom.Addr2 = rs.getString("ADDR2");
				custom.Tel = rs.getString("TEL");
				custom.Fax = rs.getString("FAX");
				custom.Homepage = rs.getString("HOMEPAGE");
				custom.Co_yn = rs.getString("CO_YN");
				custom.Foreign_yn = rs.getString("FOREIGN_YN");
				custom.Tax_yn = rs.getString("TAX_YN");
				custom.Country_eng = rs.getString("COUNTRY_ENG");
				custom.Country_kor = rs.getString("COUNTRY_KOR");
				custom.Special_relation = rs.getString("SPECIAL_RELATION");
				custom.Trade_shop = rs.getString("TRADE_STOP");
				custom.Contract_period_s = format.format(rs.getDate("CONTRACT_PERIOD_S"));
				custom.Contract_period_e = format.format(rs.getDate("CONTRACT_PERIOD_E"));
				custom.Regi_info_man = rs.getString("REGI_INFO_MAN");
				custom.Regi_info_date = format.format(rs.getDate("REGI_INFO_DATE"));
				custom.Modi_info_man = rs.getString("MODI_INFO_MAN");
				custom.Modi_info_date = format.format(rs.getDate("MODI_INFO_DATE"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return custom;
	}
	public void Custom_delect(String sql) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.execute(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public Account Account_select(String sql) {
		Statement statement = null;
		ResultSet rs = null;
		Account account = new Account();
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			if(rs.next()) {
				account.Factory = rs.getString("FACTORY");
				account.Trade_bank = rs.getString("TRADE_BANK");
				account.Account_num = rs.getString("ACCOUNT_NUM");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		} 
		return account;
	}
	public void update(String[] updatestr) {
			PreparedStatement Pstatement = null;
			String sql = "UPDATE CUSTOM SET CUSTOM = ? SHORT = ? CEO = ? CHARGE_PERSON = ? BUSI_CONDITION = ? ITEM = ? POST_NUM = ? ADDR1 = ? ADDR2 = ? TEL = ? FAX = ? HOMEPAGE = ? CO_YN = ? FOREIGN_YN = ? COUNTRY_ENG = ? COUNTRY_KOR = ? SPECIAL_RELATION = ? TRADE_SHOP = ? CONTRACT_PERIOD_S = ? CONTRACT_PERIOD_E = ? REGI_INFO_MAN = ? REGI_INFO_DATE = ? MODI_INFO_MAN = ? MODI_INFO_DATE = ? WHERE BUSI_NUM = ?";
			try {
				Pstatement = connection.prepareCall(sql);
				for(int i = 1; i<26;i++) {
					Pstatement.setString(i, updatestr[i]);
				}
				Pstatement.setString(26, updatestr[0]);
				Pstatement.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					Pstatement.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
	}
	public void close() {
		try {
			if(connection != null) {
				connection.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
class Custom{
	String Busi_num;
	String Custom;
	String Short;
	String Ceo;
	String Charge_person;
	String Busi_condition;
	String Item;
	String Post_num;
	String Addr1;
	String Addr2;
	String Tel;
	String Fax;
	String Homepage;
	String Co_yn;
	String Foreign_yn;
	String Tax_yn;
	String Country_eng;
	String Country_kor;
	String Special_relation;
	String Trade_shop;
	String Contract_period_s;
	String Contract_period_e;
	String Regi_info_man;
	String Regi_info_date;
	String Modi_info_man;
	String Modi_info_date;
}
class Account{
	String Busi_num;
	String Factory;
	String Trade_bank;
	String Account_num;
}
