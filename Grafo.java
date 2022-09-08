public class Grafo {

    int grafo[][] = new int[3][3];
    int qtdVertice;

    public Grafo(){
        grafo[0][0] = 0;
        grafo[0][1] = 1;
        grafo[0][2] = 1;
        grafo[1][0] = 1;
        grafo[1][1] = 0;
        grafo[1][2] = 1;
        grafo[2][0] = 1;
        grafo[2][1] = 1;
        grafo[2][2] = 0;

        System.out.println("grau: " + grausDoVertice(grafo));
        System.out.println("tipo: " + tipoDoGrafo(grafo));

    }

    private int getQtdVertices(){
        return grafo.length;
    }

    private String tipoDoGrafo(int grafo[][]){
        String tipoDoGrafo = "";
        if(ehDirigido(grafo))
            tipoDoGrafo += "dirigido, ";
        else
            tipoDoGrafo += "não dirigido, ";

        if(ehSimples(grafo))
            tipoDoGrafo += "simples, ";
        else
            tipoDoGrafo += "multigrafo, ";

        if(ehNulo(grafo)){
            tipoDoGrafo += "nulo, ";
        }

        if(ehRegular(grafo)){
            tipoDoGrafo += "regular, ";
        }

        if(ehCompleto(grafo)){
            tipoDoGrafo += "completo, ";
        }

        //if(ehBipartido()){
            //tipoDoGrafo += "completo, ";
        //}
        return tipoDoGrafo;


    }

    public String arestasDoGrafo(int grafo[][]){
        int qtdArestas = 0;
        String conjuntoArestas = "";

        if(!ehDirigido(grafo)){
            for (int i= 0; i <= grafo.length - 1; i++){
                for (int j=0; j <=grafo[i].length - 1; j++){
                    if(grafo[i][j] > 0){
                        ehNulo = false;
                        return ehNulo;
                    }
                }
            }
        }
    }

    public String grausDoVertice(int grafo[][]){
        String grausDoVertice = "";
        if(!ehDirigido(grafo)){
            int[] elementos = getGrauDeVerticesNaoDirigido(grafo);
            int[] sequencia = sequenciaDeGrau(elementos);
            for (int i= 0; i <= elementos.length - 1; i++){

               grausDoVertice += "\n Vértice " + i + ": " + elementos[i];

            }

            grausDoVertice += "\n Sequência de graus: ";
            for (int i= 0; i <= sequencia.length- 1; i++){

                grausDoVertice += sequencia[i] + " ";

            }
        }

        return grausDoVertice;
    }

    private Boolean ehDirigido(int grafo[][]){
        Boolean ehDirigido = false;
        for (int i= 0; i <= grafo.length - 1; i++){
            for (int j=0; j <=grafo[i].length - 1; j++){
                if ( (grafo[i][j]) != (grafo[j][i])){
                    ehDirigido = true;
                    return ehDirigido;
                }

            }
        }

        return ehDirigido;
    }

    private Boolean ehSimples(int grafo[][]){
        Boolean ehSimples = true;
        for (int i= 0; i <= grafo.length - 1; i++){
            for (int j=0; j <=grafo[i].length - 1; j++){
                if ( i == j){
                    if(grafo[i][j] > 0){
                        ehSimples = false;
                        return ehSimples;
                    }
                }

                if(grafo[i][j] > 1){
                    ehSimples = false;
                    return ehSimples;
                }

            }
        }

        return ehSimples;
    }

    private Boolean ehNulo(int grafo[][]){
        Boolean ehNulo = true;
        for (int i= 0; i <= grafo.length - 1; i++){
            for (int j=0; j <=grafo[i].length - 1; j++){
                    if(grafo[i][j] > 0){
                        ehNulo = false;
                        return ehNulo;
                    }
            }
        }

        return ehNulo;
    }

    private Boolean ehRegular(int grafo[][]){

        int[] graus = getGrauDeVerticesNaoDirigido(grafo);
        int grau = graus[0];
        for(int i = 0; i <= graus.length - 1; i++){
            if(graus[i] != grau) {
                return false;
            }
        }

        return true;
    }

    public int[] getGrauDeVerticesNaoDirigido(int grafo[][]){
        int[] graus = new int[grafo.length];

        for (int i= 0; i <= grafo.length - 1; i++){
            graus[i] = 0;
            for (int j=0; j <=grafo[i].length - 1; j++){
                if(i == j){
                    graus[i] = graus[i] + (grafo[i][j] * 2);
                }

            }
        }

        return graus;
    }

    private Boolean ehCompleto(int grafo[][]){
        int valor = grafo[0][1];
        if(grafo.length == 1){
            return true;
        }
        for (int i= 0; i <= grafo.length - 1; i++){
            for (int j=0; j <=grafo[i].length - 1; j++){
                if(grafo[i][j] != valor && i != j){
                    return false;
                }
            }
        }
        return true;
    }

    public int[] sequenciaDeGrau(int elementos[]){
        int cont1, cont2,aux;
        for(cont1 =0; cont1<elementos.length; cont1++){
            for(cont2 =0; cont2 <elementos.length - 1; cont2++){
                if(elementos[cont2]> elementos[cont2+1]){
                    aux = elementos[cont2];
                    elementos[cont2] = elementos[cont2+1];
                    elementos[cont2+1] = aux;
                }
            }
        }

        return elementos;
    }

    public static void main(String[] args) {
        Grafo g = new Grafo();
    }




}
