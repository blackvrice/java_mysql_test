package test;
import javax.swing.*;
import java.awt.*;
public class UI extends JFrame {
	
	protected JButton Initializtion,DB_Insert,DB_Update,DB_delete;
	
	protected JTextField 	west_Busi_num_text, west_Custom_text;
	protected JButton 	inquiry_button;
	protected JTable 		search_table;
	
	protected JTextField 	busi_num_text,custom_text,short_text,ceo_text,charge_peron_text,busi_condition_text,
				item_text,post_num_text,addr1_text,addr2_text,tel_text,fax_text,homepage_text,
				country_eng_text,country_kor_text,contract_period_s_text,contract_period_e_text,
				regi_info_man_text, regi_info_date_text,modi_info_man_text,modi_info_date_text;
	protected JComboBox<String> tax_yn_combo;
	protected JCheckBox 	special_relation_check,trade_stop_check;
	protected JButton		post_search_button,country_search_button;
	protected JRadioButton co_y_radio,co_n_radio,foreign_y_radio,foreign_n_radio; 
	
	JLabel		account_label;
	protected JTable		Account_table;
	
	public UI(){
		super("test");
		setSize(1000,700);
		JLabel west_Busi_num_label = new JLabel("사업자번호");
		JLabel west_Custom_label = new JLabel("거래처명");
		west_Busi_num_text = new JTextField(10);
		west_Custom_text = new JTextField(10);
		inquiry_button = new JButton("조회");

		JLabel Busi_num_label = new JLabel("사업자번호");
		JLabel custom_label = new JLabel("거래체명");
		JLabel short_label = new JLabel("약칭");
		JLabel ceo_label = new JLabel("대표자");
		JLabel charge_person_label = new JLabel("담당자");
		JLabel busi_condition_label = new JLabel("업태");
		JLabel item_label = new JLabel("종목");
		JLabel post_num_label = new JLabel("우편번호");
		JLabel addr1_label = new JLabel("주소1");
		JLabel addr2_label = new JLabel("주소2");
		JLabel tel_label = new JLabel("전화번호");
		JLabel fax_label = new JLabel("팩스번호");
		JLabel homepage_label = new JLabel("홈페이지");
		JLabel co_yn_label = new JLabel("법인여부");
		JLabel foreign_yn_label = new JLabel("해와여부");
		JLabel tax_yn_label = new JLabel("과세구분");
		JLabel country_label = new JLabel("국 가");
		JLabel special_relation_label = new JLabel("특수관계자");
		JLabel trade_stop_label = new JLabel("거래중지");
		JLabel contract_period_label = new JLabel("계약기관");
		JLabel regi_info_label = new JLabel("등록정보");
		JLabel modi_info_label = new JLabel("변경정보");

		busi_condition_text = new JTextField(10);
		custom_text = new JTextField(10);
		short_text = new JTextField(10);
		ceo_text = new JTextField(10);
		charge_peron_text = new JTextField(10);
		busi_condition_text = new JTextField(10);
		item_text = new JTextField(10);
		post_num_text = new JTextField(10);
		addr1_text = new JTextField(10);
		addr2_text = new JTextField(10);
		tel_text = new JTextField(10);
		fax_text = new JTextField(10);
		homepage_text = new JTextField(10);
		country_eng_text = new JTextField(10);
		country_kor_text = new JTextField(10);
		contract_period_s_text = new JTextField(10);
		contract_period_e_text = new JTextField(10);
		regi_info_man_text = new JTextField(10);
		regi_info_date_text = new JTextField(10);
		modi_info_man_text = new JTextField(10);
		modi_info_date_text = new JTextField(10);
		ButtonGroup co_group = new ButtonGroup();
		co_y_radio = new JRadioButton("법인");
		co_group.add(co_y_radio);
		co_n_radio = new JRadioButton("개인");
		co_group.add(co_n_radio);
		String[] tax_string = {"과세","면세"};
		tax_yn_combo = new JComboBox<>(tax_string);
		ButtonGroup foreign_group = new ButtonGroup();
		foreign_y_radio = new JRadioButton("국내");
		foreign_group.add(foreign_y_radio);
		foreign_n_radio = new JRadioButton("해외");
		foreign_group.add(foreign_n_radio);
		special_relation_check = new JCheckBox();
		trade_stop_check = new JCheckBox();
		post_search_button = new JButton("검색");
		country_search_button = new JButton("검색");
		
	}
}