package entity;

public class User {
	
	private int id;
	private String name;
	private String password;
	private String repassword;
	private String passwordMD5;
	private String xm;
	private String email;
	private String phone;
	private String qq;
	private String validationCode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) throws Exception {
		this.password = password;
		this.passwordMD5 = common.Encrypter.md5Encrypt(password);
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getPasswordMD5() {
		return passwordMD5;
	}
	public void setPasswordMD5(String passwordMD5) {
		this.passwordMD5 = passwordMD5;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getValidationCode() {
		return validationCode;
	}
	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", repassword=" + repassword
				+ ", passwordMD5=" + passwordMD5 + ", xm=" + xm + ", email=" + email + ", phone=" + phone + ", qq=" + qq
				+ ", validationCode=" + validationCode + "]";
	}

}
