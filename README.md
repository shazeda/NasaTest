**API Endpoint:** GET https://api.nasa.gov/planetary/sounds

**Parameters:**
* q
    * Type: string
    * Default: None
    * Description: Search text to filter results

* limit
    * Type: int
    * Default: 10
    * Description: number of tracks to return

* api_key
    * Type: string
    * Default: DEMO_KEY
    * Description: api.nasa.gov key for expanded usage

**Test Cases:**

```
Test Case ID 1
Test Case: Test with “moon” and limit to 5
Request: GET https://api.nasa.gov/planetary/sounds?q=moon&limit=5&api_key=DEMO_KEY
Expected Status: 200 OK
Expected Response: 5 or less sound results that matches “moon”

Test Case ID 2
Test Case: Test with “moon” and limit to 50
Request: GET https://api.nasa.gov/planetary/sounds?q=moon&limit=50&api_key=DEMO_KEY
Expected Status: 200 OK
Expected Response: 50 or less sound results that matches “moon”

Test Case ID 3
Test Case: Test without API Key
Request: GET https://api.nasa.gov/planetary/sounds?q=moon&limit=50
Expected Status: 403 Forbidden
Expected Response: Error code and message

Test Case ID 4
Test Case: Test with “mars”
Request: GET https://api.nasa.gov/planetary/sounds?q=mars&limit=5&api_key=DEMO_KEY
Expected Status: 200 OK
Expected Response: 5 or less sound results that matches “mars”

Test Case ID 5
Test Case: Test without any q parameter
Request: GET https://api.nasa.gov/planetary/sounds?limit=5&api_key=DEMO_KEY
Expected Status: 200 OK
Expected Response: 5 sound results

Test Case ID 6
Test Case: Test default limit
Request: GET https://api.nasa.gov/planetary/sounds?api_key=DEMO_KEY
Expected Status: 200 OK
Expected Response: 10 results

```



