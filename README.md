# Zhunisov Gabit Student API - Main and Documentation
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

## Automatic CI — Zhunisov Gabit
Jenkins checks this branch every minute using Poll SCM.
New commits automatically trigger Build, Test, Docker Build and Verify.
CI builds and tests changes. CD extends this to delivery or deployment.
Automatic trigger verification for Zhunisov Gabit.
