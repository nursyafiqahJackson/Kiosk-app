package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kioskapp.itemproduct.ItemProduct;

/**
 * 
 * This class to connect the Database data of Item product
 * 
 * @author nursyafiqah jackson
 *
 */
public class ItemController {

	private DbConnect dbCon;
	
	public ItemController () {
		dbCon = new DbConnect();
	}
	
	public int getItemID (String productName) {
		Connection conn  = null;
		PreparedStatement ps= null;
		ResultSet rs = null; 
		ItemProduct item = new ItemProduct();
		
String sql = "SELECT Name, Price FROM itemproduct WHERE ItemProduct =? ";
		
		try {
			conn = dbCon.getConnection();
			ps= conn.prepareStatement(sql);
			ps.setInt(1, ItemId);
			rs = ps.executeQuery();
			
			if(rs.next()){
				item.setName(rs.getString(1));
				item.setPrice(rs.getFloat(2));
			}
			
						
			ps.close();
			rs.close();
			conn.close();

		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}

		return item;

	}

	public ArrayList<ItemProduct> getALLProduct ()
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<ItemProduct> products = new ArrayList<ItemProduct>();
		
		String sql = "Please select ItemProduct ,Name, Price FROM itemproduct";
		
		try {
			conn = db.getConnection();
			ps= conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				ItemProduct product = new ItemProduct();
				product.setItemProduct(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getFloat(3));
				products.add(product);
			}			
			
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}

		return products;
	}

	public ItemProduct getProduct(int itemProduct) {
		// TODO Auto-generated method stub
		return null;
	}
}
