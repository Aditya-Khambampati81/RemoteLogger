# RemoteLogger
Remote logger stores your logs to GBQ data set , request you to generate your own , Project JSON file and replace in assets. 
Please note that is it good practice to create different data sets in GBQ and rotating logs so that your bill is not inflated..
Use this code as boiler plate for doing same 


App - Sample app that shows how to use the library.

Log - Logger library 

Place your custom JSON file from Google console 
https://github.com/Aditya-Khambampati81/RemoteLogger/tree/master/RemoteLogger/app/src/main/assets

How to get the same is given here. ..
https://console.cloud.google.com
Create a service accout credentials to access GBQ data sets

Google provided a client library for Andorid / iOS , you can easily include the same 
 in ur gradle file 
 
     compile group: 'com.google.cloud', name: 'google-cloud-bigquery', version: '0.20.1-beta'








