package core;

import java.io.Serializable;
import javax.enterprise.inject.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

/**
 * The core class for Rent
 * Person resbonsible for class: Amanda Jonsson
 */
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Model
@Table(name = "rent")
public class Rent implements Serializable {

    @Id
    @Column(nullable=false)
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String description;
    
    @Getter
    @Setter
    private int price;
      
    @Getter
    @Setter
    private int rooms;
   
     @Getter
    @Setter
    private String mail;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int phoneNr;

   

    public Rent(String id, String description, int price, int rooms, String mail, String name, int phoneNr){
        this.id=id;
        this.description=description;
        this.price=price;
        this.rooms=rooms;
        this.mail=mail;
        this.name=name;
        this.phoneNr=phoneNr;

    }
    /* A toString method to write out how a rent ad should look like */
    @Override
    public String toString() {
        return "Apartment(To rent){" + "id = " + id +  
            "description=" + description + "price=" + price + "rooms=" + rooms +  "mail= " + mail + ", name = " + name + ", phoneNr = " + phoneNr 
             + "'}'";
    } 

}
