# 🚗 Peer-to-Peer Automobile Rental Service

## Project Title
**Decentralized Vehicle Rental Marketplace with Advanced Transactional Integrity and User Segmentation**

---

## 🎯 TLDR (Too Long; Didn't Read)

This project is a complete, full-stack application mirroring the architecture of a peer-to-peer (P2P) marketplace, specifically for car rentals. It allows users to both **rent cars** and **list their own vehicles for rent**. The system is defined by a **robust, relational database structure** and complex business logic, ensuring secure transactions, accurate inventory management, and personalized user experiences by preventing users from viewing or renting their own listed cars.

---

## ✨ Key Business Logic & Technical Achievements

This system goes beyond a basic application by implementing sophisticated marketplace features and complex business rules:

1.  **P2P Ownership Conflict Prevention (Core Feature):**
    * The market view implements a crucial filtering query: when a user browses for available cars, the system compares the **Renter's User ID** against the **Vehicle Owner's User ID** for every listing.
    * Any vehicle owned by the active user is dynamically **excluded** from the marketplace listings, preventing the user from accidentally or intentionally renting their own asset.

2.  **Comprehensive Status Tracking & Auditing:**
    * The system utilizes a transactional approach to track every state change for cars, rentals, and payments, ensuring data consistency and reliability for financial and inventory reporting.
    * It manages granular status flows (e.g., `Car Status`: Available, Booked, In-Service; `Rental Status`: Pending, Confirmed, Completed, Canceled).

3.  **Database Integrity & Logging:**
    * Built on a robust relational database (e.g., PostgreSQL/MySQL), every change, from car listing updates to payment settlement, is logged to maintain a complete audit trail and simplify change tracking.

4.  **Modular Architecture (MVC):**
    * The application is strictly separated into modular components, using the **Controller** pattern within each domain folder, ensuring code separation, scalability, and high maintainability.

---

## ⚙️ Project Architecture & Structure

The repository utilizes a modular, domain-driven design where each major business entity has its own dedicated directory containing its complete logic stack (Model, View, and Controller).

| Directory | Module Name | Key Responsibilities (Controller Logic) |
| :--- | :--- | :--- |
| **`car/`** | **Car Inventory** | Handling vehicle creation, viewing listings, inventory status changes (e.g., toggling availability), and applying the **Owner Exclusion Filter** for the marketplace view. |
| **`payment/`** | **Payment Gateway** | Manages payment initiation, transaction logging, status updates (e.g., from `Pending` to `Paid`), and integration with external payment APIs. |
| **`rent/`** | **Rental Agreement** | Manages the full rental lifecycle: booking, confirmation, contract generation, and enforcing date/time validation. This is where the core P2P logic resides. |
| **`user/`** | **User Management** | Handles user registration, authentication, profile management, and ownership linkage for listed vehicles. |
| **`database/`** | **Data Migration/Setup** | Contains all necessary SQL scripts or ORM migration files for initial database setup and schema management. |

---

## 💾 Database Design Focus

The system relies on a well-normalized database structure to handle the P2P complexity. The core tables are designed to maintain integrity across all transactions.

* **`Car`:** Stores vehicle details and links directly to a `User` (the Owner).
* **`RentalAgreement`:** Links a **Renter** (`user_id`) to a **Car** (`car_id`), where the system validates that `Renter.user_id != Car.owner_id`.
* **`PaymentTransaction`:** Tracks the financial history for every rental agreement.

*(Note: If applicable, reference the `c_favContact` schema or other specific tables to show data modeling knowledge.)*

---

## 💻 Installation and Setup

**(Customize these steps based on your actual technology stack, e.g., NodeJS, Python/Django, Java/Spring, etc.)**

1.  **Clone the Repository:**
    ```bash
    git clone [YOUR-REPO-URL]
    cd automobilrental service
    ```
2.  **Environment Setup:**
    * Install required dependencies (e.g., Node modules, Python packages).
    * Create a `.env` file for database credentials and API keys.
3.  **Database Migration:**
    * Set up your SQL database (e.g., PostgreSQL).
    * Run the migration scripts to initialize the schema:
        ```bash
        # Example command
        npm run migrate 
        # OR
        python manage.py makemigrations 
        ```
4.  **Run the Application:**
    ```bash
    # Example command
    npm start 
    # OR
    python app.py
    ```
