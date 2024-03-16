package PTITHCM.BEAN;




import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "CTTHONGBAO")
public class CTThongbao implements Serializable{
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MANV")
	private NhanVien manhanvienthongbao;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "MATB")
	private ThongBao bangthongbao;

	
	public CTThongbao() {
		super();
	}


	public CTThongbao(NhanVien manhanvienthongbao, ThongBao bangthongbao) {
		super();
		this.manhanvienthongbao = manhanvienthongbao;
		this.bangthongbao = bangthongbao;
	}


	public NhanVien getManhanvienthongbao() {
		return manhanvienthongbao;
	}


	public void setManhanvienthongbao(NhanVien manhanvienthongbao) {
		this.manhanvienthongbao = manhanvienthongbao;
	}


	public ThongBao getBangthongbao() {
		return bangthongbao;
	}


	public void setBangthongbao(ThongBao bangthongbao) {
		this.bangthongbao = bangthongbao;
	}

	
}
