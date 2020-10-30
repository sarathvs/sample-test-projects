This file describes REST API testing

Sample site chosen for testing: spatial-stream.p.rapidapi.com
Supports POST and GET operations

Tests are written in Apache jmeter tool. They can be run via Jmeter UI or in command line as:
jmeter.bat -n -t .\RESTAPITesting.jmx -l .\RESTAPITesting.log -e -o .\htmlreport

HTML report is at:
.\htmlreport\index.html

CSV report from UI run is at:
.\output.csv