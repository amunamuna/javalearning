package com.nadou.mybatis.web.model.user;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *
 * 
 *
 */
@TableName("TB_U_USER")
public class TbUUser implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.UUID)
	private String id;

	/** 用户名 */
	@TableField(value = "UU_NAME")
	private String uuName;

	/** 密码 */
	@TableField(value = "UU_PASSWORD")
	private String uuPassword;

	/** 邮箱 */
	@TableField(value = "UU_EMAIL")
	private String uuEmail;

	/** 手机号 */
	@TableField(value = "UU_PHONE")
	private String uuPhone;
	/**联系人**/
	@TableField(value = "UU_CONTRACT_PERSON")
	private String uuContractPerson;

	/**联系人电话**/
	@TableField(value = "UU_CONTRACT_PHONE")
	private String uuContractPhone;

	/** 账户状态
		0 未激活
		-1 停用
		1  正常 */
	@TableField(value = "UU_STATE")
	private Integer uuState;

	/** 创建时间 */
	@TableField(value = "UU_CREATE_TIME")
	private Date uuCreateTime;

	/** 更新时间 */
	@TableField(value = "UU_UPDATE_TIME")
	private Date uuUpdateTime;


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUuName() {
		return this.uuName;
	}

	public void setUuName(String uuName) {
		this.uuName = uuName;
	}

	public String getUuPassword() {
		return this.uuPassword;
	}

	public void setUuPassword(String uuPassword) {
		this.uuPassword = uuPassword;
	}

	public String getUuEmail() {
		return this.uuEmail;
	}

	public void setUuEmail(String uuEmail) {
		this.uuEmail = uuEmail;
	}

	public String getUuPhone() {
		return this.uuPhone;
	}

	public void setUuPhone(String uuPhone) {
		this.uuPhone = uuPhone;
	}

	public String getUuContractPerson() {
		return uuContractPerson;
	}

	public void setUuContractPerson(String uuContractPerson) {
		this.uuContractPerson = uuContractPerson;
	}

	public String getUuContractPhone() {
		return uuContractPhone;
	}

	public void setUuContractPhone(String uuContractPhone) {
		this.uuContractPhone = uuContractPhone;
	}

	public Integer getUuState() {
		return this.uuState;
	}

	public void setUuState(Integer uuState) {
		this.uuState = uuState;
	}

	public Date getUuCreateTime() {
		return this.uuCreateTime;
	}

	public void setUuCreateTime(Date uuCreateTime) {
		this.uuCreateTime = uuCreateTime;
	}

	public Date getUuUpdateTime() {
		return this.uuUpdateTime;
	}

	public void setUuUpdateTime(Date uuUpdateTime) {
		this.uuUpdateTime = uuUpdateTime;
	}

	@Override
	public String toString() {
		return id+"||"+uuName;
	}
}
