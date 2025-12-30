# Used Car Estimator 🚗💰
A Spring Boot web application that estimates the value of used cars based on brand quality, mileage, accident severity, and model year.

The project was created by the students:
-Azzam Saeed Alghamdi
-Rami Jameel Aleili
-Alwaleed Mohammed Alhalafi

Under the supervision of Dr. Khalid Alharbi
---

## 📌 Overview
The Used Car Estimator is a simple yet effective tool that allows users to input details about their car and instantly receive an estimated price range.
The system applies realistic depreciation formulas, brand-quality multipliers, and accident-impact rules to generate accurate estimates.

The project implements **Factory Method** and **Strategy Pattern**, ensuring scalable and maintainable design.

---

## 🎯 Features
### 🔐 User Login
- Simple login page (username: `admin`, password: `1234`).
- Prevents unauthorized access.

### 🚘 Car Details Form
- Dynamic brand list
- Dynamic model list loaded using internal API
- Option for “Other” brand/model
- Inputs for:
  - Brand
  - Model
  - Year
  - Mileage
  - Accident Severity

### 📊 Price Estimation
The system computes the final estimated value based on:
- Brand quality (Toyota/Honda/Mercedes > Kia/Hyundai/etc.)
- Mileage impact
- Accident severity
- Depreciation by age
- Produces a **price range**: Min → Max
- Clean, modern UI with background images and animations.

### 🌐 Modern UI
- Fully redesigned professional pages:
  - Welcome Page
  - Login Page
  - Car Form
  - Result Page
- Each page uses a custom background image
- Smooth animations and clean visuals

---

## 🏗️ Architecture & Design Patterns
### ✔️ Factory Pattern
Used in `CarFactory` to create car objects dynamically based on user input.

### ✔️ Strategy Pattern
Price calculation logic is implemented using `PriceStrategy` and `DefaultPriceStrategy`.

This makes the pricing logic flexible and extensible.