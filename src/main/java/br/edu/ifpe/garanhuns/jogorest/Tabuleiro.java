/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.jogorest;

/**
 *
 * @author João Witor
 */
public class Tabuleiro {

    static String[][] tabuleiro = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
    static int jogadas = 1;
    static String peca;

    public void reiniciarTabuleiro() {
        tabuleiro[0][0] = "1";
        tabuleiro[0][1] = "2";
        tabuleiro[0][2] = "3";
        tabuleiro[1][0] = "4";
        tabuleiro[1][1] = "5";
        tabuleiro[1][2] = "6";
        tabuleiro[2][0] = "7";
        tabuleiro[2][1] = "8";
        tabuleiro[2][2] = "9";

    }

    public String mostrarTabuleiro() {
        String mostrar = "<center><div style=\"background-color:#00BFFF;text-align:center; width:10%\" >";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mostrar += tabuleiro[i][j];
                if (j != 2) {
                    mostrar += " | ";
                }
            }
            mostrar += "<br></br>";
        }
        mostrar += "</div></center>";
        return mostrar;
    }

    public boolean verificarJogada(String jogada, String[][] tabuleiro) {
        for (String[] tabuleiro1 : tabuleiro) {
            for (int j = 0; j < tabuleiro.length; j++) {
                if (tabuleiro1[j].equals(jogada)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void fazerJogada(String jogada, String peca, String[][] tabuleiro) {
        switch (jogada) {
            case "1":
                tabuleiro[0][0] = peca;
                break;
            case "2":
                tabuleiro[0][1] = peca;
                break;
            case "3":
                tabuleiro[0][2] = peca;
                break;
            case "4":
                tabuleiro[1][0] = peca;
                break;
            case "5":
                tabuleiro[1][1] = peca;
                break;
            case "6":
                tabuleiro[1][2] = peca;
                break;
            case "7":
                tabuleiro[2][0] = peca;
                break;
            case "8":
                tabuleiro[2][1] = peca;
                break;
            case "9":
                tabuleiro[2][2] = peca;
                break;
            default:
                break;
        }
        jogadas++;
    }

    public String verificarVencedor(String[][] tabuleiro) {
        String[] vitoria = new String[8];

        String vencedor = null;

        //jogadas horizontais
        for (int i = 0; i < 3; i++) {
            vitoria[i] = "";
            for (int j = 0; j < 3; j++) {
                vitoria[i] += tabuleiro[i][j];
            }
        }

        //jogadasverticais
        for (int i = 3; i < 6; i++) {
            vitoria[i] = "";
            for (int j = 0; j < 3; j++) {
                vitoria[i] += tabuleiro[j][i - 3];
            }
        }

        vitoria[6] = tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2];
        vitoria[7] = tabuleiro[2][0] + tabuleiro[1][1] + tabuleiro[0][2];

        for (String vitoria1 : vitoria) {
            if (vitoria1.equals("XXX")) {
                vencedor = "<h1>JOGADOR X FOI O VENCEDOR!</h1>";
                break;
            } else if (vitoria1.equals("OOO")) {
                vencedor = "<h1><center>JOGADOR O FOI O VENCEDOR!</center></h1>";
                break;
            }
        }

        if (vencedor == null && jogadas == 10) {
            vencedor = "<h1>EMPATE!</h1>";
        }
        return vencedor;
    }

}
