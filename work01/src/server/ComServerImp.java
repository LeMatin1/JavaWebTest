package server;

import java.util.List;

import dao.ComDAOImp;
import dao.CommodityDAO;
import pojo.Commodity;

public class ComServerImp implements CommodityServer {

	CommodityDAO cdao = new ComDAOImp();
	@Override
	public List<Commodity> getAll() {
		return cdao.getAll();
	}

	@Override
	public Commodity getCommodity(int id) {
		return cdao.getCommodity(id);
	}

	@Override
	public int updateCommodity(Commodity com) {
		return cdao.updateCommodity(com);
	}

	@Override
	public int deleteCommodity(int id) {
		return cdao.deleteCommodity(id);
	}

	@Override
	public int addCommodity(Commodity com) {
		// TODO Auto-generated method stub
		return cdao.addCommodity(com);
	}

}
