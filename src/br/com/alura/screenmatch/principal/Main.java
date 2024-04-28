package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão",1970);
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);
        System.out.println("Duração do filme: " + meuFilme.getDuracaoEmMinutos());

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

        Serie lost = new Serie("Lost",2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar Lost: " + lost.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("Avatar",2023);
        outroFilme.setAnoDeLancamento(2023);
        outroFilme.setDuracaoEmMinutos(200);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio  = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost); // já registrado
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        var filmeDoVinicius = new Filme("Velozes e Furiosos",2001);
        filmeDoVinicius.setAnoDeLancamento(2001);
        filmeDoVinicius.avalia(10);

        ArrayList<Filme> listadeFilmes = new ArrayList<>();
        listadeFilmes.add(filmeDoVinicius);
        listadeFilmes.add(meuFilme);
        listadeFilmes.add(outroFilme);

        System.out.println("Tamanho da lista " + listadeFilmes.size());
        System.out.println("Primeiro Filme " + listadeFilmes.get(0).getNome() );
        System.out.println(listadeFilmes);
        System.out.println("toString do filme" + listadeFilmes.get(0).toString());

    }

}