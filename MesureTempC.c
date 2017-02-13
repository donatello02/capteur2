#include "Timer.h"
#include "MesureTemp.h"


module TestSerialC {
  uses {
    interface SplitControl as Control;
    interface Leds;
    interface Boot;
    interface Receive as AMReceive;
    interface AMSend as AMSend;
    interface Timer<TMilli> as MilliTimer;
    interface Packet;
    interface Read<u_int16_t> as TempRead;
    
    
    interface Receive as RadioReceive;
    interface AMSend as RadioAMSend;
    interface Packet as RadioPacket;
    interface SplitControl as RadioControl;
  }
}
implementation {

  message_t packet;
  message_t packet_radio;
  
  bool locked = FALSE;
  bool locked_radio = FALSE;

  event void Boot.booted()
  {
	  call Control.start();
	  call RadioControl.start();
  }

  event void MilliTimer.fired() {
  
	  call TempRead.read();
  }


  event void Control.startDone(error_t err) {
	  if (err == SUCCESS) {
		  call MilliTimer.startPeriodic(1000);
	  }
  }
  event void Control.stopDone(error_t err) {}

  event void RadioControl.startDone(error_t err) {
	  if (err == SUCCESS) {
		  call MilliTimer.startPeriodic(1000);
	  }
  }
  event void RadioControl.stopDone(error_t err) {}

  
  event void TempRead.readDone(error_t result, uint16_t data) {
	  if (locked_radio) {
		  return;
	  }
	  else {
		  mesure_temp_msg_t* rsm;
		  
		  rsm = ( mesure_temp_msg_t*)call RadioPacket.getPayload(&packet_radio, sizeof( mesure_temp_msg_t));
		  if (rsm == NULL) {
			  return;
		  }
		  if (call Packet.maxPayloadLength() < sizeof( mesure_temp_msg_t)) {
			  return;
		  }
		  data = -39.6 +0.01 * data;
		  rsm->data = data;
		  rsm->dest_id = 0;
		  rsm->src_id = TOS_NODE_ID;
		  
		  if (call RadioAMSend.send(AM_BROADCAST_ADDR, &packet_radio, sizeof( mesure_temp_msg_t)) == SUCCESS) {
			  locked_radio = TRUE;
			  
		  } 
	  }
  }
  
  event void AMSend.sendDone(message_t* bufPtr, error_t error) {
	  if (&packet == bufPtr) {
		  locked = FALSE;
	  }
  }

   event message_t* Receive.receive(message_t* bufPtr, 
				    void* payload, uint8_t len) {
	   if (len != sizeof(mesure_temp_msg_t)) {return bufPtr;}
	   else {
		   mesure_temp_msg_t* rcm = (mesure_temp_msg_t*)payload;
		   call Leds.led0On();		  
		   return bufPtr;
	   }
   }

  event void RadioAMSend.sendDone(message_t* bufPtr, error_t error) {
	  if (&packet_radio == bufPtr) {
		  locked_radio = FALSE;
	  }
  }
  
  event message_t* RadioReceive.receive(message_t* bufPtr, void* payload, uint8_t len){
	  if(len != sizeof(mesure_temp_msg_t)){return bufPtr;}
	  else{
		  mesure_temp_msg_t* rsmReceived = (mesure_temp_msg_t*)payload;
		  if (locked) {
			  return;
		  }
		  else {
			  mesure_temp_msg_t* rsm = (mesure_temp_msg_t*)call Packet.getPayload(&packet, sizeof(mesure_temp_msg_t));
			  if (rcm == NULL) {return;}
			  if (call Packet.maxPayloadLength() < sizeof(mesure_temp_msg_t)) {
				  return;
			  }
			  
			  rsm->data = rsmReceived->data;
			  rsm->src_id = rsmReceived->src_id;
			  rsm->dest_id= rsmReceived->dest_id;
			  if (call AMSend.send(AM_BROADCAST_ADDR, &packet, sizeof(test_serial_msg_t)) == SUCCESS) {
				  locked = TRUE;
			  }
		  }
		  return bufPtr;
	  }
  }
  

}
