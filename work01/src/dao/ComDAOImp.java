package dao;

import java.awt.dnd.DnDConstants;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Commodity;
import utils.DBUtils;

public class ComDAOImp implements CommodityDAO {

	@Override
	public List<Commodity> getAll() {

		DBUtils.openConnection();
		String sql = "select * from commodityInfo";
		ResultSet res = DBUtils.executeQuery(sql);
		
		List<Commodity> list = new ArrayList<Commodity>();
		
		try {
			while(res.next()){
				int i =0;
				Commodity com = new Commodity(res.getInt(++i),res.getInt(++i),res.getString(++i),res.getInt(++i),res.getInt(++i),res.getString(++i));
				list.add(com);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection();
		}
		
		return list;
	}

	@Override
	public Commodity getCommodity(int id) {
		DBUtils.openConnection();
		String sql ="select * from commodityinfo where commodityId=?"; 
		ResultSet res = DBUtils.executeQuery(sql, id);
		try {
			if(res.next()){
				int i = 0;
				Commodity com = new Commodity(res.getInt(++i),res.getInt(++i),res.getString(++i),res.getInt(++i),res.getInt(++i),res.getString(++i));
				return com;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection();
		}
		return null;
	}

	@Override
	public int updateCommodity(Commodity com) {

		DBUtils.openConnection();
		String sql = "update commodityInfo set commodityMan = ?,commodityName = ?,"+
		"commodityPrice =?,commodityStockId = ?,commodityVaildDate = ? where commodityId=? ";
		int rs = DBUtils.executeUpdate(sql,com.getMan(),com.getName(),com.getPrice(),com.getStockId(),com.getDate(),com.getId());
		DBUtils.closeConnection();
		return rs;
	}

	@Override
	public int deleteCommodity(int id) {

		DBUtils.openConnection();
		String sql = "delete from commodityInfo where commodityId = ?";
		int res = DBUtils.executeUpdate(sql, id);
		DBUtils.closeConnection();
		return res;
	}

	@Override
	public int addCommodity(Commodity com) {

		DBUtils.openConnection();
		String sql = "insert commodityInfo values(?,?,?,?,?,?)";
		int rs = DBUtils.executeUpdate(sql,com.getId(),com.getMan(),com.getName(),com.getPrice(),com.getStockId(),com.getDate());
		DBUtils.closeConnection();
		
		return rs;
	}

}
