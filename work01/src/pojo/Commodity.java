package pojo;

public class Commodity {

	int Id;
	int Man;
	String Name;
	int Price;
	int StockId;
	String Date;
	
	
	
	
	public Commodity() {}
	public Commodity(int id, int man, String name, int price, int stockId, String date) {
		Id = id;
		Man = man;
		Name = name;
		Price = price;
		StockId = stockId;
		Date = date;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getMan() {
		return Man;
	}
	public void setMan(int man) {
		Man = man;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getStockId() {
		return StockId;
	}
	public void setStockId(int stockId) {
		StockId = stockId;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	public String[] getAllVar(){
		return new String[]{getId()+"",getMan()+"",getName(),getPrice()+"",getStockId()+"",getDate()};
	}
	
	public String[] getVarNocludeId(){
		return new String[]{getMan()+"",getName(),getPrice()+"",getStockId()+"",getDate()};
	}
	
}
