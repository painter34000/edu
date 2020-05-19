package co.yedam.app.member;

public class MemberVO {
	String id;
	String pwd;
	String name;
	String hobby;
	String gender;
	String religion;
	String introduction;
	String regdt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String gintroduction) {
		this.introduction = gintroduction;
	}

	public String getRegdt() {
		return regdt;
	}

	public void setRegdt(String redgt) {
		this.regdt = regdt;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", hobby=" + hobby + ", gender=" + gender
				+ ", religion=" + religion + ", gintroduction=" + introduction + ", redgt=" + regdt + "]";
	}

}
