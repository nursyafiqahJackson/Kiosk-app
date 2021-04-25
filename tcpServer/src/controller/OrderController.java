package controller;

import kioskapp.order.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * This class to controll the order made by the client 
 * 
 * @author nursyafiqah jackson
 *
 */
public class OrderController {

	private DbConnect dbCon;

	public OrderController(){
		dbCon = new DbConnect();
	}
	
	public Order insertOrder (Order order) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int status = 0;

       try {
			  conn = dbCon.getConnection();
               ps = conn.prepareStatement(ql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
               ps.setFloat(1, order.getTotalAmount());
               ps.setInt(2, order.getOrderReferenceNumber());
              

               status = ps.executeUpdate();
               ps.close();
               if(status!=0)
               { ps = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                   rs = ps.executeQuery();
                   rs.last();
                   
                   order.setOrderId(rs.getInt(1));
               }
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

       
   return order;

	
	}
}
