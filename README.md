# Zhunisov Gabit Student API - Documentation

Student: Zhunisov Gabit
Course: DevOps

This project will contain a Spring Boot Student CRUD API
with PostgreSQL, Docker Compose and a Jenkins pipeline.

Linux system report:
scripts/Zhunisov_Gabit_system_report.sh

## CRUD feature — Zhunisov Gabit

Implemented student creation, listing, lookup by ID, update and deletion.
Student input is validated. Missing students return HTTP 404.
GET /api/info displays the application name, author and version.
