package kr.ac.shinan.csp;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class UserLoginToken {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) 
	private Long key; 
	
	@Persistent
	private String token;
//토큰
	@Persistent
	private String userAccount;
	//사용자id
	@Persistent
	private String expireDate;
	//사용기한
	public UserLoginToken(String token, String userAccount, String expireDate){
		super();
		this.token=token;
		this.userAccount=userAccount;
		this.expireDate=expireDate;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public Long getKey() {
		return key;
	}
	
		
	}

