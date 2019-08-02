package dao;

import java.sql.ResultSet;
import java.util.List;

import pojo.Commodity;

public interface CommodityDAO {

	List<Commodity> getAll();
	Commodity getCommodity(int id);
	int updateCommodity(Commodity com);
	int deleteCommodity(int id);
	int addCommodity(Commodity com);
	
}
