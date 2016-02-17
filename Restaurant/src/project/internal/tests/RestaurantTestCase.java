package project.internal.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import project.internal.daos.ItemDAO;
import project.internal.daos.OrderDAO;
import project.internal.daos.OrderItemsDAO;
import project.internal.entity.Item;
import project.internal.entity.Order;
import project.internal.entity.OrderItem;

public class RestaurantTestCase {

	ItemDAO dao = new ItemDAO();
	OrderDAO orderdao =new OrderDAO();
	OrderItemsDAO orderItemdao = new OrderItemsDAO();
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	
	}

//	@Test
//	public void testItemDAO() {
//	
//		//	fail("Not yet implemented");
//		Item item1 = new Item("NG101", "Chicken Biriyani", "Non-Veg", 245.00, "Available");
//	
//		assertEquals(1,dao.add(item1));
//		
//	}
//
//	@Test
//	public void testOrderDAO() {
//	
//		//	fail("Not yet implemented");
//		Order order1 = new Order("D101", "SW2", 4, "Pending");
//	
//		assertEquals(1,orderdao.add(order1));
//		
//	}

//	@Test
//	public void testOrderItemDAO() {
//	
//		//	fail("Not yet implemented");
//		OrderItem orderItem = new OrderItem("L101", "NG101", 2, "More Spicy", "Pending");
//	
//		assertEquals(1,orderItemdao.add(orderItem));
//	}
	
	@Test
	public void testOrderItems() {
	
		//	fail("Not yet implemented");
	
		List<Item> itemList = new ArrayList<Item>();
		itemList = orderdao.getItemsOrdered("L101");
		System.out.println(itemList.toString());
	}
}
