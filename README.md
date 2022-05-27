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
y pasar una entrada como la siguiente: ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG 
![image](https://user-images.githubusercontent.com/48495264/170611903-24267fb9-3a11-4e3e-acb5-d9130311c267.png)

Se ejecuta y nos devolvera true:
![image](https://user-images.githubusercontent.com/48495264/170612020-4f937993-adeb-4e65-a299-2f97df8a0b53.png)


Para la siguiente entrada : TTGCGA,CAGTGC,TTATGT,AGAAGG,CCTCTA,TCACTG 
nos devolvera false : 
![image](https://user-images.githubusercontent.com/48495264/170612516-8460beae-cc46-443a-8cd5-57591b4e4126.png)


Validaciones :
 -Control NxN :
   ENTRADA: ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACT o ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA
   Respuesta : ![image](https://user-images.githubusercontent.com/48495264/170612149-e7a7f174-8334-4e52-a315-da9c95a38028.png)
   
 -Control de Strings :
   ENTRADA : ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTX
   Respuesta : ![image](https://user-images.githubusercontent.com/48495264/170612376-3f2e744c-cc90-4f84-a671-a7d390a4bd02.png)



