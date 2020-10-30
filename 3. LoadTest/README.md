This file describes Load testing that was carried out

Sample site chosen for testing: https://www.phptravels.net/home


Reports for single user hitting home page:
singleUserSummaryReport.csv
singleUserAggregateReport.csv


Reports for 1000 users hitting home page in 15sec ramp up time:
loadtestSummaryReport.csv
loadtestAggregateReport.csv


a) Explain the test in details
Test was carried out using Apache Jmeter tool.
Test file: LoadTest.jmx
1000 concurrent users are hitting the home page with a rampup time of 15sec
Reports were taken for single user and 1000 users

b) Did the load test have an impact on web application response time?
Yes. The respone time for single user was ~1.3sec
For 1000 users, the avg response time is ~1.6sec along with a std deviation of ~1.75sec
And some users also get ~16.4sec as response time which would be unacceptable

c) What is the optimal application response time for modern day web applications?
Ideal response time would be <=1sec
Optimal would be 1sec to 3sec

d) Analyze few HTTP/S responses
With 1000 users, some HTTP requests failed. Per the report, about 13% failed with error:
Response code:503
Response message:Service Unavailable

"The server is temporarily busy, try again later!"

