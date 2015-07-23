package com.geo.smallcredit.utils.net;

public class InternetURL {

	// 外网服务器
   public static String URL = "http://api.xiaoxinyong.com";
	
	//内网服务器
//	public static String URL = "http://10.65.113.37/project";
	//用户登录POST
	public static String USER_LOGIN=URL+"/index.php/Rest/Reg/login";
	// 短信验证 post请求
	public static String CHECKPHONE = URL + "/index.php/rest/Reg/mescode";
	//用户注册POST
	public static String USER_REGISTER=URL+"/index.php/Rest/Reg/reg";
	//判断银行卡名称POST
	public static String USER_YANBANK=URL+"/index.php/Rest/User/bankinfo";
	//获取银行验证码 post
	public static String BANK_NUMBER=URL+"/index.php/Rest/User/binding";
	//完成绑卡POST
	public static String BIND_BANK=URL+"/index.php/Rest/User/binding_advance";
	//验证码是否可用 找回密码用POST
	public static String CHECK_PHONE_NUMBER=URL+"/index.php/rest/Reg/iscode";
	//忘记密码post
	public static String CHECK_FORGETPWD = URL+"/index.php/Rest/Reg/retpwd";
	
	
	
	/***
	 * 登录 用户名：username 密码：password IMEI：imei
	 */
	public static String LOGIN = URL + "/xiaoxinyong/rest/users/login";
	// 注册
	/**
	 * 
	 * 姓名：username 手机号：mobileno IMEI：imei
	 * 
	 * 
	 */
	public static String REGISTER = URL + "/xiaoxinyong/rest/users/register";

	// 查询分数
	public static String SELECT_FRATION = URL+ "/xiaoxinyong/rest/score/check_zzc";

	/***
	 * 用户实名验证 姓名：username 身份证号：id_number IMEI：imei
	 */
	public static String USER_CHECK = URL + "/xiaoxinyong/rest/users/id_check";

	/***
	 * 工作验证 单位名称： workname 固定电话： fixtelno 所在省： address_province 所在市：
	 * address_city 所在区县： address_district 详细地址： address_detail IMEI： imei
	 * userId:23233423-34-234-23-423-4-23
	 */
	public static String CHECK_WORK = URL + "/xiaoxinyong/rest/users/job_check";

	/***
	 * 联系人验证_更新
	 */

	public static String CHECK_relationship = URL
			+ "/xiaoxinyong/rest/users/contact_check_post";


	/***
	 * 用户身份验证_更新 POST POST
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/users/id_check_post
	 */
	public static String USER_SHENGFEN_UPDATA = URL
			+ "/xiaoxinyong/rest/users/id_check_post";
	/***
	 * 用户身份验证_读取 GET
	 */
	public static String USER_SHENGFEN_READ = URL
			+ "/xiaoxinyong/rest/users/id_check_get";
	/***
	 * 修改密码 POST
	 * api.xiaoxinyong.com/rest/users/change_password
	 */
	public static String UPDATA_PASSWORD = URL+ "/xiaoxinyong/rest/users/change_password";
	/***
	 * 用户工作认证_更新 POST POST
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/users/work_check_post
	 */
	public static String USER_WORK_RENZHENG_UPDATA = URL
			+ "/xiaoxinyong/rest/users/work_check_post";
	/***
	 * 用户工作认证_读取 GET
	 */
	public static String USER_WORK_RENZHENG_READ = URL
			+ "/xiaoxinyong/rest/users/work_check_get";
	/***
	 * 用户房产认证_更新 POST
	 */
	public static String USER_HOUSE_RENZHENG_UPDATA = URL
			+ "/xiaoxinyong/rest/users/house_check_post";
	/***
	 * 用户房产认证_读取 GET
	 */
	public static String USER_HOUSE_RENZHENG_READ = URL
			+ "/xiaoxinyong/rest/users/house_check_get";

	/***
	 * 用户银行卡认证_更新 POST
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/users/bankcard_check_post
	 */
	public static String USER_BANK_RENZHENG_UPDATA = URL+ "/xiaoxinyong/rest/users/bankcard_check_post";

	/***
	 * 用户银行卡认证_读取 GET GET
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/users/bankcard_check_get
	 */
	public static String USER_BANK_RENZHENG_READ = URL
			+ "/xiaoxinyong/rest/users/bankcard_check_get";
	/***
	 * 联系人验证_读取 POST
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/users/contact_check_post
	 */
	public static String PEOPLE_RENZHENG_READ = URL
			+ "/xiaoxinyong/rest/users/contact_check_post";
	/***
	 * 查询当前信用分 GET
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/users/credit_score_query
	 * 
	 */
	public static String CHECK_SCORE = URL
			+ "/xiaoxinyong/rest/users/credit_score_query";
	/***
	 * 
	 * 联系人验证_读取
	 * 
	 * GET http://api.xiaoxinyong.com/xiaoxinyong/rest/users/contact_check_get
	 * 查询征信公司信用分 POST http://api.xiaoxinyong.com/xiaoxinyong/rest/users/
	 * credit_score_query_company
	 */
	public static String CHECK_ZHENGXING_SCORE = URL
			+ "/xiaoxinyong/rest/users/credit_score_query_company";

	/**
	 * post请求
	 * 
	 * 房贷代还=申请
	 * 
	 */
	public static String CHECK_HOUSEPAYMENT = URL
			+ "/xiaoxinyong/rest/business/house_credit_post";
	/**
	 * POST请求
	 * 
	 * 车贷代还-申请
	 * 
	 * 
	 */
	public static String CHECK_CARPAYMENT = URL
			+ "/xiaoxinyong/rest/business/car_credit_post";

	/**
	 * post请求
	 * 
	 * 信保代还-申请
	 * 
	 * 
	 */

	public static String CHECK_XINBAOPAYMENT = URL
			+ "/xiaoxinyong/rest/business/credit_insurance_post";

	/***
	 * post请求 旅游分期-申请
	 * 
	 * product_name 产品名称 product_price 产品价格(150x12期) userid
	 */
	public static String CHECK_TRAVER_SHENQING = URL
			+ "/xiaoxinyong/rest/business/credit_travel_post";

	/***
	 * post请求
	 * 
	 * 充值
	 * 
	 * 
	 */
	public static String CHECK_CHONGZHI = URL
			+ "/xiaoxinyong/rest/account/refund";

	/**
	 * post请求
	 * 
	 * 提现
	 */
	public static String CHECK_TIXIAN = URL
			+ "/xiaoxinyong/rest/account/withdraw";

	/***
	 * get请求
	 * 
	 * 提现银行
	 * 
	 */
	public static String CHECK_TIXIANBANK = URL
			+ "/xiaoxinyong/rest/account/bankcard_list";

	/**
	 * get请求
	 * 
	 * 我的账单
	 * 
	 * mobileno 提现手续费 userid
	 * 
	 */
	public static String CHECK_MYBILL = URL
			+ "/xiaoxinyong/rest/account/my_account";
	/**
	 * GET请求
	 * 
	 * 交易记录查询
	 * 
	 * 
	 */
	public static String CHECK_DEALJILU = URL
			+ "/xiaoxinyong/rest/account/trading_record_query";

	/**
	 * get请求
	 * 
	 * 还款计划查询
	 * 
	 */
	public static String CHECK_PAYMENTPLAN = URL
			+ "/xiaoxinyong/rest/account/repayment_plan_query";

	/***
	 * 无忧还款权益查询 GET
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/account/banlance_query
	 * 
	 */
	public static String UWYOUHUANKUANG_QUERY = URL
			+ "/xiaoxinyong/rest/account/balance_query";
	/***
	 * 还款计划_添加 POST
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/account/repayment_plan_post
	 * 
	 */
	public static String HUAN_KUAN_ADD = URL
			+ "/xiaoxinyong/rest/account/repayment_plan_post";
	/***
	 * 交易记录_查询 GET http://api.xiaoxinyong.com/xiaoxinyong/rest/account/
	 * trading_record_query
	 */
	public static String JIAO_YI_QUERY = URL
			+ "/xiaoxinyong/rest/account/trading_record_query";

	/***
	 * 充值推进 POST
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/account/refund_advance
	 */
	public static String CHONGZHI = URL
			+ "/xiaoxinyong/rest/account/refund_advance";

	/***
	 * 注册时验证是哪个行的银行卡
	 * http://api.xiaoxinyong.com/xiaoxinyong/rest/account/bankcard_info
	 */
	   
	public static String CHECK_BANK = URL+"/xiaoxinyong/rest/account/bankcard_info";
	
	/***
	 * 获取银行卡列表 主要是检测用户是否有绑定过该卡
	 * 
	 */
	public static String CEHCK_USER_BANK=URL+"/xiaoxinyong/rest/account/bankcard_list";
	
	/***
	 * 注册时银行卡信息 点击下一步使用
	 * 
	 */
	public static String USER_BANK_SUBMIT=URL+"/xiaoxinyong/rest/users/bankcard_check_advance_post";
	/***
	 * 无忧还款-还款计划步骤1
	 * 
	 */
	public static String WU_YOU_ONE=URL+"/xiaoxinyong/rest/account/repayment_plan_1";
	
	/***
	 * 无忧还款-还款计划步骤2
	 * 
	 */
	public static String WU_YOU_TWO=URL+"/xiaoxinyong/rest/account/repayment_plan_2";
	
	/***
	 * 无忧还款-还款计划步骤3
	 * 
	 */
	public static String WU_YOU_THREE=URL+"/xiaoxinyong/rest/account/repayment_plan_3";
	
}
