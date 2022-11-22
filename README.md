# ci-3725-gcl-grammar
## Requisitos
 - Java SDK
 - ANTLR 4.11.1

## Compilación
Se deben compilar los archivos `.java` en el directorio raíz y `.\com\parsing`. Para esto es necesario agregar el parámetro `-cp` indicando la 
dirección del archivo .jar de ANTLR, de la siguiente forma:

    javac -cp <PATH_ANTLR4.jar> *.java
    
## Ejecución
Simplemente se debe ubicar en el directorio raíz del proyecto y ejecutar el siguiente comando:

    java GCL <PATH_ARCHIVO_GCL_A_PARSEAR>
    
## Notas
 - En caso de que ANTLR4 ya se ubique en el `CLASSPATH` del sistema operativo, no es necesario utilizar el
parámetro `-cp`.

 - Si se quiere generar el código fuente de la gramática, se debe usar ANTLR4 en el archivo `GCLGrammar.g4`, mover los .java generado a `.\com\parsing` y agregar al inicio de estos archivos el package correspondiente `package com.parsing;`
