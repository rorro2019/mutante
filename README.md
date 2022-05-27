# mutante
Identificador de Mutantes

Identificador de Mutantes
 
Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men.

Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es mutante basándose en su secuencia de ADN.

 ![image](https://user-images.githubusercontent.com/48495264/169920513-0c020b6d-001f-4575-88fe-6828099bad90.png)


Para eso te ha pedido crear un programa con un método o función con la siguiente firma (En alguno de los siguiente lenguajes: Java / Golang / C-C++ / Javascript (node) / Python / Ruby):

boolean isMutant(String[] dna); // Ejemplo Java

En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las cuales representan cada base nitrogenada del ADN.

Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras iguales , de forma oblicua, horizontal o vertical.

Ejemplo (Caso mutante):

String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
En este caso el llamado a la función isMutant(dna) devuelve “true”.


Ejemplo de uso : 
ejecutar el proyecto, el mismo correra en el puerto 8090.
Dirigirse a la siguiente ruta: http://localhost:8090/swagger-ui.html# 

utilizar el controller isMutanteUsingPOST 
y pasar un entrada como la siguiente: ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG 
