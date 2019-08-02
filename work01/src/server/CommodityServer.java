package server;

import java.util.List;

import pojo.Commodity;

public interface CommodityServer {

	List<Commodity> getAll();
	Commodity getCommodity(int id);
	int updateCommodity(Commodity com);
	int deleteCommodity(int id);
	int addCommodity(Commodity com);
	
}
