package PTITHCM.BEAN;


import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CHAMCONG")
public class ChamCong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCHAMCONG")
	private int idchamcong;
	@Column(name = "NGAYCHAMCONG")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngaycc;
	@Column(name = "GIOVAO")
	private Time giovao;
	@Column(name = "TRANGTHAI")
	private int trangthai;
	@OneToOne
	@JoinColumn(name = "IDLLV")
	private LichLamViec lichlamviec;

	public ChamCong() {
		super();
	}

	public ChamCong(int idchamcong, Date ngaycc, Time giovao, int trangthai, LichLamViec lichlamviec) {
		super();
		this.idchamcong = idchamcong;
		this.ngaycc = ngaycc;
		this.giovao = giovao;
		
		this.trangthai = trangthai;
		this.lichlamviec = lichlamviec;
	}






	public int getIdchamcong() {
		return idchamcong;
	}

	public void setIdchamcong(int idchamcong) {
		this.idchamcong = idchamcong;
	}

	public Date getNgaycc() {
		return ngaycc;
	}

	public void setNgaycc(Date ngaycc) {
		this.ngaycc = ngaycc;
	}

	public Date getGiovao() {
		return giovao;
	}

	public void setGiovao(Time giovao) {
		this.giovao = giovao;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public LichLamViec getLichlamviec() {
		return lichlamviec;
	}

	public void setLichlamviec(LichLamViec lichlamviec) {
		this.lichlamviec = lichlamviec;
	}
	public String trangthailamviec() {
		if(this.trangthai == 0) {
			return "Đi làm đúng giờ";
		}
		else if (this.trangthai == 1) {
			return "Đi làm trễ";
		}
		return "Không đi làm";
	}
}
