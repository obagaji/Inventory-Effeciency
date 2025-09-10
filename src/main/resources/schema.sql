

CREATE TABLE if not exists STAFF
(
  staff_id  serial primary key,
  name varchar (100) not null,
  email varchar (100) not null,
  sex varchar (50)not null,
  country varchar(200),
  city varchar(200),
  street varchar(255)
);
CREATE TABLE if not exists ITEM_TABLE
(
    item_product_id  serial primary key,
    item_description varchar (255) NOT NULL,
    item_quantity_in_stock INT NOT NULL,
    item_name varchar (255) NOT NULL,
    item_expiration_date DATE NOT NULL,
    item_selling_price INT NOT NULL,
    current_date_time DATE,
    date_time_in DATE
);
CREATE TABLE if not exists STOCK_TABLE
(
    item_id int
    item_stock_total INT,
    item_Date_in DATE NOT NULL,
    total_stock INT NOT NULL,
    out_rate INT NOT NULL,
    possible_out_stock_date Date NOT NULL
);
CREATE TABLE if not exists DEPT_TABLE
(
    dept_id serial primary key,
    dept_name varchar(100) NOT NULL,
    dept_head_name varchar (100)
);
CREATE TABLE if not exists items_sold
(
   items_sale_id  serial  primary key,
   amount_paid INT NOT NULL,
   discount_given INT,
   change_given INT,
   total_sales INT NOT NULL,
   sales_agent_id INT NOT NULL,
   sold_date_time DATE NOT NULL,
   customer_aggregate bigint,
   FOREIGN key(customer_aggregate)references CUSTOMER (customer_id),
   item_reference bigint,
   FOREIGN KEY(item_reference)references ITEM_TABLE(item_product_id)

);
CREATE TABLE if not exists MONTHLY_TOTAL_SALE
(
    item_id INT NOT NULL,
    end_month_date DATE NOT NULL,
    item_total INT NOT NULL,
    percentage_total_month DOUBLE,
    monthly_total_sales DOUBLE
);
CREATE TABLE if not exists LOCATION_TABLE
(
    location_id serial primary key,
    location_name varchar(255) not null,
    item_Date_in DATE NOT NULL,
    out_rate INT NOT NULL,
    possible_out_stock_date Date NOT NULL,
    item_id_reference varchar (255),
    FOREIGN KEY (item_id_reference) references ITEM_TABLE(item_product_id)


);
CREATE TABLE IF NOT EXISTS ORDERED_ITEM
(
    quantity INT ,
    time_ordered DATE ,
    country varchar(200),
    city varchar(200),
    street varchar(255),
    items_sold bigint not null

);
CREATE TABLE if not exists CUSTOMER
(
    customer_id IDENTITY PRIMARY key,
    customer_email varchar(200),
    customer_age_range varchar(50),
    total_purchases INT,
    most_recent_purchases INT
)

   -- name varchar(200), -->
  --  phone varchar (100) not null,