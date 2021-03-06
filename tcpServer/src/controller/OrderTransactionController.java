package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kioskapp.ordertransaction.OrderTransaction;

public class OrderTransactionController {
	private DbConnect dbCon;

	public OrderTransactionController(){
		dbCon = new DbConnect();
	}

	/**
	 * 
	 * This class insert transaction detail into database
	 * 
	 * @author nursyafiqah jackson
	 *
	 */
		public OrderTransaction insertTransaction(OrderTransaction orderTransaction){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int status =0;
       
		String sql	="INSERT INTO ordertransaction (TransactionDate, `Order`, AmountCharged, "
					+ "TransactionStatus, Last4Digits, OrderMode )"
					+ "VALUES (LOCALTIMESTAMP(),?, ?, ?, ?, ?);";

		try{
			conn = dbCon.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderTransaction.getOrder().getOrderId());
			ps.setFloat(2, orderTransaction.getAmountCharged());
	
			if (orderTransaction.isTransactionStatus())
				ps.setInt(3, 1);
            else
                 ps.setInt(3, 0);
            ps.setInt(4, orderTransaction.getLast4Digits());
            ps.setString(5,orderTransaction.getOrderMode());
            status = ps.executeUpdate();
            

            if(status!=0){   
       
           sql= "OrderTransactionId,TransactionDate FROM ordertransaction";
                
                
                 ps = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
                 rs = ps.executeQuery();
                 rs.afterLast();
                 if(rs.previous()) {
                	 orderTransaction.setOrderTransactionId(rs.getInt(1));
                	 orderTransaction.setTransactioDate(rs.getDate(2) );
                 }
    }         

        }catch(Exception e){
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
        return orderTransaction;
	}

}
