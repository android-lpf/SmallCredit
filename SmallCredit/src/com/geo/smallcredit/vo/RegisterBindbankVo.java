package com.geo.smallcredit.vo;

public class RegisterBindbankVo {
	public int code;
	public data data;

	public data getData() {
		return data;
	}

	public void setData(data data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public RegisterBindbankVo(int code, data data) {
		super();
		this.code = code;
		this.data = data;
	}

	public RegisterBindbankVo() {
		super();
	}

	public class data {
		public String bank_name;
		public String card_name;
		public String card_type;
		public String bank_no;

		public String getBank_name() {
			return bank_name;
		}

		public void setBank_name(String bank_name) {
			this.bank_name = bank_name;
		}

		public String getCard_name() {
			return card_name;
		}

		public void setCard_name(String card_name) {
			this.card_name = card_name;
		}

		public String getCard_type() {
			return card_type;
		}

		public void setCard_type(String card_type) {
			this.card_type = card_type;
		}

		public String getBank_no() {
			return bank_no;
		}

		public void setBank_no(String bank_no) {
			this.bank_no = bank_no;
		}

		public data(String bank_name, String card_name, String card_type,
				String bank_no) {
			super();
			this.bank_name = bank_name;
			this.card_name = card_name;
			this.card_type = card_type;
			this.bank_no = bank_no;
		}

		public data() {
			super();
			// TODO Auto-generated constructor stub
		}

	}
}
