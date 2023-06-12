# PIIM
Platform for Interactive and Immersive Media
Users 
- must have first name, last name, username, email, password, role, isEnabled, isLocked, profile photo, uuid-primary key
- roles user / admin 

Games
- must have name, category, release date, publisher, reviews, system requirements

Reviews
- must have score, text, date & time, user

-- system requirements - OS/CPU/GPU/RAM
-- category - name
-- role - name ENUM 
-- passwordResetToken - validity, uuid

JWT access token + refresh token for authentication

Services:
-BE to FE service - mobile screen
-Game and review management
-User service - authorization and user management

Current task:
CRUD games operations + categories + system requirements
-reviews 
-users to be basic
