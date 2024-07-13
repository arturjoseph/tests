<?php

require __DIR__ . "/src/Model/Genero.php";
require __DIR__ . "/src/Model/Titulo.php";
require __DIR__ . "/src/Model/Filme.php";
require __DIR__ . "/src/Model/Serie.php";
require __DIR__ . "/src/Calculos/CalculadoraDeMaratona.php";


echo "Bem-vindo(a) ao screen match!\n";

$filme = new Filme('Thor - Ragnarok',2021,Genero::SuperHeroi,180);

$filme->avalia(10);
$filme->avalia(6);
$filme->avalia(7.8);
$filme->avalia(8.2);

var_dump($filme);

echo $filme->media() . "\n";

echo $filme->anoLancamento;

$serie = new Serie('Lost', 2007, Genero::Drama, 10, 20, 30);

echo $serie->anoLancamento . "\n";

$serie->avalia(8);

echo $serie->media() . "\n";

$calculadora = new CalculadoraDeMaratona();
$calculadora->inclui($filme);
$calculadora->inclui($serie);
$duracao = $calculadora->duracao();
echo "Para essa maratona, você precisa de $duracao minutos";
