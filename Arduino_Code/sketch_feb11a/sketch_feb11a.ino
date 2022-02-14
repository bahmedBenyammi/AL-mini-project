
int val=12355;


void setup() {
    pinMode(LED_BUILTIN, OUTPUT);  
  Serial.begin(9600);   
  Serial.print(val); 

}

void loop() {
  // put your main code here, to run repeatedly:

 if(Serial.available()) { // If data is available to read,
 val = Serial.read(); // read it and store it in val
 
 if (val == 'H') { // If H was received
 digitalWrite(LED_BUILTIN, HIGH);
 delay(3000);
  digitalWrite(LED_BUILTIN, LOW);

 } else {
 digitalWrite(LED_BUILTIN, HIGH);
  delay(1000);
   digitalWrite(LED_BUILTIN, LOW);
    delay(500);
    digitalWrite(LED_BUILTIN, HIGH);
  delay(1000);
   digitalWrite(LED_BUILTIN, LOW);

 }
 }
}
