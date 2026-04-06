You are buidling a loggin server system: 
- A client sends messages to a server
- The server writes messages to a file (log.txt)
- The server sends back a confirmation response

Client → (Socket) → Server → (FileWriter) → log.txt← confirmation


Server Requirements: 
- Listen on port 1234
- Accept one client connection
- Read incoming messages line-by-line
- Append messages to a file: log.txt
- Send acknowledgment: "Message received"

Client Requirements: 
- Connect to server (localhost:1234)
- Read input from user (console)
- Send messages to server
- Print server response


Test: 
1. Run Server 
2. Run Client
3. Logging message
4. Verify that the message is in the log.txt

Expected output (console): 
Server started...
Client connected
Received: Hello
Received: This is a test

Expected log.txt record: 
Hello
This is a test
Logging message


