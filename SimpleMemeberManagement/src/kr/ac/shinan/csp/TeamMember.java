package kr.ac.shinan.csp;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class TeamMember {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long key;

	public void setKey(Long key) {
		this.key = key;
	}

	@Persistent
	private String name;
	@Persistent
	private String hak;
	@Persistent
	private String num;
	@Persistent
	private String email;
	@Persistent
	private String kakao;
	@Persistent
	private String leader;
	@Persistent
	private String gitid;

	public TeamMember(String name, String hak, String num, String email,
			String kakao, String leader, String gitid) {
		super();
		this.name = name;
		this.hak = hak;
		this.num = num;
		this.email = email;
		this.kakao = kakao;
		this.leader = leader;
		this.gitid = gitid;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHak() {
		return hak;
	}

	public void setHak(String hak) {
		this.hak = hak;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKakao() {
		return kakao;
	}

	public void setKakao(String kakao) {
		this.kakao = kakao;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getGitid() {
		return gitid;
	}

	public void setGitid(String gitid) {
		this.gitid = gitid;
	}

	public Long getKey() {
		return key;
	}

}