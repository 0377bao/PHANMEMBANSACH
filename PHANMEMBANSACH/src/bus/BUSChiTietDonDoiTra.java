package bus;

import java.util.ArrayList;

import dao.DAOChiTietDonDoiTra;
import entity.ChiTietDonDoiTra;

public class BUSChiTietDonDoiTra {
	DAOChiTietDonDoiTra daoChiTietDonDoiTra = new DAOChiTietDonDoiTra();
	public ArrayList<ChiTietDonDoiTra> layChiTietDonDoiTraCuaDonDoiTra(String maDDT){
		return daoChiTietDonDoiTra.layChiTietDonDoiTraCuaDonDoiTra(maDDT);
	}
}
