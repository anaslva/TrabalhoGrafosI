public class Grafo {

    int grafo[][] = new int[1][1];

    public Grafo(){

        grafo[0][0] = 1;

        System.out.println("GRAU: " + grausDoVertice(grafo));
        System.out.println("=================================================");

        System.out.println("TIPO: \n" + tipoDoGrafo(grafo));
        System.out.println("=================================================");

        System.out.println("ARESTAS: \n" + arestasDoGrafo(grafo));

    }

    private int getQtdVertices(){
        return grafo.length;
    }

    private String tipoDoGrafo(int grafo[][]){
        String tipoDoGrafo = "";
        if(ehDirigido(grafo))
            tipoDoGrafo += "-dirigido \n";
        else
            tipoDoGrafo += "-não dirigido \n";

        if(ehSimples(grafo))
            tipoDoGrafo += "-simples \n";
        else
            tipoDoGrafo += "-multigrafo \n";

        if(ehNulo(grafo)){
            tipoDoGrafo += "-nulo \n";
        }

        if(ehRegular(grafo)){
            tipoDoGrafo += "-regular \n";
        }

        if(ehCompleto(grafo)){
            tipoDoGrafo += "-completo \n";
        }

        //if(ehBipartido()){
            //tipoDoGrafo += "completo, ";
        //}
        return tipoDoGrafo;


    }

    public String arestasDoGrafo(int grafo[][]){
        int qtdArestas = 0;
        String conjuntoArestas = "{ ";
        Boolean ehDirigido = ehDirigido(grafo);

            for (int i= 0; i <= grafo.length - 1; i++){
                for (int j=0; j <=grafo[i].length - 1; j++){
                    if(grafo[i][j] > 0){
                        if(!ehDirigido && !conjuntoArestas.contains("(" + j + "," + i + ") " )){
                            conjuntoArestas += "(" + i + "," + j + ") ";
                        } else {
                            conjuntoArestas += "(" + i + "," + j + ") ";
                        }
                        if(i == j && !ehDirigido ){
                            qtdArestas += grafo[i][j] * 2;
                        } else {
                            qtdArestas += grafo[i][j];
                        }
                    }
                }
            }

        return "Quantidade de arestas: " + (!ehDirigido ? qtdArestas/2 : qtdArestas) + "\nConjunto de arestas = " + conjuntoArestas  + "}";

    }

    public String grausDoVertice(int grafo[][]){
        String grausDoVertice = "";
        int[] elementos = getGrauDeVertices(grafo);
        int[] sequencia = sequenciaDeGrau(elementos);
        if(!ehDirigido(grafo)){
            for (int i= 0; i <= elementos.length - 1; i++){

               grausDoVertice += "\n Vértice " + i + ": " + elementos[i];

            }
            grausDoVertice += "\n Sequência de graus: ";
            for (int i= 0; i <= sequencia.length- 1; i++){

                grausDoVertice += sequencia[i] + " ";
            }
        } else {
            int[] qtdEntradas = new int[grafo.length];
            int[] qtdSaidas = new int[grafo.length];
            for (int i= 0; i <= grafo.length - 1; i++){
                for (int j=0; j <=grafo[i].length - 1; j++){
                        if(grafo[i][j] > 0){
                            qtdEntradas[i] += grafo[i][j];
                            qtdSaidas[j] += grafo[i][j];
                        }
                    }
                }

            for(int i = 0; i <= grafo.length - 1; i++){
                grausDoVertice += "\nVértice " + i +
                        "\n Entradas: " + qtdEntradas[i] +
                        "\n Saídas: " + qtdSaidas[i];

                }
            }

        grausDoVertice += "\n Sequência de graus: ";
        for (int i= 0; i <= sequencia.length- 1; i++){
            grausDoVertice += sequencia[i] + " ";
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
        int[] graus = getGrauDeVertices(grafo);
        if(graus.length > 0){
            int grau = graus[0];
            for(int i = 0; i <= graus.length - 1; i++){
                if(graus[i] != grau) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[] getGrauDeVertices(int grafo[][]){
        Boolean ehDirigido = ehDirigido(grafo);
        int[] graus = new int[grafo.length];

        for (int i= 0; i <= grafo.length - 1; i++){
            graus[i] = 0;
            for (int j=0; j <=grafo[i].length - 1; j++){
                if(i == j && !ehDirigido){
                    graus[i] = graus[i] + (grafo[i][j] * 2);
                } else {
                    graus[i] += grafo[i][j];
                }

            }
        }

        return graus;
    }

    private Boolean ehCompleto(int grafo[][]){
        if(grafo.length > 1){
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
        } else {
            if(grafo[0][0] > 0){
                return false;
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
