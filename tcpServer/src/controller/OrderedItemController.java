package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import kioskapp.order.Order;

public class OrderedItemController {
	private DbConnect dbCon;
	
	/**
	 * 
	 * This class to access the Database data made by the client to vbe processed 
	 * 
	 * @author nursyafiqah jackson
	 *
	 */
    public OrderedItemController (){
         dbCon=new DbConnect();
    }


    public void insertOrderedItem (Order order){
    	
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int status =0;
       String sql="INSERT  ordereditem (ItemProduct,Quantity,SubTotalAmount,`Order`) "+
        "VALUES (?,?,?,?);";
        try {
		    conn = dbCon.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i =0 ; i< order.getOrderedItems().size() ; i++){
        	
            	ps.setInt(1, order.getOrderedItems().get(i).getItemProduct().getItemProduct());
            	ps.setInt(2, order.getOrderedItems().get(i).getQuantity());
            	ps.setFloat(3, order.getOrderedItems().get(i).getSubTotalAmount());
            	ps.setInt(4, order.getOrderId());
            	status += ps.executeUpdate();
            	}
         
            if (status != order.getOrderedItems().size())
                System.out.println("Some product is not added into database");

	    } 
        
        catch (ClassNotFoundException | SQLException e) {
		
		    e.printStackTrace();
		    
		    
	    }
       
        
        
        finally{
        
				try {
                      if (ps!= null)
                            ps.close();
                      if (rs!=null)
                            rs.close();
                      if(conn!=null)
					        conn.close();
                            
				} catch (SQLException e) {
					
					e.printStackTrace();
				}  
        } 

    }
}
