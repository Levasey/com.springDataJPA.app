package com.springDataJPA.app.models;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int item_id;

    @NotEmpty(message = "Name shouldn't be empty")
    @Column(name = "item_name")
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    public Item() {}

    public Item(String item_name) {
        this.itemName = item_name;
    }

    public int getItem_id() {
        return item_id;
    }

    public String getItemName() {
        return itemName;
    }

    public Person getOwner() {
        return owner;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public void setItemName(String item_name) {
        this.itemName = item_name;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_id=" + item_id +
                ", item_name='" + itemName + '\'' +
                '}';
    }
}
