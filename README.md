# CICD-1 Coding Test — Review, Improve and Reflect

**G00470984:**  
**Examination group:** A (Room Booking / JPQL):  
**Original examination pull-request URL (`exam-work`): https://github.com/deira-v/470984/pulls**  
**New review repository URL: https://github.com/deira-v/CICD1_Review_470984**  

## 1. My original examination self-assessment

Review the code **as submitted in the original examination**. Do not change the original repository, branch or pull request. Check your own Group A or Group B examination paper and award marks only for evidence present in the original submission.

### Task 1 — /40
**My mark: 25 / 40**  
**Evidence from the original code (files, methods, working or missing requirements):**  
Created booking model storing variables for RoomId, organizer name, status and attendee count(should have been an int not a bigDecimal); missing status.  
Correctly used SpringBoot annotation and field validation for variables, getters and setters.  
Only request DTO class created, storing variables for Room instead of Booking.  
Return of Jpa Entity instead of DTO.

### Task 2 — /40
**My mark: 10 / 40**  
**Evidence from the original code:**
Only one POST created not fully working.  
No need for RoomController and RoomService Classes.  
Right approach of Constructor Dependency Injection in Booking Service.  
Not converting entities into RequestDTO and not throwing errors for invalid requests.  
In BookingController correct injection of BookingService; Validation missing and request of a JPA Entity rather than a DTO.  



### Task 3 — /20
**My mark: 0 / 20**  
**Evidence from the original code:**  
No JPQL search.

**Total self-assessed original examination mark: 35 / 100**

**Checkpoint:** Commit this completed self-assessment as the **first review commit in your new repository**, before you modify or add application code. The lecturer decides the official original examination mark.

## 2. Corrections and improvements in my new project

Start from a **fresh copy of the starter template for your own exam group**, in a **new GitHub repository**. You may consult or selectively reuse your own original examination code, but the new project must demonstrate that you understand and can correct it. Do not change your original examination submission.

Describe **two or three important problems** in your original code. For each, explain what was wrong, which class or method you changed in the new project, and why the corrected approach works.

**Problem and correction 1:**  
Missing ResponseDTO and RequestDTO not fully implemented.  
The old version of the exam was missing Validation in the RequestDTO class and had no ResponseDTO class.  
The new approach works because data can be securely transferred between layers without being exposed.  

**Problem and correction 2:**  
Wrong approach to Get and Post.
Trying to save booking without checking room capacity.

**Problem and correction 3 (optional):**  

## 3. API testing and evidence

Use Swagger UI or another HTTP client. For **at least four meaningful checks**, record the request/input, expected result, actual HTTP status/response, and pass/fail. Include unsuccessful cases; a running application alone is not enough.

**Test 1 — successful booking request:**  
- Request / input:  
{
  "organizerName": "Deira",
  "attendeeCount": 10,
  "roomId": 1
  }
- Expected: 201
- Actual HTTP status / body: 201  
{
"attendeeCount": 10,
"id": 3,
"organizerName": "Deira",
"roomId": 1,
"roomName": "Lab 201",
"status": "ACTIVE"
}
- Pass / fail: pass  

**Test 2 — invalid input or excessive attendee count:**  
- Request / input:  
  {
  "organizerName": "Deira",
  "attendeeCount": 30,
  "roomId": 1
  }
- Expected: 400
- Actual HTTP status / body: 400 Bad Request
- Pass / fail:  fail

**Test 3 — missing booking or room:**  
- Request / input: look for booking Id 5
- Expected: 404
- Actual HTTP status / body: 404 Not Found  
- Pass / fail: fail

**Test 4 — requirement specific to my group:**  
- Request / input:  
- Expected:  
- Actual HTTP status / body:  
- Pass / fail:  

**Group A:** Demonstrate `GET /api/bookings/search?roomName=...` using an exact room name, bookings ordered by attendee count descending, and an empty list for no matches. Add checks if necessary to show all three behaviours.

**Group B:** Run the **provided** Room Service separately on port 8082 and the **new** Booking Service on port 8081. Demonstrate that booking creation obtains room details through OpenFeign and that booking retrieval uses the local Booking database. Do not modify the Room Service.

## 4. Reflection

**What did I understand during the examination but struggle to implement?**  
The JPA ManyToOne relationship

**Which Spring Boot, JPA, validation, JPQL or OpenFeign concept became clearer after correcting my code? Give a specific example.**  
The DTO separation concept.  

**What will I do differently in my next coding test or API development task?**  
Review Labs and ask for clarifications during lab time if something isn't clear to me.

## Review lab assessment — 20 marks

- Honest original self-assessment with code evidence: **3 marks**
- Explanation of mistakes and Spring Boot concepts: **4 marks**
- Corrections in the new application: **4 marks**
- API testing and demonstration of understanding: **3 marks**
- Reflection and future improvement: **1 marks**

**Total: 15 marks.** Simply submitting a working solution does not demonstrate the learning required by this review.

## Proposed mark recovery — only if confirmed for CICD-1

If the same approach as OOP is adopted, the review could recover **up to 30% of marks lost** in the original examination, scaled by the review-lab mark.

**Marks recovered = (100 − official original exam mark) × 0.30 × (review lab mark ÷ 20)**

Example: exam **40/100** and review **16/20** → **14.4 recovered marks**, revised exam **54.4/100**. This is **not an approved CICD-1 policy unless confirmed by the lecturer**. The original official exam mark—not your self-awarded grade—is used in the calculation.

## Submission

Commit and push the **new review repository** with the completed README, corrected Spring Boot code and API-test evidence. Submit its GitHub URL on Moodle. **Do not push any changes to the original examination repository or `exam-work` pull request.**
