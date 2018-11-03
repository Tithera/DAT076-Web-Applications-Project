
package core;

import java.io.Serializable;
import javax.enterprise.inject.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * The core file for rent out 
 * Person responsible for class: Therese Sturesson
 */

@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Model
@Table(name = "rentOut")
public class RentOut implements Serializable {
    
    
    /* The variables with getters och setters */
    @Id
    @Column(nullable=false)
    @Getter
    @Setter
    private String id;
    
    @Getter
    @Setter
    private String adress;
    
    @Getter
    @Setter
    private int room;
    
    @Getter
    @Setter
    private int price;
    
    @Getter
    @Setter
    private String description;
    
    @Getter
    @Setter
    private String name;
    
    @Getter
    @Setter
    private int phoneNr;
    
    @Getter
    @Setter
    private String mail;
    
    @Getter
    @Setter
    private String image;
    
    
    /* The constructor for the rent out class */
    public RentOut (String id, String adress, int room, int price,  String description, 
            String name, int phoneNr, String mail, String image) {
    this.id = id;
    this.adress = adress;
    this.room = room;
    this.price = price;
    this.description = description;
    this.name = name;
    this.phoneNr = phoneNr;
    this.mail = mail;
    this.image = image;
    }
    
    
    /* A toString method to write out how a rent out ad should look like */
    @Override
    public String toString() {
        return "Apartment(To rent out){" + "id = " + id + ", adress = " + adress + 
            ", room = " + room + ", price = " + price + ", description = " + description + 
            ", name = " + name + ", phoneNr = " + phoneNr + ", mail = " + mail + 
            ", image = " + image +"}";
    }   

}
