#include "MesureTemp.h"

configuration TestSerialAppC {}
implementation {
  components MesureTempSerialC as App, LedsC, MainC;
  components SerialActiveMessageC as AMSerial;
  components new TimerMilliC();
  components new SerialPrintfC;

  App.Boot -> MainC.Boot;
  App.Control -> AMSerial;
  App.AMReceive -> AMSerial.Receive[AM_TEST_SERIAL_MSG];
  App.AMSend -> AMSerial.AMSend[AM_TEST_SERIAL_MSG];
  App.Leds -> LedsC;
  App.MilliTimer -> TimerMilliC;
  App.Packet -> AMSerial;
  
  components ActiveMessageC;
  components new AMSenderC(AM_TEST_SERIAL_MSG);
  components new AMReceiverC(AM_TEST_SERIAL_MSG);
  
  
  App.RadioReceive -> AMReceiverC;
  App.RadioAMSend -> AMSenderC;
  App.RadioControl -> ActiveMessageC;
  App.RadioPacket -> AMSenderC;

  components new SensirionSht11C() as TempRead;
  App.TempRead -> TempRead.Temperature;
}


