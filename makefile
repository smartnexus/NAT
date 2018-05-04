###########################################################################################
#
#       makefile para la compilacion de la PFPOO de Fundamentos de Programacion II
#
#
# Este fichero makefile se proporciona para realizar la compilacion y ejecucion de la PFPOO.
# El makefile lo debe usar como referencia, y puede realizar los cambios necesarios
# para realizar la compilacion y prueba del codigo.
#
#  Existen varias opciones de compilacion con este makefile: 
#
#  -Tecleando: "make excepciones" en la linea de comandos, se compilan todas las excepciones.
#
#  -Tecleando: "make interfaces" en la linea de comandos, se compilan todas las interfaces.
#
#
# El makefile se ha hecho con el UVUS fp2. 
# Cada alumno debe sustituir fp2 por el UVUS del alumno en este makefile.
#
###########################################################################################

#JAVAC=/home/antonio/Desktop/jdk1.6.0_23/bin/javac
JAVAC=javac

#JAVA=/home/antonio/Desktop/jdk1.6.0_23/bin/java
JAVA=java

#JAR=/home/antonio/Desktop/jdk1.6.0_23/bin/jar
JAR=jar
	
OPCIONES= -Xlint -encoding ISO-8859-1 -classpath ./bin  -cp ./bin -d ./bin 	

clases: interfaces \
./bin/fp2/poo/utilidades/LecturaFicheroEntrada.class \
./bin/fp2/poo/pfpooangrodboh/Ist.class                     \
./bin/fp2/poo/pfpooangrodboh/Nat.class                     \
./bin/fp2/poo/pfpooangrodboh/Paquete.class                 \
./bin/fp2/poo/pfpooangrodboh/Puerto.class                  \
./bin/fp2/poo/pfpooangrodboh/Datos.class                  
		

excepciones: ./bin/fp2/poo/utilidades/Excepciones/OperacionNoPermitidaExcepcion.class \
             ./bin/fp2/poo/utilidades/Excepciones/PuertoIncorrectoExcepcion.class
	
interfaces: excepciones \
./bin/fp2/poo/utilidades/DatosInterfaz.class \
./bin/fp2/poo/utilidades/PuertoInterfaz.class \
./bin/fp2/poo/utilidades/PaqueteInterfaz.class \
./bin/fp2/poo/utilidades/NatInterfaz.class \
./bin/fp2/poo/utilidades/IstInterfaz.class

ejecuta: ./bin/fp2/poo/principal/Principal00.class	
	java -classpath ./bin:./jar -cp bin fp2.poo.principal.Principal00 prueba00 1.1.1.4


#####################################
# Principal00.java
#####################################
./bin/fp2/poo/principal/Principal00.class: \
                          ./src/fp2/poo/principal/Principal00.java\
                          ./bin/fp2/poo/pfpooangrodboh/Nat.class \
                          ./bin/fp2/poo/pfpooangrodboh/Paquete.class \
                          ./bin/fp2/poo/utilidades/Excepciones/OperacionNoPermitidaExcepcion.class						  
	$(JAVAC) $(OPCIONES) ./src/fp2/poo/principal/Principal00.java



#############################
# LecturaFicheroEntrada.java  
#############################   
./bin/fp2/poo/utilidades/LecturaFicheroEntrada.class:  \
               ./bin/fp2/poo/utilidades/Excepciones/OperacionNoPermitidaExcepcion.class \
               ./bin/fp2/poo/utilidades/PaqueteInterfaz.class \
               ./bin/fp2/poo/pfpooangrodboh/Paquete.class \
               ./bin/fp2/poo/pfpooangrodboh/Puerto.class \
               ./bin/fp2/poo/pfpooangrodboh/Ist.class \
               ./bin/fp2/poo/pfpooangrodboh/Datos.class  \
               ./src/fp2/poo/utilidades/LecturaFicheroEntrada.java 
	$(JAVAC) $(OPCIONES) ./src/fp2/poo/utilidades/LecturaFicheroEntrada.java

#####################################
# Ist.java
#####################################
./bin/fp2/poo/pfpooangrodboh/Ist.class: \
                          ./src/fp2/poo/pfpooangrodboh/Ist.java \
                          ./bin/fp2/poo/utilidades/PuertoInterfaz.class\
						  ./src/fp2/poo/utilidades/IstInterfaz.java
	$(JAVAC) $(OPCIONES) ./src/fp2/poo/pfpooangrodboh/Ist.java

#####################################
# IstInterfaz.java
#####################################
./bin/fp2/poo/utilidades/IstInterfaz.class: \
                          ./bin/fp2/poo/utilidades/PuertoInterfaz.class\
			  ./src/fp2/poo/utilidades/IstInterfaz.java
	$(JAVAC) $(OPCIONES) ./src/fp2/poo/utilidades/IstInterfaz.java

#####################################
# Nat.java
#####################################
./bin/fp2/poo/pfpooangrodboh/Nat.class: \
                         ./bin/fp2/poo/utilidades/NatInterfaz.class \
                         ./bin/fp2/poo/utilidades/LecturaFicheroEntrada.class \
                         ./bin/fp2/poo/utilidades/PaqueteInterfaz.class \
                         ./bin/fp2/poo/utilidades/Excepciones/OperacionNoPermitidaExcepcion.class \
                         ./src/fp2/poo/pfpooangrodboh/Nat.java
	$(JAVAC) $(OPCIONES) ./src/fp2/poo/pfpooangrodboh/Nat.java

#####################################
# NatInterfaz.java
#####################################
./bin/fp2/poo/utilidades/NatInterfaz.class: \
                         ./bin/fp2/poo/utilidades/PaqueteInterfaz.class \
                         ./bin/fp2/poo/utilidades/Excepciones/OperacionNoPermitidaExcepcion.class \
                         ./src/fp2/poo/utilidades/NatInterfaz.java
	$(JAVAC) $(OPCIONES) ./src/fp2/poo/utilidades/NatInterfaz.java




#####################################
# Paquete.java
#####################################
./bin/fp2/poo/pfpooangrodboh/Paquete.class: \
                          ./bin/fp2/poo/utilidades/IstInterfaz.class \
						  ./bin/fp2/poo/utilidades/DatosInterfaz.class \
						  ./src/fp2/poo/utilidades/PaqueteInterfaz.java
	$(JAVAC) $(OPCIONES)  ./src/fp2/poo/pfpooangrodboh/Paquete.java

#####################################
# PaqueteInterfaz.java
#####################################
./bin/fp2/poo/utilidades/PaqueteInterfaz.class: \
                          ./bin/fp2/poo/utilidades/IstInterfaz.class \
						  ./bin/fp2/poo/utilidades/DatosInterfaz.class \
						  ./src/fp2/poo/utilidades/PaqueteInterfaz.java
	$(JAVAC) $(OPCIONES) ./src/fp2/poo/utilidades/PaqueteInterfaz.java
	
#####################################
# OperacionNoPermitidaExcepcion.java
#####################################
./bin/fp2/poo/utilidades/Excepciones/OperacionNoPermitidaExcepcion.class: \
                         ./src/fp2/poo/utilidades/Excepciones/OperacionNoPermitidaExcepcion.java 
	$(JAVAC) $(OPCIONES) ./src/fp2/poo/utilidades/Excepciones/OperacionNoPermitidaExcepcion.java



#####################################
# Puerto.java
#####################################
./bin/fp2/poo/pfpooangrodboh/Puerto.class:  \
             ./bin/fp2/poo/utilidades/PuertoInterfaz.class                        \
             ./bin/fp2/poo/utilidades/Excepciones/PuertoIncorrectoExcepcion.class \
             ./src/fp2/poo/pfpooangrodboh/Puerto.java
	$(JAVAC) $(OPCIONES)   ./src/fp2/poo/pfpooangrodboh/Puerto.java

#####################################
# PuertoInterfaz.java
#####################################
./bin/fp2/poo/utilidades/PuertoInterfaz.class:  \
             ./bin/fp2/poo/utilidades/Excepciones/PuertoIncorrectoExcepcion.class \
             ./src/fp2/poo/utilidades/PuertoInterfaz.java
	$(JAVAC) $(OPCIONES)   ./src/fp2/poo/utilidades/PuertoInterfaz.java

#####################################
# PuertoIncorrectoExcepcion.java
#####################################
./bin/fp2/poo/utilidades/Excepciones/PuertoIncorrectoExcepcion.class:  \
      ./src/fp2/poo/utilidades/Excepciones/PuertoIncorrectoExcepcion.java
	$(JAVAC) $(OPCIONES)   ./src/fp2/poo/utilidades/Excepciones/PuertoIncorrectoExcepcion.java
	
#####################################
# Datos.java
#####################################
./bin/fp2/poo/pfpooangrodboh/Datos.class: \
                         ./bin/fp2/poo/utilidades/DatosInterfaz.class \
                         ./src/fp2/poo/pfpooangrodboh/Datos.java
	$(JAVAC) $(OPCIONES) ./src/fp2/poo/pfpooangrodboh/Datos.java

#####################################
# DatosInterfaz.java
#####################################
./bin/fp2/poo/utilidades/DatosInterfaz.class: \
                         ./src/fp2/poo/utilidades/DatosInterfaz.java
	$(JAVAC) $(OPCIONES) ./src/fp2/poo/utilidades/DatosInterfaz.java
                       



 
