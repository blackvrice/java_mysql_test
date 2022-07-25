package test;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

class Event_Action implements ActionListener{
	UI ui;
	mysql mysql;
	public Event_Action(){
		ui = new UI();
		ui.inquiry_button.addActionListener(this);
		ui.DB_Insert.addActionListener(this);
		ui.DB_delete.addActionListener(this);
		ui.DB_Update.addActionListener(this);
		ui.post_search_button.addActionListener(this);
		ui.country_search_button.addActionListener(this);
		mysql = new mysql();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ui.inquiry_button) {
			String sql = "select busi_num custom from custom where busi_num like '%"+ui.west_Busi_num_text.getText()+"%' and like '%"+ui.west_Custom_text.getText()+"%'" ;
			ArrayList<Custom> inquiry = mysql.Customselect(sql);
			String header[] = {"사업자번호","거래처명"};
			String cells[][] = new String[inquiry.size()][2];
			for(int i = 0;i<inquiry.size();i++) {
				cells[i][0] = inquiry.get(i).Busi_num;
				cells[i][1] = inquiry.get(i).Custom;
			}
			ui.search_table.set
		}else if(e.getSource() == ui.DB_Insert) {
			String sql = "insert into custom(busi_num, custom, short, ceo, charge_person, busi_condition, item, post_num, addr1, addr2, "
					+ "tel, fax, homepage, co_yn, foreign_yn, tax_yn, country_eng, country_kor, special_relation,"
					+ "trade_stop, contract_perioz_s, contract_period_e, regi_info_man, regi_info_date, modi_info_man"
					+ "modi_info_date) values('" + ui.busi_num_text.getText()+"','"+ui.custom_text.getText()+"','"+ui.short_text.getText()+"','"
					+ ui.ceo_text.getText()+"','"+ui.charge_peron_text.getText()+"','"+ui.busi_condition_text.getText()+"','"+ui.item_text.getText()+"','"
					+ ui.post_num_text.getText()+"','"+ui.addr1_text.getText()+"','"+ui.addr2_text.getText()+"','"
					+ ui.tel_text.getText()+"','"+ui.fax_text.getText()+"','"+ui.homepage_text.getText()+"','"
					+ ui.co_y_radio.getText()+ ui.co_n_radio.getText()+"','"+ ui.foreign_y_radio.getText()+ui.foreign_n_radio.getText()+"','"
					+ ui.country_eng_text.getText()+"','"+ui.country_kor_text.getText()+"','"+ui.special_relation_check.getText()+"','"
					+ ui.trade_stop_check.getText()+"',"+ ui.contract_period_s_text.getText()+","
					+ ui.contract_period_e_text.getText()+","+ui.regi_info_man_text.getText()+"',"+ui.regi_info_date_text.getText()+",'"
					+ ui.modi_info_man_text.getText()+"',"+ui.modi_info_date_text+")";
			mysql.insert(sql);
		}else if(e.getSource() == ui.DB_delete) {
			String sql = "delect from custom where busi_num = '" + ui.busi_num_text +"'";
			mysql.Custom_delect(sql);
		}else if(e.getSource() == ui.DB_Update) {
			String sql = "update"
		}else if(e.getSource() == ui.post_search_button) {
			
		}else if(e.getSource() == ui.country_search_button) {
			
		}
	}
}
public class Main{
	public static void main(String[] args) {
		new Event_Action();
	}
}
