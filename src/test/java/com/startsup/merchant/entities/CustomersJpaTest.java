///*
// * Created on 2023-08-28 ( 12:13:46 )
// * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
// */
//package com.startsup.merchant.entities;
//
//import static junit.framework.TestCase.assertNotNull;
//import static junit.framework.TestCase.assertNull;
//
//import com.startsup.merchant.jpa.tools.JpaTest;
//import org.junit.Test;
//
//public class CustomersJpaTest extends JpaTest {
//
//    @Override
//    public void initData() {
//		// DatabaseData.init(em) has been called before
//		// Initialize here other data required for the current test
//    }
//
//    private Customers createEntity() {
//    	Customers entity = new Customers();
//		entity.setId( Integer.valueOf(200) ) ;
//		entity.setName( "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" ) ;
//		entity.setEmail( "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" ) ;
//		entity.setPhone( "BBBBBBBBBBBBBBBBBBBB" ) ;
//		entity.setZoneId( Integer.valueOf(100) ) ;
//		entity.setAddressFirstLine( "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" ) ;
//		entity.setAddressSecondLine( "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" ) ;
//		entity.setCity( "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" ) ;
//		entity.setState( "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" ) ;
//		entity.setCountry( "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" ) ;
//		entity.setAdditionalDetails( "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" ) ;
//    	return entity;
//    }
//
//    private Object getEntityKey(Customers entity) {
//    	return entity.getId();
//    }
//
//    @Test
//    public void testPersistFindRemove() {
//
//    	Customers entity = createEntity();
//    	Object key = getEntityKey(entity);
//
//    	// if entity doesn't exist yet
//    	if ( find(Customers.class, key) == null ) {
//
//	    	// Create with 'persist'
//    		persistAndRefresh(entity);
//
//			// Find
//			Customers entity2 = find(Customers.class, key);
//			assertNotNull(entity2);
//
//			// Remove
//			remove(entity2);
//			assertNull(find(Customers.class, key));
//		}
//    }
//
//    @Test
//    public void testMergeFindRemove() {
//
//    	Customers entity = createEntity();
//    	Object key = getEntityKey(entity);
//
//    	// Create or update with 'merge'
//    	mergeAndRefresh(entity);
//
//    	// Find
//    	Customers entity2 = find(Customers.class, key);
//        assertNotNull(entity2);
//
//    	// Remove
//    	remove(entity2);
//        assertNull(find(Customers.class, key));
//    }
//
//}
