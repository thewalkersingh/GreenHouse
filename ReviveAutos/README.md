# Autovice

1. Autovice is an application designed for showcasing pre-owned bikes, allowing customers to book test rides and 
schedule bike services. 
2. This app simplifies the process for bike enthusiasts and owners who want to buy, test, or service pre-owned bikes.

## Features
- Browse Second-Hand Bikes: View a detailed list of pre-owned bikes with essential specifications, price, and mileage.
- Book a Test Ride: Easily schedule a test ride for any bike listed, with options for location and preferred time.
- Bike Service Booking: Schedule bike service appointments, select service options, and get status updates.
- Service Status Tracking: Track your bike's service progress until it’s ready for pick-up.

### Getting Started
#### Prerequisites
Ensure you have the following installed:
- Java (JDK 11+)
- Spring Boot
- Maven
- MySQL or MongoDB (depending on your preferred database)

#### Installation
1. Clone the Repository:
`git clone https://github.com/thewalkersingh/Autovise`
<br/>cd autovice
2. Install Dependencies: Use Maven to install project dependencies:
`mvn install`

3. Set Up the Database:
   - Configure either MySQL or MongoDB.
   - Update `application.properties` or ``application.yml with your database credentials.

4. Run the Application:
`mvn spring-boot:run`

### Future Enhancements
- User Features: Adding notifications, bike evaluation, and financing options.
- Expanded Service Options: Add detailed service histories, booking management, and automated reminders for upcoming 
services.