package com.jtc.Inventory.Effeciency.inventoryEntities;

import org.springframework.data.annotation.Id;

public class DeptTab
{
    @Id
    private Long deptId;
    private String deptName;
    private String deptHeadName;
    /*
     dept_id serial primary key,
    dept_name varchar(100) NOT NULL,
    dept_head_name varchar (100),
    list_staff_id INT REFERENCES STAFF
    */

}
