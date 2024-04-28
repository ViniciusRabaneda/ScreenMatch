package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão",1970);
        Filme outroFilme = new Filme("Avatar",2023);
        var filmeDoVinicius = new Filme("Velozes e Furiosos",2001);
        filmeDoVinicius.avalia(10);
        Serie lost = new Serie("Lost",2000);

        List<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoVinicius);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        for (Titulo item: lista){  // for each
            System.out.println(item.getNome());
            if(item instanceof Filme filme && filme.getClassificacao()>2 ){  // forma de verificar qual a qual subclasse pertence o objeto
                System.out.println("Classificação "+ filme.getClassificacao());
            }
        }
        System.out.println("Lista de Títulos Ordenados");
        Collections.sort(lista);
        System.out.println((lista));
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano");
        System.out.println(lista);
    }
}
