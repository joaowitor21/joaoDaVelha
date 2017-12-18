package br.edu.ifpe.garanhuns.jogorest;


public class Update {

    static Tabuleiro tabuleiro = new Tabuleiro();
    
    public String resetarJogo() {
        tabuleiro.reiniciarTabuleiro();
        tabuleiro.jogadas = 1;
        return "<h1><center>Jogo da Velha</center></h1><br>"
                 + tabuleiro.mostrarTabuleiro();
    }

    public String mudarJogador() {
        if (tabuleiro.jogadas%2 != 0) {
            tabuleiro.peca = "X";
        } else {
            tabuleiro.peca = "O";
        }
        return tabuleiro.peca;
    }
    
    
    public String verificarVencedor() {
        if (tabuleiro.verificarVencedor(tabuleiro.tabuleiro) != null) {
            return tabuleiro.verificarVencedor(tabuleiro.tabuleiro) +
                    tabuleiro.mostrarTabuleiro();
        }
        return "<h1><center>Jogo da Velha</center></h1>"
                + "<h2><center><br>Nenhum ganhador! Continue jogando:</h2></center>"
                + "<center>" + tabuleiro.mostrarTabuleiro() + "</center>";
    }
    
    public String atualizarTabuleiro(String jogada) {
        if (tabuleiro.verificarVencedor(tabuleiro.tabuleiro) == null) {

            if (tabuleiro.verificarJogada(jogada, tabuleiro.tabuleiro) == false) {
                return "<h1><center>Jogo da Velha</center></h1><br>"
                        + "<center>" + tabuleiro.mostrarTabuleiro() + "Jogada incorreta! Por favor, jogue novamente: </center><br></br>";
            } else {
                mudarJogador();
                tabuleiro.fazerJogada(jogada, tabuleiro.peca, tabuleiro.tabuleiro);

            }
        }
        return "<h1><center>Jogo da Velha</center></h1><br>"
                + "<br><center>" + tabuleiro.mostrarTabuleiro() + "</center>";
    }

   public String jogar(String jogada) {
        if (tabuleiro.verificarVencedor(tabuleiro.tabuleiro) == null) {

            return atualizarTabuleiro(jogada);
        }
        
        return "<h1><center>Jogo da Velha</center></h1>" + "<h2><center>" + tabuleiro.mostrarTabuleiro()
                    +"Jogo Finalizado</center></h2><br></br>";
    }
}
