/*
 * Created on 2023-08-26 ( 12:57:23 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.startsup.merchant.entities;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * JPA entity class for "Items"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="items", catalog="merchantdb" )
public class Items implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="name", length=45)
    private String     name ;

    @Column(name="description", length=100)
    private String     description ;

    @Column(name="price")
    private Double     price ;

    @Column(name="merchant_id")
    private Integer    merchantId ;

    @Column(name="category", length=60)
    private String     category ;

    @Column(name="tags", length=65535)
    private String     tags ;

    @Column(name="custom_tax")
    private Double     customTax ;

    @Column(name="custom_commission")
    private Double     customCommission ;

    @Column(name="is_veg")
    private Byte       isVeg ;

    @Column(name="additional_details", length=1073741824)
    private String     additionalDetails ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="merchant_id", referencedColumnName="id", insertable=false, updatable=false)
    private Merchants  merchants ; 


    /**
     * Constructor
     */
    public Items() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    public void setName( String name ) {
        this.name = name ;
    }
    public String getName() {
        return this.name;
    }

    public void setDescription( String description ) {
        this.description = description ;
    }
    public String getDescription() {
        return this.description;
    }

    public void setPrice( Double price ) {
        this.price = price ;
    }
    public Double getPrice() {
        return this.price;
    }

    public void setMerchantId( Integer merchantId ) {
        this.merchantId = merchantId ;
    }
    public Integer getMerchantId() {
        return this.merchantId;
    }

    public void setCategory( String category ) {
        this.category = category ;
    }
    public String getCategory() {
        return this.category;
    }

    public void setTags( String tags ) {
        this.tags = tags ;
    }
    public String getTags() {
        return this.tags;
    }

    public void setCustomTax( Double customTax ) {
        this.customTax = customTax ;
    }
    public Double getCustomTax() {
        return this.customTax;
    }

    public void setCustomCommission( Double customCommission ) {
        this.customCommission = customCommission ;
    }
    public Double getCustomCommission() {
        return this.customCommission;
    }

    public void setIsVeg( Byte isVeg ) {
        this.isVeg = isVeg ;
    }
    public Byte getIsVeg() {
        return this.isVeg;
    }

    public void setAdditionalDetails( String additionalDetails ) {
        this.additionalDetails = additionalDetails ;
    }
    public String getAdditionalDetails() {
        return this.additionalDetails;
    }

    //--- GETTERS FOR LINKS
    public Merchants getMerchants() {
        return this.merchants;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(price);
        sb.append("|");
        sb.append(merchantId);
        sb.append("|");
        sb.append(category);
        // attribute 'tags' not usable (type = String Long Text)
        sb.append("|");
        sb.append(customTax);
        sb.append("|");
        sb.append(customCommission);
        sb.append("|");
        sb.append(isVeg);
        // attribute 'additionalDetails' not usable (type = String Long Text)
        return sb.toString(); 
    } 

}
