package com.mutante.mutante.Service;

import com.mutante.mutante.Exception.RequestValidationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MutanteService {

    public Boolean isMutante( String  entrada) {
        int totalDna = 0;
        String[] dna = entrada.split(",");
        this.validation(dna);
        //return isMutant(dna);
        int dim= dna[0].length();
        String[][] matriz = new String[dim][dim];
        matriz = cargarMatriz(dna,dim);



        totalDna =totalDna+ controlHorizontal(matriz, dim);
     /**   if ((totalDna)>1){
            return true;
        }**/
        totalDna =totalDna+ controlVertical(matriz, dim);

        totalDna =totalDna+ contarIzquierdaDerecha(matriz, dim);

        totalDna =totalDna+  contarDerechaIzquierda(matriz, dim);


        return false;
    }


  private String[][] cargarMatriz(String[] dna,int dim){
      String[][] matriz = new String[dim][dim];
      for(int i=0; i< dim; i++){
          char[] array= dna[i].toCharArray() ;
          for(int j=0; j<dim;j++){
              matriz[i][j]= String.valueOf(array[j]);
          }
      }
      return matriz;
  }

    private void validation( String[] dna){
        int longitud= dna[0].length();
        int dim =dna.length;
        if (dim != longitud){
            throw new RequestValidationException("Error, no ingreso una cadena de N x N");
        }
       for (int i=0; i < dna.length ; i++) {

           if (dna[i].trim().length() != longitud ) {
               throw new RequestValidationException("Error, no ingreso una cadena de N x N");
           }
           char[] charSearch = {'A','T','C','G'};

           for(int z=0; z<dna[i].trim().length(); z++)
           {
               char chr = dna[i].trim().charAt(z);
               boolean band=false;
               for(int j=0; j<charSearch.length; j++)
               {
                   if(charSearch[j] == Character.toUpperCase(chr))
                   {
                       band=true;
                   }
               }
               if (band==false){
                   throw new RequestValidationException("Error, caracter  no valido");
               }
           }

           }

       }



    private int controlHorizontal(String[][] matriz ,int dim){
       int totalDna=0;
        for(int i=0; i< dim; i++) {
            for (int j = 0; j < dim; j++) {
                //matriz[i][j]
                // Control Horizontal
                int count = 0;
                int x = j;
                for (int y = x; y < (dim - 1); y++) {

                    if (matriz[i][y].equals(matriz[i][y + 1])) {
                        count = count + 1;
                    } else {
                        count = 0;
                    }
                    if (count == 3) {
                        i = i + 1;
                        totalDna = totalDna + 1;
                    }
                }

            }
          }
            return totalDna ;
        }

    private int controlVertical(String[][] matriz ,int dim){
        int totalDna=0;
        for(int j=0; j< dim; j++) {
            int count=0;
            for (int i = 0; i < (dim-1); i++) {

                    if (matriz[i][j].equals(matriz[i+1][j])){
                        count =count +1;
                    }else {
                        count=0;
                    }
                    if(count ==3){
                        i=dim-1;
                        totalDna=totalDna+1;
                    }


            }
        }
        return totalDna ;
    }

    private int buscarIzquierdaDerecha(String[][] arr, int lenghMatriz, int i, int j, String indLimit){
        int contSecuencia =0;
        int limit=0;
        while (i<=lenghMatriz-1 && j<=lenghMatriz-1){
            if (indLimit == "J"){
                limit=lenghMatriz-j;
            }else{
                limit=lenghMatriz-i;
            }
            if (limit>=4) {
                if (arr[i][j].equals(arr[i+1][j+1]) &&
                        arr[i][j].equals(arr[i+2][j+2]) &&
                        arr[i][j].equals(arr[i+3][j+3])
                ) {
                    contSecuencia++;
                }
            }
            i++;
            j++;
        }
        return contSecuencia;
    }

    /* Cuenta secuencia de forma diagonal Izquierda a Derecha */
    private int contarIzquierdaDerecha (String[][] arr, int lenghMatriz){
        int i=0;
        int j=0;
        int countSecuence=0;
        for (int indI = lenghMatriz-1; indI >= 0; indI--) {
            //i=indI;
            if (indI==0){
                for (int indJ = 0; indJ < lenghMatriz; indJ++) {
                    i=indI;
                    j=indJ;
                    int cont = buscarIzquierdaDerecha(arr, lenghMatriz, i, j, "J");
                    countSecuence = countSecuence + cont;
                }
            }else{
                i=indI;
                int cont = buscarIzquierdaDerecha(arr, lenghMatriz, i, j, "I");
                countSecuence = countSecuence + cont;
            }
            // Acelera busqueda de solución
            if (countSecuence > 1){
                return countSecuence;
            }
        }
        return countSecuence;
    }

    /* Busca secuencia diagonal de DER a IZq*/
    private int buscarDerechaIzquierda(String[][] arr, int lenghMatriz, int i, int j, String indLimit){
        int contSecuencia =0;
        int limit=0;
        while (i<=lenghMatriz-1 && j>=0){
            if (indLimit == "J"){
                limit=j;
            }else{
                limit=lenghMatriz-i-1;
            }
            if (limit>=3) {
                if (arr[i][j].equals(arr[i+1][j-1]) &&
                        arr[i][j].equals(arr[i+2][j-2] )&&
                        arr[i][j].equals(arr[i+3][j-3])
                ) {
                    contSecuencia++;
                }
            }
            i++;
            j--;
        }
        return contSecuencia;
    }


    private int contarDerechaIzquierda (String[][] arr, int lenghMatriz){
        int i=0;
        int j=0;
        int countSecuence=0;
        for (int indJ = 0; indJ <= lenghMatriz-1; indJ++) {
            if (indJ==lenghMatriz-1){
                for (int indI = 0; indI <= lenghMatriz-1 ; indI++) { // busca desde [n,n]
                    i=indI;
                    j=indJ;
                    int cont = buscarDerechaIzquierda(arr, lenghMatriz, i, j, "I");
                    countSecuence = countSecuence + cont;
                }
            }else{ // busca desde [0,n]
                j=indJ;
                int cont = buscarDerechaIzquierda(arr, lenghMatriz, i, j, "J");
                countSecuence = countSecuence + cont;
            }

            // Acelera busqueda de solución
            if (countSecuence > 1){
                return countSecuence;
            }

        }
        return countSecuence;
    }


}
