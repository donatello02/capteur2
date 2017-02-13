#include "MesureTemp.h"

configuration MesureTempAppC {}
implementation {
  components MesureTempC as App,  LedsC, MainC;
  components SerialActiveMessageC as AMSerial;
  components new TimerMilliC();
  components SerialPrintfC;

  App.Boot -> MainC.Boot;
  App.Control -> AMSerial;
  App.AMReceive -> AMSerial.Receive[AM_MESURE_TEMP_MSG];
  App.AMSend -> AMSerial.AMSend[AM_MESURE_TEMP_MSG];
  App.Leds -> LedsC;
  App.MilliTimer -> TimerMilliC;
  App.Packet -> AMSerial;
  
  components ActiveMessageC;
  components new AMSenderC(AM_MESURE_TEMP_MSG);
  components new AMReceiverC(AM_MESURE_TEMP_MSG);
  
  
  App.RadioReceive -> AMReceiverC;
  App.RadioAMSend -> AMSenderC;
  App.RadioControl -> ActiveMessageC;
  App.RadioPacket -> AMSenderC;

  components new SensirionSht11C() as TempRead;
  App.TempRead -> TempRead.Temperature;
}


