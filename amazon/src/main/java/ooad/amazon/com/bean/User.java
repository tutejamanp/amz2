package ooad.amazon.com.bean;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String password;
	private String emailid;
	private int is_customer;
	private String profilePic;
	
	
	
	
	
    @Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", emailid=" + emailid + ", is_customer=" + is_customer
				+ ", profilePic=" + profilePic + ", addrlist=" + addrlist + ", cardlist=" + cardlist + "]";
	}
	@ElementCollection
    @GenericGenerator(name="addrGenerator",strategy="sequence")
    @CollectionId(
        columns=@Column(name="aid"),
        type=@Type(type="long"),
        generator="addrGenerator"
    )
    private List<Address> addrlist = new ArrayList<Address>();
	
    
    @ElementCollection
    @GenericGenerator(name="cardGenerator",strategy="sequence")
    @CollectionId(
        columns=@Column(name="cardid"),
        type=@Type(type="long"),
        generator="cardGenerator"
    )
    private List<Card> cardlist = new ArrayList<Card>();
	
    
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public List<Card> getCardlist() {
		return cardlist;
	}
	public void setCardlist(List<Card> cardlist) {
		this.cardlist = cardlist;
	}
	public List<Address> getAddrlist() {
		return addrlist;
	}
	public void setAddrlist(List<Address> addrlist) {
		this.addrlist = addrlist;
	}
	public int isIs_customer() {
		return is_customer;
	}
	public void setIs_customer(int is_customer) {
		this.is_customer = is_customer;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
