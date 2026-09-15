# QMart

## Smart Market Management and Billing System

QMart is a smart market management and billing system developed using **Java Spring Boot, MySQL, HTML, CSS, and JavaScript**.

The system helps market managers and shop owners manage shops, products, customers, billing, and transaction statistics. It also provides QR-based temporary customer identification and email-based invoice delivery.

---

## Features

### Manager Module

- Manager registration and login
- View registered shop owners
- Approve or manage shop owner status
- Register temporary customers
- Generate unique customer ID
- Generate customer QR code
- Send customer QR code through email
- Scan customer QR code
- Close customer after shopping
- Send complete customer invoice through email
- View shop transaction statistics
- Reset shop transaction statistics

### Shop Owner Module

- Shop owner registration and login
- Manage products
- Add products
- Add multiple products
- Update product price
- Update product stock
- Delete products
- View available product quantity

### Customer / Shopping Module

- Scan or enter customer ID
- View shop products
- Select product quantity
- Add products to cart
- Generate invoice
- Purchase products
- Automatically reduce product stock after purchase
- Send invoice through email

---

## Technologies Used

### Backend

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- JavaMailSender
- ZXing QR Code Library

### Frontend

- HTML
- CSS
- JavaScript
- Fetch API

---

## Project Structure


QMart
│
├── frontend
│   ├── index.html
│   ├── auth.html
│   ├── register.html
│   ├── manager.html
│   ├── shopowner.html
│   ├── shopownermanagement.html
│   ├── productmanagement.html
│   ├── shopproducts.html
│   ├── customermanagement.html
│   ├── closecustomer.html
│   └── shopstatistics.html
│
├── src
│   └── main
│       └── java
│           └── com.example.QMart
│
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── .gitattributes

Main Workflow

Manager
   |
   ├── Manage Shop Owners
   |
   ├── Register Customer
   |       |
   |       ├── Generate Customer ID
   |       ├── Generate QR Code
   |       └── Send QR through Email
   |
   └── Close Customer
           |
           ├── Enter Customer ID
           |       OR
           └── Scan QR Code
                   |
                   └── Send Complete Invoice

Shopping Flow

Customer QR
     ↓
Shop Owner scans / enters Customer ID
     ↓
View Products
     ↓
Select Quantity
     ↓
Add to Cart
     ↓
Place Order
     ↓
Store Purchased Items
     ↓
Reduce Product Stock
     ↓
Update Shop Transaction
     ↓
Send Invoice
     ↓
Customer exits market
     ↓
Manager closes Customer


DataBase
The project uses MySQL as the database.

Main entities include:

Manager
Shop Owner
Shop
Products
Customer
Purchased Items
QR Code System

QMart generates a unique 6-digit customer ID for temporary customers.

The customer ID is encoded into a QR code using the ZXing library.

The QR code is then sent to the customer's email and can later be scanned at the market.

Email System

QMart uses Gmail SMTP to send:

Customer QR codes
Individual shop invoices
Complete customer invoices

Email credentials are configured using environment variables and are not stored directly in the source code.

Example:

spring.mail.username=${MAIL_USERNAME}
spring.mail.password=${MAIL_PASSWORD}
How to Run
Backend
Clone the repository.
Open the project in IntelliJ IDEA or another Java IDE.
Configure MySQL.
Configure the required database properties.
Set the following environment variables:
MAIL_USERNAME
MAIL_PASSWORD
Run:
QMartApplication.java

The Spring Boot backend runs on:

http://localhost:8080
Frontend

Open the frontend folder using a local web server such as VS Code Live Server.

The frontend runs on:

http://127.0.0.1:5500
Version
QMart V1.0

Current version includes:

Authentication
Manager management
Shop owner management
Product management
Customer registration
QR generation
QR scanning
Email integration
Shopping cart
Billing
Stock management
Shop transaction statistics
Future Improvements

Possible future versions can include:

Improved authentication and authorization
Password encryption
Better invoice PDF generation
Advanced sales reports
Daily/monthly transaction history
Improved database relationships
Payment integration
Better UI/UX
Deployment to a cloud server
Production-level security
Author

Haries Mugunthan G

Computer Science Engineering Student


