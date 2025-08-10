--CREATE TABLE IF NOT EXISTS STAFF;
--CREATE TABLE IF NOT EXISTS ITEMS
--CREATE TABLE IF NOT EXISTS ITEM_CONSUMABLE
--CREATE TABLE IF NOT EXISTS CUSTOMER
--CREATE TABLE IF NOT EXISTS LOGISTIC_TABLE
--CREATE TABLE IF NOT EXISTS LOCATION_TABLE
--CREATE TABLE IF NOT EXISTS ITEM_BATCH
--CREATE TABLE IF NOT EXISTS SALES_TABLE
--CREATE TABLE IF NOT EXISTS DEPT_TABLE
--CREATE TABLE IF NOT EXISTS MONTHLY_TOTAL_SALE -->


CREATE TABLE if not exists STAFF
(
  staff_id  serial primary key,
  name varchar (100) not null,
  role varchar (100) not null,
  email varchar (100) not null,
  sex varchar (50)not null,
  address varchar(100)not null
);
CREATE TABLE if not exists ITEM_TABLE
(
    item_product_id  serial primary key,
    item_description varchar (255) NOT NULL,
    item_quantity_in_stock INT NOT NULL,
    item_name varchar (255) NOT NULL,
    item_expiration_date DATE NOT NULL,
    item_selling_price INT NOT NULL
);
CREATE TABLE if not exists STOCK_TABLE
(
    item_stock_total INT,
    item_Date_in DATE NOT NULL,
    total_stock INT NOT NULL,
    out_rate INT NOT NULL,
    possible_out_stock_date Date NOT NULL,
    location_of_item varchar(100)
);
CREATE TABLE if not exists DEPT_TABLE
(
    dept_id serial primary key,
    dept_name varchar(100) NOT NULL,
    dept_head_name varchar (100),
    list_staff_id INT REFERENCES STAFF
);
CREATE TABLE if not exists SALES_TABLE
(
   items_sale_id serial primary key,
   customer INT NOT NULL references CUSTOMER (id),
   amount_paid INT NOT NULL,
   discount_given INT,
   change_given INT,
   total_sales INT NOT NULL,
   sales_agent_id INT NOT NULL,
   sold_date_time DATE NOT NULL
);
CREATE TABLE if not exists MONTHLY_TOTAL_SALE
(
    item_id INT NOT NULL,
    end_month_date DATE NOT NULL,
    item_total INT NOT NULL,
    percentage_total_month INT,
    monthly_total_sales INT
);
CREATE TABLE if not exists LOCATION_TABLE
(
    location_id serial primary key,
    item_id INT NOT NULL,
    item_available_quantity INT,
    date_time_in DATE NOT NULL,
    current_date_time DATE NOT NULL
);
CREATE TABLE if not exists CUSTOMER
(
    name varchar,
    customer_email varchar(200),
    phone varchar (100) not null,
    total_purchases INT,
    recent_purchases INT
)
