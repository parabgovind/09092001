package nmfc.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="administrator") 
public class Administrator implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private String administrator_name;
	private String administrator_password;
	public String getAdministrator_name() {
		return administrator_name;
	}
	public void setAdministrator_name(String administrator_name) {
		this.administrator_name = administrator_name;
	}
	public String getAdministrator_password() {
		return administrator_password;
	}
	public void setAdministrator_password(String administrator_password) {
		this.administrator_password = administrator_password;
	}
	@Override
	public String toString() {
		return "Administrator [administrator_name=" + administrator_name + ", administrator_password="
				+ administrator_password + "]";
	}

}
