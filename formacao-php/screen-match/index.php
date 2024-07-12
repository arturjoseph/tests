<?php

require __DIR__ . "/src/Model/Filme.php";

echo "Bem-vindo(a) ao screen match!\n";

$filme = new Filme();
/*$filme->nome = 'Thor - Ragnarok';
$filme->anoLancamento = 2021;
$filme->genero = 'super-heroi';*/

$filme->avalia(10);
$filme->avalia(6);
$filme->avalia(7.8);
$filme->avalia(8.2);

var_dump($filme);

echo $filme->media() . '\n';
