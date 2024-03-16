package PTITHCM.BEAN;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class CTBANGLUONGUPDATE implements Serializable {
	@Column(name = "MANV")
	private String manv;
	
	
	@Column(name = "BACLUONG")
	private int bacluong;
	
	@Column(name = "THANG")
	private int thang;
	
	
	@Column(name = "NAM")
	private int nam;

	
	
	

	public CTBANGLUONGUPDATE() {
		super();
	}



	public CTBANGLUONGUPDATE(String manv, int bacluong, int thang, int nam) {
		super();
		this.manv = manv;
		this.bacluong = bacluong;
		this.thang = thang;
		this.nam = nam;
	}



	public String getManv() {
		return manv;
	}



	public void setManv(String manv) {
		this.manv = manv;
	}



	public int getBacluong() {
		return bacluong;
	}



	public void setBacluong(int bacluong) {
		this.bacluong = bacluong;
	}



	public int getThang() {
		return thang;
	}



	public void setThang(int thang) {
		this.thang = thang;
	}



	public int getNam() {
		return nam;
	}



	public void setNam(int nam) {
		this.nam = nam;
	}



	@Override
	public int hashCode() {
		return Objects.hash(bacluong, manv, nam, thang);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CTBANGLUONGUPDATE other = (CTBANGLUONGUPDATE) obj;
		return bacluong == other.bacluong && Objects.equals(manv, other.manv) && nam == other.nam
				&& thang == other.thang;
	}



	
}
