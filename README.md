# 🛒 Clothing E-commerce

**Status:** Backend Architecture | Frontend Development | Database

A full-stack e-commerce platform focused on the fashion industry, developed with a scalable architecture approach.

The project combines a **Spring Boot backend** and an **Angular frontend** in the same repository, focusing on clean architecture, maintainable code, and real-world application patterns.

---

# 🏗️ System Architecture

The backend follows **Hexagonal Architecture (Ports & Adapters)** principles, aiming to keep business rules independent from external technologies.

## Main Components

### Domain (Core)

Contains:

* Business entities
* Domain rules
* Application logic
* State transitions

### Input Adapters

Responsible for receiving external requests:

* REST Controllers
* API endpoints

### Output Adapters

Responsible for external communication:

* Database repositories
* Third-party integrations

---

# 🖥️ Frontend

The frontend is developed with **Angular**, following modern development practices.

## Technologies

* Angular
* TypeScript
* SCSS
* HTML

## Main Concepts Applied

* Standalone Components
* Component-based architecture
* Lazy Loading
* Change Detection optimization
* Responsive design
* Reusable UI components

## Current Frontend Structure

The interface includes:

* Home page
* Navigation toolbar
* Hero banner
* Category section
* Promotional section
* Footer
* Responsive layouts

The frontend is prepared for future API integration with the Spring Boot backend.

---

# 🔒 Authentication & Authorization

The backend implements authentication and authorization using:

* JWT authentication
* Refresh Token flow
* Role-Based Access Control (RBAC)

## Roles

Main user roles:

* SELLER
* CLIENT

Permissions are managed dynamically through database relationships.

Example:

```
users
roles
permissions
user_roles
role_permissions
```

---

# 💳 Payment Flow

The project includes payment integration with Mercado Pago.

The system uses asynchronous payment confirmation through webhooks.

## Flow

```
Order Created
      |
      v
Pending Status
      |
      v
Payment Checkout
      |
      v
Mercado Pago Webhook
      |
      v
Order Status Update
```

## Order Lifecycle

```
PENDING
   |
CONFIRMED
   |
PROCESSING
   |
SHIPPED
   |
DELIVERED
```

Alternative flow:

```
CANCELED
```

---

# 🗄️ Database

The project uses PostgreSQL.

Main entities:

| Table       | Purpose                                |
| ----------- | -------------------------------------- |
| users       | User authentication and identification |
| roles       | Access control roles                   |
| permissions | Dynamic system permissions             |
| products    | Product management                     |
| stock       | Inventory control                      |
| orders      | Customer orders                        |

---

# 🚀 Current Features

## Backend

* REST API
* JWT Authentication
* Refresh Token
* Dynamic permissions
* Product management
* Order management
* Mercado Pago integration
* PostgreSQL database

## Frontend

* Responsive e-commerce interface
* Component architecture
* Reusable UI components
* Category display
* Promotional sections
* Layout structure

---

# 🤝 Contribution

This project is under continuous development.

To contribute:

1. Fork the repository

2. Create a feature branch

```bash
git checkout -b feature/NewFeature
```

3. Commit your changes

```bash
git commit -m "Add: feature description"
```

4. Push your branch

```bash
git push origin feature/NewFeature
```

5. Open a Pull Request
