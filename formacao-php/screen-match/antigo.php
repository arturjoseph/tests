<?php

require __DIR__ . "/src/Model/Filme.php";
require __DIR__ . "/src/funcoes.php";

echo "Bem-vindo(a) ao screen match!\n";

$nomeFilme = "Top Gun - Maverick";

$anoLancamento = 2022;

$quantidadeDeNotas = $argc - 1;
$notas = [];

for ($contador = 1; $contador < $argc; $contador++) {
    $notas[] = (float) $argv[$contador];
}

$notaFilme = array_sum($notas) / $quantidadeDeNotas;
$planoPrime = true;

$incluidoNoPlano = incluidoNoPlano($planoPrime, $anoLancamento);

echo "Nome do filme:  $nomeFilme  \n";
echo "Nota do filme:  $notaFilme \n";
echo "Ano Lançamento: $anoLancamento \n";

exibeMensagemLancamento($anoLancamento);

$genero = match ($nomeFilme){
    "Top Gun - Maverick" => "ação",
    "Thor: Ragnarok" => "super-herói",
    "Se beber não case" => "comédia",
    default => "gênero desconhecido"
};

echo "Gênero do filme é $genero \n";

$filme = criaFilme(
    nome:"Thor: Ragnarok", 
    anoLancamento: 2021, 
    nota: 7.8, 
    genero: "super-herói"
);

echo $filme->anoLancamento . "\n";
var_dump($notas);
sort($notas);
var_dump($notas);
var_dump(min($notas));
var_dump($filme->nome);

$filmeComoJson = json_encode($filme);
echo $filmeComoJson  . "\n";
var_dump(json_decode('{"nome":"Thor: Ragnarok","ano":2021,"nota":7.8,"genero":"super-her\u00f3i"}',true));

file_put_contents(__DIR__ .'/filme.json',$filmeComoJson);

