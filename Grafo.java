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

        System.out.println("tipo: " + tipoDoGrafo(grafo));
        System.out.println("vertices: " + getQtdVertices());

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

        return tipoDoGrafo;
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

    public static void main(String[] args) {
        Grafo g = new Grafo();
    }


}
