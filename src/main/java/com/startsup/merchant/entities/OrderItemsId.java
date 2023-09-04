/*
 * Created on 2023-08-29 ( 12:15:32 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.startsup.merchant.entities;

import java.io.Serializable;


/**
 * Composite primary key for entity "OrderItems" ( stored in table "order_items" )
 *
 * @author Telosys
 *
 */
public class OrderItemsId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private Integer    orderId ;
    
    private Integer    itemId ;
    
    /**
     * Constructor
     */
    public OrderItemsId() {
        super();
    }

    /**
     * Constructor with values
     * @param orderId 
     * @param itemId 
     */
    public OrderItemsId( Integer orderId, Integer itemId ) {
        super();
        this.orderId = orderId ;
        this.itemId = itemId ;
    }
    
    //--- GETTERS & SETTERS FOR KEY FIELDS
    public void setOrderId( Integer value ) {
        this.orderId = value;
    }
    public Integer getOrderId() {
        return this.orderId;
    }

    public void setItemId( Integer value ) {
        this.itemId = value;
    }
    public Integer getItemId() {
        return this.itemId;
    }


    //--- equals METHOD
	@Override
	public boolean equals(Object obj) { 
		if ( this == obj ) return true ; 
		if ( obj == null ) return false ;
		if ( this.getClass() != obj.getClass() ) return false ; 
		OrderItemsId other = (OrderItemsId) obj; 
		//--- Attribute orderId
		if ( orderId == null ) { 
			if ( other.orderId != null ) 
				return false ; 
		} else if ( ! orderId.equals(other.orderId) ) 
			return false ; 
		//--- Attribute itemId
		if ( itemId == null ) { 
			if ( other.itemId != null ) 
				return false ; 
		} else if ( ! itemId.equals(other.itemId) ) 
			return false ; 
		return true; 
	} 

    //--- hashCode METHOD
	@Override
	public int hashCode() { 
		final int prime = 31; 
		int result = 1; 
		
		//--- Attribute orderId
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode() ) ; 
		//--- Attribute itemId
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode() ) ; 
		
		return result; 
	} 

    //--- toString METHOD
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(orderId);
        sb.append("|");
        sb.append(itemId);
        return sb.toString(); 
    } 

}