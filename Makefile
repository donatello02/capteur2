COMPONENT=MesureTempAppC
BUILD_EXTRA_DEPS += MesureTempSerial.class
CLEAN_EXTRA = *.class MesureTempMsg.java
CC2420_CHANNEL=15
PFLAGS += -I$(TOSDIR)/lib/printf
CFLAGS += -I$(TOSDIR)/lib/T2Hack

MesureTempSerial.class: $(wildcard *.java) MesureTempMsg.java
	javac -target 1.4 -source 1.4 *.java

MesureTempMsg.java:
	mig java -target=null $(CFLAGS) -java-classname=MesureTempMsg MesureTemp.h mesure_temp_msg -o $@


include $(MAKERULES)

