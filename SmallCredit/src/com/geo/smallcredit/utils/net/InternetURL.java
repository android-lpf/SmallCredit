package com.geo.smallcredit.utils.net;

public class InternetURL {

	// ����������
   public static String URL = "http://api.xiaoxinyong.com";
	
	//����������
//	public static String URL = "http://10.65.113.37/project";
	//�û���¼POST
	public static String USER_LOGIN=URL+"/index.php/Rest/Reg/login";
	// ������֤ post����
	public static String CHECKPHONE = URL + "/index.php/rest/Reg/mescode";
	//�û�ע��POST
	public static String USER_REGISTER=URL+"/index.php/Rest/Reg/reg";
	//�ж����п�����POST
	public static String USER_YANBANK=URL+"/index.php/Rest/User/bankinfo";
	//��ȡ������֤�� post
	public static String BANK_NUMBER=URL+"/index.php/Rest/User/binding";
	//��ɰ�POST
	public static String BIND_BANK=URL+"/index.php/Rest/User/binding_advance";
	//��֤���Ƿ���� �һ�������POST
	public static String CHECK_PHONE_NUMBER=URL+"/index.php/rest/Reg/iscode";
	//��������post
	public static String CHECK_FORGETPWD = URL+"/index.php/Rest/Reg/retpwd";
	
	
	
	/***
	 * ��¼ �û�����username ���룺password IMEI��imei
	 */
	public static String LOGIN = URL + "/xiaoxinyong/rest/users/login";
	// ע��
	/**
	 * 
	 * ������username �ֻ��ţ�mobileno IMEI��imei
	 * 
	 * 
	 */
	public static String REGISTER = URL + "/xiaoxinyong/rest/users/register";

	// ��ѯ����
	public static String SELECT_FRATION = URL+ "/xiaoxinyong/rest/score/check_zzc";

	/***
	 * �û�ʵ����֤ ������username ���֤�ţ�id_number IMEI��imei
	 */
	public static String USER_CHECK = URL + "/xiaoxinyong/rest/users/id_check";

	/***
	 * ������֤ ��λ���ƣ� workname �̶��绰�� fixtelno ����ʡ�� address_province �����У�
	 * address_city �������أ� address_district ��ϸ��ַ�� address_detail IMEI�� imei
	 * userId:23233423-34-234-23-423-4-23
	 */
	public static String CHECK_WORK = URL + "/xiaoxinyong/rest/users/job_check";

	/***
	 * ��ϵ����֤_����
	 */

	public static String CHECK_relationship = URL
			+ "/xiaoxinyong/rest/users/contact_check_post";


	/***
	 * �û������֤_���� POST POST
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/users/id_check_post
	 */
	public static String USER_SHENGFEN_UPDATA = URL
			+ "/xiaoxinyong/rest/users/id_check_post";
	/***
	 * �û������֤_��ȡ GET
	 */
	public static String USER_SHENGFEN_READ = URL
			+ "/xiaoxinyong/rest/users/id_check_get";
	/***
	 * �޸����� POST
	 * api.xiaoxinyong.com/rest/users/change_password
	 */
	public static String UPDATA_PASSWORD = URL+ "/xiaoxinyong/rest/users/change_password";
	/***
	 * �û�������֤_���� POST POST
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/users/work_check_post
	 */
	public static String USER_WORK_RENZHENG_UPDATA = URL
			+ "/xiaoxinyong/rest/users/work_check_post";
	/***
	 * �û�������֤_��ȡ GET
	 */
	public static String USER_WORK_RENZHENG_READ = URL
			+ "/xiaoxinyong/rest/users/work_check_get";
	/***
	 * �û�������֤_���� POST
	 */
	public static String USER_HOUSE_RENZHENG_UPDATA = URL
			+ "/xiaoxinyong/rest/users/house_check_post";
	/***
	 * �û�������֤_��ȡ GET
	 */
	public static String USER_HOUSE_RENZHENG_READ = URL
			+ "/xiaoxinyong/rest/users/house_check_get";

	/***
	 * �û����п���֤_���� POST
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/users/bankcard_check_post
	 */
	public static String USER_BANK_RENZHENG_UPDATA = URL+ "/xiaoxinyong/rest/users/bankcard_check_post";

	/***
	 * �û����п���֤_��ȡ GET GET
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/users/bankcard_check_get
	 */
	public static String USER_BANK_RENZHENG_READ = URL
			+ "/xiaoxinyong/rest/users/bankcard_check_get";
	/***
	 * ��ϵ����֤_��ȡ POST
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/users/contact_check_post
	 */
	public static String PEOPLE_RENZHENG_READ = URL
			+ "/xiaoxinyong/rest/users/contact_check_post";
	/***
	 * ��ѯ��ǰ���÷� GET
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/users/credit_score_query
	 * 
	 */
	public static String CHECK_SCORE = URL
			+ "/xiaoxinyong/rest/users/credit_score_query";
	/***
	 * 
	 * ��ϵ����֤_��ȡ
	 * 
	 * GET http://api.xiaoxinyong.com/xiaoxinyong/rest/users/contact_check_get
	 * ��ѯ���Ź�˾���÷� POST http://api.xiaoxinyong.com/xiaoxinyong/rest/users/
	 * credit_score_query_company
	 */
	public static String CHECK_ZHENGXING_SCORE = URL
			+ "/xiaoxinyong/rest/users/credit_score_query_company";

	/**
	 * post����
	 * 
	 * ��������=����
	 * 
	 */
	public static String CHECK_HOUSEPAYMENT = URL
			+ "/xiaoxinyong/rest/business/house_credit_post";
	/**
	 * POST����
	 * 
	 * ��������-����
	 * 
	 * 
	 */
	public static String CHECK_CARPAYMENT = URL
			+ "/xiaoxinyong/rest/business/car_credit_post";

	/**
	 * post����
	 * 
	 * �ű�����-����
	 * 
	 * 
	 */

	public static String CHECK_XINBAOPAYMENT = URL
			+ "/xiaoxinyong/rest/business/credit_insurance_post";

	/***
	 * post���� ���η���-����
	 * 
	 * product_name ��Ʒ���� product_price ��Ʒ�۸�(150x12��) userid
	 */
	public static String CHECK_TRAVER_SHENQING = URL
			+ "/xiaoxinyong/rest/business/credit_travel_post";

	/***
	 * post����
	 * 
	 * ��ֵ
	 * 
	 * 
	 */
	public static String CHECK_CHONGZHI = URL
			+ "/xiaoxinyong/rest/account/refund";

	/**
	 * post����
	 * 
	 * ����
	 */
	public static String CHECK_TIXIAN = URL
			+ "/xiaoxinyong/rest/account/withdraw";

	/***
	 * get����
	 * 
	 * ��������
	 * 
	 */
	public static String CHECK_TIXIANBANK = URL
			+ "/xiaoxinyong/rest/account/bankcard_list";

	/**
	 * get����
	 * 
	 * �ҵ��˵�
	 * 
	 * mobileno ���������� userid
	 * 
	 */
	public static String CHECK_MYBILL = URL
			+ "/xiaoxinyong/rest/account/my_account";
	/**
	 * GET����
	 * 
	 * ���׼�¼��ѯ
	 * 
	 * 
	 */
	public static String CHECK_DEALJILU = URL
			+ "/xiaoxinyong/rest/account/trading_record_query";

	/**
	 * get����
	 * 
	 * ����ƻ���ѯ
	 * 
	 */
	public static String CHECK_PAYMENTPLAN = URL
			+ "/xiaoxinyong/rest/account/repayment_plan_query";

	/***
	 * ���ǻ���Ȩ���ѯ GET
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/account/banlance_query
	 * 
	 */
	public static String UWYOUHUANKUANG_QUERY = URL
			+ "/xiaoxinyong/rest/account/balance_query";
	/***
	 * ����ƻ�_��� POST
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/account/repayment_plan_post
	 * 
	 */
	public static String HUAN_KUAN_ADD = URL
			+ "/xiaoxinyong/rest/account/repayment_plan_post";
	/***
	 * ���׼�¼_��ѯ GET http://api.xiaoxinyong.com/xiaoxinyong/rest/account/
	 * trading_record_query
	 */
	public static String JIAO_YI_QUERY = URL
			+ "/xiaoxinyong/rest/account/trading_record_query";

	/***
	 * ��ֵ�ƽ� POST
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/account/refund_advance
	 */
	public static String CHONGZHI = URL
			+ "/xiaoxinyong/rest/account/refund_advance";

	/***
	 * ע��ʱ��֤���ĸ��е����п�
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/account/bankcard_info
	 */
	   
	public static String CHECK_BANK = URL+"/xiaoxinyong/rest/account/bankcard_info";
	
	/***
	 * ��ȡ���п��б� ��Ҫ�Ǽ���û��Ƿ��а󶨹��ÿ�
	 * 
	 */
	public static String CEHCK_USER_BANK=URL+"/xiaoxinyong/rest/account/bankcard_list";
	
	/***
	 * ע��ʱ���п���Ϣ �����һ��ʹ��
	 * 
	 */
	public static String USER_BANK_SUBMIT=URL+"/xiaoxinyong/rest/users/bankcard_check_advance_post";
	/***
	 * ���ǻ���-����ƻ�����1
	 * 
	 */
	public static String WU_YOU_ONE=URL+"/xiaoxinyong/rest/account/repayment_plan_1";
	
	/***
	 * ���ǻ���-����ƻ�����2
	 * 
	 */
	public static String WU_YOU_TWO=URL+"/xiaoxinyong/rest/account/repayment_plan_2";
	
	/***
	 * ���ǻ���-����ƻ�����3
	 * 
	 */
	public static String WU_YOU_THREE=URL+"/xiaoxinyong/rest/account/repayment_plan_3";
	
}
