package tcpServerApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.List;

/**
 * 
 */

/**
 * @author nursyafiqah adilla 
 *
 */

import controller.OrderTransactionController;
import controller.OrderedItemController;
import controller.DbConnect;
import controller.ItemController;
import controller.OrderController;

import kioskapp.ordertransaction.OrderTransaction;
import kioskapp.ordereditem.OrderedItem;
public class tcpOrderServerApp {
	
	/**
	 * main class of the server
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	public static void main (String[] args) throws IOException, ClassNotFoundException {
		
		//connected to port 
		int portNo = 1223;
		DatagramSocket serverSocket = new DatagramSocket(1223);
		
		ServerInterfaceFrame frame = new ServerInterfaceFrame ();
		frame.setVisible(true);
		
		int referenceNumber=0;
		
		while(true) {
			
			
			Socket DataClientSocket= serverSocket.accept(); //client request received
			
			ObjectInputStream inputStream = new ObjectInputStream(DataClientSocket.getInputStream());
			
			OrderTransaction orderTransaction = (OrderTransaction)inputStream.readObject();
			//order being processed
			
			String creditCardNumber = inputStream.readUTF();
			frame.updateRequestStatus(creditCardNumber);
			
			Socket transactionSocket = new Socket(InetAddress.getLocalHost(),1223);
			
			ObjectOutputStream transactionOutputStream = new ObjectOutputStream (transactionSocket.getOutputStream());
			transactionOutputStream.writeObject(orderTransaction);
			transactionOutputStream.writeUTF(creditCardNumber);
			
			//to open a transaction server
			transactionOutputStream.flush();
			
			ObjectInputStream transactionInputStream = new ObjectInputStream(transactionSocket.getInputStream());
			orderTransaction = (OrderTransaction)transactionInputStream.readObject();
			//to open a transaction server
			
			if(orderTransaction.isTransactionStatus()) { //inserting the database
				
				orderTransaction.getOrder().setOrderReferencenumber(++referenceNumber);
					OrderController orderController = new OrderController();
					orderTransaction.setOrder(orderController.insertOrder(orderTransaction.getOrder()));
					
					OrderTransactionController placeController = new OrderTransactionController ();
					placeController.insertTransaction(orderTransaction);
					
					OrderedItemController orderedItemController = new OrderedItemController();
					orderedItemController.insertOrderedItem(orderTransaction.getOrder());
					
					ItemController itemProductController = new ItemController();
					List<OrderedItem>products = orderTransaction.getOrder().getOrderedItem();
					
					for(OrderedItem product : product) {
						product.setItemProduct(itemProductController.getProduct(product.getItemProduct().getItemProduct()));
						
					}
			}
			
			ObjectOutputStream outputStream = new ObjectOutputStream(DataClientSocket.getOutputStream());
			
			outputStream.writeObject(orderTransaction);
			outputStream.flush();
			
			DataClientSocket.close();
			inputStream.close();
			transactionSocket.close();
			outputStream.close();
			transactionOutputStream.close();
			transactionInputStream.close();
		
		}
	}

}
