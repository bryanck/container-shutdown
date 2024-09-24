
## Test shutdown hang
Run:
`./gradlew clean build`

Test should hang for a while on shutdown, using Spring 2.7.18 and Testcontainers 1.20.1.

Change Testcontainers to v1.19.1, and rerun. Test shouldn't hang.

Change Testcontainers back to v1.20.1, and Spring to 3.3.4. Test shouldn't hang.
