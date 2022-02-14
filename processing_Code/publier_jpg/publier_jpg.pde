import http.requests.*;
import processing.serial.*;
String val;
Serial myPort;
PostRequest post;
void setup(){
  String portName = Serial.list()[0];
  myPort = new Serial(this, portName, 9600);
 print(myPort.available() > 0);

}
void draw() {

if(myPort.available() > 0)
{
     val=myPort.readString();
         print(val);
          post=new PostRequest ("http://localhost:8081/findPassenger/"+val);

     post.send();
    String  rep=  post.getContent();
    if(rep.equals("true")==true)
    myPort.write('H'); 
    else
    myPort.write('L'); 
     delay(100);
}
}
