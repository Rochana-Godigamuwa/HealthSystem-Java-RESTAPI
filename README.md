# HealthSystem-Java-RESTAPI

A RESTful hospital/clinic management backend built with **Jakarta EE 8** and **JAX-RS (Jersey)**. It exposes a set of CRUD APIs for managing patients, doctors, appointments, prescriptions, billing, and medical records — the core entities of a small health system.

## Overview

HealthSystem is a Maven-based Java web application (packaged as a `.war`) that models a hospital's day-to-day data: who the patients and doctors are, when appointments are scheduled, what's been prescribed, what a patient's medical history looks like, and what they owe in billing. Each entity is exposed through its own REST resource with full Create, Read, Update, and Delete support, returning and accepting JSON.

It's built as a clean example of a layered JAX-RS backend — resources talk to DAOs, DAOs manage the data — without any framework magic obscuring how the pieces fit together.

## Features

- **Patient management** — track patient contact details, medical history, and current health status
- **Doctor management** — track doctor specialization and contact details
- **Appointment scheduling** — link a patient and doctor to a date/time
- **Prescriptions** — dosage, instructions, and duration tied to a patient and doctor
- **Medical records** — diagnoses and treatments per patient
- **Billing** — payments and outstanding balances per patient
- Full REST CRUD (`GET`, `POST`, `PUT`, `DELETE`) for every entity
- JSON request/response bodies via Jersey's Jackson integration
- Built-in request logging for every operation (success and failure)

## Tech Stack

- **Java 8**
- **Jakarta/Java EE 8**
- **JAX-RS 2.x** via **Jersey** (`jersey-container-servlet`, `jersey-hk2`)
- **Jackson** for JSON (de)serialization (`jersey-media-json-jackson`)
- **Maven** for build and dependency management
- Packaged as a **WAR** for deployment to a servlet container / application server (e.g. GlassFish, Payara, Tomcat + Jersey)

## Architecture

The codebase follows a simple layered structure:

```
resources/   → JAX-RS endpoints (HTTP layer): request handling, status codes, logging
dao/         → Data access layer: in-memory CRUD logic
models/      → Plain Java objects (POJOs) representing entities
```

`Doctor` and `Patient` both extend a shared `Person` base class (id, name, contact info, address), since both are people with overlapping fields.

**Note on data storage:** Data is currently held in-memory in static `List` collections inside each DAO (e.g. `PatientDAO`, `DoctorDAO`), seeded with sample records at startup. There's no database wired up yet — `persistence.xml` is present but not yet connected to a JPA implementation. This means data resets whenever the app restarts. Swapping the DAOs for real JPA/database-backed implementations would be the natural next step for production use.

## API Endpoints

All endpoints are rooted under `/rest` (configured in `web.xml`). Base URL when running locally, for example: `http://localhost:8080/HealthSystem/rest`

| Resource | Method | Path | Description |
|---|---|---|---|
| Persons | GET | `/persons` | Get all persons |
| Persons | GET | `/persons/{id}` | Get person by ID |
| Persons | POST | `/persons` | Create a person |
| Persons | PUT | `/persons/{id}` | Update a person |
| Persons | DELETE | `/persons/{id}` | Delete a person |
| Patients | GET | `/patients` | Get all patients |
| Patients | GET | `/patients/{id}` | Get patient by ID |
| Patients | POST | `/patients` | Create a patient |
| Patients | PUT | `/patients/{id}` | Update a patient |
| Patients | DELETE | `/patients/{id}` | Delete a patient |
| Doctors | GET | `/doctors` | Get all doctors |
| Doctors | GET | `/doctors/{id}` | Get doctor by ID |
| Doctors | POST | `/doctors` | Create a doctor |
| Doctors | PUT | `/doctors/{id}` | Update a doctor |
| Doctors | DELETE | `/doctors/{id}` | Delete a doctor |
| Appointments | GET | `/appointments` | Get all appointments |
| Appointments | GET | `/appointments/{id}` | Get appointment by ID |
| Appointments | POST | `/appointments` | Create an appointment |
| Appointments | PUT | `/appointments/{id}` | Update an appointment |
| Appointments | DELETE | `/appointments/{id}` | Delete an appointment |
| Prescriptions | GET | `/prescriptions` | Get all prescriptions |
| Prescriptions | GET | `/prescriptions/{prescriptionId}` | Get prescription by ID |
| Prescriptions | POST | `/prescriptions` | Create a prescription |
| Prescriptions | PUT | `/prescriptions/{prescriptionId}` | Update a prescription |
| Prescriptions | DELETE | `/prescriptions/{prescriptionId}` | Delete a prescription |
| Medical Records | GET | `/medicalrecords` | Get all medical records |
| Medical Records | GET | `/medicalrecords/{medicalRecordId}` | Get medical record by ID |
| Medical Records | POST | `/medicalrecords` | Create a medical record |
| Medical Records | PUT | `/medicalrecords/{medicalRecordId}` | Update a medical record |
| Medical Records | DELETE | `/medicalrecords/{medicalRecordId}` | Delete a medical record |
| Billing | GET | `/billings` | Get all billing records |
| Billing | GET | `/billings/{billingId}` | Get billing record by ID |
| Billing | POST | `/billings` | Create a billing record |
| Billing | PUT | `/billings/{billingId}` | Update a billing record |
| Billing | DELETE | `/billings/{billingId}` | Delete a billing record |

## Getting Started

### Prerequisites

- JDK 8+
- Maven 3.x
- A Jakarta EE-compatible application server or servlet container (e.g. GlassFish, Payara)

### Build

```bash
mvn clean package
```

This produces `target/healthsystem-1.0-SNAPSHOT.war`.

### Run

Deploy the generated WAR file to your application server (e.g. drop it into GlassFish/Payara's `autodeploy` directory, or deploy through your server's admin console). Once deployed, the API will be available at:

```
http://localhost:8080/HealthSystem/rest/{resource}
```

For example:

```bash
curl http://localhost:8080/HealthSystem/rest/patients
```

### Sample Request

Create a new patient:

```bash
curl -X POST http://localhost:8080/HealthSystem/rest/patients \
  -H "Content-Type: application/json" \
  -d '{
        "id": 4,
        "name": "Jane Doe",
        "contactInfo": 771234567,
        "address": "12 Lake Road, Colombo",
        "medicalHistory": "No known allergies",
        "currentHealthStatus": "Stable"
      }'
```

## Project Structure

```
HealthSystem/
├── pom.xml
├── src/main/java/com/mycompany/healthsystem/
│   ├── JAXRSConfiguration.java     # JAX-RS application config
│   ├── dao/                        # In-memory data access objects
│   ├── models/                     # Entity POJOs
│   └── resources/                  # REST endpoints
├── src/main/resources/META-INF/
│   └── persistence.xml             # JPA persistence unit (not yet wired up)
└── src/main/webapp/
    ├── index.html
    └── WEB-INF/web.xml             # Servlet mapping (/rest/*)
```

## Possible Next Steps

- Wire up `persistence.xml` to a real database via JPA (e.g. H2, MySQL, PostgreSQL) so data persists across restarts
- Add input validation (e.g. Bean Validation annotations) on model fields
- Add authentication/authorization for protected endpoints
- Add a simple front-end to consume the API
- Add automated tests for the DAO and resource layers

## License

No license specified yet.
